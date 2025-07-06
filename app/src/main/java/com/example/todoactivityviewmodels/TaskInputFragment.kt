package com.example.todoactivityviewmodels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels

class TaskInputFragment : Fragment(R.layout.fragment_task_input) {

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editText = view.findViewById<EditText>(R.id.editTextTask)
        val buttonAdd = view.findViewById<Button>(R.id.buttonAdd)
        val buttonToList = view.findViewById<Button>(R.id.buttonToList)

        buttonAdd.setOnClickListener {
            val task = editText.text.toString()
            if (task.isNotBlank()) {
                viewModel.addTask(task)
                editText.text.clear()
            }
        }

        buttonToList.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TaskListFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
