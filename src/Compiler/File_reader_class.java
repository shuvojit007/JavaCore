package Compiler;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_reader_class {
    static FileReader file_reader;
    static FileWriter fileWriter;
    static BufferedReader reader;
    static BufferedWriter writer;
    static JFileChooser fileChooser;
    static FileNameExtensionFilter filter;
    static JFileChooser save_path;

    public File_reader_class() {
    }

    public static void main(String[] args) throws IOException {
        filter = new FileNameExtensionFilter("TEXT FILES", new String[]{"txt", "text"});
        fileChooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Chose A Text File");
        save_path = new JFileChooser(System.getProperty("user.home") + "/Desktop");
        save_path.setFileFilter(filter);
        save_path.setDialogTitle("Select Directory To Save File");

        try {
            String temp = "";
            boolean flag = false;
            if(fileChooser.showOpenDialog((Component)null) == 0) {
                file_reader = new FileReader(fileChooser.getSelectedFile().getAbsolutePath());

                String a;
                for(reader = new BufferedReader(file_reader); (a = reader.readLine()) != null; temp = temp + a + "\n") {
                    ;
                }

                flag = true;
                file_reader.close();
                reader.close();
            }

            if(!flag) {
                JOptionPane.showMessageDialog((Component)null, "No Chosen File, Program Will Exit");
                System.exit(0);
            }

            flag = false;
            if(save_path.showSaveDialog((Component)null) == 0) {
                fileWriter = new FileWriter(save_path.getSelectedFile() + ".txt");
                writer = new BufferedWriter(fileWriter);
                writer.write(temp);
                writer.close();
                fileWriter.close();
                flag = true;
            }

            if(!flag) {
                JOptionPane.showMessageDialog((Component)null, "Dont Have Any \nlocation and File Name, File Will Not Save");
                System.exit(0);
            }
        } catch (FileNotFoundException var4) {
            System.out.println("File Not Found");
        }

    }
}
