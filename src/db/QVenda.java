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
import model.Venda;

/**
 *
 * @author behof
 */
public class QVenda {

    private File arquivo = new File("vendas.dat");
    private File arquivoTmp = new File("vendas.dat.tmp");
    private File arquivoBak = new File("vendas.dat.bak");
    private boolean podeSalvar = true;

    @SuppressWarnings("unchecked")
    public ArrayList<Venda> carregar() {
        if (!arquivo.exists()) return new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(arquivo);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            return (ArrayList<Venda>) in.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException ex) {
            Logger.getLogger(QVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        preservarArquivo();
        return new ArrayList<>();
    }

    public void salvar(ArrayList<Venda> vendas) {
        if (!podeSalvar) return;
        try {
            try (FileOutputStream fos = new FileOutputStream(arquivoTmp);
                    ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(vendas);
            }
            Files.move(arquivoTmp.toPath(), arquivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(QVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar as vendas.");
        }
    }

    private void preservarArquivo() {
        try {
            Files.move(arquivo.toPath(), arquivoBak.toPath(), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo de vendas.\n"
                    + "Ele foi renomeado para " + arquivoBak.getName() + " e o relatório de vendas vai começar vazio.");
        } catch (IOException ex) {
            Logger.getLogger(QVenda.class.getName()).log(Level.SEVERE, null, ex);
            podeSalvar = false;
            JOptionPane.showMessageDialog(null, "Não foi possível ler nem renomear o arquivo de vendas.\n"
                    + "As novas vendas não serão registradas no relatório.");
        }
    }
}
