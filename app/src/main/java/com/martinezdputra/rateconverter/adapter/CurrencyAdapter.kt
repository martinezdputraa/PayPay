package com.martinezdputra.rateconverter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.martinezdputra.rateconverter.R
import com.martinezdputra.rateconverter.databinding.LayoutCurrencyDropdownItemBinding
import com.martinezdputra.rateconverter.datamodel.Currency

class CurrencyAdapter(context: Context, currencies: List<Currency>): ArrayAdapter<Currency>(context, 0, currencies) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempView = convertView
        if(tempView == null) {
            tempView = LayoutInflater.from(context).inflate(R.layout.layout_currency_dropdown_item, parent, false)
        }
        val displayString = getItem(position)?.let { "${it.code} - ${it.displayString}" }
        tempView?.findViewById<TextView>(R.id.text_view_label)?.text = displayString
        return tempView!!
    }
}