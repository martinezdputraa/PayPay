package com.martinezdputra.rateconverter.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class CoreActivity<VM: CoreViewModel>: AppCompatActivity() {
    private lateinit var mViewModel: VM

    abstract fun createViewModel(): VM
    abstract fun onInitView(): ViewDataBinding
    abstract fun injectComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        mViewModel = createViewModel()
        val viewBinding = onInitView()
        viewBinding.lifecycleOwner = this
        setContentView(viewBinding.root)
    }

    val viewModel: VM
        get() = mViewModel
}