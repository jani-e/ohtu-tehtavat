
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito implements KirjanpitoIO {
    
    private KirjanpitoIO kirjanpitoIO;
    private ArrayList<String> tapahtumat;

    @Autowired
    public Kirjanpito(@Lazy KirjanpitoIO kirjanpitoIO) {
        this.kirjanpitoIO = kirjanpitoIO;
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
