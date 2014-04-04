/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.codecentric;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import de.codecentric.domain.Service;
import de.codecentric.repository.ServiceRepository;

/**
 * Integration tests for {@link ServiceRepository}.
 * 
 * @author Dennis Schulte
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = Application.class)
public class ServiceRepositoryIntegrationTest {

	@Autowired
	ServiceRepository repository;

	@Test
	public void savesNewService() {

		//Given
		Service service = new Service("service1","1.0","http://localhost:8080/service1","Testmessage");
		
		//When
		Service result = repository.save(service);

		//Then
		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(notNullValue()));
		assertThat(result.getName(), is("service1"));
		assertThat(result.getVersion(), is("1.0"));
		assertThat(result.getUrl(), is("http://localhost:8080/service1"));
		assertThat(result.getMessage(), is("Testmessage"));
	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void savesNewServiceWithNull() {

		//Given
		Service service = new Service("service1","1.0",null,null);
		
		//When
		Service result = repository.save(service);

		//Then
		assertThat(result, is(notNullValue()));
	}
	
	@Test
	public void findServiceByName() {

		//Given
		String name = "service1";
		
		//When
		List<Service> result = repository.findByName(name);

		//Then
		assertThat(result, is(notNullValue()));
		assertThat(result.get(0).getName(), is("service1"));
	}

	@Test
	public void findServiceByNameAndVersion() {

		//Given
		String name = "service1";
		String version = "1.0";
		
		//When
		Service result = repository.findByNameAndVersion(name,version);

		//Then
		assertThat(result, is(notNullValue()));
		assertThat(result.getName(), is("service1"));
		assertThat(result.getVersion(), is("1.0"));
	}
	
	public void findServiceByNameAndVersionNotFound() {

		//Given
		String name = "service1";
		String version = "x.0";
		
		//When
		Service service = repository.findByNameAndVersion(name,version);

		//Then
		assertThat(service, is(notNullValue()));
		
	}
	
}
