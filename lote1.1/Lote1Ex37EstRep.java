/*
OBJETIVO: Receba um número inteiro. Calcule e mostre a série de Fibonacci até o seu N’nésimo termo.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 05/03/2026
*/

import javax.swing.JOptionPane;

public class Lote1Ex37EstRep {
    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        int n, anterior, atual, temp, tries = 0;

        while (true) {
            try {
                if (tries == MAX_TRIES) {
                    JOptionPane.showMessageDialog(null, "Máximo de tentativas atingido. O programa será encerrado.",
                            "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

                    return;
                }

                String entradaN = JOptionPane.showInputDialog("Forneça um número maior que 0: ");

                if (entradaN == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim",
                            JOptionPane.WARNING_MESSAGE);

                    return;
                }

                n = Integer.parseInt(entradaN);

                if (n < 1)
                    throw new IllegalArgumentException("O número precisa ser maior que 0.");

                StringBuilder msgResultado = new StringBuilder("");

                if (n == 1)
                    msgResultado.append("1");

                else if (n == 2)
                    msgResultado.append("1, 1");

                else {
                    msgResultado.append("1, 1");

                    anterior = 1;
                    atual = 1;

                    for (int i = 3; i <= n; i++) {
                        temp = atual;
                        atual = temp + anterior;
                        anterior = temp;

                        msgResultado.append(", ").append(atual);
                    }
                }

                JOptionPane.showMessageDialog(null, msgResultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

                return;

            } catch (NumberFormatException e) {
                tries++;

                if (tries < MAX_TRIES)
                    JOptionPane.showMessageDialog(null, "O valor precisa ser um número inteiro.",
                    "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.INFORMATION_MESSAGE);

            } catch (IllegalArgumentException e) {
                tries++;

                if (tries < MAX_TRIES)
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }
}
