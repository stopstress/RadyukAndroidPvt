package by.stress.radyukandroidpvt.dz6

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.stress.radyukandroidpvt.R

/**
 * RecyclerView.Adapter
 */
class Dz6RecyclerViewAdapter(
    private val items: List<StudentItem>,
    private val listener: ClickListener
) : RecyclerView.Adapter<Dz6RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dz6RecyclerViewHolder {

        // макет слайда для холдера
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_dz6_list_item, parent, false)

        // ссылка на холдер
        val holder = Dz6RecyclerViewHolder(view)

        // слушатель кликов
        holder.itemView.setOnClickListener {
            listener.onItemClick(items[holder.adapterPosition])
        }

        return holder
    }

    override fun onBindViewHolder(holder: Dz6RecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    interface ClickListener {
        fun onItemClick(item: StudentItem)
    }
}