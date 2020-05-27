package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals3

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.codelabs.androidkotlinfundamentals.R
import org.codelabs.androidkotlinfundamentals.databinding.FragmentGameOverBinding

class GameOverFragment() : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false)

        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }
        return binding.root
    }

}