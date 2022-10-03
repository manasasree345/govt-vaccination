package govt.vaccination.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import govt.vaccination.model.News;
import govt.vaccination.model.QuestionsFAQ;
import govt.vaccination.service.NewsService;
import govt.vaccination.service.QuestionService;
import govt.vaccination.utils.DateUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	
	@GetMapping("/view")
	public List<QuestionsFAQ> getAllQuestionsFAQ(){
		
		return  questionService.findAll();
			
		}
	
    
	@PostMapping("/add")
	
	public QuestionsFAQ insertUserRegistration(@RequestBody QuestionsFAQ  question ) throws ParseException {
		
		
     return questionService.save(question); 
}
	
	@DeleteMapping("delete/{id}")
	 public String deletefaqId(@RequestParam(value="faqId") Integer faqId)
	    {
		questionService.deleteById(faqId);
		
       	return "Record Deleted Succesfully";
	    }
}
