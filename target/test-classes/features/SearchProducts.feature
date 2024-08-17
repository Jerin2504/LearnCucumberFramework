Feature: Search and place order for Products

Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When user search with Shortname <shortName> and extracted actual name of product
Then user search fro same <shortName> in offers page to check the product exists

Examples: 
|shortName |
|   Tom    |
|   Beet   |

