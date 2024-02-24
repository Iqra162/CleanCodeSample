package com.example.cleanarchitecturebasics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecturebasics.R
import com.example.cleanarchitecturebasics.presentation.viewmodels.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [SampleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SampleFragment : Fragment() {
    private val viewModel: SampleViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sample, container, false)
       // getData()
        view.findViewById<Button>(R.id.btn_next).setOnClickListener {
            findNavController().navigate(R.id.action_sampleFragment_to_sampleFragment2)
        }
        return view
    }

    fun getData() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.sampleModelValue.collect {
                if (it.isLoading) {
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
                if (it.error.isNotBlank()) {
                    Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                }
                if (it.data != null) {
                    Toast.makeText(context, it.data.value1, Toast.LENGTH_SHORT).show()

                }
            }
        }

    }


}