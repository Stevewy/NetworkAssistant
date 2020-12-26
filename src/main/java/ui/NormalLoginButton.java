package ui;

import entity.User;
import service.ConnectNetwork;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/12/13
 * @function 普通连接
 */
public class NormalLoginButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        if(!User.get()) {
            MainPanel.text.append("请先输入上面参数\n");
            return;
        }

        MainPanel.text.append("正在连接校园网\n");
        normalLogin(User.number,User.password);
        if(ConnectNetwork.loginStatus) MainPanel.text.append("连接成功\n");
        else MainPanel.text.append("连接失败,建议使一下强制连接\n");
    }

    private void normalLogin(String number, String password){
        while(!ConnectNetwork.loginStatus) {
            try {
                ConnectNetwork.login();
            } catch (Exception var3) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
