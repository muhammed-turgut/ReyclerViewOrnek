package com.muhammedturgut.youtubeproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammedturgut.youtubeproject.databinding.RecyclerRowBinding

class ProgramAdapter(val ProgramLanListe: ArrayList<ProgramLan>):RecyclerView.Adapter<ProgramAdapter.ProgramHolder>() {

    class ProgramHolder(val binding : RecyclerRowBinding ):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramHolder {
        val binding= RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ProgramHolder(binding)
    }

    override fun getItemCount(): Int {
        return ProgramLanListe.size
    }

    override fun onBindViewHolder(holder: ProgramHolder, position: Int) {
    holder.binding.progNameText.text=ProgramLanListe.get(position).programNmae
        holder.binding.progAboutText.text=ProgramLanListe.get(position).programAbout
        holder.binding.progImage.setImageResource(ProgramLanListe.get(position).programImage)

        holder.itemView.setOnClickListener {
            val intent=Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("ProgramLan",ProgramLanListe.get(position))
            holder.itemView.context.startActivity(intent)
        }

    }
}