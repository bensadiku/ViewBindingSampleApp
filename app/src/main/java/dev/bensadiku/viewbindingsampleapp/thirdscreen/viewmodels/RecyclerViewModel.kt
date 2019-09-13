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

package dev.bensadiku.viewbindingsampleapp.thirdscreen.viewmodels

import androidx.lifecycle.ViewModel
import dev.bensadiku.viewbindingsampleapp.thirdscreen.adapters.HelloWorldRecyclerViewAdapter
import dev.bensadiku.viewbindingsampleapp.thirdscreen.models.HelloWorld

/**
 * Initialises the recyclerView adapter with a empty arraylist until dummy data comes in
 */
class RecyclerViewModel : ViewModel() {
    private var helloWorldList: ArrayList<HelloWorld> = ArrayList()
    private var helloWorldRecyclerViewAdapter: HelloWorldRecyclerViewAdapter

    init {
        //add dummy data for the Recycler view to have something to bind
        addDummyData()

        //Initialize the adapter
        helloWorldRecyclerViewAdapter = HelloWorldRecyclerViewAdapter(helloWorldList)
    }

    fun getAdapter(): HelloWorldRecyclerViewAdapter {
        return helloWorldRecyclerViewAdapter
    }

    //creates 10 dummy objects for the recycler adapter
    private fun addDummyData() {
        for (i in 1..10) {
            helloWorldList.add(HelloWorld(i, "Hello $i"))
        }
    }
}