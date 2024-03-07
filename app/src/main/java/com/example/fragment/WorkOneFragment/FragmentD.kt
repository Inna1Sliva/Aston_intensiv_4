package com.example.fragment.WorkOneFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragment.R
import com.example.fragment.databinding.FragmentDBinding


class FragmentD : Fragment() {
    private var fragmentB = FragmentB()
    private  var _binding: FragmentDBinding?= null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDBinding.inflate(inflater,container, false)

    binding.backFragment.setOnClickListener {
        backStartFragment(fragmentB)
    }
        return binding.root
    }
    private fun backStartFragment(fragment: Fragment): FragmentTransaction {
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