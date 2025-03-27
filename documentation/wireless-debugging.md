# Wireless debugging guide

In order to connect to the Android device via WiFi for debugging purposes follow the following steps:
1. Activate developer settings on the device
2. In the settings turn on wireless debugging
3. Pair the device with development machine via adb with command `adb pair IP:PORT` and provide the pairing code. 
4. Connect the devices via adb with comman `adb connect IP:PORT`