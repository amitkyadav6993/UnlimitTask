package com.amit.unlimit.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amit.domain.entities.joke.JokeResponse
import com.amit.unlimit.databinding.ItemJokeLayoutBinding

class JokesAdapter(
    private val dataList: ArrayList<JokeResponse>,
    private val onItemClicked: (JokeResponse, Int) -> Unit,
) : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val binding = ItemJokeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokesViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: JokesViewHolder, @SuppressLint("RecyclerView") position: Int) {
        dataList.getOrNull(position)?.let { jokeItem ->
            holder.itemBinding.tvJoke.apply {
                text = jokeItem.joke.orEmpty()
                setOnClickListener {
                    onItemClicked(jokeItem, position)
                }
            }
        }
    }

    fun addData(newDataList: ArrayList<JokeResponse>) {
        kotlin.runCatching {
            val oldData = arrayListOf<JokeResponse>()
            oldData.addAll(dataList)
            dataList.clear()
            dataList.addAll(newDataList)
            DiffUtil.calculateDiff(JokeDiffCallback(oldData, dataList)).dispatchUpdatesTo(this)
        }
    }

    inner class JokesViewHolder(val itemBinding: ItemJokeLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root)

}

