package exer02;

/**
 * Classe Principal que contém o método main
 */
public class Principal {

    /**
     * Método que é chamado pelo sistema operacional
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {

        Tempo t = new Tempo(1,0,0);
        Tempo a = new Tempo(1,1,0);

        System.out.println(t.diferenca(a));
    }
}