package com.project;
import com.project.ui.InputForm;
public class Main {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    InputForm form = new InputForm();
                    form.setVisible(true);
                }
            });
	}
}
