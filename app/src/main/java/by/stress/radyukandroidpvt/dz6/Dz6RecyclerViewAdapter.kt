package by.stress.radyukandroidpvt.dz6

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.stress.radyukandroidpvt.R
import android.text.method.TextKeyListener.clear
import androidx.lifecycle.ViewModel
//import android.R



/**
 * RecyclerView.Adapter
 */
class Dz6RecyclerViewAdapter(
    private val items: List<Dz6Data.StudentItem>,
    private val listener: ClickListener
) : RecyclerView.Adapter<Dz6RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dz6RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_dz6_list_item, parent, false)
        val holder = Dz6RecyclerViewHolder(view)
        holder.itemView.setOnClickListener {
            listener.onItemClick(items[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: Dz6RecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /*
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            listener?.onListFragmentInteraction(item)
        }
    }
    */

    override fun getItemCount(): Int = items.size

    interface ClickListener {
        fun onItemClick(item: Dz6Data.StudentItem)
    }



//    public void update(ArrayList<Person> data) {
//        mData.clear()
//        mData.addAll(data)
//        notifyDataSetChanged();
//    }

//    fun updateData(viewModels: ArrayList<ViewModel>) {
//        items.clear()
//        items.addAll(viewModels)
//        notifyDataSetChanged()
//    }
}
