package sorting;

import java.util.Comparator;

import com.ty.Student;

public class SortStudentById implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getId().compareTo(y.getId());
	}

}
