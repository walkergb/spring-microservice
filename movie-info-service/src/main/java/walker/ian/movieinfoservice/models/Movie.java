package walker.ian.movieinfoservice.models;

public class Movie {
	private String movieId;
	private String title;

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Movie(String title, String movieId) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.movieId = movieId;
	}
	
	public Movie() {
		
	}
	
}
