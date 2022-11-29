import javax.swing.*;
import java.math.BigInteger;

public class Exponentes {

    public static void main(String[] args) {

        BigInteger comparacion = new BigInteger("-1");
        int opcion= -1;
        while(opcion != 0){

            String mensaje = JOptionPane.showInputDialog("MENÚ" + "\n" +
                   "1.Ingresar datos"  + "\n" +
                    "0.Salir.");

            try {
                opcion = Integer.parseInt(mensaje);

                BigInteger resultado;
                switch (opcion) {
                    case 1:

                        BigInteger valor = new BigInteger(JOptionPane.showInputDialog("Ingrese el valor del número a elevar"));
                        BigInteger exponente = null;
                        BigInteger modulo = null;
                        if (valor.compareTo(comparacion) > 0) {
                            exponente = new BigInteger(JOptionPane.showInputDialog("Ingrese el valor del exponente"));
                            if (exponente.compareTo(comparacion) > 0) {
                                modulo = new BigInteger(JOptionPane.showInputDialog("Ingrese el valor del módulo"));
                                while (modulo.compareTo(comparacion) < 0) {
                                    modulo = new BigInteger(JOptionPane.showInputDialog("Ingrese un valor positivo para el módulo."));
                                }
                            }
                        } else {
                            mostrarInformacionError("ERROR");
                        }

                        resultado = valor.modPow(exponente, modulo);
                        mostrarMensaje("El resultado es: " + resultado + ".");

                        break;
                    case 0:
                        mostrarMensaje("Vuelva pronto");
                        break;

                    default:
                        mostrarInformacionError("ERROR, ingrese una opción válida (números positivos, sin letras, sin caracteres especiales).");
                        break;
                }
            }catch (Exception e) {
                mostrarInformacionError("ERROR, ingrese una opción válida (números positivos, sin letras, sin caracteres especiales).");
            }

            }

        }

    public static void mostrarMensaje(String mensaje ) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void mostrarInformacionError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error" , JOptionPane.ERROR_MESSAGE);

    }

}
