package com.example.fragment.WorkOneFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.fragment.R
import com.example.fragment.databinding.FragmentBBinding


class FragmentB : Fragment() {
    private var fragmentC = FragmentC()
    private  var _binding: FragmentBBinding?= null
    private val binding get() =_binding!!
    companion object{
    private const val DATA_KEY = "data_key"
}




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)

        binding.nextFragment.setOnClickListener {
            nextStartFragment(setArgumentFragment())
        }
        binding.backFragment.setOnClickListener {
            backStartFragment()
        }
        return binding.root
    }

    private fun setArgumentFragment(): Fragment {
        val data = "Hello Fragment C"
        val args =  Bundle()
        args.putString(DATA_KEY, data)
        fragmentC.arguments = args
        return fragmentC
    }

    private fun backStartFragment() {
       parentFragmentManager.popBackStack()
    }

    private fun nextStartFragment(fragment: Fragment):FragmentTransaction {
        val nexFragment =parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
        return nexFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}