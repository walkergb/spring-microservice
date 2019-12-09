package walker.ian.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import walker.ian.moviecatalogservice.models.CatalogItem;
import walker.ian.moviecatalogservice.models.Movie;
import walker.ian.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
		public List<CatalogItem> getCatalog(@PathVariable("userId")String userId){
			
			UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/" + userId, UserRating.class);
			
			return ratings.getUserRating().stream().map(rating -> {
				//for each movie ID, call movie info service and get details
                Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                //put everything together (movie title from movie-info, and rating from the list of ratings returned by the 
                //ratings-data service call 
                return new CatalogItem(movie.getTitle(), "Description", rating.getRating());
            })
            .collect(Collectors.toList());
		}
	
}
