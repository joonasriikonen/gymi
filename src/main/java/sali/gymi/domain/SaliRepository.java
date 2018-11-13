package sali.gymi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface SaliRepository extends CrudRepository <Sali, Long> {
    List<Sali> findByDay(String day);

	}