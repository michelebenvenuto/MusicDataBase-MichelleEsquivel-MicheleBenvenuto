import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Song(
        val year: Int,
        val country: String,
        val region: String,
        val artistName: String,
        val song: String,
        val artistGender: String,
        val groupOrSolo: String,
        val place: Int,
        val points: Int,
        val isFinal: Boolean,
        val isSongInEnglish: Boolean,
        val songQuality: Float,
        val normalizedPoints: Float,
        val energy: Float,
        val duration: Float,
        val acousticness: Float,
        val danceability: Float,
        val tempo: Float,
        val speechines: Float,
        val key: Int,
        val liveness: Float,
        val timeSignature: Int,
        val mode: Int,
        val loudness: Float,
        val valence: Float,
        val happiness: Float
){
    class SongArrayDeserializer: ResponseDeserializable<Array<Song>>{
        override fun deserialize(content: String): Array<Song>? {
            return Gson().fromJson(content, Array<Song>::class.java)
        }
    }
}