package biz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PhuongTrinhBac2Test {
	//StudentList
	
	@BeforeAll
	static void setUp() {
		//System.out.println("Before All");
	}
	
	@BeforeEach
	void beforeEach(){
		//System.out.println("Before Each");
		//Setup Student List includes 10 students 
	}
		
	@Test	
	void testInvalid() {		
		//setup & execute & verify
		assertThrows(IllegalArgumentException.class, 
				() -> new PhuongTrinhBac2(0, 1, 2));
	}
	
	@Test
	@Disabled
	void test2NghiemPhanBiet() {		
		fail("Not yet implemented");
	}
	
	@Test
	void test1NghiemKep() {	
		fail("Not yet implemented");
	}
	
	@Test
	void testVoNghiem() {		
		fail("Not yet implemented");
	}
	
	@Test
	void testVoSoNghiem() {
	
		fail("Not yet implemented");
	}

	@AfterEach
	void afterEach(){
		//System.out.println("After Each");
		//Delete all students 
	}
	
	@AfterAll
	static void tearDown() {
		//System.out.println("After All");
	}
}
