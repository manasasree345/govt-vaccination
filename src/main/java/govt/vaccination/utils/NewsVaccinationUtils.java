package govt.vaccination.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import govt.vaccination.model.News;

public class NewsVaccinationUtils {

	public static int getNewsListCount(String newsType, List<News>  userNewsList) {
		
		return (int) userNewsList.stream().filter(o->o.getNewsdescDate().equals(newsType)).count();
		}
		
		
		
		public static int getNewsListCountBasedOnDate(Date date,List<News> userNewsList ) {
			
			return (int) userNewsList.stream().filter(o->date.before(o.getNewsdescDate())).count();
			}
		
		
		
		
		public static Map<String , Integer>  getNewsListBasedOnNews(List<News> userNewsList){
			
			Map<String,Integer> newsMap = new HashMap<>();
			Set<String> newsList = userNewsList.stream().map(l ->l.getDescription()).collect(Collectors.toSet());

			
			for(String news : newsList) {
				newsMap.put(news, (int) userNewsList.stream().filter(l ->l.getDescription().equals(news)).count());
			}
			
			return newsMap;
		}
	}


