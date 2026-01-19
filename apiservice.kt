import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("/register")
    suspend fun register(@Part image: MultipartBody.Part, @Part("name") name: String): Response<ResponseBody>

    @Multipart
    @POST("/recognize")
    suspend fun recognize(@Part image: MultipartBody.Part): Response<ResponseBody>
}
