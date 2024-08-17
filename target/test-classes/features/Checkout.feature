Feature: place order for Products

Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When user search with Shortname <shortName> and extracted actual name of product
And Add "3" items of the selected product to cart
Then user proceeds to checkout and validates the item in checkout page
And verify user has provision to apply promocode

Examples: 
|shortName |
|   Tom    |


