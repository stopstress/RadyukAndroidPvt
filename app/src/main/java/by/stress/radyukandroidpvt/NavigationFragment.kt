package by.stress.radyukandroidpvt


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.android.synthetic.main.fragment_navigation.view.*


/**
 * A simple Fragment subclass.
 *
 */
class NavigationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentLayout = inflater.inflate(R.layout.fragment_navigation, container, false)

        val navController = NavHostFragment.findNavController(this)

        fragmentLayout.goToDz0.setOnClickListener { navController.navigate(R.id.dz0) }

        return fragmentLayout
    }


}
