/*
Copyright 2019 bensadiku

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package dev.bensadiku.viewbindingsampleapp.thirdscreen.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bensadiku.viewbindingsampleapp.thirdscreen.adapters.HelloWorldRecyclerViewAdapter.MyViewHolder
import android.view.LayoutInflater
import dev.bensadiku.viewbindingsampleapp.databinding.RecyclerViewViewBinding
import dev.bensadiku.viewbindingsampleapp.thirdscreen.models.HelloWorld

/**
 * A generic RecyclerViewAdapter, gets the dummy data from the viewModel on the constructor,
 *      used those to bind the views in the MyViewHolder ViewHolder
 * RecyclerViewViewBinding is the auto generated layout
 */
class HelloWorldRecyclerViewAdapter(private val helloWorlds: ArrayList<HelloWorld> ) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewViewBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return helloWorlds.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindHelloWorld(position)
    }

    inner class MyViewHolder(private val binding: RecyclerViewViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindHelloWorld(position: Int) {
            binding.recyclerViewNum.text = helloWorlds[position].number.toString()
            binding.recyclerViewName.text = helloWorlds[position].name
        }
    }
}