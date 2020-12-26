package entity;

import ui.MainPanel;

/**
 * @author WangYao
 * @date 2020/12/13
 * @function
 */
public class User {
    public static String number;
    public static String password;
    public static int location;

    public static boolean get(){
        if(number == null && !MainPanel.getUserNumber()) return false;
        if(password == null && !MainPanel.getUserPassword()) return false;
        if(location == 0 && !MainPanel.getUserLocation()) return false;
        return true;
    }
}
