.class public abstract Lcom/google/android/gms/internal/measurement/zzyj;
.super Ljava/lang/Object;


# static fields
.field private static volatile zzbts:Z = true


# instance fields
.field zzbtp:I

.field private zzbtq:I

.field private zzbtr:Z


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/16 v0, 0x64

    iput v0, p0, Lcom/google/android/gms/internal/measurement/zzyj;->zzbtp:I

    const v0, 0x7fffffff

    iput v0, p0, Lcom/google/android/gms/internal/measurement/zzyj;->zzbtq:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzyj;->zzbtr:Z

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/measurement/zzyk;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/measurement/zzyj;-><init>()V

    return-void
.end method

.method static zza([BIIZ)Lcom/google/android/gms/internal/measurement/zzyj;
    .locals 6

    new-instance p3, Lcom/google/android/gms/internal/measurement/zzyl;

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p3

    move-object v1, p0

    move v2, p1

    move v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/measurement/zzyl;-><init>([BIIZLcom/google/android/gms/internal/measurement/zzyk;)V

    :try_start_0
    invoke-virtual {p3, p2}, Lcom/google/android/gms/internal/measurement/zzyl;->zzah(I)I
    :try_end_0
    .catch Lcom/google/android/gms/internal/measurement/zzyy; {:try_start_0 .. :try_end_0} :catch_0

    return-object p3

    :catch_0
    move-exception p0

    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw p1
.end method


# virtual methods
.method public abstract zztr()I
.end method
