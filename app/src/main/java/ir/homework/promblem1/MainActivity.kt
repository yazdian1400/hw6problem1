package ir.homework.promblem1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ir.homework.promblem1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var pass1 : String? = ""
    var pass2 : String?= ""
    var isFemale = true
    var isPassTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor=preference.edit()

        fun register(){
            editor.putString("name", binding.etFullName.text.toString());
            editor.putString("username",binding.etUsername.text.toString())
            editor.putString("email",binding.etEmail.text.toString())
            pass1 = binding.etPassword.text.toString()
            pass2 = binding.etPassword2.text.toString()
            if (pass1 != null && pass2 != null && pass1 == pass2) {
                isPassTrue = true
                editor.putString("password",pass1 as String)
            }
            else    isPassTrue = false
            isFemale = when (binding.radioGroup.checkedRadioButtonId){
                binding.rbFemale.id -> true
                binding.rbMale.id -> false
                else -> true
            }
            editor.putBoolean("isFemale",isFemale)
            editor.commit();
            if (isPassTrue == false){
                Toast.makeText(this, "The password repeat does not match!", Toast.LENGTH_LONG).show()
            }
        }
        fun showInfo(){
            if (isPassTrue) {
                binding.layoutShowInfo.visibility = View.VISIBLE
                binding.tvFullName.text = preference.getString("name", "")
                binding.tvUsername.text = preference.getString("username", "")
                binding.tvEmail.text = preference.getString("email", "")
                binding.tvPassword.text = preference.getString("password", "")
                binding.tvGender.text = when (preference.getBoolean("isFemale", true)) {
                    true -> "Female"
                    false -> "Male"
                }
            }
        }
        fun hideInfo(){
            binding.layoutShowInfo.visibility = View.GONE
        }

        binding.btnRegister.setOnClickListener{
            register()
        }
        binding.btnShowInfo.setOnClickListener{
            showInfo()
        }
        binding.btnHideInfo.setOnClickListener{
            hideInfo()
        }
    }
}