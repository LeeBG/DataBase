import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conifg.DBConnection;
import dao.DeptDao;
import model.Dept;

public class MainApp {
	public static void main(String[] args) {
		//갱신(8,10);
		DeptDao deptDao = new DeptDao();
		deptDao.전체검색();
	}
}
