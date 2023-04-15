package de.malte.unknowncommand.commands

import de.malte.unknowncommand.UnknownCommand
import de.malte.unknowncommand.config.Config
import de.malte.unknowncommand.config.ConfigLoader
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ReloadCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        UnknownCommand.instance.config = ConfigLoader.read(UnknownCommand.instance, "config.json", Config::class.java)
        sender.sendMessage("§cUnknownCommand §8»§a Config Reloaded.")
        return true
    }
}