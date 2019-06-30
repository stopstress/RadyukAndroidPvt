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

    fun bind(item: Dz6Data.StudentItem) {
        textView.text = item.name
        imageView.setImageResource(R.drawable.ic_launcher_background)
        Glide.with(itemView)
            .load(item.imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}
