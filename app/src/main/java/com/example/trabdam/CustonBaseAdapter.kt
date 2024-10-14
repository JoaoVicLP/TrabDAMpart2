package com.example.trabdam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomBaseAdapter(
    private val context: Context,
    private val listRaca: Array<String>
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return listRaca.size
    }

    override fun getItem(position: Int): Any {
        return listRaca[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.activity_custom_list_view, parent, false)
        val txtView = view.findViewById<TextView>(R.id.textView)
        txtView.text = listRaca[position]
        return view
    }
}
