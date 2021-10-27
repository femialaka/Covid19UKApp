package com.kiniun.covid.uk.app.views.display

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.kiniun.covid.uk.app.CovidAppUKApplication
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.databinding.DisplayFragmentBinding
import com.kiniun.covid.uk.app.main.CovidInfoAdapter
import com.kiniun.covid.uk.app.models.CovidDataType
import com.kiniun.covid.uk.app.utils.AppDateUtil
import com.kiniun.covid.uk.app.utils.CountryUtil
import com.robinhood.spark.SparkView

class DisplayFragment : Fragment() {

    //Properties
    private lateinit var viewModel: DisplayViewModel
    private lateinit var viewModelFactory: DisplayViewModelFactory
    private lateinit var binding: DisplayFragmentBinding
    private lateinit var adapter: CovidInfoAdapter

    var _countryCode = 0
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.display_fragment, container, false)

        _countryCode = requireArguments().getInt("countryCode")

        Log.i("MSG", "onCreateView: DisplayFragment $_countryCode")

        val app = requireContext().applicationContext as CovidAppUKApplication

        viewModelFactory = DisplayViewModelFactory(app.repository)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(DisplayViewModel::class.java)

        viewModel.setCountryCode(_countryCode)

        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(binding.mainToolbar)
            binding.mainToolbar.setNavigationOnClickListener {
                backPressedNavigation()
            }
        }

        observeData()
        initializeSparkView()
        setupListeners()
        setTitle()
        setContentDescription()

        return binding.root
    }

    private fun setTitle() {
        binding.mainToolbar.title = CountryUtil.countries.get(_countryCode)  //main_toolbar
    }

    private fun setContentDescription() {
        binding.mainToolbar.contentDescription = CountryUtil.countries.get(_countryCode)  //main_toolbar
    }

    private fun initializeSparkView() {
        binding.sparkview.scrubListener = SparkView.OnScrubListener { value ->
            if (value != null) {
                setScrub(value as CovidRecordEntity)
            }
        }
        binding.sparkview.fillType = SparkView.FillType.DOWN
    }

    private fun backPressedNavigation() : Unit {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_displayFragment_to_homeFragment)
    }

    private fun observeData() {
        viewModel.ukData.observe(viewLifecycleOwner, Observer {
            it.let {
                //values start from recent to old - so we need to reverse them
                adapter = CovidInfoAdapter(it.reversed(), CovidDataType.NEWCASSES)
                binding.sparkview.adapter = adapter
                binding.scrubInfoTextview.setText(
                    viewModel.resetDisplayText(CovidDataType.NEWCASSES)
                )
                binding.radioButtonCases.isChecked = true
            }
            Log.i("MSG", "code: $_countryCode Data: ${viewModel.ukData.value}")
        })
    }

    //Radio Buttons to change the information displayed
    private fun setupListeners() {
        binding.radioButtonAdmissions.setOnClickListener {
            changeData(CovidDataType.ADMISSIONS)
            binding.scrubInfoTextview.setText(
                viewModel.resetDisplayText(CovidDataType.ADMISSIONS)
            )
        }
        binding.radioButtonCases.setOnClickListener {
            changeData(CovidDataType.NEWCASSES)
            binding.scrubInfoTextview.setText(
                viewModel.resetDisplayText(CovidDataType.NEWCASSES)
            )
        }
        binding.radioButtonDeaths.setOnClickListener {
            changeData(CovidDataType.DEATH)
            binding.scrubInfoTextview.setText(
                viewModel.resetDisplayText(CovidDataType.DEATH)
            )
        }
    }

    //React to sparkView Events------------------------------



    //This method formats the scrub display string e.g UK 282822 cases  09 Aug 2021
    //_currentDataType is determined by the radio Buttons
    private fun setScrub(entity: CovidRecordEntity) {
        when (viewModel.currentDataType) {
            CovidDataType.NEWCASSES -> viewModel.currentDisplayText = Html.fromHtml(
                getString(
                    R.string.scrub_format_cases,
                    CountryUtil.countries.get(_countryCode),
                    entity.newCases.toString(),
                    AppDateUtil.dateToString(entity.date)
                ),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            CovidDataType.ADMISSIONS -> viewModel.currentDisplayText = Html.fromHtml(
                getString(
                    R.string.scrub_format_admissions,
                    CountryUtil.countries.get(entity.countryCode),
                    entity.newAdmissions.toString(),
                    AppDateUtil.dateToString(entity.date)
                ), HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            CovidDataType.DEATH -> viewModel.currentDisplayText = Html.fromHtml(
                getString(
                    R.string.scrub_format_deaths,
                    CountryUtil.countries.get(entity.countryCode),
                    entity.newDeaths.toString(),
                    AppDateUtil.dateToString(entity.date)
                ), HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        }
        binding.scrubInfoTextview.text = viewModel.currentDisplayText
    }

    //change data displayed
    private fun changeData(dataType: CovidDataType): Boolean {
        //update fill color
        viewModel.currentDataType = dataType

        binding.sparkview.lineColor = viewModel.colorMap[viewModel.currentDataType.dataType]!!
        viewModel.ukData.value?.let { adapter.resetData(it.reversed(), viewModel.currentDataType) }
        adapter.notifyDataSetChanged()
        return true
    }

    override fun onStart() {
        super.onStart()
        requireActivity().onBackPressedDispatcher.addCallback(handleNav)
    }

    private val handleNav = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
           Navigation.findNavController(requireView()).navigate(R.id.action_displayFragment_to_homeFragment)
        }
    }
}