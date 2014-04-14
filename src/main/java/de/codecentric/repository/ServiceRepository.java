package de.codecentric.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import de.codecentric.domain.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {

    List<Service> findByName(String name);
    
	/**
	 * Returns all {@link Service}s having the given name and version.
	 * 
	 * @param attribute
	 * @return
	 */
	@Cacheable("services")
	Service findByNameAndVersion(String name, String version);
}
