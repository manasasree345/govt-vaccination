package govt.vaccination.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import govt.vaccination.model.News;
import govt.vaccination.service.NewsService;
import govt.vaccination.utils.DateUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("news")
public class NewsController {
	@Autowired
	NewsService newsService;
	
	@GetMapping("/view")
	public List<News> getAllNews(){
		
		
		return newsService.getAllNews();
			
		}
	

	@GetMapping("/newsstatistics")
	public Map getNewsStatistics() throws ParseException {
		
		return newsService.getNewsStatistics();
		
	}
	
	
	@PostMapping("/add")
	public News insertUserRegistration(@RequestBody News  news ) throws ParseException {
		//news.setDescription(DateUtils.getTodayDate());
	   news.setNewsdescDate(DateUtils.getTodayDate());
       return newsService.save(news); 
}
	


}
