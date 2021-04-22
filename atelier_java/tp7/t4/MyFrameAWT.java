import java.awt.*;
import java.awt.event.*;

class MyFrameAWT extends Frame {
    Panel pNorth = new Panel();
    Button bNew = new Button("New");
    Button bOpen = new Button("Open txt");
    Button bOpenO = new Button("Open obj");
    Button bSaveO = new Button("Save obj");
    Button bSaveT = new Button("Save txt");
    Button bQuit = new Button("Exit");
    Button bSearch = new Button("Search");
    Button bLoad = new Button("Load");
    Panel pSouth = new Panel();
    TextArea ta = new TextArea("");
    TextArea search = new TextArea("");
    int line;
    public MyFrameAWT () {
        pNorth.setBackground(Color.gray);
        pNorth.add(bNew);
        pNorth.add(bOpen);
        pNorth.add(bOpenO);
        pNorth.add(bSaveO);
        pNorth.add(bSaveT);
        pNorth.add(bSearch);
        pNorth.add(bQuit);
        pNorth.add(bLoad);
        pNorth.add(search);
        pSouth.setBackground(Color.black);
        pSouth.add(ta);
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(2, 0));
        this.add(pNorth);
        this.add(pSouth);
        this.setBounds(10, 10, 500, 400);
        this.setVisible(true);

        MyWindowListener x1 = new MyWindowListener();
        this.addWindowListener(x1);

        MyActionListenerForOpen x2 = new MyActionListenerForOpen(this);
        bOpen.addActionListener(x2);
        bNew.addActionListener(new MyActionListenerForNew(this));
        bOpenO.addActionListener(new MyActionListenerForOpenO(this));
        bSaveT.addActionListener(new MyActionListenerForSave(this));
        bQuit.addActionListener(new MyActionListenerForExit(this));
        bSaveO.addActionListener(new MyActionListenerForSaveO(this));
        bSearch.addActionListener(new MyActionListenerForSearch(this));
        bLoad.addActionListener(new MyActionListenerForLoad(this));

    }

}
