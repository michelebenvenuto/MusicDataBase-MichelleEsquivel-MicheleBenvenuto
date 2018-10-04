class Buscador{
    fun buscarPorNombre(songs:Array<Song>, name:String):List<Song>{
        var filteredSongs: List<Song>
        filteredSongs=songs.filter { it.song.contains(name) }
        return filteredSongs
    }
    fun buscarPorAutor(songs:Array<Song>, name:String):List<Song>{
        var filteredSongs: List<Song>
        filteredSongs=songs.filter { it.artistName==name }
        return filteredSongs
    }
}