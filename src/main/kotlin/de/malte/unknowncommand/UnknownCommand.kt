package de.malte.unknowncommand

import de.malte.unknowncommand.commands.ReloadCommand
import de.malte.unknowncommand.config.Config
import de.malte.unknowncommand.config.ConfigLoader
import de.malte.unknowncommand.listener.CommandListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class UnknownCommand : JavaPlugin() {
    private lateinit var configFile: File
    lateinit var config: Config

    override fun onLoad() {
        plugin = this
    }

    override fun onEnable() {
        configFile = File(dataFolder, "config.json")
        if (!configFile.exists())
            ConfigLoader.write(this, "config.json", Config())
        config = ConfigLoader.read(this, "config.json", Config::class.java)

        Bukkit.getPluginManager().registerEvents(CommandListener(), this)
        getCommand("ucreload")?.executor = ReloadCommand()
    }

    companion object {
        private var plugin: UnknownCommand? = null
        val instance: UnknownCommand
            get() {
                return plugin!!
            }
    }
}