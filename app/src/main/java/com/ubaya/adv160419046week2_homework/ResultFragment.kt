package com.ubaya.adv160419046week2_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val score = ResultFragmentArgs.fromBundle(requireArguments()).score
            textPoint.text = "Your score is $score"
        }
        buttonBack.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}