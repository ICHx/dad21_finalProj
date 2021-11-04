/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package studentDatabase;

import org.junit.Test;

import studentDatabase.Pojo.*;

public class AppTest {

    @Test
    public void testSQL() throws Exception {
        var dept = new Dept("ISE", "Industrial and Sys Eng", "Room 208", 25567111);
        var course = new Course("ISE", 101, "Introduction to engineering", "nothing given");
        var ac = new Account("122235d", "TaiMan", "Chan", "ISE", "M", "+852-21090000");

        var ach = new Account("130622t", "Ben", "Cheung", "ISE", "M", "+852-98993310");
        var ach2 = new Account("177722t", "Ken", "Chung", "ISE", "M", "+852-98994410");

        var dh = new DeptHead("130622t", "ISE");
        var dh2 = new DeptHead("177722t", "ISE");

        DBUtil.insert(dept);
        DBUtil.insert(course);
        DBUtil.insert(ac);

        // add teacher
        DBUtil.insert(ach);
        DBUtil.insert(ach2);
        DBUtil.insert(dh);
        DBUtil.insert(dh2);

        // enroll, teach
        var teach = new Teach("130622t", "ISE", 101);
        DBUtil.insert(teach);
        // var enroll = new Enroll("122235d","ISE",101);
        // DBUtil.insert(enroll);
    }

    @Test
    public void testCourse() {
        var course = new Course("CS", 102, "Adv CS", null);
        var course2 = new Course("ISE", 102, "More industrial", null);
        var course3 = new Course("CS", 202, "Magical Turing Machine", null);
        // DBUtil.insert(course);
        DBUtil.insert(course2);
        // DBUtil.insert(course3);
    }

    @Test
    public void genereateDefaultPassword() {

        // ! generate password = netid + phone

        var aclist = DBUtil.findAccount();
        aclist.forEach((ac) -> {
            var p = new Password(ac.getNetid(), ac.getNetid() + ac.getLastname());
            p.hash();
            System.out.println(p);
            DBUtil.update(p);
        });
    }
}
