package by.stress.radyukandroidpvt.dz6

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import by.stress.radyukandroidpvt.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Dz6RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageView = itemView.findViewById<ImageView>(R.id.itemImageView)
    private val textView = itemView.findViewById<TextView>(R.id.itemTextView)

    // указываем, где какие значения отображать на слайде при привязке (bind) его к объекту (item)
    fun bind(item: StudentItem) {
        textView.text = item.name
        Glide.with(itemView)
            .load(item.imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}
