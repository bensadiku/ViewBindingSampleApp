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

package dev.bensadiku.viewbindingsampleapp.secondscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.bensadiku.viewbindingsampleapp.databinding.ActivityViewModelBinding
import dev.bensadiku.viewbindingsampleapp.secondscreen.viewmodels.MyViewModel
import dev.bensadiku.viewbindingsampleapp.thirdscreen.RecyclerViewActivity

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setting up layout with viewBinding with the generated class
        val activityViewModelBinding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(activityViewModelBinding.root)

        /**
         *  Create a ViewModel the first time the system calls an activity's onCreate() method.
         *  Re-created activities receive the same MyViewModel instance created by the first activity.
         *
         *  https://developer.android.com/topic/libraries/architecture/viewmodel
         */
        val myViewModel = ViewModelProviders.of(this)[MyViewModel::class.java]

        /**
         * Observe the number of taps for changes
         */
        myViewModel.numberOfTaps.observe(this, Observer { tapNumber ->
            activityViewModelBinding.viewModelTapNum.text = tapNumber.toString()
        })

        /**
         * When button is pressed tell viewModel to increase the number by 1
         */
        activityViewModelBinding.viewModelButtonTap.setOnClickListener { myViewModel.userTapped() }

        /**
         * Move the to the next activity button
         */
        activityViewModelBinding.viewModelButtonNextActivity.setOnClickListener {
            startActivity(Intent(this,RecyclerViewActivity::class.java))
        }
    }
}
