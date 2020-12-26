import ui.MainPanel;

import javax.swing.*;

/**
 * @author WangYao
 * @date 2020/11/27
 * @function 运行类
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 900, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainPanel());
        frame.setVisible(true);
    }
}
