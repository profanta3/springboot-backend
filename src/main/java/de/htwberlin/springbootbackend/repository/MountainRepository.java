package de.htwberlin.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.htwberlin.springbootbackend.model.Mountain;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, Long>{

}
