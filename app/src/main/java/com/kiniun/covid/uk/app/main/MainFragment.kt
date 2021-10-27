package com.kiniun.covid.uk.app.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.kiniun.covid.uk.app.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.kiniun.covid.uk.app.data.source.remote.ApiAdapter
import com.kiniun.covid.uk.app.databinding.MainFragmentBinding
import com.kiniun.covid.uk.app.di.AppModule
import com.kiniun.covid.uk.app.di.DaggerAppComponent
import com.kiniun.covid.uk.app.di.RoomModule
import com.kiniun.covid.uk.app.models.CovidData
import com.kiniun.covid.uk.app.utils.JSONApiTestClient
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.*
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModelFactory: MainViewModelFactory

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val apiList = arrayListOf<Single<CovidData>>(
            ApiAdapter.apiClient.getUKCovidData(),
            ApiAdapter.apiClient.getEnglandCovidData(),
            ApiAdapter.apiClient.getScotlandCovidData(),
            ApiAdapter.apiClient.getWalesCovidData(),
            ApiAdapter.apiClient.getNICovidData()
        )

        viewModel.loadData(apiList)

        observeData()

        binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        return binding.root
    }

    private fun observeData() {
        viewModel.dbInitialized.observe(viewLifecycleOwner, Observer {
            Log.i("MSG", "dbInitialized: "+it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loadingProgress.visibility = View.GONE
        doNav(view)
    }

    private fun doNav(view: View) {
        val bundle = bundleOf("countryCode" to 0)
        Navigation.findNavController(view).navigate(R.id.homeFragment, bundle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerAppComponent.builder()
            .appModule(AppModule(requireActivity().application))
            .roomModule(RoomModule(requireActivity().application))
            .build()
            .inject(this)
    }
}