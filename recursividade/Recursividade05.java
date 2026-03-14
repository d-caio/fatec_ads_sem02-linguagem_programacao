/*
OBJETIVO:  Serie5 = (N)! + (N-1)! + (N-2)! + ... + (1)!
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

package recursividade;

import javax.swing.JOptionPane;

public class Recursividade05 {
    public static void main(String[] args) {
        int n, resultado;

        try {
            String entradaN = JOptionPane.showInputDialog("Valor de N: ");

            if (entradaN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                return;
            }

            n = Integer.parseInt(entradaN);

            resultado = serie05(n);

            JOptionPane.showMessageDialog(null, "N = " + n + "\n\n(N)! + (N-1)! + (N-2)! + ... + (1)! = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "N precisa ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    private static int serie05(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N deve ser maior que zero.");

        if (n == 1)
            return fatorial(n);

        return serie05(n - 1) + fatorial(n);
    }

    private static int fatorial(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N deve ser maior que zero.");

        if (n == 1)
            return n;

        return n * fatorial(n - 1);
    }
}
