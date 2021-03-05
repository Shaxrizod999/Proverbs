package com.example.app.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.app.R
import com.example.app.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private lateinit var binding: FragmentSlideshowBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSlideshowBinding.inflate(layoutInflater, container, false)

        return binding.root.apply {
            setOnClickListener {

            }
        }
    }
}