package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneBtn: Button = findViewById(R.id.done_btn)
        doneBtn.setOnClickListener {
            // itにすることで変数自信(今回ならdoneBtn)を対象にできる
            addNickname(it)
        }

        val nicknameText: TextView = findViewById(R.id.nickname_text)
        nicknameText.setOnClickListener {
            // itにすることで変数自信(今回ならnicknameText)を対象にできる
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText: EditText = findViewById(R.id.nickNameEdit)
        val nicknameText: TextView = findViewById(R.id.nickname_text)
        nicknameText.text = editText.text
        // 入力フォームを非表示
        editText.visibility = View.GONE
        // Doneボタンを非表示
        view.visibility = View.GONE
        // 入力値を保持したViewを非表示から表示に切り替える
        nicknameText.visibility = View.VISIBLE

        // 表示してるキーボードを非表示にする
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        val editText: EditText = findViewById(R.id.nickNameEdit)
        val doneBtn: Button = findViewById(R.id.done_btn)
        // 入力フォームを非表示から表示に変更
        editText.visibility = View.VISIBLE
        // doneボタンを非表示から表示に変更
        doneBtn.visibility = View.VISIBLE
        //
        view.visibility = View.GONE
    }
}