package exer02;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class ValidacaoTempo {

    @Test
    public void testTempo(){
        Tempo t1 = new Tempo(7,0,30);

        assertEquals("07:00:30",t1.toString());
        assertTrue(t1.alterarMinuto(25));
        assertEquals("00:00:00",new Tempo(26).toString());
        t1.alterarTempo(0,1,15);
        assertEquals(75,t1.totalSegundos());

        Tempo t2 = new Tempo(1);
        assertEquals(3525,t1.diferenca(t2));
    }
}
