package com.codemen.viewbindingsample

import android.R
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.codemen.viewbindingsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var fragmentManager: FragmentManager = supportFragmentManager
    var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.send.setOnClickListener {
            val printName = binding.name.text.toString()
            Toast.makeText(this, " Welcome $printName to viewBinding", Toast.LENGTH_LONG).show()
            fragmentTransaction.add(R.id.content, FragmentProfile())
            fragmentTransaction.commit()
            hidekeyboard()
        }


    }

    private fun hidekeyboard() {
        if (this.currentFocus != null) {
            val inputManager: InputMethodManager =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                this.currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }


}

