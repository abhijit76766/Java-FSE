package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Hands on 3 (doc 2): repository for the Skill entity.
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
