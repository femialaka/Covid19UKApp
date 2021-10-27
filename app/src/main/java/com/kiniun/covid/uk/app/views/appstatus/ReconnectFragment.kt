package com.kiniun.covid.uk.app.views.appstatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.databinding.ReconnectLayoutBinding

class ReconnectFragment: Fragment() {

    lateinit var binding: ReconnectLayoutBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.reconnect_layout, container, false)


        /*binding.reconnectBtn.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_reconnectFragment_to_covidFragment)
        }*/

        return binding.root
    }
}