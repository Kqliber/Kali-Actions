package me.kaliber.actionutil.base

import org.bukkit.entity.Player

interface Action
{
    val id: String
    val aliases: List<String>

    fun run(player: Player, action: String)
}
