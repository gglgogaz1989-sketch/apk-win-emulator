package com.emulator.core;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import java.io.File;
import java.io.IOException;

public class ApkValidator {

    public record ValidationResult(boolean isValid, String message) {}

    public static ValidationResult validate(String filePath) {
        File file = new File(filePath);
        
        if (!file.exists() || !filePath.endsWith(".apk")) {
            return new ValidationResult(false, "Файл не найден или это не APK.");
        }

        try (ApkFile apkFile = new ApkFile(file)) {
            ApkMeta apkMeta = apkFile.getApkMeta();
            
            // Здесь логика проверки: 
            // Например, проверяем версию SDK или наличие метаданных
            if (apkMeta.getLabel() == null) {
                return new ValidationResult(false, "Поврежденный манифест APK.");
            }

            return new ValidationResult(true, "Этот APK хорош, можно запускать эмулятор: " + apkMeta.getLabel());
            
        } catch (IOException e) {
            return new ValidationResult(false, "Ошибка чтения APK: " + e.getMessage());
        }
    }
}
