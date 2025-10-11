package com.example.GroupOfHero.Service;

import com.example.GroupOfHero.Entity.Hero;
import com.example.GroupOfHero.Repository.HeroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SelectHeroService {

    private final HeroRepository heroRepository;

    public SelectHeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> findByName(String name) {
        return heroRepository.findByName(name); }

    public List<Hero> findByClasstype(String classtype) {
        return heroRepository.findByClasstype(classtype); }

    public List<Hero> findByLevelGreaterThan(int level) {
        return heroRepository.findByLevelGreaterThan(level); }

    public List<Hero> findByLevelLessThan(int level) {
        return heroRepository.findByLevelLessThan(level); }

    public List<Hero> findByWeapon(String weapon) {
        return heroRepository.findByWeapon(weapon); }

    public List<Hero> findByIdIn(List<Long> ids) {
        return heroRepository.findByIdIn(ids); }

    public Hero findByAlias(String alias) {
        return heroRepository.findByAlias(alias);
    }
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }
    public List<Hero> addHero(Hero hero) {
        heroRepository.save(hero);
        return heroRepository.findAll();
    }
    public List<Hero> deleteHero(Long id) {
        heroRepository.deleteById(id);
        return heroRepository.findAll();
    }

}
