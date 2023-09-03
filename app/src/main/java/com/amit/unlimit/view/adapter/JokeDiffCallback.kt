package com.amit.unlimit.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.amit.domain.entities.joke.JokeResponse

class JokeDiffCallback(
    private val oldItems: List<JokeResponse>,
    private val newItems: List<JokeResponse>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].joke == newItems[newItemPosition].joke
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}