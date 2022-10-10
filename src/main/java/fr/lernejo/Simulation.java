package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long userNumberInput = player.askNextGuess();
        logger.log(Long.toString(userNumberInput));

        if (userNumberInput == numberToGuess){
            return true;
        }else{
            player.respond(userNumberInput > this.numberToGuess);
            return false;
        }

    }

    public void loopUntilPlayerSucceed(long loopNumber) {
        int i = 0;
        boolean success = nextRound();
        long startTime = System.currentTimeMillis();
        //TODO implement me
        while (success != true && i < loopNumber){
            i++;
            success = nextRound();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        SimpleDateFormat simpleDate = new SimpleDateFormat("mm:ss.SSS");
        Date date = new Date(totalTime);
        String time = simpleDate.format(date);

        if (success == true && i < loopNumber){
            //System.out.println("Bravo vous avez trouve le nombre avant la limite d'iterations en " + time + "ms");
            logger.log("Bravo vous avez trouve le nombre avant la limite d'iterations en " + time + "ms");
            logger.log("fin");
        } else if(success == true && i == loopNumber){
            //System.out.println("Bravo vous avez trouve le nombre avant la limite d'iterations en " + time + "ms");
            logger.log("Bravo vous avez trouve le nombre avant la limite d'iterations en " + time + "ms");
            logger.log("fin");
        } else {
            //System.out.println("Desole mais vous n'avez pas trouve le nombre");
            logger.log("Desole mais vous n'avez pas trouve le nombre");
            logger.log("fin");
        }
    }
}
