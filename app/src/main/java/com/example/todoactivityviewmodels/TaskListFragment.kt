package com.example.todoactivityviewmodels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.activityViewModels

class TaskListFragment : Fragment(R.layout.fragment_task_list) {

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView = view.findViewById<ListView>(R.id.listViewTasks)
        val backButton = view.findViewById<Button>(R.id.buttonBack)

        viewModel.tasks.observe(viewLifecycleOwner) { taskList ->
            listView.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                taskList
            )
        }

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
