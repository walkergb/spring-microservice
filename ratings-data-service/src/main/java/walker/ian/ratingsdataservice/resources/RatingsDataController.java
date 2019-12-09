package walker.ian.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import walker.ian.ratingsdataservice.model.Rating;
import walker.ian.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings/")
public class RatingsDataController {
	 @RequestMapping("/{movieId}")
	    public Rating getRating(@PathVariable("movieId") String movieId) {return new Rating(movieId, 4);}
	 @RequestMapping("users/{userId}")   
	 public UserRating getUserRating(@PathVariable("userId") String userId) {
	    	List<Rating> ratings = Arrays.asList(
	    			new Rating("1234", 4),
	    			new Rating("4952", 8)
	    			);
	    UserRating userRating = new UserRating();
	    userRating.setUserRating(ratings);
	    return userRating;
	    }

}
