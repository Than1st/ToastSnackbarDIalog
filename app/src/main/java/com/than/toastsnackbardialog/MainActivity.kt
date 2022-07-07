package com.than.toastsnackbardialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.than.toastsnackbardialog.databinding.ActivityMainBinding
import com.than.toastsnackbardialog.databinding.MyCustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelableDialog.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setIcon(R.mipmap.ic_launcher_round)
                setMessage("Anda Mencet Tombol")
                setTitle("Binar")
                setCancelable(true)
                show()
            }
        }

        binding.btnActionDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setIcon(R.mipmap.ic_launcher_round)
            dialog.setMessage("Mau keluar ga?")
            dialog.setTitle("Konfir")
            dialog.setCancelable(false)
            dialog.setPositiveButton("Ok"){dialogInterface, i ->
                Toast.makeText(this, "Anda Mencet Positive Button", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("No"){dialogInterface, i ->
                Toast.makeText(this, "Anda Mencet Negative Button", Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Ga Tau"){dialogInterface, i ->
                Toast.makeText(this, "Anda Mencet Gak Tau Button", Toast.LENGTH_SHORT).show()
                
            }
            dialog.show()
        }

        binding.btnCustomDialog.setOnClickListener {
            val dialogBinding = MyCustomDialogBinding.inflate(LayoutInflater.from(this))
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(dialogBinding.root)
            val dialog = dialogBuilder.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialogBinding.btnOk.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(this, "Custom Dialog Ditutup!", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }
        
        //fragment dialog

        binding.btnFragmentDialog.setOnClickListener {
            val dialogFragment = CobaDialogFragment("Sulthan")
            dialogFragment.show(supportFragmentManager, null)
        }
    }
}
