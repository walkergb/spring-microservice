package walker.ian.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import walker.ian.ratingsdataservice.model.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingsDataController {
	 @RequestMapping("/{movieId}")
	    public Rating getRating(@PathVariable("movieId") String movieId) {
	        return new Rating(movieId, 4);
	}

}
