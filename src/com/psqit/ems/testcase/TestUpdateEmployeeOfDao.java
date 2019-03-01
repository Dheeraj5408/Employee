package com.psqit.ems.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.psq.emsdao.Empdao;
import com.psqit.ems.emspojo.Emspojo;

	class TestUpdateEmployeeOfDao {
			
			Emspojo pojo=new Emspojo();
			Empdao dao=new Empdao();
			
		@Test
		void test() {
			pojo.setEmp_id(16);
			pojo.setEmp_name("Kamal_Hasan_ji");
			pojo.setSalary(20000);
			
			String s=dao.updateEmployee();
			
			assertEquals("Updated Successfully",s);
		}

	}
