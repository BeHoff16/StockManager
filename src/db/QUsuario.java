/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author behof
 */
public class QUsuario {

    private File arquivo = new File("usuarios.dat");
    private File arquivoTmp = new File("usuarios.dat.tmp");
    private File arquivoBak = new File("usuarios.dat.bak");
    private File arquivoAntigo = new File("stockmanager67.dat");
    private boolean podeSalvar = true;

    @SuppressWarnings("unchecked")
    public ArrayList<Usuario> carregar() {
        if (arquivo.exists()) {
            try (FileInputStream fis = new FileInputStream(arquivo);
                    ObjectInputStream in = new ObjectInputStream(fis)) {
                return (ArrayList<Usuario>) in.readObject();
            } catch (IOException | ClassNotFoundException | ClassCastException ex) {
                Logger.getLogger(QUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            preservarArquivo();
            return new ArrayList<>();
        }
        if (!arquivoAntigo.exists()) return new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(arquivoAntigo);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            return (ArrayList<Usuario>) in.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException ex) {
            Logger.getLogger(QUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void salvar(ArrayList<Usuario> usuarios) {
        if (!podeSalvar) return;
        try {
            try (FileOutputStream fos = new FileOutputStream(arquivoTmp);
                    ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(usuarios);
            }
            Files.move(arquivoTmp.toPath(), arquivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(QUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os usuários.");
        }
    }

    private void preservarArquivo() {
        try {
            Files.move(arquivo.toPath(), arquivoBak.toPath(), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo de usuários.\n"
                    + "Ele foi renomeado para " + arquivoBak.getName() + " e o sistema vai iniciar com os usuários padrão.");
        } catch (IOException ex) {
            Logger.getLogger(QUsuario.class.getName()).log(Level.SEVERE, null, ex);
            podeSalvar = false;
            JOptionPane.showMessageDialog(null, "Não foi possível ler nem renomear o arquivo de usuários.\n"
                    + "O sistema vai iniciar com os usuários padrão, mas as alterações nos usuários não serão salvas.");
        }
    }
}
