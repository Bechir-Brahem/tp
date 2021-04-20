import java.awt.*;
import java.awt.event.*;

class MyFrameAWT extends Frame {
    Panel pNorth = new Panel();
    Button bNew = new Button("New");
    Button bOpen = new Button("Open");
    Button bSave = new Button("Save");
    Button bQuit = new Button("Exit");
    Panel pSouth = new Panel();
    TextArea ta = new TextArea("");
    public MyFrameAWT () {
        pNorth.setBackground(Color.green);
        pNorth.add(bNew);
        pNorth.add(bOpen);
        pNorth.add(bSave);
        pNorth.add(bQuit);
        pSouth.setBackground(Color.yellow);
        pSouth.add(ta);
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(2, 1));
        this.add(pNorth);
        this.add(pSouth);
        this.setBounds(10, 10, 500, 400);
        this.setVisible(true);

        MyWindowListener x1 = new MyWindowListener();
        this.addWindowListener(x1);

        MyActionListenerForOpen x2 = new MyActionListenerForOpen(this);
        bOpen.addActionListener(x2);
        bNew.addActionListener(new MyActionListenerForNew(this));
        bSave.addActionListener(new MyActionListenerForSave(this));
        bQuit.addActionListener(new MyActionListenerForExit(this));
    
    }

}
