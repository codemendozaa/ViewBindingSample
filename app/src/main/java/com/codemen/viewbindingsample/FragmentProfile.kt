package com.codemen.viewbindingsample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.codemen.viewbindingsample.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar


class FragmentProfile : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        binding.getPrintName.text = getString(R.string.fragment_viewBinding)
        binding.back.setOnClickListener {
            Snackbar.make(
                view,
                "Welcome to Android Medellín..!!",
                Snackbar.LENGTH_LONG
            )
                .show()
        }


    }


}


