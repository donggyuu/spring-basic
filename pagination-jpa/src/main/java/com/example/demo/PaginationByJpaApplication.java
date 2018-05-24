package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Country;
import com.example.demo.repositories.CountryRepository;

@SpringBootApplication
public class PaginationByJpaApplication implements CommandLineRunner {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PaginationByJpaApplication.class, args);
	}
	
	// Insert sample data before starting.
	@Override
	public void run(String... args) throws Exception {
		countryRepository.save(new Country("Earth1", "World1"));
		countryRepository.save(new Country("Earth2", "World2"));
		countryRepository.save(new Country("Earth3", "World3"));
		countryRepository.save(new Country("Earth4", "World4"));
		countryRepository.save(new Country("Earth5", "World5"));
		countryRepository.save(new Country("Earth6", "World6"));
		countryRepository.save(new Country("Earth7", "World7"));
		countryRepository.save(new Country("Earth8", "World8"));
		countryRepository.save(new Country("Earth9", "World9"));
		countryRepository.save(new Country("Earth10", "World10"));
		countryRepository.save(new Country("Earth11", "World11"));
		countryRepository.save(new Country("Earth12", "World12"));
		
		countryRepository.save(new Country("Earth11", "World1"));
		countryRepository.save(new Country("Earth12", "World2"));
		countryRepository.save(new Country("Earth13", "World3"));
		countryRepository.save(new Country("Earth14", "World4"));
		countryRepository.save(new Country("Earth15", "World5"));
		countryRepository.save(new Country("Earth16", "World6"));
		countryRepository.save(new Country("Earth17", "World7"));
		countryRepository.save(new Country("Earth18", "World8"));
		countryRepository.save(new Country("Earth19", "World9"));
		countryRepository.save(new Country("Earth110", "World10"));
		countryRepository.save(new Country("Earth111", "World11"));
		countryRepository.save(new Country("Earth112", "World12"));
		
		
		countryRepository.save(new Country("Earth1", "World1"));
		countryRepository.save(new Country("Earth2", "World2"));
		countryRepository.save(new Country("Earth3", "World3"));
		countryRepository.save(new Country("Earth4", "World4"));
		countryRepository.save(new Country("Earth5", "World5"));
		countryRepository.save(new Country("Earth6", "World6"));
		countryRepository.save(new Country("Earth7", "World7"));
		countryRepository.save(new Country("Earth8", "World8"));
		countryRepository.save(new Country("Earth9", "World9"));
		countryRepository.save(new Country("Earth10", "World10"));
		countryRepository.save(new Country("Earth11", "World11"));
		countryRepository.save(new Country("Earth12", "World12"));
		
		
	}
}
