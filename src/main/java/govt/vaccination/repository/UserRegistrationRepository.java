package govt.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import govt.vaccination.model.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

	UserRegistration findByUserRegistrationId(Integer userRegistrationId);

	UserRegistration findByUserEmailAndUserPassword(String userEmail, String userPassword);

	


}
