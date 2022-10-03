package govt.vaccination;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import govt.vaccination.model.UserDosage;
//import govt.vaccination.repository.UserDosageRepository;
//import govt.vaccination.utils.DateUtils;
import govt.vaccination.repository.UserDosageRepository;

@SpringBootTest
class GovtVaccinationApplicationTests {

	 @Autowired
	 UserDosageRepository userDosageRepository;
				 
	 
	@Test
	 void testCreate() {
		UserDosage u = new UserDosage();
		u.setUservaccinationId(25);
		u.setUserRegistrationId(12);
		u.setUservaccinationType("CovidShield");
		u.setUserFirstDose(true);
		u.setUserSecondDose(false);
	    u.setUserFirstDoseDate(Timestamp.from(Instant.parse("2020-01-01T17:10:10Z")));
	    u.setUserSecondDoseDate(Timestamp.from(Instant.parse("2020-01-01T17:10:10Z")));
		u.setUserAEFIpostFirstdose(true);
		u.setUserAEFIpostFirstdosedescription("mildfever");
		userDosageRepository.save(u);
		assertNotNull(userDosageRepository.findById(25).get());
	}
	
	
	
	@Test
    void testReadAll() {
	List<UserDosage> list	= userDosageRepository.findAll();
	assertThat(list).size().isGreaterThan(0);

	}

}
