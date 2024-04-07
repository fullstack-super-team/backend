package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

  @Test
  void testFromStringValidCategories() {
    assertEquals(Category.FOOD, Category.fromString("food"), "String 'food' should map to Category.FOOD");
    assertEquals(Category.SPORT, Category.fromString("sport"), "String 'sport' should map to Category.SPORT");
    assertEquals(Category.SCIENCE, Category.fromString("science"), "String 'science' should map to Category.SCIENCE");
    assertEquals(Category.HISTORY, Category.fromString("history"), "String 'history' should map to Category.HISTORY");
    assertEquals(Category.CULTURE, Category.fromString("culture"), "String 'culture' should map to Category.CULTURE");
  }

  @Test
  void testFromStringInvalidCategory() {
    assertEquals(Category.GENERAL, Category.fromString("nonexistent"), "Unrecognized category strings should default to Category.GENERAL");
  }

  @Test
  void testFromStringCaseSensitivity() {
    // Assuming the fromString method is case-sensitive based on the implementation shown.
    // If the implementation changes to be case-insensitive, adjust this test accordingly.
    assertEquals(Category.GENERAL, Category.fromString("Food"), "Case-sensitive strings that do not match exactly should default to Category.GENERAL");
  }
}
