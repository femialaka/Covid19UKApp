package com.kiniun.covid.uk.app.views.info

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import android.R.string
import android.content.Intent
import android.net.MailTo.isMailTo
import android.net.Uri
import android.text.style.*
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.databinding.InfoLayoutBinding

class InformationFragment : Fragment() {

    lateinit var binding: InfoLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.info_layout, container, false)

        val mainHeading =
            SpannableString("This application was designed to provide up to date information on Covid-19 within the United Kingdom")
        mainHeading.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            mainHeading.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.infoIntro.setText(mainHeading)

        val infoSubHeading01Span = SpannableString("Cases: Cases by date reported")
        infoSubHeading01Span.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            infoSubHeading01Span.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // infoSubHeading01Span.setSpan(UnderlineSpan(), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        infoSubHeading01Span.setSpan(
            ForegroundColorSpan(Color.BLUE),
            0,
            5,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.infoSubHeading01.setText(infoSubHeading01Span)

        binding.infoContent01.setText(R.string.info_content_01)


        val infoSubHeading02Span = SpannableString("Admissions: Patients admitted to hospital")
        infoSubHeading02Span.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            infoSubHeading02Span.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        //infoSubHeading02Span.setSpan(UnderlineSpan(), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        infoSubHeading02Span.setSpan(
            ForegroundColorSpan(Color.BLUE),
            0,
            10,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.infoSubHeading02.setText(infoSubHeading02Span)

        binding.infoContent02.setText(R.string.info_content_02)

        val infoSubHeading03Span =
            SpannableString("Deaths: \tDeaths within 28 days of positive test by date reported")
        infoSubHeading03Span.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            infoSubHeading03Span.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        //infoSubHeading03Span.setSpan(UnderlineSpan(), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        infoSubHeading03Span.setSpan(
            ForegroundColorSpan(Color.BLUE),
            0,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.infoSubHeading03.setText(infoSubHeading03Span)

        binding.infoContent03.setText(R.string.info_content_03)

        val infoContactSpan = SpannableString("contact: kiniun.apps@gmail.com")
        infoContactSpan.setSpan(UnderlineSpan(), 10, infoContactSpan.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        infoContactSpan.setSpan(ForegroundColorSpan(Color.BLUE), 0, infoContactSpan.length-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.infoContact.setText(infoContactSpan)
        binding.infoContact.setOnClickListener {
            composeEmail(arrayOf("kiniun.apps@gmail.com"), "RE: Covid-19 UK App")
        }

        binding.infoCreatedBy.setText(R.string.developed_by)

        val infoSourceSpan = SpannableString("source of information: click here")
        infoSourceSpan.setSpan(UnderlineSpan(), 23, infoSourceSpan.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        infoSourceSpan.setSpan(
            ForegroundColorSpan(Color.RED),
            23,
            infoSourceSpan.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.infoSource.setOnClickListener {
            Log.i("MSG", "Hello World")

           /* val safeArgs = InformationFragmentDirections.actionInformationFragmentToInfoWebFragment()
            safeArgs.arguments.putString("url", "https://coronavirus.data.gov.uk")
            view?.findNavController()?.navigate(safeArgs)*/
            val bundle = bundleOf("url" to "https://coronavirus.data.gov.uk")
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                .navigate(R.id.action_homeFragment_to_displayFragment, bundle)
        }

        binding.infoSource.setText(infoSourceSpan)

        val disclaimerSpan = SpannableString(
            "Disclaimer about Information Accuracy \n" +
                    "Although every effort has been made to provide complete and accurate information, Kiniun Ltd makes no warranties, " +
                    "express or implied, or representations as to the accuracy of content on this App. Kiniun Ltd assumes no liability " +
                    "or responsibility for any error or omissions in the information contained in the App or the operation of the App."
        )

        disclaimerSpan.setSpan(StyleSpan(Typeface.BOLD), 0, 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.infoDisclaimer.setText((disclaimerSpan))

        return binding.root
    }

    fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)

        }
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        requireActivity().onBackPressedDispatcher.addCallback(handleNav)
    }

    private val handleNav = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Navigation.findNavController(requireView()).navigate(R.id.action_informationFragment_to_homeFragment)
        }
    }
}