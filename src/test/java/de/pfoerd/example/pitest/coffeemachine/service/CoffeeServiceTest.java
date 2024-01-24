package de.pfoerd.example.pitest.coffeemachine.service;

import de.pfoerd.example.pitest.coffeemachine.repo.RecipeTO;
import de.pfoerd.example.pitest.coffeemachine.repo.DrinksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static de.pfoerd.example.pitest.coffeemachine.repo.RecipeTO.DEFAULT_RECIPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CoffeeServiceTest {
  @Mock
  DrinksRepository drinksRepo;
  @InjectMocks
  CoffeeService    service;

  @BeforeEach
  void beforeEach() {
    List<RecipeTO> recipes = List.of(
        DEFAULT_RECIPE,
        new RecipeTO(1, "cappuccino"),
        new RecipeTO(2, "latte macchiato")
    );
    when(drinksRepo.getRecipes()).thenReturn(recipes);
  }

  @Test
  void returnsDefaultRecipeForCoffee() {
    // when
    RecipeTO result = service.getRecipe("coffee");

    // then
    assertThat(result).isSameAs(DEFAULT_RECIPE);
  }

  @ParameterizedTest
  @CsvSource({ "cappuccino,1", "latte macchiato,2" })
  void returnsRecipeForCoffeeType(String drinkType, int expectedRecipeId) {
    // when
    RecipeTO result = service.getRecipe(drinkType);

    // then
    assertThat(result.id()).isEqualTo(expectedRecipeId);
  }
}