package id208133280_id207496068;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import comperators.QuestionComparator;

public class Test implements Cloneable {
	protected ArrayList<Question> allTestQuestions;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Test() {
		allTestQuestions = new ArrayList<Question>();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String printAll() {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; (i < allTestQuestions.size()) && (allTestQuestions.get(i) != null); i++) {
			sb.append("Question " + (i + 1) + ":\n");
			sb.append("------------\n");
			sb.append(allTestQuestions.get(i).toString());
			sb.append("\n");
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addTestQuestion(Question q) {
		if (q instanceof AmericanQuestion) {
			allTestQuestions.add(q);
		} else {
			allTestQuestions.add(q);
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sortTest() {
		Collections.sort(allTestQuestions,new QuestionComparator());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public void saveToTxt(PrintWriter pw) {
		pw.println("Saved test: ");
		pw.println();
		for (int i = 0; (i < allTestQuestions.size()) && (allTestQuestions.get(i) != null); i++) {
			pw.println("Question " + (i + 1) + ":");
			pw.println("------------");
			pw.println(allTestQuestions.get(i).toString());

		}
		pw.println();
	}
	public void saveTestInTxt() {
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			File testFile = new File("Exam_" + date);
			PrintWriter pw;
			try {
				pw = new PrintWriter(testFile);
				this.saveToTxt(pw);
				pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
			}
	}


