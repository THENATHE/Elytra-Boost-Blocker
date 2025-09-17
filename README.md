# Elytra Boost Blocker (Fabric 1.21.x)
Blocks **firework boosting** while gliding with an elytra in configurable dimensions.
Defaults: **Overworld** and **Nether**; **End** remains allowed.

## Requirements
- **Java 21** (e.g., Eclipse Temurin 21)
- **One of:**
  - Gradle **8.12+** installed _or_
  - Run `gradle wrapper` once to generate `gradlew` on your machine

## Build
```bash
# Option A: If you have Gradle installed
gradle build

# Option B: Generate the wrapper, then use it
gradle wrapper --gradle-version 8.12
./gradlew build
```

The built jar will be at:
`build/libs/elytra-boost-blocker-fabric-1.0.0.jar`

## Install (server-side Fabric)
1) Put the jar into your server's `mods/` folder.
2) Ensure the server runs **Fabric Loader** and includes **Fabric API** for your exact 1.21.x version.
3) Start the server once; a config file will be created at `config/elytra_boost_blocker.json`.

## Configure
Edit `config/elytra_boost_blocker.json`:
```json
{
  "blocked_dimensions": ["minecraft:overworld", "minecraft:the_nether"],
  "notify_player": true,
  "message": "Firework boosting is disabled in this dimension."
}
```
To allow boosting in the End, **do not** include `minecraft:the_end`.

## Notes
- The mod cancels using **firework rockets** only when the player is **fall-flying** (elytra gliding) *and* in a blocked dimension.
- Normal elytra gliding is unaffected; rockets elsewhere still work.
- Works on dedicated servers; clients can be vanilla.

---

### Gradle & Loom versions
This project now uses **Fabric Loom 1.11.4**, which supports **Gradle 8.14 and 9.0**. 
If you still want to force a specific Gradle, you can generate a wrapper:
```bash
gradle wrapper --gradle-version 8.14.0
./gradlew build
```
