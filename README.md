# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.shaan.shoppingcart.shopping-cart' is invalid and this project uses 'com.shaan.shoppingcart.shoppingcart' instead.

# Getting Started

API references:

1. GetDiscountRules: Get the discount rules for different types of customers.
Url: http://localhost:8090/rest/shoppingcart/discounts/{customerType}
Method: GET
Produces: application/json

Sample API response:
a. URL: http://localhost:8090/rest/shoppingcart/discounts/general
Output Json response:
{
    "discountRules": [
        {
            "discountId": 1001,
            "title": "general_1_5000",
            "customerType": "general",
            "priceBandStart": 1,
            "priceBandEnd": 5000,
            "percentageDiscount": 0
        },
        {
            "discountId": 1002,
            "title": "general_5001_10000",
            "customerType": "general",
            "priceBandStart": 5001,
            "priceBandEnd": 10000,
            "percentageDiscount": 10
        },
        {
            "discountId": 1003,
            "title": "general_10001_1000000",
            "customerType": "general",
            "priceBandStart": 10001,
            "priceBandEnd": 1000000,
            "percentageDiscount": 20
        }
    ]
}

b. URL: http://localhost:8090/rest/shoppingcart/discounts/premium
Output Json response:
{
    "discountRules": [
        {
            "discountId": 1004,
            "title": "premium_1_4000",
            "customerType": "premium",
            "priceBandStart": 1,
            "priceBandEnd": 4000,
            "percentageDiscount": 10
        },
        {
            "discountId": 1005,
            "title": "premium_4001_8000",
            "customerType": "premium",
            "priceBandStart": 4001,
            "priceBandEnd": 8000,
            "percentageDiscount": 15
        },
        {
            "discountId": 1006,
            "title": "premium_8001_12000",
            "customerType": "premium",
            "priceBandStart": 8001,
            "priceBandEnd": 12000,
            "percentageDiscount": 20
        },
        {
            "discountId": 1007,
            "title": "premium_12001_1000000",
            "customerType": "premium",
            "priceBandStart": 12001,
            "priceBandEnd": 1000000,
            "percentageDiscount": 30
        }
    ]
}

2. PostDiscountRules: Define the discount rules for different types of customers.
Url: http://localhost:8090/rest/shoppingcart/discounts/
Method: POST
Consumes: application/json requestBody - DiscountRule
Produces: application/json responseBody - DiscountRule

Sample API: 
URL: http://localhost:8090/rest/shoppingcart/discounts/
RequestBody: {
	"title": "premium_12000_above",
	"customerType": "premium",
	"priceBandStart": 12001,
	"priceBandEnd": 1000000,
	"percentageDiscount" : 30
}

Output response: 

{
    "discountRules": [
        {
            "discountId": 7,
            "title": "premium_12000_above",
            "customerType": "premium",
            "priceBandStart": 12001,
            "priceBandEnd": 1000000,
            "percentageDiscount": 30
        }
    ]
}

3. GetTotalDiscount: Get the total discount for a given type of customer for the given total cart amount.
Url: http://localhost:8090/rest/shoppingcart/calculateDiscountedPrice/{customerType}/{totalCartAmount}
Method: GET
Produces: application/json

a. Sample api:
URL: http://localhost:8090/rest/shoppingcart/calculateDiscountedPrice/premium/20000
Output: 
{
    "totalCartAmount": 20000,
    "discountedAmount": 15800,
    "totalDiscount": 4200,
    "discountType": "premium"
}

b. Sample api:
URL: http://localhost:8090/rest/shoppingcart/calculateDiscountedPrice/general/20000
Output: 
{
    "totalCartAmount": 20000,
    "discountedAmount": 17500,
    "totalDiscount": 2500,
    "discountType": "general"
}

