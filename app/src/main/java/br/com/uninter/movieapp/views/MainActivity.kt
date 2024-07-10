package br.com.uninter.movieapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.uninter.movieapp.R
import br.com.uninter.movieapp.databinding.ActivityMainBinding
import br.com.uninter.movieapp.viewModels.MoviesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapterMovie: AdapterMovie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]

        setupRecycleView()

        viewModel.movieList.observe(this) {
            adapterMovie.movieList = it
            adapterMovie.notifyDataSetChanged()
        }

        binding.cvBanner.setOnClickListener {
            viewModel.getBanner()
            changeColorButton("banner")
        }

        binding.cvPopulars.setOnClickListener {
            viewModel.getPopular()
            changeColorButton("popular")
        }

        viewModel.getBanner()
    }

    private fun changeColorButton(button: String) {
        val greenColor = ResourcesCompat.getColor(resources, R.color.green_200, null)
        val blueColor = ResourcesCompat.getColor(resources, R.color.blue_200, null)

        when(button) {
            "banner" -> {
                binding.cvBanner.setCardBackgroundColor(greenColor)
                binding.cvPopulars.setCardBackgroundColor(blueColor)
            }
            "popular" -> {
                binding.cvBanner.setCardBackgroundColor(blueColor)
                binding.cvPopulars.setCardBackgroundColor(greenColor)
            }
        }
    }

    private fun setupRecycleView() {
        val layoutManager = GridLayoutManager(this, 3)
        binding.rvMovies.layoutManager = layoutManager
        adapterMovie = AdapterMovie(this, arrayListOf())
        binding.rvMovies.adapter = adapterMovie
    }
}