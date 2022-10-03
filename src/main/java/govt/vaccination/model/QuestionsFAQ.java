package govt.vaccination.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class QuestionsFAQ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer faqId;
	private String question;
	private String answer;
}
