package com.example.fragment.WorkOneFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragment.R
import com.example.fragment.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private var fragmentA = FragmentA()
    private var fragmentD = FragmentD()
    private  var _binding: FragmentCBinding?= null
    private val binding get() =_binding!!
    companion object{
        private const val DATA_KEY = "data_key"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentCBinding.inflate(inflater, container, false)
       val data= arguments?.getString(DATA_KEY)
        if (data != null){
            binding.textFragment.text = data
        }
        else binding.textFragment.text = "No Data"
        binding.fragment.setOnClickListener {
            backStartFragment(fragmentA)
        }
        binding.textFragment.setOnClickListener {
            nextStartFragment(fragmentD)
        }

        return binding.root
    }

    private fun nextStartFragment(fragment: Fragment) :FragmentTransaction{
        val nexFragment =parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
        return nexFragment
    }

    private fun backStartFragment(fragment: Fragment):FragmentTransaction {
        parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val fragmentA = parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
        return fragmentA

    }


    override fun onDestroyView() {
        super.onDestroyView()
    _binding = null
    }
}