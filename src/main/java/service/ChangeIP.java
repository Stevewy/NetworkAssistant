package service;

import ui.MainPanel;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ChangeIP {
    private static List<String> ipPool = new LinkedList();
    private static String netGate = "";
    public static String networkName = "WLAN";

    public ChangeIP() {
    }

    public static void changeIP(int location) {
        initPool(location);

        Iterator var4 = ipPool.iterator();
        while(var4.hasNext()) {
            String ip = (String)var4.next();

            try {
                reconnect(ip);
                TimeUnit.SECONDS.sleep(4L);
            } catch (Exception var7) {
                return;
            }

            try {
                ConnectNetwork.login();
                return;
            } catch (IOException var3) {
                MainPanel.text.append(var3.toString());
            }
        }
    }

    private static void reconnect(String ip) throws Exception {
        Runtime.getRuntime().exec("netsh interface ip set address \"" + networkName + "\" static " + ip + " 255.255.255.0 " + netGate);
    }

    private static void initPool(int location){
        ipPool.clear();
        int i, j;
        switch(location) {
            case 1:
                netGate = "10.132.15.254";

                for(i = 0; i <= 15; ++i) {
                    for(j = 2; j <= 253; ++j) {
                        ipPool.add("10.132." + i + "." + j);
                    }
                }

                return;
            case 2:
                netGate = "10.132.31.254";

                for(i = 28; i <= 31; ++i) {
                    for(j = 1; j <= 253; ++j) {
                        ipPool.add("10.132." + i + "." + j);
                    }
                }

                return;
            case 3:
                netGate = "10.132.39.254";

                for(i = 36; i <= 39; ++i) {
                    for(j = 1; j <= 253; ++j) {
                        ipPool.add("10.132." + i + "." + j);
                    }
                }

                return;
            case 4:
                netGate = "10.132.51.254";

                for(i = 48; i <= 51; ++i) {
                    for(j = 1; j <= 253; ++j) {
                        ipPool.add("10.132." + i + "." + j);
                    }
                }
        }
    }
}
