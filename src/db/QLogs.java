/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.EOFException;
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
import model.Log;

/**
 *
 * @author behof
 */
public class QLogs {

    private File arquivo = new File("logs.dat");
    private File arquivoTmp = new File("logs.dat.tmp");
    private File arquivoBak = new File("logs.dat.bak");
    private File arquivoAntigo = new File("stockmanager67.dat");
    private boolean podeSalvar = true;

    @SuppressWarnings("unchecked")
    public ArrayList<Log> carregar() {
        if (arquivo.exists()) {
            try (FileInputStream fis = new FileInputStream(arquivo);
                    ObjectInputStream in = new ObjectInputStream(fis)) {
                return (ArrayList<Log>) in.readObject();
            } catch (IOException | ClassNotFoundException | ClassCastException ex) {
                Logger.getLogger(QLogs.class.getName()).log(Level.SEVERE, null, ex);
            }
            preservarArquivo();
            return new ArrayList<>();
        }
        if (!arquivoAntigo.exists()) return new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(arquivoAntigo);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            in.readObject();
            in.readObject();
            return (ArrayList<Log>) in.readObject();
        } catch (EOFException semLogs) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException | ClassCastException ex) {
            Logger.getLogger(QLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void salvar(ArrayList<Log> logs) {
        if (!podeSalvar) return;
        try {
            try (FileOutputStream fos = new FileOutputStream(arquivoTmp);
                    ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(logs);
            }
            Files.move(arquivoTmp.toPath(), arquivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(QLogs.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os logs.");
        }
    }

    private void preservarArquivo() {
        try {
            Files.move(arquivo.toPath(), arquivoBak.toPath(), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo de logs.\n"
                    + "Ele foi renomeado para " + arquivoBak.getName() + " e o histórico vai começar vazio.");
        } catch (IOException ex) {
            Logger.getLogger(QLogs.class.getName()).log(Level.SEVERE, null, ex);
            podeSalvar = false;
            JOptionPane.showMessageDialog(null, "Não foi possível ler nem renomear o arquivo de logs.\n"
                    + "Os novos logs não serão salvos.");
        }
    }
}
