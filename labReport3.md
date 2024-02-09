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
        assertEquals("Mother", input1.get(0));
        input1.add("Haha");
        input1 = ListExamples.filter(input1, sc);
        assertEquals("Mother", input1.get(0)); //this is the line that created the failure
        assertEquals("Haha", input1.get(1)); //this line returned no errors
    }
```
symptom
![image](scrShot1.jpg)
