package com.nematjon.androidkotlinfundamentals_02_1

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done).setOnClickListener {
            addNickaname(it)
        }

        findViewById<TextView>(R.id.nick_name_txt).setOnClickListener {
            updateNickaname(it)
        }
    }

    private fun addNickaname(view: View) {
        val editText = findViewById<EditText>(R.id.nick_name_input)
        val nicknameText = findViewById<TextView>(R.id.nick_name_txt)

        nicknameText.visibility = View.VISIBLE
        nicknameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickaname(view: View) {
        val editText = findViewById<EditText>(R.id.nick_name_input)
        val doneButton = findViewById<Button>(R.id.done)
        view.visibility = View.GONE

        editText.visibility = View.VISIBLE
        editText.requestFocus()
        doneButton.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
}
