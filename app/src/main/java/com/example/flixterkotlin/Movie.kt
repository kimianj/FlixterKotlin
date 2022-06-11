package com.example.flixterkotlin



import org.json.JSONArray

data class Movie (
    val backdropPath:String,
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
){
    val PosterImageURL = "https://image.tmdb.org/t/p/w342/$posterPath"
    val BackDropPath = "https://image.tmdb.org/t/p/w342/$backdropPath"
    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
           val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){
                val movieJSON = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJSON.getString(("backdrop_path")),
                        movieJSON.getInt("id"),
                        movieJSON.getString("poster_path"),
                        movieJSON.getString("title"),
                        movieJSON.getString("overview"),



                    )
                )
            }
            return movies
        }
    }
}