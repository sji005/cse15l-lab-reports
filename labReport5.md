# Debugging scenario
## Original Post
- Student: Help! I was working on my ListExamples and I encountered this error. I was running it with the given tester, I can't find out what is going wrong, Pls Help! Attached below is also my ListExamples. (FYI: the test.sh is just the typical JUnit set up call)
```
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
This is my ListExamples, all of these are down in the ieng6 btw
```
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

