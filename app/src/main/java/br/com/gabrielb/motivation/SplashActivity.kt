package br.com.gabrielb.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import android.view.View
import android.widget.Toast
import br.com.gabrielb.motivation.util.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurity = SecurityPreferences(this)

        buttonSave.setOnClickListener(this)
        verifyUserName()
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave){
            handleSave()
        }
    }

    private fun verifyUserName(){
        editName.setText(mSecurity.getStoredString("key"))
    }

    private fun handleSave() {
        val name: String = editName.text.toString()

        if (name == "") {
            Toast.makeText(this, getString(R.string.informe_seu_nome), Toast.LENGTH_LONG).show()
        } else {
            mSecurity.storeString("key", name)

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }}