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
Tests run: 2,  Failures: 1``` 


