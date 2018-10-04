package Tables

import org.jetbrains.exposed.sql.Table

object MusicTable: Table(){
    val id = integer("id").autoIncrement().primaryKey()
    val year= varchar("year",50)
    val country=varchar("country", 50)
    val region=varchar("region", 50)
    val artistName=varchar("artist", 50)
    val title=varchar("title",50)
    val artistGender=varchar("Artists Gender",50)
    val groupOrSolo=varchar("Group or Solo", 50)
    val place=varchar("Place", 50)
    val points=varchar("Points", 50)
    val isFinal=varchar("isFinal", 50)
    val isSongInEnglish=varchar("En ingles", 50)
    val songQuality=varchar("Quality", 50)
    val normalizedPoints=varchar("Normalized Points",50)
    val energy=varchar("Energy",50)
    val duration=varchar("Duration", 50)
    val acousticness=varchar("Acousticness",50)
    val danceability=varchar("Danceability", 50)
    val tempo=varchar("Tempo", 50)
    val speechines=varchar("Speechines", 50)
    val key=varchar("Key",50)
    val liveness=varchar("Liveness",50)
    val timeSignature=varchar("timeSignature",50)
    val mode=varchar("Mode", 50)
    val loudness=varchar("Loudness", 50)
    val valence=varchar("Valence", 50)
    val happiness=varchar("Happiness", 50)
    val isFavorite=bool("Favorita")

}