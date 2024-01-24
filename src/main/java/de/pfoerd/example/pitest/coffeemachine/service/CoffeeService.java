package de.pfoerd.example.pitest.coffeemachine.service;

import de.pfoerd.example.pitest.coffeemachine.repo.RecipeTO;
import de.pfoerd.example.pitest.coffeemachine.repo.DrinksRepository;

import static de.pfoerd.example.pitest.coffeemachine.repo.RecipeTO.DEFAULT_RECIPE;

class CoffeeService {
  private final DrinksRepository drinksRepo;

  CoffeeService(DrinksRepository drinksRepo) {
    this.drinksRepo = drinksRepo;
  }

  RecipeTO getRecipe(String drinkType) {
    if ("Coffee".equals(drinkType)) {
      return DEFAULT_RECIPE;
    }

    return drinksRepo.getRecipes()
        .stream()
        .filter(recipe -> recipe.name().equals(drinkType))
        .findFirst()
        .orElseThrow();
  }
}