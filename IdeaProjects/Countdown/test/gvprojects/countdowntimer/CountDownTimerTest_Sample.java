package gvprojects.countdowntimer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example tests for students
 *
 * @author Zachary Kurmas
 */
// Created  1/2/13 at 8:34 AM
// (C) Zachary Kurmas 2013

public class CountDownTimerTest_Sample {

   ///////////////////////////////////////////////////////////////////
   //
   // Steps 1 - 3
   //
   ///////////////////////////////////////////////////////////////////

   @Test
   public void totalSecondsCombinesAllThreeValues() throws Throwable {
      assertEquals(3661, CountDownTimer.totalSeconds(1, 1, 1));
   }
   // I suggest at least 3 more tests for totalSeconds(int, int, int).
   // (Make sure the method handles 0s correctly)


   @Test
   public void defaultConstructorSetsTimeToZero() throws Throwable {
      CountDownTimer timer = new CountDownTimer();
      assertEquals(0, timer.totalSeconds());
   }
   // The test above should be sufficient  for the default constructor


   @Test
   public void threeParameterConstructorCorrectlySetsTime() throws Throwable {
      CountDownTimer timer = new CountDownTimer(1, 2, 3);
      assertEquals(3723, timer.totalSeconds());
   }
   // Assuming your constructor simply sets instance variables and doesn't contain any logic, one test should be sufficient.
   // Test CountDownTimer(int, int) and CountDownTimer(int) in a similar manner.

   @Test
   public void copyConstructor() throws Throwable {
      CountDownTimer timer1 = new CountDownTimer(2, 3, 4);
      CountDownTimer timer2 = new CountDownTimer(timer1);
      assertEquals(7384, timer2.totalSeconds());
   }
   // How many tests you need for this constructor depends on how much logic you use.  One test may be sufficient,
   // you many need a set of tests similar to your tests for totalSeconds(int, int, int)

   @Test
   public void stringConstructor() throws Throwable {
      CountDownTimer timer1 = new CountDownTimer("11:12:13");
      assertEquals(40333, timer1.totalSeconds());
   }
   //  You'll need *a lot* mre test here.  Remember your input can have 1, 2, or 3 numbers,
   // and may or may not have leading zeros.


   @Test
   public void equalsDetectsEquality() throws Throwable {
      CountDownTimer timer1 = new CountDownTimer(2, 3, 4);
      CountDownTimer timer2 = new CountDownTimer("2:03:04");
      assertTrue(timer1.equals(timer2));
   }
   // Be sure to verify that equals returns false when it should.  That requires at least *three* separate tests

   @Test
   public void compareToDetectsEquality() throws Throwable {
      CountDownTimer timer1 = new CountDownTimer(2, 3, 4);
      CountDownTimer timer2 = new CountDownTimer("2:03:04");
      assertTrue(timer1.equals(timer2));
      assertEquals(0, timer2.compareTo(timer1));
   }
   // You need *at least* 9 total total tests.  ***3 is not enough***

   @Test
   public void subtractHandlesSmallSeconds() throws Throwable {
      CountDownTimer timer = new CountDownTimer(55);
      timer.subtract(25);
      assertEquals(30, timer.totalSeconds());
   }
   // Make sure you test all the different flavors of "roll over"
   // Remember to test decrement.  However, you don't need too many decrement tests if your implementation doesn't
   // contain any logic.

   @Test
   public void toStringAddsLeading0toSeconds() throws Throwable {
      CountDownTimer timer = new CountDownTimer(0, 0, 3);
      assertEquals("0:00:03", timer.toString());
   }
   // You will need many tests for toString


   ///////////////////////////////////////////////////////////////////
   //
   // Step 4
   //
   ///////////////////////////////////////////////////////////////////

   /*  Uncomment this after you've implemented load() and save()
   @Test
   public void testLoadSave() throws IOException {
      CountDownTimer c1 = new CountDownTimer(10, 10, 10);
      c1.save("timer1.txt");
      CountDownTimer c2 = new CountDownTimer();
      c2.load("timer1.txt");
      assertTrue(c1.equals(c2));
   }
   // Your files can contain any data you wish, as long as you can save, then re-load an object.
   */

   /* Uncomment this after you've implemented getNumberCreated()
   @Test
   public void testNumberCreated_1() throws IOException {
      int count = CountDownTimer.getNumberCreated();
      new CountDownTimer(1, 1, 1);
      new CountDownTimer(5, 5);
      new CountDownTimer(5);
      new CountDownTimer();
      assertTrue(CountDownTimer.getNumberCreated() == count + 4);
   }
   */

   ///////////////////////////////////////////////////////////////////
   //
   // Step 5
   //
   // These tests will fail until you get to step 5.  When you reach step 5,
   // remove the @Ignore annotation.
   //
   ///////////////////////////////////////////////////////////////////

   @Test(expected = IllegalArgumentException.class)
   public void totalSecondsShouldThrowExceptionIfSecondsNegative() {
      CountDownTimer.totalSeconds(1, 2, -5);
   }
   // add more tests here

   @Test(expected = IllegalArgumentException.class)
   public void constructorShouldThrowExceptionIfSecondsNegative() {
      new CountDownTimer(1, -2, 5);
   }
   // add more tests here.  Be sure to test all the constructors.


   @Test(expected = IllegalArgumentException.class)
   public void stringConstructor_error18() {
      new CountDownTimer("1:2:3:4");
   }
   // You need *a lot* of tests here, because there are many ways that a String could
   // not be a valid timer value.  For example, what should "3:" or "1:62" generate?


   // Finally, write tests to verify that subtract() and dec() throw exceptions when necessary.

}

