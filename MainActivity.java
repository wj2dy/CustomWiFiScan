

Field field = WifiManager.class.getDeclaredField("mService");
field.setAccessible(true);
Object mService = field.get(wifiman);

Class scanSettingsClass = Class.forName("android.net.wifi.ScanSettings");
Constructor scanSettingsCons = scanSettingsClass.getConstructor();
Object scanSettings = scanSettingsCons.newInstance();

Class wifiChannelClass = Class.forName("android.net.wifi.WifiChannel");
Constructor wifiChannelCons = wifiChannelClass.getConstructor();
Object wifiChannel;

ArrayList<Object> channelSet = new ArrayList<>();
field = scanSettingsClass.getDeclaredField("channelSet");
field.set(scanSettings, channelSet);

wifiChannel = wifiChannelCons.newInstance();
field = wifiChannelClass.getDeclaredField("freqMHz");
field.setInt(wifiChannel, 5765);
field = wifiChannelClass.getDeclaredField("channelNum");
field.setInt(wifiChannel, 153);
field = wifiChannelClass.getDeclaredField("isDFS");
field.setBoolean(wifiChannel, false);
channelSet.add(wifiChannel);

wifiChannel = wifiChannelCons.newInstance();
field = wifiChannelClass.getDeclaredField("freqMHz");
field.setInt(wifiChannel, 5745);
field = wifiChannelClass.getDeclaredField("channelNum");
field.setInt(wifiChannel, 149);
field = wifiChannelClass.getDeclaredField("isDFS");
field.setBoolean(wifiChannel, false);
channelSet.add(wifiChannel);

wifiChannel = wifiChannelCons.newInstance();
field = wifiChannelClass.getDeclaredField("freqMHz");
field.setInt(wifiChannel, 2437);
field = wifiChannelClass.getDeclaredField("channelNum");
field.setInt(wifiChannel, 6);
field = wifiChannelClass.getDeclaredField("isDFS");
field.setBoolean(wifiChannel, false);
channelSet.add(wifiChannel);

wifiChannel = wifiChannelCons.newInstance();
field = wifiChannelClass.getDeclaredField("freqMHz");
field.setInt(wifiChannel, 2462);
field = wifiChannelClass.getDeclaredField("channelNum");
field.setInt(wifiChannel, 11);
field = wifiChannelClass.getDeclaredField("isDFS");
field.setBoolean(wifiChannel, false);
channelSet.add(wifiChannel);

Class[] cArg = new Class[2];
cArg[0] = scanSettingsClass;
cArg[1] = WorkSource.class;
Method method = mService.getClass().getDeclaredMethod("startScan", cArg);
method.invoke(mService, scanSettings, null);



