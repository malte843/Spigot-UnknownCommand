package de.malte.unknowncommand.config

import com.google.gson.annotations.SerializedName

class Config {
    val unknownCommandMessage = "§cUnknownCommand §8»§7 The Command: §e{0} §7is not available."
    @SerializedName("splitAtColon(Required that for example /bukkit:help works)")
    val splitAtColon = false
}