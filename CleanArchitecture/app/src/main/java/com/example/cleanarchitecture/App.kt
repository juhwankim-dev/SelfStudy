package com.example.cleanarchitecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 앱 실행시 그 무엇보다도 가장 먼저 실행되는 클래스입니다.
// Hilt를 사용하려면 이 클래스 위에 @HiltAndroidApp을 달아주어야 해요.
@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // 만약 앱이 실행되자마자 해야할 작업이 있다면 여기서 해주셔도 돼요. (MainActivity에서 해도 되구요)
        // 저는 주로 여기서 Firebase와의 연동 같은 작업을 하곤 합니다.
    }
}