package learn.kursivee.com.login.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar

import kotlinx.android.synthetic.main.activity_next.*
import learn.kursivee.com.common.BaseActivity
import learn.kursivee.com.common.services.UserDataService
import learn.kursivee.com.login.R
import javax.inject.Inject

class NextActivity : BaseActivity() {

    @Inject
    lateinit var userDataService: UserDataService

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, NextActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        setSupportActionBar(toolbar)
        getCommonComponent().inject(this)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action ${userDataService.name}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
