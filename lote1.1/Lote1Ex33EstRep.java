/*
OBJETIVO: Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

import javax.swing.JOptionPane;

public class Lote1Ex33EstRep {
    static final double DIVIDENDO = 1;
    static final double DIVISOR_MIN = 2;
    public static void main(String[] args) {
        int n;
        double divisor, resultado;

        try {
            String entradaN = JOptionPane.showInputDialog("Informe o número (mínimo 2): ");

            if (entradaN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);

                return;
            }

            n = Integer.parseInt(entradaN);

            if (n < DIVISOR_MIN) throw new IllegalArgumentException("O número precisa ser no mínimo 2.");

            divisor = DIVISOR_MIN;
            resultado = DIVIDENDO;

            StringBuilder msg = new StringBuilder(String.format("%.0f", resultado));
            
            while (divisor <= n) {
                resultado += (DIVIDENDO / divisor);
                
                msg.append(" + " + String.format("%.0f", DIVIDENDO) + "/" + String.format("%.0f", divisor));
                
                divisor++;
            }

            msg.append(" = " + String.format("%.2f", resultado));

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O valor precisa ser um número inteiro maior ou igual a 2", "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
