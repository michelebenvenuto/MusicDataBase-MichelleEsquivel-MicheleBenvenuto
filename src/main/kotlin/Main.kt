import Tables.MusicTable
import com.github.kittinunf.fuel.Fuel
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    val buscador = Buscador

    val url="https://next.json-generator.com/api/json/get/EkeSgmXycS"

    val (request, response, result)=Fuel.get(url).responseObject(Song.SongArrayDeserializer())
    val(songs, err)= result

    Database.connect(
            "jdbc:postgresql:Songs",
            "org.postgresql.Driver",
            "postgres",
            "59809690"
    )
    transaction {
        //        //SchemaUtils.create(MusicTable)
//        //if (songs != null) {
//            //for (song in songs){
//                //MusicTable.insert {
//                    it[year] = song.year
//                    it[country] = song.country
//                    it[region] = song.region
//                    it[artistName] = song.artistName
//                    it[title] = song.song
//                    it[artistGender] = song.artistGender
//                    it[groupOrSolo] = song.groupOrSolo
//                    it[place] = song.place
//                    it[points] = song.points
//                    it[isFinal] = song.isFinal
//                    it[isSongInEnglish] = song.isSongInEnglish
//                    it[songQuality] = song.songQuality
//                    it[normalizedPoints] = song.normalizedPoints
//                    it[energy] = song.energy
//                    it[duration] = song.duration
//                    it[acousticness] = song.acousticness
//                    it[danceability] = song.danceability
//                    it[tempo] = song.tempo
//                    it[speechines] = song.speechiness
//                    it[key] = song.key
//                    it[liveness] = song.liveness
//                    it[timeSignature] = song.timeSignature
//                    it[mode] = song.mode
//                    it[loudness] = song.loudness
//                    it[valence] = song.valence
//                    it[happiness] = song.happiness
//                    it[isFavorite] = song.isFavorite


        // }
        //}

        val menuPrincipal = """
        1)Buscar canciones por nombre
        2)Buscar canciones por artista
        3)Mostrar canciones favoritas
        4)Salir
    """.trimIndent()
        var wantsToContinue = true
        do {
            println(menuPrincipal)
            var selectedOption = readLine()!!.toIntOrNull()
            when (selectedOption) {
                1 -> {
                    print("Ingrese el nombre de la cancion que quiere buscar:")
                    val stringToSearch = readLine()!!
                    var songsTosearch=MusicTable.select { MusicTable.title.like("%${stringToSearch}%") }
                    for (song in songsTosearch) {
                        println("${song.data.get(0)}) ${song.data.get(5)}\n")
                    }
                    print("Desea guardar alguna cancion como favorita?")
                    var wantsToFavorite= readLine()!!
                    if (wantsToFavorite.toUpperCase()=="SI"){
                        print("Cual?")
                        var songToFavorite= readLine()!!.toIntOrNull()
                        if (songToFavorite != null) {
                            var likedSong=MusicTable.select{MusicTable.id.eq(songToFavorite)}
                            
                            }
                        }
                    }
                2->{
                    print("Ingrese el nombre del artista que quiere buscar:")
                    val stringToSearch = readLine()!!
                    var songsTosearch=MusicTable.select { MusicTable.artistName.like("%${stringToSearch}%") }
                    for (song in songsTosearch) {
                        println("${song.data.get(0)}) ${song.data.get(5)}\n")
                    }
                }
                3->{
                    var i=1
                    var songsTosearch=MusicTable.select { MusicTable.isFavorite.eq(true) }
                    for (song in songsTosearch) {
                        println("$${song.data.get(0)}) ${song.data.get(5)}\n")
                        i+=1
                    }
                }
                4->wantsToContinue=false
                else-> println("Esta opcion no esta en el menu")
            }
        } while (wantsToContinue)
    }

}