package com.anggit97.data.user


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    @SerializedName("items")
    val items: List<UserItem?>?,
    @SerializedName("total_count")
    val totalCount: Int?
)