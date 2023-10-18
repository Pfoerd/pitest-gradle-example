package de.pfoerd.example.pitest.coffeemachine.repo;

public record RecipeTO(int id, String name) {
  public static final RecipeTO DEFAULT_RECIPE = new RecipeTO(0, "coffee");
}
