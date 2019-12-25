package com.example.languagefragmentexample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yariksoffice.lingver.Lingver
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btnEnglish.setOnClickListener {
            Lingver.getInstance().setLocale(view.context, "en")
            activity?.recreate()
        }

        view.btnRussian.setOnClickListener {
            Lingver.getInstance().setLocale(view.context, "uk")
            activity?.recreate()
        }

        view.btnOpenWebView.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, WebViewFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}
