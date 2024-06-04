package com.example.aidar_badirov_hw_3_8

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.aidar_badirov_hw_3_8.databinding.ItemCharacterBinding

class AdapterCharacter(
    private val characterList: List<CharacterModel>,
    val onClick: (model: CharacterModel) -> Unit
) :
    RecyclerView.Adapter<AdapterCharacter.ViewHolderCharacter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
        return ViewHolderCharacter(binding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {
        holder.bind(characterList[position])
    }

    inner class ViewHolderCharacter(private val binding: ItemCharacterBinding) :
            RecyclerView.ViewHolder(binding.root){

                fun bind(characterModel: CharacterModel){
                    binding.apply {
                        characterModel.apply {
                            tvStatus.text = status
                            tvName.text = name
                            Glide.with(characterImg).load(image).into(binding.characterImg)

                            itemView.setOnClickListener{
                                onClick.invoke(characterModel)
                            }
                        }
                    }
                }

    }            }
