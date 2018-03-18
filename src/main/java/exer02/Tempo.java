package exer02;

import java.util.Calendar;

/**
 * Classe que representa o tempo em horas,minutos e segundos.
 */
public class Tempo {

    //ATRIBUTOS

    private int hora;
    private int minuto;
    private int segundo;

    //MÉTODOS CONSTRUTORES

    /**
     * Método construtor padrão que inicializa os atributos com valor definido.
     * hora = 0;minuto = 0;segundo = 0;
     */
    public Tempo(){
        hora = 0;
        minuto = 0;
        segundo = 0;
    }

    /**
     * Método construtor que inicializa os atributos com valores passados como parâmetros.
     * Caso algum dos valores seja inválido o construtor inicializa os atributos com zeros.
     * @param h hora a ser inicializada.
     * @param m minuto a ser inicializado.
     * @param s segundo a ser incializado.
     */
    public Tempo(int h,int m,int s){
        if(!alterarTempo(h,m,s)){
            hora = 0;
            minuto = 0;
            segundo = 0;
        }
    }

    /**
     * Método construtor que inicializa somente o atributo hora com valor passado como parâmetro.
     * Os demais atributos são inicializados com zeros.
     * Caso o valor seja inválido para hora, essa também é inicializada com zero.
     * @param h hora a ser inicializada.
     */
    public Tempo(int h){
        if(!alterarHora(h)){
            hora = 0;
        }
        minuto = 0;
        segundo = 0;
    }

    /**
     * Método construtor que incializa os atributos com valores de tempo do sistema.
     * @param horaAtual uma variavel booleana, se for passada como true, inicializa com valores do sistema.
     */
    public Tempo(boolean horaAtual){
        if(horaAtual){
            Calendar tempo = Calendar.getInstance();
            hora = tempo.get(Calendar.HOUR_OF_DAY);
            minuto = tempo.get(Calendar.MINUTE);
            segundo = tempo.get(Calendar.SECOND);
        }
    }
    //MÉTODOS

    /**
     * Método que formata o Tempo em (hora:minuto:segundo). ex.:(00:00:00)
     * @return retorna uma string com o tempo formatado.
     */
    public String toString() {
        String formatado = "";
        formatado += (hora < 10) ? "0" + hora : hora;
        formatado += (minuto < 10) ? ":0" + minuto : ":" + minuto;
        formatado += (segundo < 10) ? ":0" + segundo : ":" + segundo;

        return formatado;
    }

    /**
     * Método para alterar somente a hora para valor passado como parâmetro.
     * @param h novo valor de hora a ser alterado.
     * @return retorna um booleano (true para hora válida e false para inválida)
     */
    public boolean alterarHora(int h){
        if(h >= 0 && h <= 23){
            hora = h;
            return true;
        }
        return false;
    }

    /**
     * Método para alterar somente o minuto para valor passado como parâmetro.
     * @param m novo valor do minuto a ser alterado.
     * @return retorna um booleano (true para minuto válido e false para inválido)
     */
    public boolean alterarMinuto(int m){
        if(m >= 0 && m <= 59){
            minuto = m;
            return true;
        }
        return false;
    }

    /**
     * Método para alterar somente o segundo para valor passado como parâmetro.
     * @param s novo valor do segubdo a ser alterado.
     * @return retorna um booleano (true para segundo válido e false para inválido)
     */
    public boolean alterarSegundo(int s){
        if(s >= 0 && s <= 59){
            segundo = s;
            return true;
        }
        return false;
    }

    /**
     * Método para alterar todos os valores dos atributos(hora, minuto e segundo) de uma só vez.
     * @param h novo valor para hora a ser alterado
     * @param m novo valor para minuto a ser alterado
     * @param s novo valor para segundo a ser alterado
     * @return retorna um booleano (true se todos os valores foram alterados com sucesso e false caso contrário).
     */
    public boolean alterarTempo(int h,int m,int s){
        if(alterarHora(h)){
            if(alterarMinuto(m)){
                if(alterarSegundo(s)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método que calcula o total de segundos do objeto.
     * @return retorna um long com os segundos.
     */
    public long totalSegundos(){
        return hora*3600 + minuto*60 + segundo;
    }

    /**
     * Métodos que calcula a diferença entre o objeto passado como parâmetro e o objeto em questão.
     * @param t Tempo (objeto)
     * @return retorna um long com a diferença em segundos.
     */
    public long diferenca(Tempo t){
        return t.totalSegundos() - totalSegundos();
    }
}