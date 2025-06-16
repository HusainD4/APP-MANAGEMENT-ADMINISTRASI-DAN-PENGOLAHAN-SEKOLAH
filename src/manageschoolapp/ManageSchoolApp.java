/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manageschoolapp;

import javax.swing.JFrame;
import ui.LoginForm;

/**
 *
 * @author HUSAIN
 */
public class ManageSchoolApp {

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        LoginForm loginForm = new LoginForm();
        loginForm.setExtendedState(JFrame.MAXIMIZED_BOTH); // fullscreen
        loginForm.setVisible(true);
    }

}
