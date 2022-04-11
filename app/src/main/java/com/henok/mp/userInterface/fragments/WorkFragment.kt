package com.henok.mp.userInterface.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henok.mp.data.Work
import com.henok.mp.adapter.WorkAdapter
import com.henok.mp.userInterface.dialog.WorkDialog
import com.henok.mp.R
import com.zelalem.mp.R

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    getString(R.string.netflix),
                    getString(R.string.soft_eng),
                    getString(R.string._2020_present),
                    R.drawable.neflix
                ),
                Work(
                    getString(R.string.google),
                    getString(R.string.application_developer_for_youtube),
                    getString(R.string._2018_2020),
                    R.drawable.google
                ),
                Work(
                    getString(R.string.amazon),
                    getString(R.string.sde_ii),
                    getString(R.string._2016_2018),
                    R.drawable.amazon
                ),
                Work(
                    getString(R.string.creospan),
                    getString(R.string.sr_full_stack_engineer),
                    getString(R.string._2014_2016),
                    R.drawable.creospan
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkDialog()
        dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}