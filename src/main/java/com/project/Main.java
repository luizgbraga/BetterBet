package com.project;
import com.project.ui.InputForm
;
/**
 * Main class
 * @author Luiz Guilherme Amadi Braga
 */
public class Main {

    /**
     * Simply calls the first screen
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                InputForm form = new InputForm();
                form.setVisible(true);
            }
		});
	}
}
