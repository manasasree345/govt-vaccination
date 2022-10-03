package govt.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import govt.vaccination.model.News;

public interface NewsRepository  extends JpaRepository<News, Integer>{

}
