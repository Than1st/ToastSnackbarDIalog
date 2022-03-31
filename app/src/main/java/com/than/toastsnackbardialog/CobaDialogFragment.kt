package com.than.toastsnackbardialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.than.toastsnackbardialog.databinding.FragmentCobaDialogBinding

class CobaDialogFragment(name: String) : DialogFragment() {
    private var _binding : FragmentCobaDialogBinding? = null
    private val binding get() = _binding!!
    var nama :String = name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCobaDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.setCancelable(false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (nama.isNotEmpty()){
            binding.tvNama.text = nama
        }
        binding.btnOk.setOnClickListener {
            Toast.makeText(requireContext(), "DialogFragement Ditutup!", Toast.LENGTH_LONG).show()
            dialog?.dismiss()
        }
    }
}