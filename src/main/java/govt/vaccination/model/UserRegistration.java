package govt.vaccination.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;



@Data
@Entity
@Table(name = "users")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRegistrationId;
	private String userUsername;
	private String userPassword;
	private String userGender;
	private String userState;
	private String userMobile;
	private String userEmail;
	@Temporal(TemporalType.TIMESTAMP)
	private Date userUserregistrationdate;

}