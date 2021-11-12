package com.igorsantos.mars_photos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.igorsantos.mars_photos.databinding.FragmentOverviewBinding

/**
 * Created by IgorSantos on 8/17/2021.
 */
class OverviewFragment : Fragment(){

    private val _viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentOverviewBinding.inflate(inflater, container, false).also {
            it.apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = _viewModel
            }
        }

        fragmentBinding.photosGrid.adapter = PhotoGridAdapter()

        return fragmentBinding.root
    }
}