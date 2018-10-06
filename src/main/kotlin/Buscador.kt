object Buscador{
    fun findById(songs:Array<Song>, id:Int):Song{
        var filteredSong: Song
        filteredSong=songs[id]
        return filteredSong
    }
    fun buscarPorAutor(songs:Array<Song>, name:String):List<Song>{
        var filteredSongs: List<Song>
        filteredSongs=songs.filter { it.artistName==name }
        return filteredSongs
    }
}