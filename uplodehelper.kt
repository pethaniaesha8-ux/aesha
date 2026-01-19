import android.graphics.Bitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream

suspend fun bitmapToMultipart(bitmap: Bitmap, partName: String = "file", fileName: String = "face.jpg"): MultipartBody.Part {
    return withContext(Dispatchers.IO) {
        val bos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, bos)
        val bytes = bos.toByteArray()
        val reqFile: RequestBody = bytes.toRequestBody("image/jpeg".toMediaTypeOrNull())
        MultipartBody.Part.createFormData(partName, fileName, reqFile)
    }
}
