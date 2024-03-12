# Debugging scenario
## Original Post
- Student: Help! I was working on my ListExamples and I encountered this error. I was running it with the given tester, I can't find out what is going wrong, Pls Help! Attached below is also my ListExamples and the tester(FYI: the test.sh is just the typical JUnit set up call). Also if it helps i also provided the file structure.

```Code
[siji@ieng6-201]:lab7:340$ ls
ListExamples.class  ListExamples.java  ListExamplesTests.class  ListExamplesTests.java  StringChecker.class  lib  test.sh
```

This is the error code ```  ```

```Code
[siji@ieng6-201]:lab7:328$ bash test.sh
JUnit version 4.13.2
..E
Time: 0.016
There was 1 failure:
1) testMerge2(ListExamplesTests)
array lengths differed, expected.length=6 actual.length=10; arrays first differed at element [2]; expected:<[c]> but was:<[x]>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:78)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:285)
        at org.junit.Assert.assertArrayEquals(Assert.java:300)
        at ListExamplesTests.testMerge2(ListExamplesTests.java:19)
        ... 11 trimmed
Caused by: org.junit.ComparisonFailure: expected:<[c]> but was:<[x]>
        at org.junit.Assert.assertEquals(Assert.java:117)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ExactComparisonCriteria.assertElementsEqual(ExactComparisonCriteria.java:8)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:76)
        ... 17 more

FAILURES!!!
Tests run: 2,  Failures: 1
```

- Student: This is my ListExamples, all of these are down in the ieng6 btw

```Code
[siji@ieng6-201]:lab7:330$ cat ListExamples.java
import java.util.ArrayList;
import java.util.List;

interface StringChecker { boolean checkString(String s); }

class ListExamples {
  static List<String> result = new ArrayList<>();
  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }


  // Takes two sorted list of strings (so "a" appears before "b" and so on),
  // and return a new list that has all the strings in both list in sorted order.
  static List<String> merge(List<String> list1, List<String> list2) {
    int index1 = 0, index2 = 0;
    while(index1 < list1.size() && index2 < list2.size()) {
      if(list1.get(index1).compareTo(list2.get(index2)) < 0) {
        result.add(list1.get(index1));
        index1 += 1;
      }
      else {
        result.add(list2.get(index2));
        index2 += 1;
      }
    }
    while(index1 < list1.size()) {
      result.add(list1.get(index1));
      index1 += 1;
    }
    while(index2 < list2.size()) {
      result.add(list2.get(index2));
      // change index1 below to index2 to fix test
      index2 += 1;
    }
    return result;
  }


}
```

ListExamplesTest

```Code
[siji@ieng6-201]:lab7:331$ cat ListExamplesTests.java
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.util.ArrayList;


public class ListExamplesTests {
        @Test(timeout = 500)
        public void testMerge1() {
                List<String> l1 = new ArrayList<String>(Arrays.asList("x", "y"));
                List<String> l2 = new ArrayList<String>(Arrays.asList("a", "b"));
                assertArrayEquals(new String[]{ "a", "b", "x", "y"}, ListExamples.merge(l1, l2).toArray());
        }

        @Test(timeout = 500)
        public void testMerge2() {
                List<String> l1 = new ArrayList<String>(Arrays.asList("a", "b", "c"));
                List<String> l2 = new ArrayList<String>(Arrays.asList("c", "d", "e"));
                assertArrayEquals(new String[]{ "a", "b", "c", "c", "d", "e" }, ListExamples.merge(l1, l2).toArray());
        }

}
[siji@ieng6-201]:lab7:332$
```

- TA: Thanks for providing such a detailed post. We can definitely help you with your bug. This is a really weird interaction! It says that there are something wrong with the string length, why don't you try putting less elements in your l1 or l2 list in the merge2 test and run it again.
- Student: Ok, I did this and it gave a different error

```Code
@Test(timeout = 500)
        public void testMerge2() {
                List<String> l1 = new ArrayList<String>(Arrays.asList("a", "c"));
                List<String> l2 = new ArrayList<String>(Arrays.asList("c","d","e"));
                assertArrayEquals(new String[]{ "a","c", "c", "d", "e" }, ListExamples.merge(l1, l2).toArray());
        }
```
```Code
[siji@ieng6-201]:lab7:334$ bash test.sh
JUnit version 4.13.2
..E
Time: 0.013
There was 1 failure:
1) testMerge2(ListExamplesTests)
array lengths differed, expected.length=6 actual.length=9; arrays first differed at element [2]; expected:<[c]> but was:<[x]>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:78)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:285)
        at org.junit.Assert.assertArrayEquals(Assert.java:300)
        at ListExamplesTests.testMerge2(ListExamplesTests.java:19)
        ... 11 trimmed
Caused by: org.junit.ComparisonFailure: expected:<[c]> but was:<[x]>
        at org.junit.Assert.assertEquals(Assert.java:117)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ExactComparisonCriteria.assertElementsEqual(ExactComparisonCriteria.java:8)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:76)
        ... 17 more

FAILURES!!!
Tests run: 2,  Failures: 1
```

- TA: Interesting... Wait I see what's going on. The merge2 test is being effected by merge1 also. Since combined they will have 9 elements in the list. Since your results is static. So try to just put the result back into the method.
- Student: Oh. Ok it worked, I changed it again and it stopped giving the error. Thanks.

```Code
import java.util.ArrayList;
import java.util.List;

interface StringChecker { boolean checkString(String s); }

class ListExamples {
  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }


  // Takes two sorted list of strings (so "a" appears before "b" and so on),
  // and return a new list that has all the strings in both list in sorted order.
  static List<String> merge(List<String> list1, List<String> list2) {
    List<String> result = new ArrayList<>();
    int index1 = 0, index2 = 0;
    while(index1 < list1.size() && index2 < list2.size()) {
      if(list1.get(index1).compareTo(list2.get(index2)) < 0) {
        List<String 
        result.add(list1.get(index1));
        index1 += 1;
      }
      else {
        result.add(list2.get(index2));
        index2 += 1;
      }
    }
    while(index1 < list1.size()) {
      result.add(list1.get(index1));
      index1 += 1;
    }
    while(index2 < list2.size()) {
      result.add(list2.get(index2));
      // change index1 below to index2 to fix test
      index2 += 1;
    }
    return result;
  }

}
```

# Part2: Reflection
I think for me I thought jdb is really cool. Because before no way has ever taught me how to use it. And from the labs and the lab demo, I understand how powerful of a tool it is. Since you are able to set breakpoints and know exactly what values each reference and object have at a certain line or loop or method. I want to try to encorporate that into my future and classes to make my debugging more effient. 

