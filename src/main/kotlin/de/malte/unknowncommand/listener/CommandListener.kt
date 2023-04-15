package de.malte.unknowncommand.listener

import de.malte.unknowncommand.UnknownCommand
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class CommandListener : Listener {
    @EventHandler
    fun onCommand(e: PlayerCommandPreprocessEvent) {
        if (e.isCancelled) return
        val config = UnknownCommand.instance.config
        val cmd: String = if (config.splitAtColon) {
            val s = e.message.split(" ")[0].split(":")
            if (s.size > 1)
                "/${s[1]}"
            else
                s[0]
        } else {
            e.message.split(" ")[0]
        }
        val helpTopic = Bukkit.getHelpMap().getHelpTopic(cmd)
        if (helpTopic == null) {
            e.player.sendMessage(config.unknownCommandMessage.replace("{0}", e.message.split(" ")[0]))
            e.isCancelled = true
        }
    }
}