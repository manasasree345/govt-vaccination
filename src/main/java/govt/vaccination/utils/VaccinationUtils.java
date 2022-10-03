package govt.vaccination.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import govt.vaccination.model.UserDosage;
import govt.vaccination.model.UserRegistration;
import govt.vaccination.repository.UserRegistrationRepository;

@Service
@SuppressWarnings("unused")
public class VaccinationUtils {
	

	@Autowired
	UserRegistrationRepository userRegistrationRepository;

	public static int getGenderListCount(String genderType, List<UserRegistration>  userRegistrationList) {
		
	return (int) userRegistrationList.stream().filter(o-> o.getUserGender().equals(genderType)).count();
	}
	
	
	
		
	
	
	public static int getRegistrationListCountBasedOnDate(Date date,List<UserRegistration> userRegistrationList ) {
		
		return (int) userRegistrationList.stream().filter(o->date.before(o.getUserUserregistrationdate())).count();
		}
	
	
	
	
	public static Map<String , Integer>  getRegistrationListBasedOnState(List<UserRegistration> userRegistrationList){
		
		Map<String,Integer> stateMap = new HashMap<>();
		Set<String> stateList = userRegistrationList.stream().map(l ->l.getUserState()).collect(Collectors.toSet());
		
		
		for(String state : stateList) {
			stateMap.put(state, (int) userRegistrationList.stream().filter(l ->l.getUserState().equals(state)).count());
		}
		
		return stateMap;
	}
	
	

	
	
	
	
	
	public static int getUserDosageListCountBasedOnDateCount(Date date , List<UserDosage> userDosageList) {
		return (int) userDosageList.stream().filter(o->o.getUserFirstDoseDate()!=null).filter(o -> date.before(o.getUserFirstDoseDate())).count();
	}
	

	public static Map<String,Integer>  getUserDosageListCountBasedOnDoseCount(List<UserDosage> userDosageList){
		Map<String , Integer> vaccinMap = new HashMap<>();
		
		Set<String> vaccinList = userDosageList.stream().map(l->l.getUservaccinationType()).collect(Collectors.toSet());
		
		for(String user_vaccinatedType : vaccinList) {
			
			vaccinMap.put(user_vaccinatedType, (int)userDosageList.stream().filter(l->l.getUservaccinationType().equals(user_vaccinatedType)).count());
		}
		return vaccinMap;
	}
	

	
	
	public   int getGenderListCountForDosage(String genderType, List<UserDosage>  userDosageList) {
		
		Set<Integer> userDosageRegistrationIdList = userDosageList.stream().filter(Objects :: nonNull).map(l ->l.getUserRegistrationId()).collect(Collectors.toSet());
		
		List<UserRegistration> userDosageRegistrationList= new ArrayList<>();
		
		if(userDosageRegistrationList!= null) {
			
			for(Integer id : userDosageRegistrationIdList ) {
				
				UserRegistration userRegistration=userRegistrationRepository.findByUserRegistrationId(id);
				
				if(userRegistration != null) {
					userDosageRegistrationList.add(userRegistration);
				}

			}
			
		}
		
		if(userDosageRegistrationList != null) {
			return(int) userDosageRegistrationList.stream().filter(o->o.getUserGender()!=null).filter(o->o.getUserGender().equalsIgnoreCase(genderType)).count();
					
		}
	
		return 0;
	}
		
		

	public static int getAEFIPostFirstDosage(List<UserDosage>  userDosageList) {
		
		return (int) userDosageList.stream().filter(l-> l.isUserFirstDose() == true &&  l.isUserAEFIpostFirstdose() == true).count();
		}
	
		
		}
	
		
	

		
	
	

