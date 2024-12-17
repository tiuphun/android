package hust.soict.navis.kadbaddigame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import hust.soict.navis.kadbaddigame.databinding.FragmentTeamBinding

class TeamFragment : Fragment() {
    private lateinit var binding: FragmentTeamBinding
    private val scoreViewModel: ScoreViewModelLiveData by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.myViewModel = scoreViewModel

        val isTeamA = arguments?.getBoolean(ARG_IS_TEAM_A) != false
        binding.tvTeamLabel.text = if (isTeamA) "Team A" else "Team B"

        if (isTeamA) {
            scoreViewModel.scoreA.observe(viewLifecycleOwner) { score ->
                binding.tvScore.text = score.toString()
            }
        } else {
            scoreViewModel.scoreB.observe(viewLifecycleOwner) { score ->
                binding.tvScore.text = score.toString()
            }
        }

        binding.btnIncrease.setOnClickListener {
            scoreViewModel.increaseScore(isTeamA)
        }

        return binding.root
    }

    companion object {
        private const val ARG_IS_TEAM_A = "isTeamA"

        fun newInstance(isTeamA: Boolean) =
            TeamFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_IS_TEAM_A, isTeamA)
                }
            }
    }
}

