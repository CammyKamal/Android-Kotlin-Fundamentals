package org.codelabs.androidkotlinfundamentals

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.codelabs.androidkotlinfundamentals.databinding.ItemRowBinding


class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private var dataModelList: List<String>? = null
    private var context: Context? = null
    var dashboardViewModel: DashboardViewModel

    constructor(
        dataModelList: List<String>?,
        ctx: Context?,
        dashboardViewModel: DashboardViewModel
    ) {
        this.dataModelList = dataModelList
        context = ctx
        this.dashboardViewModel = dashboardViewModel
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_row, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel: String = dataModelList!![position]
        holder.bind(position, dataModel, dashboardViewModel)
    }

    class ViewHolder(itemRowBinding: ItemRowBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
        private val itemRowBinding: ItemRowBinding = itemRowBinding
        fun bind(pos: Int, obj: String?, dashboardViewModel: DashboardViewModel) {
            itemRowBinding.value = obj
            itemRowBinding.root.setOnClickListener {
                dashboardViewModel.onItemClick(pos)
            }
            itemRowBinding.executePendingBindings()
        }

    }

    override fun getItemCount(): Int {
        return dataModelList!!.size
    }


}