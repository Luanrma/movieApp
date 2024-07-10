package br.com.uninter.movieapp.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import br.com.uninter.movieapp.R
import br.com.uninter.movieapp.core.Constants
import br.com.uninter.movieapp.models.MovieModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterMovie(
    val context: Context,
    var movieList: List<MovieModel>
): RecyclerView.Adapter<AdapterMovie.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cvMovie = itemView.findViewById(R.id.cvMovie) as CardView
        val ivPoster = itemView.findViewById(R.id.ivPoster) as ImageView
        val pcIndicator = itemView.findViewById(R.id.circular_progress) as CircularProgressIndicator
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMovie.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterMovie.ViewHolder, position: Int) {
        val movie = movieList[position]

        Glide
            .with(context)
            .load("${Constants.BASE_URL_IMAGE}${movie.poster}")
            .apply(RequestOptions().override(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT))
            .into(holder.ivPoster)

        holder.pcIndicator.maxProgress = Constants.MAX_QUALIFICATION
        holder.pcIndicator.setCurrentProgress(movie.voteAverage.toDouble())
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}