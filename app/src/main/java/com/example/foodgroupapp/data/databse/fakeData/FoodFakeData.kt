package com.example.foodgroupapp.data.databse.fakeData

import com.example.foodgroupapp.data.databse.models.FoodModel

fun foodFakeData() = listOf<FoodModel>(
    FoodModel(
        foodName = "Cup Cake",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = 5,
        foodImage = "https://leitesculinaria.com/wp-content/uploads/2021/10/classic-vanilla-cupcakes-1.jpg",
    ),
    FoodModel(
        foodName = "Donut",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = 3,
        foodImage = "https://socialrevelry.com/cdn/shop/products/ScreenShot2021-05-14at11.59.06AM_800x.png?v=1621008032",
    ),
    FoodModel(
        foodName = "Macaron",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = 6,
        foodImage = "https://www.simplyrecipes.com/thmb/u8qvNVK47o0-1HaMwGngoNneelo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Simply-Recipes-Chocolate-Macarons-Lead-3-07d3c26364604ddbb3fd3a40b6435a50.jpg",
    ),
)