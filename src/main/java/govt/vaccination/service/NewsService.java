package govt.vaccination.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import govt.vaccination.model.News;
import govt.vaccination.repository.NewsRepository;
import govt.vaccination.utils.DateUtils;
import govt.vaccination.utils.NewsVaccinationUtils;

@Service
public class NewsService {

	@Autowired
	NewsRepository newsRepository;

	

	public News save(News news) throws ParseException {
		
		news.setDescription(news.getDescription());

		  news.setNewsdescDate(DateUtils.getTodayDate());

		return newsRepository.save(news);
	}

	public List<News> getAllNews() {
		return newsRepository.findAll();
	}

	public Map<String, Object> getNewsStatistics() throws ParseException {
		List<News> userNewsList =  getAllNews();
		Map<String ,Object> responseMap = new HashMap<>();
		responseMap.put("totalStrength", userNewsList.size());
		
		
		//state 
				responseMap.put("description", NewsVaccinationUtils.getNewsListBasedOnNews(userNewsList));
				
				
				//Last 24 hours
				Date yesterdayDate = DateUtils.minusDays(DateUtils.getTodayDate(),1);
				
				responseMap.put("twentyfourhours",
						       NewsVaccinationUtils.getNewsListCountBasedOnDate(yesterdayDate, userNewsList));
				
				// Last 2 Days
				Date twoDaysBackDate = DateUtils.minusDays(DateUtils.getTodayDate(),2);
				
				responseMap.put("twodays",
						          NewsVaccinationUtils.getNewsListCountBasedOnDate(twoDaysBackDate, userNewsList));
				
				
				Date monthBackDate = DateUtils.minusDays(DateUtils.getTodayDate(),30);
				responseMap.put("onemonth",
						             NewsVaccinationUtils.getNewsListCountBasedOnDate(monthBackDate, userNewsList));
				return responseMap;
			}






	}
	
