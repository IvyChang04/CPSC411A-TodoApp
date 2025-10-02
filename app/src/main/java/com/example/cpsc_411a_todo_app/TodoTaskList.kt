package com.example.cpsc_411a_todo_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TodoTaskList(
    list: List<TodoTask>,
    onCheckedTask: (TodoTask, Boolean) -> Unit,
    onCloseTask: (TodoTask) -> Unit,
    modifier: Modifier = Modifier
) {
    val (checkedTasks, uncheckedTasks) = list.partition { it.checked }
    Column (
        modifier = modifier
    ) {
        LazyColumn(
            modifier = modifier
        ) {
            if(uncheckedTasks.isNotEmpty()){
                item { SectionTitle("Items") }
                items(
                    items = uncheckedTasks,
                    key = { task -> "unchecked-${task.id}" }
                ) { task ->
                    TodoTaskItem(
                        taskName = task.label,
                        checked = task.checked,
                        onCheckedChange = { checked -> onCheckedTask(task, checked) },
                        onClose = { onCloseTask(task) }
                    )
                }
            }
            if(checkedTasks.isNotEmpty()){
                item { SectionTitle("Completed Items") }
                items(
                    items = checkedTasks,
                    key = { task -> "checked-${task.id}" }
                ) { task ->
                    TodoTaskItem(
                        taskName = task.label,
                        checked = task.checked,
                        onCheckedChange = { checked -> onCheckedTask(task, checked) },
                        onClose = { onCloseTask(task) }
                    )
                }
            }
        }
    }
}
@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier
            .padding(top = 16.dp, start = 8.dp)
    )
}