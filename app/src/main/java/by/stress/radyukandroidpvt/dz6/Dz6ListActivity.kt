package by.stress.radyukandroidpvt.dz6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.stress.radyukandroidpvt.R
import by.stress.radyukandroidpvt.dz6.Dz6Data.ITEMS
import kotlinx.android.synthetic.main.activity_dz6_list.*
import org.jetbrains.anko.toast

class Dz6ListActivity : AppCompatActivity(), Dz6RecyclerViewAdapter.ClickListener, SearchView.OnQueryTextListener {

    var filteredItems: List<StudentItem> = ITEMS

    fun recyclerViewSet() {
        recyclerViewWidget.setHasFixedSize(true)
        recyclerViewWidget.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerViewWidget.isNestedScrollingEnabled = false // не внутри другого скролла
    }

    fun recyclerViewUpdate() {
        recyclerViewWidget.adapter = Dz6RecyclerViewAdapter(filteredItems, this)
        //recyclerViewWidget.adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6_list)

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, Dz6CreateActivity::class.java)
            startActivity(intent)
        }

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        toolBar.title = "Список студентов"

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(this)
    }

    override fun onResume() {
        super.onResume()
        recyclerViewSet()
        recyclerViewUpdate()
    }

    override fun onItemClick(item: StudentItem) {
        val intent = Intent(this,Dz6DetailsActivity::class.java)
        intent.putExtra("id", item.id)
        startActivity(intent)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        updateFilteredItems(query)
        recyclerViewUpdate()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        updateFilteredItems(newText)
        recyclerViewUpdate()
        return true
    }

    fun updateFilteredItems(query: String?) {
        this.filteredItems = ITEMS.filter { it.name.toLowerCase().contains(query.toString().toLowerCase()) }
    }
}
