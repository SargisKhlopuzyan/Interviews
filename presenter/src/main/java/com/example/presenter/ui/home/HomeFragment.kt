package com.example.presenter.ui.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.presenter.ui.base.BaseFragment
import com.example.presenter.ui.theme.InterviewTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onAttach(context: Context) {
        logF("onAttach - context: Context?")
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity) {
        logF("onAttach - activity: Activity?")
        super.onAttach(activity)
    }

    override fun onAttachFragment(childFragment: Fragment) {
        logF("onAttachFragment")
        super.onAttachFragment(childFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        logF("onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logF("onCreateView")

        return ComposeView(requireContext()).apply {
            setContent {
                InterviewTheme {
                    HomeScreen(
                        viewModel = viewModel,
                        onNavigateServiceScreenClicked = {
                            navigateToServiceScreen()
                        }
                    )
                }
            }
        }
    }

    private fun navigateToServiceScreen() {
        HomeFragmentDirections.actionNavigationHomeToMusicListFragment(
            "xxxxx"
//                AddMultiTextArgument(
//                    appBarTitle = getString(R.string.title),
//                    textType = MultiTextType.TITLE,
//                    textValue = viewModel.uiState.value.title
//                )
        )
            .navigate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        logF("onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        logF("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        logF("onStart")
        super.onStart()
    }

    override fun onResume() {
        logF("onResume")
        super.onResume()
    }

    override fun onPause() {
        logF("onPause")
        super.onPause()
    }

    override fun onStop() {
        logF("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        logF("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        logF("onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        logF("onDetach")
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private fun logF(msg: String) {
        Log.e("LOG_TAG_FRAGMENT", msg)
    }
}