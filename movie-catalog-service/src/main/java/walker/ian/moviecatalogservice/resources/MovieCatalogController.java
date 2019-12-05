package walker.ian.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import walker.ian.moviecatalogservice.models.CatalogItem;
import walker.ian.moviecatalogservice.models.Movie;
import walker.ian.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
		public List<CatalogItem> getCatalog(@PathVariable("userId")String userId){
		
			List<Rating> ratings = Arrays.asList(
					new Rating("3256", 88),
					new Rating("7064", 24),
					new Rating("2062", 58)
			);
			
			return ratings.stream().map(rating -> {
                Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getTitle(), "Description", rating.getRating());
            })
            .collect(Collectors.toList());
		}
	
}
