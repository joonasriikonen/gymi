package sali.gymi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface VisitRepository extends CrudRepository <Visit, Long> {
    List<Visit> findByDate(String date);

	}