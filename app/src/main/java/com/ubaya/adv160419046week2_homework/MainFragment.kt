package com.ubaya.adv160419046week2_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var value = 0
        var points = 0
        var number1 = (0 until 101).random()
        var number2 = (0 until 101).random()
        textNumber.text = "$number1 + $number2"
        value = number1 + number2
        buttonSubmit.setOnClickListener {
            val answer = editAnswer.text.toString().toInt()
            if(value == answer)
            {
                points +=1
                number1 = (0 until 101).random()
                number2 = (0 until 101).random()
                textNumber.text = "$number1 + $number2"
                value = number1 + number2
                editAnswer.setText("")
            }
            else
            {
                //dapatkan action yang ingin dijalankan
                val action = MainFragmentDirections.actionMainFragmentToResultFragment(points)
                //jalankan action tersebut
                Navigation.findNavController(it).navigate(action)
            }

        }
    }
}