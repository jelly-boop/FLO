package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.*

class Backgroundsong3Fragment : Fragment() {
    lateinit var binding: FragmentBackgroundsong3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBackgroundsong3Binding.inflate(inflater,container,false)
        return binding.root
    }


}