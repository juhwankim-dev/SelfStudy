package com.ssafy.optionmenuproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 옵션메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.menu_item_login -> {
                Toast.makeText(this, "로그인 선택 됨", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item_setting -> {
                Toast.makeText(this, "설정 선택 됨", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item_help -> {
                Toast.makeText(this, "고객센터 선택 됨", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}