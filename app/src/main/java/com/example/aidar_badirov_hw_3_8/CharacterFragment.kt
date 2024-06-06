package com.example.aidar_badirov_hw_3_8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aidar_badirov_hw_3_8.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val character = listOf(
        CharacterModel(
            "Alive",
            "Rick Sanchez",
            "https://s3-alpha-sig.figma.com/img/b86d/7059/b695d8bbb483cac677dfbff28a6b3f98?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fcsBYzsKuzfyJc~lHvyjYQo1K9n4RxlmxmIdzNAF2r6ybCzbRwrhjCwDxMMc~WLJkccANCpfnAJIJbq~eJ95l7MeGmqVmuF6Z9trfTy3Qi~44GSdqYWt7n~B~Vi4ugWLThfm-Eu4eWuMHaZVxhNHMVl5Wz2sGvDmPhEheEo8nVrhIwlM0hT1E-Piz2HklSBIL2fUi9ISpCCK3kiR0Oo-fAPud2PXgYxvzrRaJRUdBRZSXia4EsQyLP9ubtLWR4AqAxsS4Af-~Rvi4KhFJ~lR7awev5zJJyLhkLzkmHv0JQwSwhAyOlNjBhlcyaf45Nt6rhXjae~FZ2Iz85QGns18Kw__"
        ),
        CharacterModel(
            "Alive",
            "Morty Smith",
            "https://s3-alpha-sig.figma.com/img/68d8/7089/d36f153442643543e91adfb999cbcc8f?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=BAYn3nrdg28Y46fpC7YUwK1IJxGyZbztNcfwJuzySKoZgCuTNuodK0ZPwCdApdCItJnuEJggK3g6Hw0x1teYQU6VkCs3vASmr4XtW6-paMyJa~3ELMI7DWhq68KgGtpWBo7FcFFdURqslfM7ZVOvuoX8rOqvhz96QbQY15OttjO7QWymSllV37RLWlJ~procgJKJ8wNec1YKxpcHQI213k0Ci-cGZ93O~L-Zgd5TSiDBz9WKsi8g9LWV3Q0ILgGW-dia8CjK~2TNZwDUvTBedP8JCl-lRyUPKYRMervERzv8aPwLzS8LmdaCUizDAkmGK-1q-43maLhveYU43v948g__"
        ),
        CharacterModel(
            "Dead",
            "Albert Einstein",
            "https://s3-alpha-sig.figma.com/img/5231/5420/d3cab7e26baca69cfedf6be5d1cbe6a8?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=UNmFNkPzQilgLtIDSqByAfSonOwFN0mOE4GghrqkjESPOzYVrjkMM9c6DFNaARcwfKy4gu~9Eev~qRwPhPLfSMShA26QIp8A6NCXPYgWikr0SSxEaE~p7Emytiqr6qe83Y5X8UcgZ7j~Kaj-1NH2DZzeu0isLek6D8~CxyhHGpM9mC1bkIWp1NExUa9HtcXTbjsx~h1lzU7j7AI3PBNadBD6KpC~VlNlDv0GMSxjuGKIKmjvovnyu6kBeLsytFpkcH-n0Ia1Iq1H~p5M3rwlJrQcRag0YbjTrmmGMpLsGFDp~PbouDHN5DoJiD~vYbnX6KIYcELcT08gdsITiag9Jw__"
        ),
        CharacterModel(
            "Alive",
            "Jerry Smith",
            "https://s3-alpha-sig.figma.com/img/037c/875a/38865ee70c2fa0b1b556ff1ffdd17939?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=D2zBjvMPUYg1pzoYX3WIsFLS9~IWmlAUNJWyZFVBOlI4WgBgQqOyNHjQBHQ3UofcalsiQM5xmyVpj7gTmpZB1RKbwfwQzBwMoIlt6-VkYwi68USaDr7Gm4WedVmTTHtdXRu-2qUcmWvofecVp4rLIH7obroCeYykDcCEvUzH2MBKouujnQQruz1cvZZCwbY5w0u1zMkwe1ntlUnZFBpQeAbYaX0njkSKXj8d2r3svzkg7R1V0qN~dzdEOt6qYFVQZqJEUUenFGMHxt25WNRfbB2JpZKi4L1lVtdYHe7YbnueM4LyUIi4QqmGli5haFdu-7axW0DWcalOhiBTfNqhMw__"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = AdapterCharacter(character, this::onClick)
        binding.rvCharacter.adapter = adapter
    }

    private fun onClick(characterModel: CharacterModel) {
        findNavController().navigate(R.id.characterDetailFragment, bundleOf("character" to characterModel))
    }
}

