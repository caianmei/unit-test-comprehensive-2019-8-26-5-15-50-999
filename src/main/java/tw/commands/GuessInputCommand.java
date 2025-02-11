package tw.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GuessInputCommand {

	private BufferedReader bufferedReader;
	private String height;
	private String answerString;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getAnswerString() {
		return answerString;
	}

	public void setAnswerString(String answerString) {
		this.answerString = answerString;
	}

	public GuessInputCommand() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public Set<Integer> getAnswer() {
		Set<Integer> set = new HashSet<>();
		while (set.size() < 4) {
			set.add(new Random().nextInt(9));
		}
		return set;
	}

	public String input() throws IOException {
		System.out.println("------Please input your answer as x x x x , x <10 ------");
		return bufferedReader.readLine();
	}

	public String[] stringToArray(String input) {
		return input.split(" ");
	}

	public int[] StringToInt(String[] inputStringAnswer) {
		int[] inputAnswer = new int[inputStringAnswer.length];
		for (int i = 0; i < inputStringAnswer.length; i++) {
			inputAnswer[i] = Integer.valueOf(inputStringAnswer[i].trim());
		}
		return inputAnswer;
	}

	public boolean judgeCount(int[] inputAnswer) {
		Set<Integer> countSet = new HashSet<>();
		for (int number : inputAnswer) {
			countSet.add(number);
		}
		return countSet.size() == 4 ? true : false;
	}

	public boolean judgeIsExsit(Set<Integer> answer, int inputAnswerNumber) {
		boolean flag = false;
		for (Integer number : answer) {
			if (number == inputAnswerNumber) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean isInIndex(Set<Integer> answer, int inputAnswerNumber, int inputAnswerIndex) {
		boolean flag = false;
		int which = 0;
		for (Integer number : answer) {
			if (number == inputAnswerNumber) {
				if (which == inputAnswerIndex) {
					flag = true;
				}
				break;
			}
			which++;
		}
		return flag;
	}

	public int[] countAnswer(Set<Integer> answer, int[] inputAnswer) {
		int[] rightArray = { 0, 0 };
		int index = 0;
		for (int number : inputAnswer) {
			if (!judgeIsExsit(answer, number)) {
				continue;
			}
			rightArray[0] += 1;
			if (isInIndex(answer, number, index)) {
				rightArray[1] += 1;
			}
			index++;
		}
		return rightArray;

	}

	public boolean judgeAnswer(int[] countArray) {
		return countArray[0] == 4 && countArray[1] == 4 ? true : false;
	}

	public String printAnswer(int[] countArray) {
		return countArray[0] + "A" + countArray[1] + "B";
	}
}
