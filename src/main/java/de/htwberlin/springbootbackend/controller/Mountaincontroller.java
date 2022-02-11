package de.htwberlin.springbootbackend.controller;
import de.htwberlin.springbootbackend.model.Mountain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.springbootbackend.repository.MountainRepository;


@RestController
@RequestMapping("/api/v1/")
public class Mountaincontroller {

	@Autowired
	private MountainRepository mountainRepository;
	
	//get all employees REST API
	@GetMapping("/mountains")
	public List<Mountain> getAllMountains() {
		return mountainRepository.findAll();
	}
	
	//get specific employees REST API
	@GetMapping("/mountains/{id}")
	public Optional<Mountain> getAllMountains(@PathVariable Long id) {
		return mountainRepository.findById(id);
	}
	
	@PostMapping("/mountains")
	Mountain newMountain(@RequestBody Mountain newMountain) {
		return mountainRepository.save(newMountain);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/mountains/{id}")
	Mountain replaceMountain(@RequestBody Mountain newMountain, @PathVariable Long id) {
		Mountain updatedMountain = mountainRepository.findById(id)
				.map(mountain -> {
					mountain.setName(newMountain.getName());
					mountain.setLocation(newMountain.getLocation());
					mountain.setLength(newMountain.getLength());
					mountain.setImageUrl(newMountain.getImageUrl());
					mountain.setMaxHight(newMountain.getMaxHight());
					return mountainRepository.save(mountain);
				})
				.orElseGet(() -> {
					newMountain.setId(id);
					return mountainRepository.save(newMountain);
				});
		System.out.println("Added mountain: "+updatedMountain);
		
		return mountainRepository.getById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("mountains/{id}")
	List<Mountain> removeMountain(@PathVariable Long id) {
		mountainRepository.deleteById(id);
		return mountainRepository.findAll();
	}
	
	
}
