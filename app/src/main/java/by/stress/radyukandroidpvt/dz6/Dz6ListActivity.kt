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

    var filteredItems: List<Dz6Data.StudentItem> = ITEMS

    override fun onQueryTextSubmit(query: String?): Boolean {
        this.filteredItems = ITEMS.filter { it.name.toLowerCase().contains(query.toString().toLowerCase()) }
        recyclerViewUpdate()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        this.filteredItems = ITEMS.filter { it.name.toLowerCase().contains(newText.toString().toLowerCase()) }
        recyclerViewUpdate()
        return true
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

        recyclerViewSet()
        recyclerViewUpdate()
    }

    fun recyclerViewSet() {
        recyclerViewWidget.setHasFixedSize(true)
        recyclerViewWidget.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerViewWidget.isNestedScrollingEnabled = false // не внутри другого скролла
    }

    fun recyclerViewUpdate() {
        recyclerViewWidget.adapter = Dz6RecyclerViewAdapter(filteredItems, this)
    }

    override fun onItemClick(item: Dz6Data.StudentItem) {
        toast(item.id)
//        val intent = Intent(this,Dz6EditActivity::class.java)
//        intent.putExtra("id", item.id)
//        startActivity(intent)
    }
}
