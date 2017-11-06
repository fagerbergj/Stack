package edu.wit.comp2000.jasonfagerberg.application2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Calculator
	{
		private static String input = "";
		private String output = "";
		private VectorStack stack = new VectorStack();

		/**
		 * Constructor
		 *
		 * probably where the gui will go to initlize input string
		 */

		public Calculator()
			{
				// probably where the gui will go to initlize input string
				// Placeholder until gui is done
				ArrayList<String> arrayInputs = new ArrayList<String>();
				String inputString = "";
				try
					{
						File scannedFile = new File(
								"/Users/fagerbergj1/Dropbox/workspace/Lab04/src/edu/wit/comp2000/jasonfagerberg/application2/Infix Calculator Expressions - valid -- 2016-10-04 01.txt");
						if (scannedFile.canRead())
							{
								System.out.println("file read");
							}
						else
							System.out.println("no file found");
						Scanner input = new Scanner(scannedFile);
						while (input.hasNextLine())
							{
								String line = input.nextLine();
								inputString += line + " ";
							}
					}
				catch (FileNotFoundException e)
					{

						e.printStackTrace();
					}

				input = inputString;
			}

		/**
		 * ABBY'S PART
		 * 
		 * takes input String expression and converts it to postfix char array
		 * 
		 * @return char[] of expression in postfix
		 */

		private char[] convertToPostfix()
			{
				for (int j = 0; j < input.length(); j++)
					{
						char ch = input.charAt(j);
						switch (ch)
							{
							// calls based on precedence
							case '+':
							case '-':
								gotOper(ch, 1);
								break;
							case '*':
							case '/':
								gotOper(ch, 2);
								break;
							case '(':
								stack.push(ch);
								break;
							case ')':
								gotParen();
								break;
							default:
								output = output + ch;
								break;
							}
					}
				while (!stack.isEmpty())
					{
						output = output + stack.pop();
					}
				System.out.println("The Postfix Expression is:      " + output);
				return output.toCharArray();
			}

		/**
		 * Get the order of the operands to be done
		 * 
		 * @param opThis
		 *            current operand
		 * @param prec1
		 *            precedence of current operand
		 */
		public void gotOper(char opThis, int prec1)
			{
				while (!stack.isEmpty())
					{
						char opTop = (char) stack.pop();
						if (opTop == '(')
							{
								stack.push(opTop);
								break;
							}
						else
							{
								int prec2;
								if (opTop == '+' || opTop == '-')
									prec2 = 1;
								else
									prec2 = 2;
								if (prec2 < prec1)
									{
										stack.push(opTop);
										break;
									}
								else
									output = output + opTop;
							}
					}
				stack.push(opThis);
			}

		/**
		 * get the starting paren
		 * 
		 * called when a closing paren is seen
		 */
		public void gotParen()
			{
				while (!stack.isEmpty())
					{
						char chx = (char) stack.pop();
						if (chx == '(')
							break;
						else
							output = output + chx;
					}
			}

		/**
		 * For internal use only Simple 2 number operation
		 * 
		 * @param num1
		 *            first num in each operation
		 * @param num2
		 *            second num in each operation
		 * @param operator
		 *            operation to be performed
		 * @return result
		 */
		private int calc(int num1, int num2, char operator)
			{
				switch (operator)
					{
					case '+':
						return num1 + num2;
					case '-':
						return num1 - num2;
					case '/':
						if(num2 == 0)
							{
								System.out.println("               DEVIDE BY ZERO PLEASE ENTER VALID EXPRESSION");
								return 0;
							}
						return num1 / num2;
					case '*':
						return num1 * num2;
					}
				return 0;
			}

		/**
		 * Takes postfix operation in the form of char Array
		 * 
		 * Performs all simple operations using stack
		 * 
		 * @param inputArr
		 * @return Answer
		 */
		public int giveAnswer()
			{
				stack.clear();
				output = "";
				int num1;
				int num2;
				// Call to get input array
				System.out.println("The Passed Expression is:    " + input);
				char[] inputArr = convertToPostfix();
				for (int i = 0; i < inputArr.length; i++)
					{
						Character[] numbers = new Character[inputArr.length];
						// if numaric
						if (inputArr[i] >= '0' && inputArr[i] <= '9')
							{
								numbers[i] = new Character(inputArr[i]);
								stack.push(numbers[i].getNumericValue(numbers[i].charValue()));
							}
						else // do operation
							{
								num2 = (int) stack.pop();
								num1 = (int) stack.pop();
								stack.push(calc(num1, num2, inputArr[i]));
							}
					}
				return (int) stack.pop();
			}
		public void setInput(String input)
		{
			this.input = input;
		}

		public static void main(String[] args)
			{
				Calculator calculator = new Calculator();
				String[] inputs = null;
				try
					{
						inputs = input.split("\\s+");
					}
				catch (PatternSyntaxException ex)
					{

					}
				// pressing equals on gui should print this
				for(int i = 0; i < inputs.length; i++)
					{
						input = inputs[i];
								System.out.println("The Answer is:     " + calculator.giveAnswer());
					}
			}
	}
