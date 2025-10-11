package com.example.GroupOfHero.Controller;

import com.example.GroupOfHero.Entity.Hero;
import com.example.GroupOfHero.Service.SelectHeroService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final SelectHeroService selectHeroService;

    public HeroController(SelectHeroService selectHeroService) {
        this.selectHeroService = selectHeroService;
    }

    @GetMapping("/name/{name}")
    public List<Hero> getHeroesByName(@PathVariable String name) {
        return selectHeroService.findByName(name);
    }

    @GetMapping("/classtype/{classtype}")
    public List<Hero> getHeroesByClasstype(@PathVariable String classtype) {
        return selectHeroService.findByClasstype(classtype);
    }
    @GetMapping("/level/greater/{level}")
    public List<Hero> getHeroesByLevelGreaterThan(@PathVariable int level) {
        return selectHeroService.findByLevelGreaterThan(level);
    }
    @GetMapping("/level/less/{level}")
    public List<Hero> getHeroesByLevelLessThan(@PathVariable int level) {
        return selectHeroService.findByLevelLessThan(level);
    }
    @GetMapping("/weapon/{weapon}")
    public List<Hero> getHeroesByWeapon(@PathVariable String weapon) {
        return selectHeroService.findByWeapon(weapon);
    }
    @PostMapping("/ids")
    public List<Hero> getHeroesByIds(@RequestBody List<Long> ids) {
        return selectHeroService.findByIdIn(ids);
    }
    @GetMapping("/alias/{alias}")
    public Hero getHeroByAlias(@PathVariable String alias) {
        return selectHeroService.findByAlias(alias);
    }
    @GetMapping("/all")
    public List<Hero> findAll() {
        return selectHeroService.findAll();
    }
    @PostMapping("/add")
    public List<Hero> addHero(@RequestBody Hero hero) {
        return selectHeroService.addHero(hero);
    }
    @DeleteMapping("/delete/{id}")
    public List<Hero> deleteHero(@PathVariable Long id) {
        return selectHeroService.deleteHero(id);
    }
}

