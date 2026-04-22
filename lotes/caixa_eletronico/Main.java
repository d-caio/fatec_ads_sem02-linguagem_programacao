package lotes.caixa_eletronico;

import java.math.BigDecimal;

import lotes.caixa_eletronico.telas.*;
import lotes.caixa_eletronico.caixa.Caixa;
import lotes.caixa_eletronico.exceptions.*;

public class Main {
    private static final int MAXIMO_DE_TENTATIVAS = 5;
    private static int tentativas = 0;

    public static void main(String[] args) {
        try {
            var caixa = new Caixa(
                "Banco do Brasil",
                "Caixa Econômica Federal",
                "Bradesco",
                "Itaú"
            );

            var menuPrincipal = new Menu(
                "Menu Principal",
                "Carregar notas",
                "Sacar",
                "Estatísticas",
                "Fim"
            );

            int opcaoDoMenuPrincipal;

            while (true) {
                opcaoDoMenuPrincipal = menuPrincipal.selecionarOpcao();

                if (opcaoDoMenuPrincipal == 0) {
                    var telaDeFim = new TelaDeVisualizacao(
                        "Fim",
                        "Obrigado!"
                    );

                    telaDeFim.mostrar();

                    return;
                } else if (opcaoDoMenuPrincipal == 1) {
                    caixa.carregarNotas();

                    String relatorioDeValoresDisponiveis = caixa.relatorioDeValoresDisponiveis();

                    var telaDeNotasCarregadas = new TelaDeVisualizacao(
                        "Notas Carregadas",
                        relatorioDeValoresDisponiveis
                    );

                    telaDeNotasCarregadas.mostrar();

                } else if (opcaoDoMenuPrincipal == 2) {
                    try {
                        String[] bancos = caixa.iniciarSaque();

                        tentativas = 0;

                        var menuDeBancos = new Menu(
                            "Bancos Disponíveis",
                            bancos
                        );

                        int opcaoDoMenuDeBancos = menuDeBancos.selecionarOpcao();

                        if (opcaoDoMenuDeBancos == 0)
                            continue;

                        String relatorioDeValoresDisponiveis = caixa.relatorioDeValoresDisponiveis();
                        
                        var telaDeEntradaDeValorDoSaque = new TelaDeEntrada(
                            "Saque",
                            relatorioDeValoresDisponiveis + "\n\nInforme o valor desejado"
                        );

                        BigDecimal valorDoSaque;
                        
                        while (true) {
                            try {
                                valorDoSaque = telaDeEntradaDeValorDoSaque.solicitarEntrada();

                                caixa.sacar(valorDoSaque, opcaoDoMenuDeBancos);

                                tentativas = 0;

                                break;
                                
                            } catch (NumberFormatException e) {
                                tratarExcecoesInternas("O valor deve ser monetário e inteiro, sem separação por centavos.");

                            } catch (ValorDeSaqueInvalidoException e) {
                                tratarExcecoesInternas(e.getMessage());

                            } catch (IllegalArgumentException e) {
                                tratarExcecoesInternas(e.getMessage());
                            }
                        }

                        String relatorioDeSaque = caixa.relatorioDeSaque();

                        var telaDeSaque = new TelaDeVisualizacao(
                            "Saque Realizado com Sucesso",
                            relatorioDeSaque
                        );

                        telaDeSaque.mostrar();
                        
                    } catch (CaixaNaoCarregadoException e) {
                        tratarExcecoesInternas(e.getMessage());

                    } catch (LimiteDeSaquesAlcancadoException e) {
                        tratarExcecoesInternas(e.getMessage());
                        
                    } catch (ValorDeSaqueInvalidoException e) {
                        tratarExcecoesInternas(e.getMessage());
                        
                    }
                } else {
                    String estatisticas = caixa.estatisticasCompletas();

                    var telaDeEstatisticas = new TelaDeVisualizacao(
                        "Estatísticas",
                        estatisticas
                    );

                    telaDeEstatisticas.mostrar();
                }

            }
            
        } catch (JanelaFechadaException e) {
            TelaDeException.programaEncerradoPeloUsuario();

        } catch (TentativasExcedidasException e) {
            TelaDeException.telaDeErro(tentativas, MAXIMO_DE_TENTATIVAS, e.getMessage());
        }
    }

    private static void tratarExcecoesInternas(String texto) {
        tentativas++;

        if (tentativas == MAXIMO_DE_TENTATIVAS)
            throw new TentativasExcedidasException();

        TelaDeException.telaDeErro(
            tentativas,
            MAXIMO_DE_TENTATIVAS,
            texto
        );
    }
}
