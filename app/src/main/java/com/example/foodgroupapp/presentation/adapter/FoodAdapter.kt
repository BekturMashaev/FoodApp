package com.example.foodgroupapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodgroupapp.R
import com.example.foodgroupapp.data.databse.models.FoodModel
import com.example.foodgroupapp.databinding.FoodItemBinding

class FoodAdapter(
    private val listener: ItemCLickListener,
    private val context:Context
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private var foodList = mutableListOf<FoodModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(foodSmallList: List<FoodModel>) {
        foodList.clear()
        foodList.addAll(foodSmallList)
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            binding.apply {
                foodNameTxt.text = foodModel.foodName
                descriptionTxt.text = foodModel.foodDescription
                priceTxt.text = "${foodModel.foodPrice}$"
                itemCv.setOnClickListener {
                    listener.onFoodItemClick(foodModel)
                }
                Glide.with(context).load(foodModel.foodImage).into(foodIv)
                cartItemIv.setOnClickListener{
                    listener.onSendItemClick(foodModel)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): FoodViewHolder {
        val binding = FoodItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        )
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size


    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int,
    ) {
        holder.bind(foodList[position])
    }
}