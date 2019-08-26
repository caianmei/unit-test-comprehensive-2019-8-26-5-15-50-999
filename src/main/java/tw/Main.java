package tw;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    private static final int RUN_TIMES = 6;
    
    public static void main(String[] args) throws Exception {
    	GuessInputCommand guessInputCommand = new GuessInputCommand();
    	Set<Integer> answer = guessInputCommand.getAnswer();
    	for (Integer integer : answer) {
			System.out.print(integer + "  ");
		}
    	System.out.println();
        for (int i = 0; i < RUN_TIMES; i++) {
            String input = guessInputCommand.input();
            String[] inputStringAnswer = guessInputCommand.stringToArray(input);
            int[] inputAnswer = guessInputCommand.StringToInt(inputStringAnswer);         
            int[] countArray = guessInputCommand.countAnswer(answer, inputAnswer);
            guessInputCommand.setAnswerString(guessInputCommand.printAnswer(countArray));
            System.out.println(guessInputCommand.getAnswerString());
            if (guessInputCommand.judgeAnswer(countArray)) {
            	guessInputCommand.setHeight("you win");
        	    System.out.println(guessInputCommand.getHeight());
        	    break;
		      } 
        }
    }
}
