package db;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
import model.Produto;

/**
 *
 * @author behof
 */
public class QProduto {

    private File arquivo = new File("produtos.dat");
    private File arquivoTmp = new File("produtos.dat.tmp");
    private File arquivoBak = new File("produtos.dat.bak");
    private File arquivoAntigo = new File("stockmanager67.dat");
    private boolean podeSalvar = true;

    @SuppressWarnings("unchecked")
    public ArrayList<Produto> carregar() {
        if (arquivo.exists()) {
            try (FileInputStream fis = new FileInputStream(arquivo);
                    ObjectInputStream in = new ObjectInputStream(fis)) {
                return (ArrayList<Produto>) in.readObject();
            } catch (IOException | ClassNotFoundException | ClassCastException ex) {
                Logger.getLogger(QProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            preservarArquivo();
            return new ArrayList<>();
        }
        if (!arquivoAntigo.exists()) return new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(arquivoAntigo);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            in.readObject();
            return (ArrayList<Produto>) in.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException ex) {
            Logger.getLogger(QProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void salvar(ArrayList<Produto> produtos) {
        if (!podeSalvar) return;
        try {
            try (FileOutputStream fos = new FileOutputStream(arquivoTmp);
                    ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(produtos);
            }
            Files.move(arquivoTmp.toPath(), arquivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(QProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os produtos.");
        }
    }

    private void preservarArquivo() {
        try {
            Files.move(arquivo.toPath(), arquivoBak.toPath(), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo de produtos.\n"
                    + "Ele foi renomeado para " + arquivoBak.getName() + " e a lista de produtos vai começar vazia.");
        } catch (IOException ex) {
            Logger.getLogger(QProduto.class.getName()).log(Level.SEVERE, null, ex);
            podeSalvar = false;
            JOptionPane.showMessageDialog(null, "Não foi possível ler nem renomear o arquivo de produtos.\n"
                    + "As alterações nos produtos não serão salvas.");
        }
    }
}
