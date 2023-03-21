import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
            List<Signal> res = new ArrayList<Signal>();
            Boolean normalOrder = true;
            if(number >= 16){
                int division = number/16;
                normalOrder = division % 2 == 0;
                number -= 16 * division;
            }
                while(number > 0){
                    if(number >= 8){
                        number -= 8;
                        res.add(Signal.JUMP);
                    }else if (number < 8 && number >= 4){
                        number -= 4;
                        res.add(Signal.CLOSE_YOUR_EYES);
                    }else if(number < 4 && number >=2){
                        number -= 2;
                        res.add(Signal.DOUBLE_BLINK); 
                    }else{
                        number -= 1;
                        res.add(Signal.WINK);
                    }
                }
            
            if(normalOrder){
                Collections.reverse(res);
            }
            
            return res;
    }

}
