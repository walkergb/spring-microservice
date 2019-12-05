package walker.ian.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import walker.ian.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Name for ID " + movieId);
	}

}
