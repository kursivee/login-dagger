package learn.kursivee.com.login.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import learn.kursivee.com.common.BaseActivity
import learn.kursivee.com.common.services.ApiClient
import learn.kursivee.com.common.services.UserDataService
import learn.kursivee.com.login.R
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var userDataService: UserDataService

    @Inject
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCommonComponent().inject(this)
        userDataService.name = userDataService.getSomething()
        submitBtn.setOnClickListener {
            NextActivity.start(this)
        }


        GlobalScope.launch(Dispatchers.Default) {
            val request = apiClient.get().get()
            val response = request.await()
            if(response.isSuccessful) {
                userDataService.name = response.body()?.notHere ?: "it worked"
            } else {
                println("#### response ${response.code()} ${response.errorBody()}")
            }

        }
    }
}
