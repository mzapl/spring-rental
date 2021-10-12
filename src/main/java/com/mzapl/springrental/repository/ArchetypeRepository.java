package com.mzapl.springrental.repository;

import com.mzapl.springrental.model.Archetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchetypeRepository extends JpaRepository<Archetype, Long> {
}
