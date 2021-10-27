package com.kiniun.covid.uk.app.views.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.kiniun.covid.uk.app.R

class InfoWebFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.basic_web, container, false)

        val myWebView: WebView = view.findViewById(R.id.webview)

        myWebView.loadUrl("https://coronavirus.data.gov.uk")

        return view
    }

    override fun onStart() {
        super.onStart()
        requireActivity().onBackPressedDispatcher.addCallback(handleNav)
    }

    private val handleNav = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Navigation.findNavController(requireView()).navigate(R.id.action_infoWebFragment_to_homeFragment)
        }
    }
}