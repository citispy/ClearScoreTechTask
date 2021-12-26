package com.rapiddeploy.mobile.clearscoretechtask.api.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class CoachingSummary {
    @SerializedName("activeTodo")
    @Expose
    var activeTodo: Boolean? = null

    @SerializedName("activeChat")
    @Expose
    var activeChat: Boolean? = null

    @SerializedName("numberOfTodoItems")
    @Expose
    var numberOfTodoItems: Int? = null

    @SerializedName("numberOfCompletedTodoItems")
    @Expose
    var numberOfCompletedTodoItems: Int? = null

    @SerializedName("selected")
    @Expose
    var selected: Boolean? = null
}