package govt.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import govt.vaccination.model.QuestionsFAQ;
import govt.vaccination.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	public List<QuestionsFAQ> findAll() {
		return questionRepository.findAll();
	}
	
	
	public QuestionsFAQ save(QuestionsFAQ question) {
		return questionRepository.save(question);
	}


	

	public String deleteById(Integer faqId) {
		questionRepository.deleteById(faqId);
		return "Record Deleted Succesfully";

	}


	

}
