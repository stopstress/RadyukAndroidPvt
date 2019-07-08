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

    //var filteredItems: List<Dz6Data.StudentItem> = ITEMS
    var filteredItems: List<Dz6Data.StudentItem> = ITEMS


    //private lateinit var filteredItems: List<Dz6Data.StudentItem>

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

        //filteredItems = ITEMS

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, Dz6CreateActivity::class.java)
            startActivity(intent)
        }

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        toolBar.title = "Список студентов"

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(this)

    }

    fun recyclerViewSet() {
        recyclerViewWidget.setHasFixedSize(true)
        recyclerViewWidget.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerViewWidget.isNestedScrollingEnabled = false // не внутри другого скролла
    }

    fun recyclerViewUpdate() {
        //filteredItems = ITEMS
        recyclerViewWidget.adapter = Dz6RecyclerViewAdapter(filteredItems, this)
        //(recyclerViewWidget.adapter as Dz6RecyclerViewAdapter).notifyDataSetChanged()
    }

    override fun onItemClick(item: Dz6Data.StudentItem) {
        val intent = Intent(this,Dz6DetailsActivity::class.java)
        intent.putExtra("id", item.id)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        recyclerViewSet()
        this.filteredItems = ITEMS
        recyclerViewUpdate()
    }

    /*
    override fun onStart() {
        super.onStart()
        //filteredItems = ITEMS
        //recyclerViewWidget.adapter?.notifyDataSetChanged()
        //recyclerViewUpdate()
    }

    override fun onResume() {
        super.onResume()
        //recyclerViewUpdate()
        //filteredItems = ITEMS
        //recyclerViewWidget.adapter?.notifyDataSetChanged()
        //recyclerViewUpdate()
        //recyclerView.getAdapter().notifyDataSetChanged();
    }
    */
}
