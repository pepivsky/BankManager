package com.example.bankmanager

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bankmanager.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    interface LoginFragmentListener {
        fun onLoginClicked(username: String, password: String)
    }

    private var listener: LoginFragmentListener? = null
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {

            val username = binding.loginUsername.text.toString()
            val password = binding.loginPassword.text.toString()
            Log.d("fragment", "onViewCreated: $username $password")
            listener?.onLoginClicked(username, password)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? LoginFragmentListener
    }
}