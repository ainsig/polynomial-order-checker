import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main extends JFrame {


    public static void main(String[] args) throws InvalidPolynomialSyntax {

        ArrayList<Polynomial> list = new ArrayList<>();

        boolean weakOrder = false;
        boolean strongOrder = false;

        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        chooser.setMultiSelectionEnabled(false);

        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int r = chooser.showOpenDialog(null);

        if(r != JFileChooser.APPROVE_OPTION){
            return;
        }

        if (r == JFileChooser.APPROVE_OPTION){
            File f = chooser.getSelectedFile();

            Scanner in;

            try {
                in = new Scanner(f);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            StringBuilder input = new StringBuilder();

            try{
                while(in.hasNextLine()){
                    String line = in.nextLine();
                    if (line == null){
                        break;
                    }

                    list.add(new Polynomial(line));
                }
            } catch (InvalidPolynomialSyntax e) {
                throw new RuntimeException(e);
            }

        }

        for(int i = 0; i < list.size() - 1; i+=2){
            int result = list.get(i).compareTo(list.get(i+1));
            System.out.println(result);
        }



//        String test2 = "9 10 3 4 2 3";
//        String test3 = "10 2 3 4 2 0";
//
//        //ArrayList
//        ArrayList<Polynomial> pList = new ArrayList<>();
//
//        Polynomial o = new Polynomial("10 4 3 4 3 0");
//        Polynomial p = new Polynomial("10 2 3 4 3 0");
//        Polynomial e = new Polynomial(" ");
//
//        pList.add(p);
//        pList.add(e);
//        pList.add(o);
//
//
//
//////
////        Polynomial.StringIterator iterator = (Polynomial.StringIterator) o.iterator();
//////
//////
////        while (iterator.hasNext()) {
////            Polynomial.LL.Node node = iterator.next();
////            System.out.println(node);
////        }
//
////        int result = o.compareTo(p);
//
//        OrederedList oList = new OrederedList(pList);
//
//        int result = oList.checkSorted(pList);
//        System.out.println(result);
//
////        System.out.println(result);

    }



}