package com.example.a62.presentation.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.a62.databinding.FragmentAddBinding
import com.example.a62.presentation.ItemViewModel

class AddFragment : Fragment() {
private lateinit var binding: FragmentAddBinding
private val viewModel: ItemViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        binding.savebutton.setOnClickListener {
            val nombre= binding.productet.text.toString()
            val precio= binding.priceet.text.toString().toInt()
            val cantidad = binding.quantityet.text.toString().toInt()

            viewModel.insertItem( nombre, precio, cantidad)

            showSuccesfullMessage()
            cleanUI()
        }

        return binding.root
    }

    private fun cleanUI() {
        binding.productet.setText("")
        binding.quantityet.setText("")
        binding.priceet.setText("")
    }

    private fun showSuccesfullMessage() {
       Toast.makeText(requireContext(), "Registro realizado exitosamente", Toast.LENGTH_LONG).show()
    }

}