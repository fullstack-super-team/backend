package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

  @Test
  void testFromStringValidCategories() {
    assertEquals(Category.FOOD, Category.fromString("food"), "String 'food' should map to Category.FOOD");
    assertEquals(Category.DRINK, Category.fromString("drink"), "String 'drink' should map to Category.DRINK");
    assertEquals(Category.CLOTHING, Category.fromString("clothing"), "String 'clothing' should map to Category.CLOTHING");
    assertEquals(Category.ELECTRONICS, Category.fromString("electronics"), "String 'electronics' should map to Category.ELECTRONICS");
    assertEquals(Category.BOOKS, Category.fromString("books"), "String 'books' should map to Category.BOOKS");
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
