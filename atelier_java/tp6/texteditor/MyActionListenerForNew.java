import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class MyActionListenerForNew implements ActionListener {
    MyFrameAWT f;
    public MyActionListenerForNew(MyFrameAWT f) {
        this.f = f;
    }
    public void actionPerformed(ActionEvent e) {
        f.ta.setText("");

    }
}
