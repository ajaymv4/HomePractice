import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lambdas {

	public static void main(String[] args) {

		List<Employee> empList = initializeList();

		//System.out.println(empList);
		
		
		//Group all the employees belonging to Finance department
		
		Map<Integer, String> groupByDept = empList.stream()
													 .collect(Collectors.groupingBy(Employee::getEmpId,
																	 Collectors.mapping(Employee::getEmpName,Collectors.joining(", "))))
													 
													 ;
		
		
		System.out.println(groupByDept);
		

	}

	public static List<Employee> initializeList() {

		List<Employee> empList = new ArrayList<Employee>();

		for (int i = 1; i < 10; i++) {

			Employee e = new Employee();

			e.setEmpId(i + 1000);
			e.setEmpName("Ajay" + i);
			e.setPlace("Bangalore");
			e.setSalary(i * 500);
			e.setDept(DepartmentSingleton.INSTANCE.getDepartmentId(i));

			empList.add(e);

		}

		return empList;

	}

	private enum DepartmentSingleton {

		INSTANCE;

		Department dept1 = null;

		Department dept2 = null;

		private DepartmentSingleton() {

			dept1 = new Department(1, "Computer");
			dept2 = new Department(2, "Finance");
		}

		public Department getDepartmentId(int i) {

			if (i % 2 == 0) {

				return dept1;
			} else {
				return dept2;
			}

		}

	}

}
