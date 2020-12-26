package ui;

import service.ChangeIP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author WangYao
 * @date 2020/12/13
 * @function 重置协议
 */
public class ResetButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel.text.append("正在重置协议\n");
        changeToDHCP();
        MainPanel.text.append("重置协议完成\n");
    }

    private void changeToDHCP(){
        try {
            Runtime.getRuntime().exec("netsh interface ip set address \"" + ChangeIP.networkName + "\" DHCP");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
