package com.example.selfstudy_kotlin

import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.util.Log
import android.webkit.JavascriptInterface
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import com.example.selfstudy_kotlin.repository.NoticeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory


var source: String = ""

class MainActivity : AppCompatActivity(), updateListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO){
            var test = NoticeRepository()
            test.requestPost(this@MainActivity)
        }
    }

    override fun update(test: String) {
        var totalStr = ""
        try{
            var doc = Jsoup.parse(test)

            var elem = doc.select(".alignL a")
            var elementDate = doc.select(".alignC")

            for(e in elem){
                totalStr += e.attr("href") + "\n"
                totalStr += e.text() + "\n"
            }

            Log.v("size: ", elementDate.size.toString())

            for(i in 2..elementDate.size step(4)){
                totalStr += elementDate[i].text() + "\n"
            }

            binding.textView.text = totalStr.toString()
        }catch (e: Exception){

        }
    }
}