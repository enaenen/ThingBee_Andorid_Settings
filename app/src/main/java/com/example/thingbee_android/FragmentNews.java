package com.example.thingbee_android;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingbee_android.retorift.ApiNewsService;
import com.example.thingbee_android.retorift.ArticleInfoVO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentNews extends Fragment {
    private Retrofit retrofit;
    private ApiNewsService newsService;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ArticleInfoVO> myArticles;
    private FloatingActionButton searchBtn;
    private EditText searchBox;
    private LinearLayout searchBar;
    private Boolean flag;
    private Animation top;
    private Animation bottom;
    private ImageButton searchButton;
    private String searchWord;

    public FragmentNews() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_news, container, false);

        //값 초기화
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager= new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        myArticles = new ArrayList<>();

        searchBar = view.findViewById(R.id.searchBar);
        searchBox  = view.findViewById(R.id.searchBox);
        searchBtn = view.findViewById(R.id.searchBtn);
        searchButton = view.findViewById(R.id.search);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.searchBtn :
                        if(flag){
                            flag = false;
                        }else {
                            flag = true;
                        }
                        switchSearchBar();
                        break;
                }
            }
        });

        //검색어를 입력한 후, 검색버튼을 눌렀을 경우, 감지하는 onClick 리스너
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.search:
                        searchWord = searchBox.getText().toString();
                        searchArticleAtFirst();
                }
            }
        });

        flag = true;

        top = AnimationUtils.loadAnimation(getContext(),R.anim.animation_top);
        bottom = AnimationUtils.loadAnimation(getContext(),R.anim.animation_bottom);

        //http 방식 통신 라이브러리
        retrofit= new Retrofit.Builder()
                .baseUrl(ApiNewsService.API_URL)
                .addConverterFactory(GsonConverterFactory.create()) //GSON parser 라이브러리 사용
                .build();
        newsService=retrofit.create(ApiNewsService.class);

        initArticles();     //기사 초기화(myArticles),
        Log.d("test", myArticles.toString());
        mAdapter = new MyAdapter(myArticles);   //어댑터 생성, 데이터 부여
        mRecyclerView.setAdapter(mAdapter);     //어댑터 등록


        //탑 뷰 프래그먼트
/*        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        MenuTopbar topbar= new MenuTopbar();
        fragmentTransaction.add(R.id.topbar_container, topbar);
        fragmentTransaction.commit();*/


        //스크롤이벤트
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!mRecyclerView.canScrollVertically(1)) {    //맨끝까지 닿았을 때
                    add_article();
                }
            }
        });

        return view;
    }

    private void searchArticleAtFirst(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("searchWord",searchWord);
//        params.put()

//        Call<List<ArticleInfoVO>> call = newsService.getArticles();
    }

    public void initArticles(){
        Call<List<ArticleInfoVO>> call = newsService.getArticles("first");
        Log.d("test", "call 할당");
        call.enqueue(new Callback<List<ArticleInfoVO>>() {
            @Override   //onRes, onFail 둘다 스레드로 돌기 때문에 윗라인 실행하고 initArticel 메서드는
            //종료된다. 이후 다른작업을 하다가 아래 스레드가 실행된다.
            public void onResponse(Call<List<ArticleInfoVO>> call, Response<List<ArticleInfoVO>> response) {
                List<ArticleInfoVO> result=response.body();
                myArticles.addAll(result);
                Log.d("test", "기사: "+myArticles);
                mAdapter.notifyDataSetChanged();    //데이터 업데이트
            }
            @Override
            public void onFailure(Call<List<ArticleInfoVO>> call, Throwable t) {
                Log.d("initArticle()","Exception 발생");
                t.printStackTrace();
            }
        });
    }


    public void add_article(){
        //데이터 추가
        int size= myArticles.size();
        Call<List<ArticleInfoVO>> call = newsService.getArticles(myArticles.get(size-1).getCode());
        Log.d("test", "call 할당");
        call.enqueue(new Callback<List<ArticleInfoVO>>() {
            @Override
            public void onResponse(Call<List<ArticleInfoVO>> call, Response<List<ArticleInfoVO>> response) {
                List<ArticleInfoVO> result=response.body();
                if(result!=null)
                    myArticles.addAll(result);
                Log.d("test",result.toString());
                mAdapter.notifyDataSetChanged();    //Recycle View의 데이터,화면 업데이트.
            }
            @Override
            public void onFailure(Call<List<ArticleInfoVO>> call, Throwable t) {
                Log.d("test",  "Exception 발생");
                t.printStackTrace();
            }
        });
    }

    private void switchSearchBar(){
        if(flag){
            searchBar.setVisibility(View.VISIBLE);
            searchBar.startAnimation(top);
        }else{
            searchBar.startAnimation(bottom);
            searchBar.setVisibility(View.INVISIBLE);
        }
    }
}
