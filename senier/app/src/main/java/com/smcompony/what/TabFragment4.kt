package com.smcompony.what

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class TabFragment4 : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    private var mWebView: WebView? = null
    private var mWebSettings: WebSettings? = null
    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tab3, container, false)
        mWebView = view.findViewById<View>(R.id.webview_login) as WebView
        mWebView!!.webViewClient = WebViewClient()
        mWebSettings = mWebView!!.settings
        mWebSettings!!.javaScriptEnabled = true
        mWebSettings!!.allowFileAccess = true
        mWebSettings!!.allowFileAccessFromFileURLs = true
        mWebSettings!!.allowUniversalAccessFromFileURLs = true
        mWebSettings!!.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        mWebSettings!!.cacheMode = WebSettings.LOAD_NO_CACHE
        mWebSettings!!.useWideViewPort = false
        mWebSettings!!.loadWithOverviewMode = true
        mWebSettings!!.domStorageEnabled = true
        mWebView!!.settings.setSupportZoom(true)
        mWebView!!.settings.builtInZoomControls = true
        mWebView!!.settings.displayZoomControls = false
        mWebView!!.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: JsResult): Boolean {
                return super.onJsAlert(view, url, message, result)
            }
        }

        if (Build.VERSION.SDK_INT >= 21) {
            mWebView!!.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        mWebView!!.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                if (url.endsWith(".mp4")) {
                    val i = Intent(Intent.ACTION_VIEW)
                    val uri = Uri.parse(url)
                    i.setDataAndType(uri, "video/mp4")
                    startActivity(i)
                }
                super.onPageFinished(view, url)
            }

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.startsWith("market://")) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                    return true
                } else {
                    super.shouldOverrideUrlLoading(view, url)

                }
                return false
            }
        }

        mWebView!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // 웹뷰 뒤로가기 버튼 클릭시 액션
            //This is the filter
            if (event.action != KeyEvent.ACTION_DOWN)
                return@OnKeyListener true

            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (mWebView!!.canGoBack()) {
                    mWebView!!.goBack()
                    Log.d("canGoBack", "로그 내용")
                } else {
                    Log.d("canNotGoBack", "로그 내용")
                    (activity as MainActivity).onBackPressed()
                }
                return@OnKeyListener true
            }
            false
        })
        mWebView!!.loadUrl("http://172.20.10.2:8080/BootstrapEx/index.jsp")     //  http://192.168.0.3:8080/BootstrapEx/index.jsp    http://172.30.52.10:8080  109.160 "http://172.30.53.100:8080/BootstrapEx/loginAndroid.jsp"
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }


    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WebviewFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): TabFragment4 {
            val fragment = TabFragment4()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor