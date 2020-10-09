package com.prueba.pruebafinloop.ui.detailUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prueba.pruebafinloop.R
import kotlinx.android.synthetic.main.fragment_detail_user.*

class DetailUserFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        arguments?.let {
            txvEmail.text = DetailUserFragmentArgs.fromBundle(it).email
            txvUsername.text = DetailUserFragmentArgs.fromBundle(it).username
        }
    }
}