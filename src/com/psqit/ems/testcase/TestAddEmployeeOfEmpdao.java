package com.psqit.ems.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.psq.emsdao.Empdao;
import com.psqit.ems.emspojo.*;

class TestAddEmployeeOfEmpdao {

	Emspojo pojo = new Emspojo();
	Empdao dao = new Empdao();

	@Test
	void test() {
		pojo.setEmp_name("Kamal");
		pojo.setSalary(1000);

		String s = dao.addEmployee();

		assertEquals("Detail Added", s);
	}

}
