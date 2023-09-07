package com.aleph.biweekly.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aleph.biweekly.R
import com.aleph.biweekly.data.Job
import com.aleph.biweekly.data.Profile
import com.aleph.biweekly.databinding.FragmentKotlinPlaygroundBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KotlinPlaygroundFragment : Fragment() {

    private var _binding: FragmentKotlinPlaygroundBinding? = null

    private val binding get() = _binding

    companion object {
        fun newInstance() = KotlinPlaygroundFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKotlinPlaygroundBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doSomething()
    }

    private fun doSomething() {
        val profile = Profile("Yaqub", 27, Job.Android_Developer, 848448000)
        binding?.outputTextView?.text = profile.toString()

        val profileAbi = profile.copy(name = "Abi Farhan", age = 25, birthDate = 888710400)
        println(profileAbi)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}