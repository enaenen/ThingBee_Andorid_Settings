.class final Lcom/google/android/gms/internal/measurement/zzhc;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final synthetic zzany:Lcom/google/android/gms/internal/measurement/zzgq;

.field private final synthetic zzaoc:Ljava/lang/String;

.field private final synthetic zzaod:Lcom/google/android/gms/internal/measurement/zzeu;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/measurement/zzgq;Lcom/google/android/gms/internal/measurement/zzeu;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzany:Lcom/google/android/gms/internal/measurement/zzgq;

    iput-object p2, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzaod:Lcom/google/android/gms/internal/measurement/zzeu;

    iput-object p3, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzaoc:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzany:Lcom/google/android/gms/internal/measurement/zzgq;

    invoke-static {v0}, Lcom/google/android/gms/internal/measurement/zzgq;->zza(Lcom/google/android/gms/internal/measurement/zzgq;)Lcom/google/android/gms/internal/measurement/zzgl;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzgl;->zzka()V

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzany:Lcom/google/android/gms/internal/measurement/zzgq;

    invoke-static {v0}, Lcom/google/android/gms/internal/measurement/zzgq;->zza(Lcom/google/android/gms/internal/measurement/zzgq;)Lcom/google/android/gms/internal/measurement/zzgl;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzaod:Lcom/google/android/gms/internal/measurement/zzeu;

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzhc;->zzaoc:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/measurement/zzgl;->zzb(Lcom/google/android/gms/internal/measurement/zzeu;Ljava/lang/String;)V

    return-void
.end method
