package hust.soict.navis.kadbaddigame

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import hust.soict.navis.kadbaddigame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val scoreViewModel: ScoreViewModelLiveData by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val teamAFragment = TeamFragment.newInstance(true)
        val teamBFragment = TeamFragment.newInstance(false)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentTeamA, teamAFragment)
            replace(R.id.fragmentTeamB, teamBFragment)
            commitNow()
        }


        binding.btnReset.setOnClickListener {
            scoreViewModel.resetScores()
        }
    }
}
