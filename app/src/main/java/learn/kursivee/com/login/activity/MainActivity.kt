package learn.kursivee.com.login.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import learn.kursivee.com.common.BaseActivity
import learn.kursivee.com.common.services.UserDataService
import learn.kursivee.com.login.R
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var userDataService: UserDataService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCommonComponent().inject(this)
        println("#### ${userDataService.getSomething()}")
        userDataService.name = userDataService.getSomething()
        submitBtn.setOnClickListener {
            NextActivity.start(this)
        }
    }
}
