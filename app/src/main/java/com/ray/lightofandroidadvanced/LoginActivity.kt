package com.ray.lightofandroidadvanced

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        //TODO 使用AutoFill来自动填充
//        et_login_name.setAutofillHints(View.AUTOFILL_HINT_PHONE)
    }
}