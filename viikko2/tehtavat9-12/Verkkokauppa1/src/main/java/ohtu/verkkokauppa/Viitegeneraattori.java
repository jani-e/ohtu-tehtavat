package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements ViitegeneraattoriIO {
    
    private ViitegeneraattoriIO viitegeneraattori;
    private int seuraava;
    
    @Autowired
    public Viitegeneraattori(@Lazy ViitegeneraattoriIO viitegeneraattoriIO){
        this.viitegeneraattori = viitegeneraattoriIO;
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
