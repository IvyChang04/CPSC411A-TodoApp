package com.example.cpsc_411a_todo_app

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<TodoTask>() // start empty
    val tasks: List<TodoTask>
        get() = _tasks

    private var nextId = 0

    fun add(label: String) {
        val trimmed = label.trim()
        if (trimmed.isEmpty()) return
        _tasks.add(TodoTask(id = nextId++, label = trimmed))
    }

    fun remove(item: TodoTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: TodoTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}