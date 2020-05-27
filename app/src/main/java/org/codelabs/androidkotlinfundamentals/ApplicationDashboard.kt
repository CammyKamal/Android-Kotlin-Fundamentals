package org.codelabs.androidkotlinfundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.ui.DevByteActivity
import com.example.android.marsrealestate.MarsInternetExample
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals2.linearlayoutusingthelayouteditor.AboutMe
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals2.linearlayoutusingthelayouteditor.AboutMeInteractive
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals2.constraintexample.ConstraintExample
import org.codelabs.androidkotlinfundamentals.databinding.ActivityDashboardBinding
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals2.databindingbasics.DataBindingBasicExample
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals3.TriviaActivity
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals4.LifeCycleAndLoggingActivity
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals5.viewmodelandviewmodelfactory.GameActivity
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals6.RoomMainActivity
import org.codelabs.androidkotlinfundamentals.diceroller.DiceRoller
import org.codelabs.androidkotlinfundamentals.diceroller.DiceRollerWithImage
import org.codelabs.androidkotlinfundamentals.helloworld.HelloWorld

class ApplicationDashboard : AppCompatActivity() {

    private lateinit var dashboardBinding: ActivityDashboardBinding
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        dashboardBinding.lifecycleOwner = this
        dashboardBinding.viewModel = dashboardViewModel
        initRecyclerView()
        observeClickEvents()
    }

    private fun observeClickEvents() {
        dashboardViewModel.listClickObserver.observe(this, Observer {
            handleEvents(it)
        })
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter =
            MyRecyclerViewAdapter(dashboardViewModel.getList(), this, dashboardViewModel)
    }

    private fun handleEvents(pos: Int) {
        when (dashboardViewModel.getListValue(pos)) {
            "Hello World" -> startActivity(Intent(this, HelloWorld::class.java))
            "Dice Roller" -> startActivity(Intent(this, DiceRoller::class.java))
            "Dice Roller With Image" -> startActivity(Intent(this, DiceRollerWithImage::class.java))
            "Linear layout using the Layout Editor" -> startActivity(Intent(this, AboutMe::class.java))
            "User interactivity In Linear layout using the Layout Editor" -> startActivity(Intent(this, AboutMeInteractive::class.java))
            "Constraint layout using the Layout Editor" -> startActivity(Intent(this, ConstraintExample::class.java))
            "Data-binding basics" -> startActivity(Intent(this, DataBindingBasicExample::class.java))
            "Trivia Example Using Fragments" -> startActivity(Intent(this, TriviaActivity::class.java))
            "Lifecycles and logging" -> startActivity(Intent(this, LifeCycleAndLoggingActivity::class.java))
            "Game Using ViewModel And ViewModel Factory" -> startActivity(Intent(this, GameActivity::class.java))
            "Livedata And Observers" -> startActivity(Intent(this, org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals5.livedataandobservers.GameActivity::class.java))
            "Create Room database" -> startActivity(Intent(this, RoomMainActivity::class.java))
            "Getting data from the internet" -> startActivity(Intent(this, MarsInternetExample::class.java))
            "Repository" -> startActivity(Intent(this, DevByteActivity::class.java))
        }
    }
}