package com.example.GroupOfHero.Repository;

import com.example.GroupOfHero.Entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findByName(String name);
    List<Hero> findByClasstype(String classtype);
    List<Hero> findByLevelGreaterThan(int level);
    List<Hero> findByLevelLessThan(int level);
    List<Hero> findByWeapon(String weapon);
    List<Hero> findByIdIn(List<Long> ids);
    Hero findByAlias(String alias);


}
