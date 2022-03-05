package controller;

import view.MyView;

public class MyController {
    private MyView myGUI;

    private void Start() {
        myGUI = new MyView();
        //Initialize();
        myGUI.setVisible(true);
    }

    /*private void Initialize()
    {
        myGUI.setMyButtonActionListener(e->{
            myGUI.setMyLabelValue("My button works!");
        });
    }*/

    public static void main(String[] args) {
        MyController controller = new MyController();

        controller.Start();
    }
}
