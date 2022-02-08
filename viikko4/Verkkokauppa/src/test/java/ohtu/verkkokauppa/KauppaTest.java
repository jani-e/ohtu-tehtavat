/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Jani
 */
public class KauppaTest {
    
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa kauppa;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
    }
    
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
        //Pankki pankki = mock(Pankki.class);
        //Viitegeneraattori viite = mock(Viitegeneraattori.class);
        
        when(viite.uusi()).thenReturn(42);
        
        //Varasto varasto = mock(Varasto.class);
        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        //Kauppa k = new Kauppa(varasto, pankki, viite);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }
    
    @Test
    public void tilisiirtoaKutsutaanOikeillaTiedoilla() {
        when(viite.uusi()).thenReturn(555);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("jaska", "12345");
        
        verify(pankki).tilisiirto("jaska", 555, "12345", "33333-44455", 5);
    }
    
    @Test
    public void tilisiirtoOikeinKahdellaEriTuotteella() {
        when(viite.uusi()).thenReturn(333);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "murot", 7));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("jaska", "12345");
        
        verify(pankki).tilisiirto("jaska", 333, "12345", "33333-44455", 12);
    }
    
    @Test
    public void tilisiirtoOikeinKahdellaSamallaTuotteella() {
        when(viite.uusi()).thenReturn(222);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("jaska", "12345");
        
        verify(pankki).tilisiirto("jaska", 222, "12345", "33333-44455", 10);
    }
    
    @Test
    public void ostosKahdellaTuotteellaJoistaToistaEiOleVarastossa() {
        when(viite.uusi()).thenReturn(777);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "murot", 7));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2); //ei ole varastossa
        kauppa.tilimaksu("jaska", "12345");
        
        verify(pankki).tilisiirto("jaska", 777, "12345", "33333-44455", 5);
    }
    
}
