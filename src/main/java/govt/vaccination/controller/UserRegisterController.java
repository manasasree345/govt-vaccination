package govt.vaccination.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import govt.vaccination.model.ListResponse;
import govt.vaccination.model.Response;
import govt.vaccination.model.UserRegistration;
import govt.vaccination.service.UserRegistrationService;
import govt.vaccination.utils.DateUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/userregistrations")
public class UserRegisterController {

	@Autowired
	UserRegistrationService userRegistrationService;

	@GetMapping("/allregisteredusers")
	public ListResponse getAllUserRegistration() {

		return userRegistrationService.getAllUserRegistration();

	}

	@GetMapping("eachuser/{userRegistrationId}")
	public Response getUserRegistrationId(@RequestParam("userRegistrationId") Integer userRegistrationId) {
		return userRegistrationService.getUserRegistrationId(userRegistrationId);
	}

	@GetMapping("/userstatistics")
	public Map<String, Object> getUserRegistrationStatistics() throws ParseException {
		return userRegistrationService.getUserRegistrationStatistics();

	}

	@PostMapping("login/{userEmail},{userPassword}")
	public Response userLogin(@RequestParam(name = "userEmail") String userEmail,
			@RequestParam(name = "userPassword") String userPassword) {

		return userRegistrationService.userLogin(userEmail, userPassword);
	}

	@PostMapping("/add")
	public Response insertUserRegistration(@RequestBody UserRegistration userRegistration) throws ParseException {
		userRegistration.setUserUserregistrationdate(DateUtils.getTodayDate());
		return userRegistrationService.save(userRegistration);
	}
	
	
	 	
	
}
	
	
	
	
	
	

