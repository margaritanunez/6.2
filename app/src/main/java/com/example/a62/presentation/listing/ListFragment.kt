package com.example.a62.presentation.listing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.a62.R
import com.example.a62.databinding.FragmentListBinding
import com.example.a62.presentation.ItemViewModel


class ListFragment : Fragment() {
    private lateinit var binding : FragmentListBinding
    private val viewModel: ItemViewModel by activityViewModels()
    private var adapter = ItemsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        initRecyclerView()
        loadData()
        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.addItemBtn.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

    private fun loadData() {
        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        binding.rvAddList.adapter = adapter
    }

}