package com.aleph.biweekly.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.aleph.biweekly.R
import com.aleph.biweekly.databinding.FragmentConstraintSampleBinding
import com.aleph.biweekly.ext.dp
import com.aleph.biweekly.ui.NavigationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LayoutSampleFragment : Fragment() {

    companion object {
        fun newInstance() = LayoutSampleFragment()
    }

    private val viewModel by activityViewModels<MainViewModel>()

    private var binding: FragmentConstraintSampleBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return if (viewModel.getNavigationType() == NavigationActivity.Companion.NavigationType.CONSTRAINT_LAYOUT){
            binding = FragmentConstraintSampleBinding.inflate(inflater, container, false)
            binding!!.root
        } else inflater.inflate(R.layout.fragment_motion_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.getNavigationType() == NavigationActivity.Companion.NavigationType.CONSTRAINT_LAYOUT)
            doSomeConstraintSample()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        if (viewModel.getNavigationType() == NavigationActivity.Companion.NavigationType.CONSTRAINT_LAYOUT)
            binding = null
    }

    private fun doSomeConstraintSample() {
        binding?.sampleTerbang?.apply {
            coba2.updateLayoutParams<ConstraintLayout.LayoutParams> {
                endToStart = coba3.id
            }
            coba4.visibility = View.GONE
        }
        binding?.sampleTerbangBayangan?.apply {
            coba3.visibility = View.GONE
            //coba4.visibility = View.GONE
        }
        binding?.organismCard?.apply {
            imageView.apply {
                updateLayoutParams<ConstraintLayout.LayoutParams> {
//                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
//                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
//                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
//                    marginEnd = (10).dp(context)

                    topToTop = subtitle.id
                    bottomToBottom = subtitle.id
                    startToEnd = subtitle.id
                    endToEnd = ConstraintLayout.LayoutParams.UNSET
                    marginStart = (10).dp(context)
                }
            }
        }
    }
}