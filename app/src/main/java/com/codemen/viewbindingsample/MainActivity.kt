package com.codemen.viewbindingsample

import android.R
import android.os.Bundle
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
        }


    }


}

