package example;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import tw.commands.GuessInputCommand;

class LibraryTest {

	@Test
	void should_return_a_not_null_set_when_get_answer() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		//when
		Set<Integer> answer = guessInputCommand.getAnswer();
		//then
		assertNotNull(answer);
	}
	
	@Test
	void should_return_a_not_null_string_array_when_get_answer() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "1 2 3 4";
		//when
		String[] stringArray = guessInputCommand.stringToArray(input);
		//then
		assertNotNull(stringArray);
	}

	@Test
	void should_return_a_string_array_equal_1_2_3_4_when_get_answer_given_input_1234() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "1 2 3 4";
		//when
		String[] stringArray = guessInputCommand.stringToArray(input);
		//then
		assertEquals("1", stringArray[0]);
		assertEquals("2", stringArray[1]);
		assertEquals("3", stringArray[2]);
		assertEquals("4", stringArray[3]);
	}
	
	@Test
	void should_return_not_null_int_array_when_string_to_int_array_given_string_array_1234() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String[] stringAnswer = {"1", "2" ,"3","4"};
		//when
		int[] intArray = guessInputCommand.StringToInt(stringAnswer);
		//then
		assertNotNull(intArray);
	}

	@Test
	void should_return_a_int_array_equal_1_2_3_4_when_get_answer_given_string_array_1234() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String[] stringAnswer = {"1", "2" ,"3","4"};
		//when
		int[] intArray = guessInputCommand.StringToInt(stringAnswer);
		//then
		assertEquals(1, intArray[0]);
		assertEquals(2, intArray[1]);
		assertEquals(3, intArray[2]);
		assertEquals(4, intArray[3]);
	}
	
	@Test
	void should_return_true_when_judge_is_exsit_given_int_number_1_and_set_1234() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int number = 1;
		Set<Integer> array = new HashSet<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		//when
		boolean isExsit = guessInputCommand.judgeIsExsit(array, number);
		//then
		assertEquals(true, isExsit);
	}
	
	@Test
	void should_return_false_when_judge_is_exsit_given_int_number_5_and_set_1234() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int number = 5;
		Set<Integer> array = new HashSet<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		//when
		boolean isExsit = guessInputCommand.judgeIsExsit(array, number);
		//then
		assertEquals(false, isExsit);
	}
	
	@Test
	void should_return_true_when_judge_is_in_index_given_int_number_1_and_set_1234_and_index_0() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int number = 1;
		Set<Integer> array = new HashSet<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		//when
		boolean indexFlag = guessInputCommand.isInIndex(array, number,0);
		//then
		assertEquals(true, indexFlag);
	}
	
	@Test
	void should_return_false_when_judge_is_in_index_given_int_number_1_and_set_1234_and_index_1() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int number = 1;
		Set<Integer> array = new HashSet<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		//when
		boolean indexFlag = guessInputCommand.isInIndex(array, number,1);
		//then
		assertEquals(false, indexFlag);
	}
	
	
	@Test
	void should_return_count_array_44_when_count_answer_given_input_answer_1234_and_set_1234_and_index_1() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] inputAnswer = {1,2,3,4};
		Set<Integer> array = new HashSet<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		//when
		int[] countArray = guessInputCommand.countAnswer(array, inputAnswer);
		//then
		assertEquals(4, countArray[0]);
		assertEquals(4, countArray[1]);
	}
	
	@Test
	void should_return_count_array_42_when_count_answer_given_input_answer_1243_and_set_1234_and_index_1() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] inputAnswer = {1,2,4,3};
		Set<Integer> array = new HashSet<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		//when
		int[] countArray = guessInputCommand.countAnswer(array, inputAnswer);
		//then
		assertEquals(4, countArray[0]);
		assertEquals(2, countArray[1]);
	}
	
	@Test
	void should_return_true_when_judge_answer_given_count_answer_44() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] countAnswer = {4,4};
		//when
		boolean isRight = guessInputCommand.judgeAnswer(countAnswer);
		//then
		assertEquals(true, isRight);
	}
	
	@Test
	void should_return_false_when_judge_answer_given_count_answer_43() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] countAnswer = {4,3};
		//when
		boolean isRight = guessInputCommand.judgeAnswer(countAnswer);
		//then
		assertEquals(false, isRight);
	}
	
	@Test
	void should_return_4A3B_when_print_answer_given_count_answer_43() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] countAnswer = {4,3};
		//when
		String answer = guessInputCommand.printAnswer(countAnswer);
		//then
		assertEquals("4A3B", answer);
	}
	
	@Test
	void should_return_true_when_judge_count_given_input_answer_4321() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] inputAnswer = {4,3,2,1};
		//when
		boolean isRight = guessInputCommand.judgeCount(inputAnswer);
		//then
		assertEquals(true, isRight);
	}
	
	@Test
	void should_return_false_when_judge_count_given_input_answer_431() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		int[] inputAnswer = {4,3,1};
		//when
		boolean isRight = guessInputCommand.judgeCount(inputAnswer);
		//then
		assertEquals(false, isRight);
	}
}
