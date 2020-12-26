package ui;

import entity.User;
import service.ChangeIP;
import service.ConnectNetwork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author WangYao
 * @date 2020/12/13
 * @function 强制连接
 */
public class ForceLoginButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!User.get()) {
            MainPanel.text.append("请先输入上面参数\n");
            return;
        }

        MainPanel.text.append("正在强制连接校园网\n");
        ChangeIP.changeIP(User.location);
        if(ConnectNetwork.loginStatus) MainPanel.text.append("连接成功\n");
        else MainPanel.text.append("连接失败\n");
    }

}
