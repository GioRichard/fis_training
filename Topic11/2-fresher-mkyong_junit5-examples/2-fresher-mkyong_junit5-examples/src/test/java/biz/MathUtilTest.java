package biz;

//JUnit
import org.junit.jupiter.api.Test;

//AssertJ
import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

	@Test
	void testAdd() {
		//setup & mock
		int a = 10;
		int b = 20;
		int expected = 30;
		
		//execute
		int result = MathUtil.add(a, b);
		
		//verify by junit + third party
		assertEquals(expected, result);		
	}
}
