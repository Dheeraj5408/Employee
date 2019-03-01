package com.psqit.ems.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.psqit.ems.emspojo.Emspojo;

class TestSetGetMethodOfPojo {

	@Test
	void test1() {
		Emspojo ep = new Emspojo();
		ep.setEmp_id(5);

		assertEquals(5, ep.getEmp_id());
	}

}
