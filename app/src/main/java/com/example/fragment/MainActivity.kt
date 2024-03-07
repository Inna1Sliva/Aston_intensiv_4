package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fragment.WorkOneFragment.FragmentA
import com.example.fragment.WorkTwoFragment.FragmentList
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var fragmentWorkOne = FragmentA()
    private var fragmentWorkTwo = FragmentList()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOne.setOnClickListener {

            startFragmentWorkOne(fragmentWorkOne)
        }
        binding.buttonTwe.setOnClickListener {
            startFragmentWorkTwo(fragmentWorkTwo)
        }
    }
    private fun startFragmentWorkOne(fragment: Fragment):FragmentTransaction{
        val instFragmentA = supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    return instFragmentA
    }
    private fun startFragmentWorkTwo(fragment: Fragment): FragmentTransaction{
    val instFragmentList = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragment_container, fragment)
        commit()
    }
        return instFragmentList
    }
}