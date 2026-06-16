package com.emulator.launcher;

import com.emulator.core.GameConfig;
import java.io.IOException;

public class GameLauncher {
    public void launch(GameConfig config) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "emulator-engine.jar");
            // Передаем настройки через аргументы
            pb.command().addAll(java.util.Arrays.asList(config.toArgs()));
            
            // Запускаем в новом окне (ИСПРАВЛЕНО: добавлен вызов метода скобками)
            Process process = pb.start();
            System.out.println("Эмулятор запущен с настройками: " + config.resolution());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
