package de.pfoerd.example.pitest.coffeemachine.repo;

import java.util.List;

public interface DrinksRepository {
  public List<RecipeTO> getRecipes();
}
