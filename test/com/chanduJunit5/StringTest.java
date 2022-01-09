/**
 * 
 */
package com.chanduJunit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
/**
 * @author CHANDAN KS
 *
 */
class StringTest {
	
	private String str;
	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Intialing connectiion to database");
		//run only once start of test
	}
	
	
	@AfterAll
	static void afterAll()
	{
		System.out.println("Close connection to database");
		//run last all the test 
	}
	
	@BeforeEach//@Before in junit 4
	void BeforeEach(TestInfo info)//not there in junit4
	{
		System.out.println("Initializing Test Data for "+info.getDisplayName());
	}

	@AfterEach//@After in juint 4
	void afterEach(TestInfo info)
	{
		System.out.println("clean up test data for "+info.getDisplayName());
	}
	
	
	
	@Test
	@Disabled//@Ignored
	void length_basic() {
		int actualLength="ABCD".length();
		int expectedLength=4;
		//Assert length==4
		assertEquals(expectedLength,actualLength);
		//write test code
		//invoke method square(4)=>Code Under Test
		//checks in place -16=> Assertions
		}
	
		@Test
		void length_greater_than_zero()
		{
			assertTrue("ABCD".length()>0);
			assertTrue("ABC".length()>0);
			assertTrue("A".length()>0);
			assertTrue("DEF".length()>0);
		}
		@ParameterizedTest
		@ValueSource(strings= {"ABCD","ABC","A","DEF"})
		void length_greater_than_Zero_using_parameterize_test(String s)
		{
			assertTrue(s.length()>0);
		
		}
		
		@ParameterizedTest(name="{0} toUpperCase  is {1}")
		@CsvSource(value= {"abcd,ABCD","abc,ABC","'',''","abcdefg,ABCDEFG"})
		void uppercase(String word,String capitalizedWord)
		{
			assertEquals(capitalizedWord,word.toUpperCase());
		}
		
		

		@ParameterizedTest(name="{0} length is {1}")
		@CsvSource(value= {"abcd,4","abc,3","'',0","abcdefg,7"})
		void length(String word,int expLength)
		{
			assertEquals(expLength,word.length());
		}
		
	@Test
	@DisplayName("When length is null,throw an Exception")
	void length_exception() {
		String str=null;
	
		assertThrows(NullPointerException.class, 
				() -> {
					str.length();
				}
				);
	
		
		}
		
		@Test 
		void performanceTest()
		{
			assertTimeout(Duration.ofSeconds(5),()->{
				for(int i=0;i<=1000000;i++)
				{
					int j=i;
					System.out.println(j);
				}
			});
		}
	
	
		@Test
		void toUpperCase()
		{
			String str="abcd";
			String res=str.toUpperCase();
			assertEquals("ABCD",res);
			assertNotNull(res);
//			assertNull(res);
		}
		
		@Test 
		@RepeatedTest(10)
		void contains_basic()
		{
			assertEquals(false,"abcdefgh".contains("ijk"));
			assertFalse("abcdefgh".contains("ijk"));
//			assertTrue();
		}
		
		@Test
		void split_basic()
		{
			String str="abc def ghi";
			String res[]=str.split(" ");
			String[] expected=new String[] {"abc","def","ghi"};
			assertArrayEquals(expected ,res);
		}
		@Nested
		@DisplayName("For an Empty String")
		class EmptyStringTests{
			@BeforeEach
			void setToEmpty() {
				str="";
			}
			@Test
			@DisplayName("length should be zero")
			void lengthIsZero()
			{
				assertEquals(0,str.length());
			}
			@Test
			@DisplayName("upper case should be zeo")
			void uppercaseIsEmpty()
			{
				assertEquals("",str.toUpperCase());
			}
		}
}