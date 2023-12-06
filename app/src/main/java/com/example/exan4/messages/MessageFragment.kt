package com.example.exan4.messages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exan4.BaseFragment
import com.example.exan4.R
import com.example.exan4.databinding.FragmentMessageBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MessageFragment : BaseFragment<FragmentMessageBinding>(FragmentMessageBinding::inflate){
    private val viewModel: MessageViewModel by viewModels()
    private val adapter: MessageAdapter by lazy {
        MessageAdapter()
    }

    override fun setup() {
        with(binding){
            messageRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            messageRecyclerView.setHasFixedSize(true)
            messageRecyclerView.adapter = adapter
        }
    }

    override fun setupListeners() {
        viewModel.addMessage()
    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.messageFlow.collect{
                    adapter.submitList(it)
                }
            }
        }
    }
}