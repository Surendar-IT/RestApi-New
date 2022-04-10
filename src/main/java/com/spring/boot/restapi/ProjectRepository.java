package com.spring.boot.restapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

	@Repository
	public interface ProjectRepository extends CrudRepository<Project, Long>{

		@Override
		Iterable<Project> findAllById(Iterable<Long> iterable);
		
	}
