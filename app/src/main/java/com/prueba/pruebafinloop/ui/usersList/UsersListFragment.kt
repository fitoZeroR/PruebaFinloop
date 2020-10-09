package com.prueba.pruebafinloop.ui.usersList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.prueba.pruebafinloop.R
import com.prueba.pruebafinloop.ui.MainActivity
import com.prueba.pruebafinloop.ui.usersList.adapter.CustomAdapterUsersList
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_users_list.*
import javax.inject.Inject

class UsersListFragment : Fragment() {
    @Inject
    lateinit var usersListViewModel: UsersListViewModel

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
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        usersListViewModel.getUsersList()
    }

    private fun subscribeToViewModel() {
        usersListViewModel.requestGetUsersListLiveData.observe(this, {
            (activity as? MainActivity)?.observerResourcesManager(it) {
                rcv_principal_id.also { recyclerView ->
                    recyclerView.adapter = CustomAdapterUsersList(it.data!!) { index ->
                        NavHostFragment.findNavController(this).navigate(
                            UsersListFragmentDirections.actionNavUsersListToUserDetail(
                                it.data[index].email, it.data[index].username))
                    }
                }
            }
        })
    }
}