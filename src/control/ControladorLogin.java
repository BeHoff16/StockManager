/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Usuario;

/**
 *
 * @author behof
 */
public class ControladorLogin {

    private ArrayList<Usuario> usuarios;
    private ControladorTela controladorTela;
    private JTextField jTextFieldUser;
    private JPasswordField jPassword;
    private JLabel jLabelAviso;

    public ControladorLogin(JLabel jLabelAviso, JPasswordField jPassword, JTextField jTextFieldUser, ControladorTela controladorTela) {
        this.jLabelAviso = jLabelAviso;
        this.jPassword = jPassword;
        this.jTextFieldUser = jTextFieldUser;
        this.controladorTela = controladorTela;
        this.usuarios = new ControladorUsuario(controladorTela).getUsuarios();
    }

    public void tentarLogin() {
        String user = jTextFieldUser.getText();
        String senha = new String(jPassword.getPassword());

        for (Usuario u : usuarios) {
            if (u.getUser().equals(user) && u.getSenha().equals(senha)) {
                controladorTela.setUsuarioLogado(u);
                controladorTela.abrirTelaMenu();
                return;
            }
        }
        jLabelAviso.setText("Usuário ou senha incorretos.");
    }
}
