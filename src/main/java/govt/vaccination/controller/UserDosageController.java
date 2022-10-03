package govt.vaccination.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import govt.vaccination.model.UserDosage;
import govt.vaccination.service.UserDosageService;
import govt.vaccination.utils.DateUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/userdoses")
public class UserDosageController {
	@Autowired
	UserDosageService  userDosageService;
     
	@GetMapping("/viewalldoses")
	public List<UserDosage>  getAlldosesList(){
		return userDosageService.getAlldosesList();
	}
	

	@GetMapping("/userstatistics")
	public Map<String,Object> getUserDosageStatistics() throws ParseException {
		return userDosageService.getUserDosageStatistics();
		
	}
	

	@PostMapping("/add")
	public UserDosage insertUserDosage(@RequestBody UserDosage userDosage ) throws ParseException {
		userDosage.setUserFirstDoseDate(DateUtils.getTodayDate());
		userDosage.setUserSecondDoseDate(DateUtils.getTodayDate());
     return userDosageService.save(userDosage); 
}

}
