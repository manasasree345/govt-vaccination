package govt.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import govt.vaccination.model.QuestionsFAQ;

@Repository
public interface QuestionRepository  extends JpaRepository<QuestionsFAQ, Integer>{

}
