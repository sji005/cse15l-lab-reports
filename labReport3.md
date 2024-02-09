#Lab Report 3

##Bugs 
failure inducing input
```
    @Test
    public void testFilter(){
        List<String> input1 = new ArrayList<String>();
        input1.add("China");
        input1.add("china");
        input1.add("Mother");
        input1 = ListExamples.filter(input1, sc);
        assertEquals("Mother", input1.get(0)); //this is the line that created the failure
        assertEquals("Haha", input1.get(1)); 
    }
```
no failure
```
    @Test
    public void testFilter(){
        List<String> input1 = new ArrayList<String>();
        input1.add("China");
        input1.add("china");
        input1.add("Mother");
        input1 = ListExamples.filter(input1, sc);
        assertEquals("Mother", input1.get(0));
```
    
symptom
![image](scrShot1.jpg)

the bug is that it is adding the list at the beginning, causing the order to be reversed.
```
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }
```
fixed
```
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(s);
      }
    }
    return result;
  }
```

## 
