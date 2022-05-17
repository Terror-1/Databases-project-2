import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Random;

public class Schema1 {
	static int noOfInst1=0;
	static int noOfInst2=0;
	static Random  random = new Random();
	static int noOfCourses=0;
	static int i1,i2,i3,i4=0;
	// //////////////////////////////////////////// Table Insertion Methods
	// ///////////////////////////////////////////////////////////////
	public static long insertDepartment(int building, String deptName,
			int budget, Connection conn) {
		String SQL = "INSERT INTO department(dep_name,building,budget) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, building);
			pstmt.setString(1, deptName);
			pstmt.setInt(3, budget);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(2);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	public static long insertInstructor(int ID, String name, int salary,
			String deptName, Connection conn) {
		String SQL = "INSERT INTO instructor(ID,name,salary,dep_name)"
				+ "VALUES(?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(2, name);
			pstmt.setInt(1, ID);
			pstmt.setInt(3, salary);
			pstmt.setString(4, deptName);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	public static long insertClassroom(int building, int roomNo, int capacity,
			Connection conn) {
		String SQL = "INSERT INTO classroom(building,room_number,capacity)"
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, roomNo);
			pstmt.setInt(1, building);
			pstmt.setInt(3, capacity);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	public static long insertTimeSlot(int ID, String day, Time start, Time end,
			Connection conn) {
		String SQL = "INSERT INTO time_slot(id,day,start,end_time)"
				+ "VALUES(?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(2, day);
			pstmt.setInt(1, ID);
			pstmt.setTime(3, start);
			pstmt.setTime(4, end);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	public static long insertStudent(int ID, String name, int credit,
			String deptName, int instID, Connection conn) {
		String SQL = "INSERT INTO student(id,name,tot_credit,department,advisor_id)"
				+ "VALUES(?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(2, name);
			pstmt.setInt(1, ID);
			pstmt.setInt(3, credit);
			pstmt.setString(4, deptName);
			pstmt.setInt(5, instID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE course(course_id INT PRIMARY KEY, title VARCHAR(20), credits
	// INT, department VARCHAR(20) REFERENCES department);
	public static long insertCourse(int ID, String title, int credit,
			String deptName, Connection conn) {
		String SQL = "INSERT INTO course(course_id,title,credits,department)"
				+ "VALUES(?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(2, title);
			pstmt.setInt(1, ID);
			pstmt.setInt(3, credit);
			pstmt.setString(4, deptName);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE pre_requiste(course_id INT, prereq_id INT,PRIMARY
	// KEY(course_id, prereq_id));
	public static long insertPrerequiste(int ID, int preID, Connection conn) {
		String SQL = "INSERT INTO pre_requiste(course_id,prereq_id)"
				+ "VALUES(?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, preID);
			pstmt.setInt(1, ID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE section(section_id INT PRIMARY KEY, semester INT, year INT,
	// instructor_id INT REFERENCES instructor, course_id INT REFERENCES
	// course,classroom_building INT REFERENCES classroom(building),
	// classroom_room_no INT REFERENCES classroom(room_number));

	public static long insertSection(int ID, int semester, int year,
			int instID, int courseID, int classroomBuilding,
			int classroomRoomNo, Connection conn) {
		String SQL = "INSERT INTO section(section_id,semester,year,instructor_id,course_id,classroom_building,classroom_room_no)"
				+ "VALUES(?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, semester);
			pstmt.setInt(1, ID);
			pstmt.setInt(3, year);
			pstmt.setInt(4, instID);
			pstmt.setInt(5, courseID);
			pstmt.setInt(6, classroomBuilding);
			pstmt.setInt(7, classroomRoomNo);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE takes(student_id INT REFERENCES student, section_id INT
	// REFERENCES section, grade real, PRIMARY KEY(student_id, section_id));
	public static long insertTakes(int ID, int secID, double grade,
			Connection conn) {
		String SQL = "INSERT INTO takes(student_id,section_id,grade)"
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, secID);
			pstmt.setInt(1, ID);
			pstmt.setDouble(3, grade);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE section_time(time_slot INT REFERENCES time_slot, section_id
	// INT REFERENCES section, PRIMARY KEY(time_slot, section_id));
	public static long insertSectionTime(int timeSlot, int secID,
			Connection conn) {
		String SQL = "INSERT INTO section_time(time_slot,section_id)"
				+ "VALUES(?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, secID);
			pstmt.setInt(1, timeSlot);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// ///////////////////////////////////////// Data Population Method
	// //////////////////////////////////////////////////////
	public static void populateDepartment(Connection conn) {
		if (insertDepartment(random.nextInt(10)+1, "CSEN", random.nextInt(901)+100, conn) == 0) {
			System.err.println("insertion of record failed");
			}
		for (int i = 1; i < 60; i++) {
			
			if (insertDepartment(i, "CS" + i, i+200, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateInstructor(Connection conn) {
//		for (int i = 1; i < 60; i++) {
//			if (insertInstructor(i, "Name" + i, i, "CS" + i, conn) == 0) {
//				System.err.println("insertion of record " + i + " failed");
//				break;
//			} else
//				System.out.println("insertion was successful");
//		}
		
		 noOfInst1=random.nextInt(26)+10;
		i2=1;
		for(; i2<=noOfInst1 ;i2++) {
			if (insertInstructor(i2, "Name" + i2, i2, "CSEN", conn) == 0) {
				System.err.println("insertion of record " + i2 + " failed");
		}
		}
		for (int j=1;  j < 60; j++) {
			//noOfInst2=random.nextInt(26)+10;

			for(int k=1;k<=noOfInst1;k++,i2++) {
				if (insertInstructor(i2, "Name" + i2, i2, "CS" + j, conn) == 0) {
					System.err.println("insertion of record " + i2 + " failed");
					
					break;
					
				} else
					System.out.println("insertion was successful");
				
			}
		
		}
	}

	public static void populateClassroom(Connection conn) {
		for (int i = 1; i < 10000; i++) {
			if (insertClassroom(i, i, 100 + i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	@SuppressWarnings("deprecation")
	public static void populateTimeSlot(Connection conn) {
		for (int i = 1; i < 10000; i++) {
			if (insertTimeSlot(i, "day" + i, new Time(12, 0, 0), new Time(13,
					0, 0), conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateStudent(Connection conn) {
//		for (int i = 1; i < 10000; i++) {
//			if (insertStudent(i, "name" + i, i, "CS" + i, i, conn) == 0) {
//				System.err.println("insertion of record " + i + " failed");
//				break;
//			} else
//				System.out.println("insertion was successful");
//		}
		
		int r=random.nextInt(2101)+1100;
		i4=1;
		for(; i4<=r ;i4++) {
			
			if (insertStudent(i4, "name" + i4, i4, "CSEN", random.nextInt(noOfInst1-1)+1, conn) == 0) {
				System.err.println("insertion of record " + i4 + " failed");
		}
		}
		for (int j=1;  j < 60; j++) {
			r=random.nextInt(2101)+1100;

			for(int k=1;k<=r;k++,i4++) {
				if (insertStudent(i4, "name" + i4, i4, "CS"+j, random.nextInt(noOfInst1-1)+noOfInst1+1, conn) == 0) {
					System.err.println("insertion of record " + i4 + " failed");
					
					break;
					
				} else
					System.out.println("insertion was successful");
				
			}
		
		}
	}

	public static void populateCourse(Connection conn) {
		
		noOfCourses=random.nextInt(26)+20;
		i1=1;
		for(; i1<= noOfCourses;i1++) {
			if (insertCourse(i1, "COU" + i1, i1, "CSEN", conn) == 0) {
				System.err.println("insertion of record " + i1 + " failed");
		}
		}
		for (int j=1;  j < 60; j++) {
			//r=random.nextInt(26)+20;

			for(int k=1;k<=noOfCourses;k++,i1++) {
				if (insertCourse(i1, "GCOU" + i1, i1, "CS" + j, conn) == 0) {
					System.err.println("insertion of record " + i1 + " failed");
					
					break;
					
				} else
					System.out.println("insertion was successful");
				
			}
		
		}
	}

	public static void populatePrerequiste(Connection conn) {
		for (int i = 1; i <= noOfCourses; i++) {
			if (insertPrerequiste(i, i,	conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateSection(Connection conn) {
		int j = 1;
		
		for ( i3 = 1; i3 <= 500 ; i3++) {
			if (insertSection(i3, 1, 2019, random.nextInt(i2-1)+1, random.nextInt(i1-1)+1, j, j, conn) == 0) {
				System.err.println("insertion of record " + i3 + " failed");
				break;
			} else
				System.out.println("insertion was successful");
			j++;
		}
	}

	public static void populateTakes(Connection conn) {
		double j = 0.7;
		for (int i = 1; i <= 500; i++) {
			if (j == 5)
				j = 0.7;
			if (insertTakes(random.nextInt(i4-1)+1, i, j, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
			j += 0.3;
		}
	}

	public static void populateSectionTime(Connection conn) {
		for (int i = 1; i <= 500; i++) {
			if (insertSectionTime(i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void insertSchema1(Connection connection) {
		populateDepartment(connection);
		populateInstructor(connection);
		populateClassroom(connection);
		populateTimeSlot(connection);
		populateStudent(connection);
		populateCourse(connection);
		populatePrerequiste(connection);
		populateSection(connection);
		populateTakes(connection);
		populateSectionTime(connection);
	}

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/schema1", "postgres",
					"123");
			insertSchema1(connection);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
