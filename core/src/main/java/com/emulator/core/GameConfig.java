// core/src/main/java/com/emulator/core/GameConfig.java
package com.emulator.core;

public record GameConfig(String apkPath, int fps, String resolution) {
    public String[] toArgs() {
        return new String[] {
            "--apk", apkPath,
            "--fps", String.valueOf(fps),
            "--res", resolution
        };
    }
}
