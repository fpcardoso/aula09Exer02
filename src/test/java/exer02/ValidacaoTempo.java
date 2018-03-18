package exer02;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class ValidacaoTempo {

    @Test
    public void testTempo(){
        //Inicializando com valores definido
        Tempo t1 = new Tempo(7,0,30);

        //valores válidos
        assertEquals("07:00:30",t1.toString());
        assertTrue(t1.alterarMinuto(25));
        assertEquals("15:00:00",new Tempo(15).toString());
        assertTrue(t1.alterarTempo(0,1,15));
        assertEquals(75,t1.totalSegundos());

        Tempo t2 = new Tempo(0,0,45);
        Tempo t3 = new Tempo(1);

        assertEquals(3555,t2.diferenca(t3));

        //valores inválidos
        assertFalse(t3.alterarSegundo(65));
        assertFalse(t3.alterarTempo(-5,15,30));
        assertEquals("00:00:00",new Tempo(12,-35,25).toString());
        assertEquals("00:00:00",new Tempo(-25).toString());
    }
}
