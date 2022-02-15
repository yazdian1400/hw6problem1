package ir.homework.promblem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ir.homework.promblem1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun onButtonClick(){
            binding.layoutShowInfo.visibility = View.VISIBLE
        }

        binding.btnRegister.setOnClickListener{
            onButtonClick()
        }
    }
}