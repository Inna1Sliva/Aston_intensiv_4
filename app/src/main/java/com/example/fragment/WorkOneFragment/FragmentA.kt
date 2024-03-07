package com.example.fragment.WorkOneFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.fragment.R
import com.example.fragment.databinding.FragmentABinding

class FragmentA : Fragment() {
    private var fragmentB = FragmentB()
    private  var _binding: FragmentABinding?= null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)

        binding.nextFragment.setOnClickListener {
            startFragment(fragmentB)
        }

        return binding.root


    }

    private fun startFragment(fragment: Fragment):FragmentTransaction {
        val nextFragment = parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
        return nextFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}