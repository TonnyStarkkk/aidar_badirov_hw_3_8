package com.example.aidar_badirov_hw_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.aidar_badirov_hw_3_8.databinding.FragmentSingInScreenBinding


class CharacterDetailFragment : Fragment() {
    private lateinit var binding: FragmentSingInScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingInScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = requireArguments().getSerializable("character") as CharacterModel
        binding.apply {
            tvStatus.text = character.status
            tvName.text = character.name
            Glide.with(characterImg).load(character.image).into(characterImg)
        }
    }

}