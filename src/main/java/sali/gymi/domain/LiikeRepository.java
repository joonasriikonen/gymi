package sali.gymi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface LiikeRepository extends CrudRepository <Liike, Long> {
    List<Liike> findByLiikeName(String liikeName);

	}