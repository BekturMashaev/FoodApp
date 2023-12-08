package com.example.foodgroupapp.data.databse.fakeData

import com.example.foodgroupapp.data.databse.models.FoodModel

fun foodFakeData() = listOf<FoodModel>(
    FoodModel(
        foodName = "Cup Cake",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = 5,
        foodImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg2gvFMmqqdx8gtpZfrzBVJsW8ppYFEsLNJfb9QPL2fHIvQa4nzH0FFEYOiHC9AnRcWN8&usqp=CAU",
    ),
    FoodModel(
        foodName = "Donut",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = 3,
        foodImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg2gvFMmqqdx8gtpZfrzBVJsW8ppYFEsLNJfb9QPL2fHIvQa4nzH0FFEYOiHC9AnRcWN8&usqp=CAU",
    ),
    FoodModel(
        foodName = "Macaron",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = 6,
        foodImage = "https://www.simplyrecipes.com/thmb/u8qvNVK47o0-1HaMwGngoNneelo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Simply-Recipes-Chocolate-Macarons-Lead-3-07d3c26364604ddbb3fd3a40b6435a50.jpg",
    ),
)