package com.example.testcasemagang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity(), GameContract.View {

    private lateinit var presenter: GameContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set layout, inisialisasi presenter, dan implementasi lainnya
        setContentView(R.layout.activity_game)

        val service = RetrofitClient.createService(RawgApiService::class.java)
        presenter = GamePresenter(this, service)

        // Panggil fungsi untuk mendapatkan daftar permainan
        presenter.getGames()
    }

    override fun showGames(games: List<Game>) {
        // Implementasi tampilan daftar permainan
    }

    override fun showGameDetails(game: Game) {
        // Implementasi tampilan detail permainan
    }

    override fun showErrorMessage(error: String) {
        // Implementasi menampilkan pesan kesalahan
    }
}
