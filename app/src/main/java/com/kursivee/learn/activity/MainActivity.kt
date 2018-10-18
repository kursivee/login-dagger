package com.kursivee.learn.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.launch
import com.kursivee.learn.common.api.MockyClient
import com.kursivee.learn.common.services.UserDataService
import com.kursivee.learn.login.R
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var userDataService:
            UserDataService

    @Inject
    lateinit var mockyClient: MockyClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCommonComponent().inject(this)
        userDataService.name = userDataService.getSomething()
        submitBtn.setOnClickListener {
            NextActivity.start(this)
        }

        // Yeeeah I have no idea if this coroutine stuff is right
        CoroutineScope(Dispatchers.IO).launch {
            // This thing fails if I turn off wifi...
            // hmm....
            val request = mockyClient.getApi().get()
            val response = request.await()
            if(response.isSuccessful) {
                println("#### HERE")
                userDataService.name = response.body()?.wew ?: "it worked"
            } else {
                println("#### response ${response.code()} ${response.errorBody()}")
            }

        }

        println("#### CONFUSED")
    }
}
