@regression @UI
Feature: Pizza application place order functionality

  @RTB-5
  Scenario Outline: Validating successful place order
    Given user navigates to "PizzaApp" application
    When user creates pizza order with data
      | Pizza    | <Pizza>    |
      | Topping1 | <Topping1> |
      | Topping2 | <Topping2> |
      | Quantity | <Quantity> |
      | Name     | <Name>     |
      | Email    | <Email>    |
      | Phone    | <Phone>    |
      | Payment  | <Payment>  |

    Then user validates that order is created with message "Thank you for your order! TOTAL: " "<Quantity>" "<Pizza>"

    Examples:
      | Pizza                        | Topping1           | Topping2          | Quantity | Name        | Email           | Phone     | Payment        |
      | Small 6 Slices - no toppings | Mushrooms          | Extra cheese      | 1        | Patel Harsh | patel@gmail.com | 123456789 | Cash on Pickup |
      | Medium 8 Slices - 2 toppings | Diced Mango        | Salami            | 2        | John Doe    | doe@gmail.com   | 223456789 | Credit Card    |
      | Large 10 Slices - 2 toppings | Caramelized onions | Mozzarella cheese | 11       | Jane Pit    | janep@gmail.com | 423456789 | Cash on Pickup |