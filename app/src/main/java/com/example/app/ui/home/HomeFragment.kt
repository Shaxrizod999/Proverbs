package com.example.app.ui.home

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.app.R
import com.example.app.adapters.RecyclerAdapter
import com.example.app.databinding.FragmentHomeBinding
import com.example.app.network.RetrofitInstance
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.dialog_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.app.models.Maqollar as Maqollar

class HomeFragment : Fragment() {

   private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val api = RetrofitInstance.api

        api.getAllMaqollar().enqueue(object : Callback<List<Maqollar>> {
            override fun onResponse(
                call: Call<List<Maqollar>>,
                response: Response<List<Maqollar>>
            ) {
                if (response.isSuccessful){
                    val list: List<Maqollar> =  response.body() as List<Maqollar>
                    binding.rv.adapter = RecyclerAdapter(list){
                        showDiaolg(it)
                    }
                }
            }
            override fun onFailure(call: Call<List<Maqollar>>, t: Throwable) {
                Toast.makeText(binding.root.context, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
        return binding.root
    }
    private fun showDiaolg(maqollar: Maqollar) {

        val dialog = AlertDialog.Builder(requireContext() ).create()
        val dialogView = layoutInflater.inflate(R.layout.dialog_view, binding.root, false)

        var ss = dialogView.findViewById<TextView>(R.id.maqoleng)
        ss.text = maqollar.english
        var sss = dialogView.findViewById<TextView>(R.id.maqoluz)
        sss.text = maqollar.uzbek
        var ssss = dialogView.findViewById<TextView>(R.id.maqolru)
        ssss.text = maqollar.russian

//        var share = dialog.findViewById<ImageView>(R.id.share)

//        share.setOnClickListener {
//            val intent= Intent()
//            intent.action= Intent.ACTION_SEND
//            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this Great app:")
//            intent.type="text/plain"
//            startActivity(Intent.createChooser(intent,"Share To:"))
//        }

        dialog.setView(dialogView.rootView)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setView(dialogView)
        dialog.show()
    }
}