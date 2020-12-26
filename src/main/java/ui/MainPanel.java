package ui;

import entity.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author WangYao
 * @date 2020/12/13
 * @function 主页面
 */
public class MainPanel extends JPanel {
    private static JTextArea Jnumber = new JTextArea("学号",1,10);
    private static JTextArea Jpassword = new JTextArea("密码",1,10);
    private static JTextArea Jlocation = new JTextArea("位置",1,10);
    public static JTextArea text = new JTextArea(18,100);
    private static JButton btn1 = new JButton("普通连接");
    private static JButton btn2 = new JButton("强制连接");
    private static JButton btn3 = new JButton("重置为DHCP协议");

    public MainPanel() {
        read();
        init();
    }

    private void read(){
        try {
            InputStream input = new FileInputStream("resources/config.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            User.number = reader.readLine();
            User.password = reader.readLine();
        } catch (FileNotFoundException e) {
            text.append("没有找到配置文件\n");
        } catch (UnsupportedEncodingException e) {
            text.append("配置文件编码不对,应该是utf-8\n");
        } catch (IOException e) {
            text.append("读取配置文件出错了\n");
        }
        if(User.number == null || User.password == null){
            this.add(Jnumber);
            this.add(Jpassword);
        }
        this.add(Jlocation);
    }


    private void init(){
        text.setLineWrap(true);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("楷体",Font.BOLD,16));
        text.setBackground(Color.YELLOW);
        text.setEditable(false);
        this.add(text);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(text);
        this.add(scrollPane);
        menu();
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);

        btn1.addActionListener(new NormalLoginButton());
        btn2.addActionListener(new ForceLoginButton());
        btn3.addActionListener(new ResetButton());
    }

    private void menu(){
        text.append("                          *************************************************\n");
        text.append("                          *                    Tips                       *\n");
        text.append("                          *  选项2的响应速度不理想                        *\n");
        text.append("                          *  位置：1 第一教学楼 2 图书馆 3 综合楼 4 二基楼*\n");
        text.append("                          *  使用完后需重置为DHCP协议                     *\n");
        text.append("                          *  by: SCU-Java程序设计协会  王耀               *\n");
        text.append("                          *************************************************\n");
    }

    public static boolean getUserNumber(){
        if(!Jnumber.getText().equals("学号")){
            User.number = Jnumber.getText();
            return true;
        }
        return false;
    }

    public static boolean getUserPassword(){
        if(!Jpassword.getText().equals("密码")){
            User.password = Jpassword.getText();
            return true;
        }
        return false;
    }

    public static boolean getUserLocation(){
        if(!Jlocation.getText().equals("位置")){
            User.location = Integer.parseInt(Jlocation.getText());
            return true;
        }
        return false;
    }
}
