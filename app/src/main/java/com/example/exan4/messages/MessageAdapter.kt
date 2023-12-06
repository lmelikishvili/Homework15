package com.example.exan4.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exan4.databinding.MessageItemBinding

class MessageAdapter: ListAdapter<Message, MessageAdapter.MessageVH>(MessageDiffutil()) {

    class MessageDiffutil: DiffUtil.ItemCallback<Message>(){
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MessageVH(MessageItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MessageVH, position: Int) {
        holder.bind()
    }

    inner class MessageVH(private val binding: MessageItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(){
            val message = currentList[adapterPosition]
            with(binding){
                tvUserName.text = message.owner
                tvMessage.text= message.lastMessage
                tvTime.text = "${message.lastActive} PM"
                tvUnreads.text = message.unreadMessages.toString()
            }
        }
    }
}