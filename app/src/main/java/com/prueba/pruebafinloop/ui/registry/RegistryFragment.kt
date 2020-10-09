package com.prueba.pruebafinloop.ui.registry

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.prueba.pruebafinloop.R
import com.prueba.pruebafinloop.data.remote.model.request.LoginRequest
import com.prueba.pruebafinloop.data.remote.model.request.RegistryRequest
import com.prueba.pruebafinloop.ui.MainActivity
import com.prueba.pruebafinloop.utils.Tools.Companion.hideKeyboard
import com.prueba.pruebafinloop.utils.showToast
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_registry.*
import javax.inject.Inject

class RegistryFragment : Fragment() {
    @Inject
    lateinit var registryViewModel: RegistryViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assignEvent()
        init()
    }

    private fun init() {
        if (registryViewModel.registryValidate()) {
            edtUsername.visibility = View.GONE
            btnRegistry.text = getString(R.string.txt_session_init)
        }
    }

    private fun subscribeToViewModel() {
        registryViewModel.requestRegistryLiveData.observe(this, {
            (activity as? MainActivity)?.observerResourcesManager(it) {
                nextScreen()
            }
        })

        registryViewModel.requestLoginLiveData.observe(this, {
            (activity as? MainActivity)?.observerResourcesManager(it) {
                nextScreen()
            }
        })
    }

    private fun nextScreen() {
        findNavController().navigate(R.id.usersListFragment)
    }

    private fun assignEvent() {
        btnRegistry.setOnClickListener {
            hideKeyboard(requireActivity())
            if (validateTextEmpty(if (validateTextButton()) {
                    edtEmail.text; edtPassword.text
                }
                else {
                    edtEmail.text; edtUsername.text; edtPassword.text
                })) {
                requireActivity().showToast(getString(R.string.msg_no_campos_vacios))
            }
            else {
                if (validateTextButton()) {
                    registryViewModel.sendLogin(LoginRequest(edtEmail.text.toString(),
                        edtPassword.text.toString()))
                } else {
                    registryViewModel.sendRegistry(
                        RegistryRequest(
                            edtEmail.text.toString(),
                            edtUsername.text.toString(), edtPassword.text.toString()
                        )
                    )
                }
            }
        }
    }

    private fun validateTextButton () =
        btnRegistry.text.toString() == getString(R.string.txt_session_init)

    private fun validateTextEmpty (vararg editable: Editable?): Boolean {
        for (edit: Editable? in editable) {
            if (TextUtils.isEmpty(edit)) {
                return true
            }
        }
        return  false
    }
}