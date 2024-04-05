package com.example.habit_helper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddActivityFragment : Fragment() {

    private lateinit var editTextActivityName: EditText
    private lateinit var spinnerColorLabel: Spinner
    private lateinit var buttonSaveActivity: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find views
        editTextActivityName = view.findViewById(R.id.editTextActivityName)
        spinnerColorLabel = view.findViewById(R.id.spinnerColorLabel)
        buttonSaveActivity = view.findViewById(R.id.buttonSaveActivity)

        // Set up color label spinner
        val colors = arrayOf("Red", "Blue", "Green", "Yellow") // Example list of colors
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColorLabel.adapter = adapter

        // Set up OnClickListener for the save button
        buttonSaveActivity.setOnClickListener {
            // Validate user input and save the activity data
            saveActivity()
        }
    }

    private fun saveActivity() {
        val activityName = editTextActivityName.text.toString().trim()
        val selectedColor = spinnerColorLabel.selectedItem.toString()

        // Add validation logic here if needed

        // Save the activity data or perform other actions
        // You can implement the logic to save the activity data to a database or any other storage mechanism
        // For now, you can just display a message indicating the activity was saved
        val message = "Activity saved: $activityName, Color label: $selectedColor"
        // For example, you can show a Toast message
        // Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

        // Navigate back to the previous destination (activities screen)
        findNavController().navigateUp()
    }

}