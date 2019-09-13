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

package dev.bensadiku.viewbindingsampleapp.thirdscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import dev.bensadiku.viewbindingsampleapp.databinding.ActivityRecyclerViewBinding
import dev.bensadiku.viewbindingsampleapp.thirdscreen.adapters.BindAdapters
import dev.bensadiku.viewbindingsampleapp.thirdscreen.viewmodels.RecyclerViewModel

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var myViewModel: RecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Initialize the view-binding
        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Init the viewModel
        myViewModel = ViewModelProviders.of(this)[RecyclerViewModel::class.java]

        //Bind the adapter
        BindAdapters.bindRecyclerViewAdapter(binding.recyclerView,myViewModel.getAdapter())
    }
}
