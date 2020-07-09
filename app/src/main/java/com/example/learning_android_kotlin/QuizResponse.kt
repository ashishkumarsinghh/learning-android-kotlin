package com.example.learning_android_kotlin

import com.google.gson.annotations.SerializedName

class QuizResponse {
    @SerializedName("results")
    var results: ArrayList<Question>?=null
}

class Question{
    @SerializedName("category")
    var category:String?=null

    @SerializedName("type")
    var type:String?=null

    @SerializedName("difficulty")
    var difficulty:String?=null

    @SerializedName("question")
    var question:String?=null

    @SerializedName("correct_answer")
    var correct_answer:String?=null

    @SerializedName("incorrect_answers")
    var incorrect_answers:ArrayList<String>?=null
}
