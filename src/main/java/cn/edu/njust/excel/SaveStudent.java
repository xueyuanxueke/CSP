package cn.edu.njust.excel;

import cn.edu.njust.*;
import cn.edu.njust.bean.Confirm;
import cn.edu.njust.bean.Score;
import cn.edu.njust.bean.Student;
import cn.edu.njust.dao.ConfirmDao;
import cn.edu.njust.dao.ScoreDao;
import cn.edu.njust.dao.StudentDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SaveStudent {
	@SuppressWarnings({ "rawtypes" })
    public void save(String path, String grade) throws IOException, SQLException {
        ReadStudentExcel xlsMain = new ReadStudentExcel();
        StudentDao d = new StudentDao();

        xlsMain.readXls(path, grade);
        List<Student> list1 = xlsMain.getList1();
        
        for (int i = 0; i < list1.size(); i++) {
        	Student stu = list1.get(i);
            
            if (!d.isValid(stu.getStuID(), stu.getStuPassword())) {
            	d.addStudent(stu);
            } else {
                System.out.println("The Record was Exist, and has been throw away!");
            }
        }
    }

}
