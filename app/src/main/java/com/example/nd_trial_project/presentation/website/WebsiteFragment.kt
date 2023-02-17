package com.example.nd_trial_project.presentation.website

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.nd_trial_project.R
import com.example.nd_trial_project.TAG
import com.example.nd_trial_project.databinding.FragmentWebsiteBinding

class WebsiteFragment : Fragment() {
    private lateinit var binding: FragmentWebsiteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebsiteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.title = arguments?.getString("name")
        setupToolbar()

        binding.webView.apply {
            webViewClient = MyWebViewClient()
            arguments?.getString("url")?.let { loadUrl(it) }
        }

        Log.d(TAG, "webView Created")

    }

    private fun setupToolbar() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == android.R.id.home) {
                    findNavController().navigate(R.id.destination_gallery_fragment)
                }
                return false
            }
        })
    }
}