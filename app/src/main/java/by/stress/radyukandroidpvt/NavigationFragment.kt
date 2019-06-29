package by.stress.radyukandroidpvt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_navigation.*

/**
 * Navigation Fragment *
 */
class NavigationFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )
        val navController = NavHostFragment.findNavController(this)
        goToDz0.setOnClickListener { navController.navigate(R.id.dz0) }
        goToDz1.setOnClickListener { navController.navigate(R.id.dz1) }
        goToDz2a.setOnClickListener { navController.navigate(R.id.dz2a) }
        goToDz2b.setOnClickListener { navController.navigate(R.id.dz2b) }
        goToDz3.setOnClickListener { navController.navigate(R.id.dz3) }
        goToDz4.setOnClickListener { navController.navigate(R.id.dz4) }
        goToDz6.setOnClickListener { navController.navigate(R.id.dz6list) }
    }
}