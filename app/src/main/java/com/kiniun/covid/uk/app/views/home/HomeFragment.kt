package com.kiniun.covid.uk.app.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.databinding.HomeFragmentBinding
import com.kiniun.covid.uk.app.main.CovidInfoAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapter: CovidInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )
        setListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setListeners() {
        var bundle: Bundle
        binding.ukBtn.setOnClickListener {
            bundle = bundleOf("countryCode" to 0)
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_displayFragment, bundle)
        }
        binding.englandBtn.setOnClickListener {
            bundle = bundleOf("countryCode" to 1)
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_displayFragment, bundle)
        }
        binding.scotlandBtn.setOnClickListener {
            bundle = bundleOf("countryCode" to 2)
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_displayFragment, bundle)
        }
        binding.walesBtn.setOnClickListener {
            bundle = bundleOf("countryCode" to 3)
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_displayFragment, bundle)
        }
        binding.niBtn.setOnClickListener {
            bundle = bundleOf("countryCode" to 4)
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_displayFragment, bundle)
        }
        binding.infoBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_informationFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        requireActivity().onBackPressedDispatcher.addCallback(handleNav)
    }

    private val handleNav = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {   }
    }
}