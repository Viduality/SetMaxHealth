package com.github.Viduality.SetMaxHealth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;



/**
 * Copyright (C) 2018 Viduality
 * <p>
 * This program is free software;
 * you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses/>.
 *
 * @author Viduality
 */

public class SetHealth extends JavaPlugin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setmaxhealth")) {
            if (args.length == 2) {
                Player player = getServer().getPlayer(args[0]);
                if (!(player == null)) {
                    if (isInt(args[1])) {
                        int Health = Integer.parseInt(args[1]);
                        if (Health <= 100) {
                            if (Health > 0) {
                                player.setMaxHealth(Health);
                                return true;
                            }sender.sendMessage(ChatColor.RED + "Enter a Health that is over 0!");
                            return true;
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "You have to Enter a number which can be up to 100!");
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "Player is not Online!");
                return true;
            }
        }
        return false;
    }


    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
