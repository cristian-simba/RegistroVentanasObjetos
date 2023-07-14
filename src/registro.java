import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class registro {
    private JPanel registro;
    private JLabel labelPais;
    private JTextField pais;
    private JLabel capitalLabel;
    private JTextField capital;
    private JLabel poblacionLabel;
    private JTextField poblacion;
    private JLabel dineroLabel;
    private JTextField dinero;
    private JButton registrateBt;
    private JButton atrBt;
    private JButton sigBt;
    private ArrayList<Datos> listaDatos;
    int indiceActual;

    public registro() {
        listaDatos = new ArrayList<>();
        registrateBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paisIngreso = pais.getText();
                String capitalIngreso = capital.getText();
                int poblacionIngreso = Integer.parseInt(poblacion.getText());
                double dineroIngreso = Double.parseDouble(dinero.getText());

                Datos ingreso = new Datos(paisIngreso, capitalIngreso, poblacionIngreso, dineroIngreso);
                listaDatos.add(ingreso);

                String filePath = "datos.txt";
                try(
                    FileOutputStream fileOut = new FileOutputStream(filePath);
                    ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                ){
                    objOut.writeObject(ingreso);
                    System.out.println("Archivo guardado correctamente");
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }
                pais.setText("");
                capital.setText("");
                poblacion.setText("");
                dinero.setText("");
            }
        });
        sigBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual < listaDatos.size() - 1) {
                    indiceActual++;
                    Datos datos = listaDatos.get(indiceActual);
                    System.out.println(datos);
                    pais.setText(datos.getPais());
                    capital.setText(datos.getCapital());
                    poblacion.setText(String.valueOf(datos.getPoblacion()));
                    dinero.setText(String.valueOf(datos.getDinero()));
                }
            }
        });
        atrBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual > 0) {
                    indiceActual--;
                    Datos datos = listaDatos.get(indiceActual);
                    System.out.println(datos);
                    pais.setText(datos.getPais());
                    capital.setText(datos.getCapital());
                    poblacion.setText(String.valueOf(datos.getPoblacion()));
                    dinero.setText(String.valueOf(datos.getDinero()));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("registro");
        frame.setContentPane(new registro().registro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

