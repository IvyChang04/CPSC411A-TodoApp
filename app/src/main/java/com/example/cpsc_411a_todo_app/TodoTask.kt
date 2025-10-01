package com.example.cpsc_411a_todo_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class TodoTask(
    val id: Int,
    val label: String,
    var initialChecked: Boolean = false
) {
    var checked: Boolean by mutableStateOf(initialChecked)
}