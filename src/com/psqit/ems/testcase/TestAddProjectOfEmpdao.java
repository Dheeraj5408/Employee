package com.psqit.ems.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.psq.emsdao.Empdao;
import com.psqit.ems.emspojo.Emspojo;

class TestAddProjectOfEmpdao {

	Emspojo pojo = new Emspojo();
	Empdao dao = new Empdao();

	@Test
	void test() {
		pojo.setProjectName("Indian Idol");
		pojo.setEmp_id(16);

		String s = dao.addProject();

		assertEquals("Project Added", s);
	}

}
