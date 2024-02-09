# Lab Report 3

## Bugs 
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

## Less

credits: https://phoenixnap.com/kb/less-command-in-linux

less with option -f : which forcifily opens non-regular files

```
less -f technical/

read error (press RETURN)
```
```
less -f government/

read error (press RETURN)
```
not a good respresentation given this file, but might be good for understand files of different formats that are not commonly accessable such as .exe. 

less with option -m: Instructs less to prompt verbosely (similar to more), showing the percentage into the file. By default, less prompts with a colon.

```
less -m pmed.0020024.txt
```
![image](scrShot2.png)

```
less -m 1471-230X-1-5.txt      
        Background & Aims
        MAdCAM-1 is a 60 kD endothelial cell adhesion mol
ecule
        expressed on the surface of high endothelial venu
les in the
        gut, and in Peyers patches. MAdCAM-1 is expressed
 basally
        in these tissues and is dramatically increased in
        inflammatory bowel disease (IBD). In IBD, especia
lly
        Crohn's disease, MAdCAM-1 acts as the main ligand
 for
        a4b7-expressing lymphocytes and recruits these ly
mphocytes
        into the intestine where they initiate and sustai
n chronic
        inflammation. Several animal models and human stu
dies
        support an absolute requirement for both MAdCAM-1
 and a4b7
        in the production of immune models of colitis. MA
dCAM-1 is
        expressed on the surface of lymphoid endothelial 
4%
```
useful or reading through long documents since you know how far in you are 

less with option -X: Disable clearing the screen after quitting less.

```
less -X 1471-230X-1-5.txt
```
After pressing q
```
230X-1-5.txt 

  
    
      
        Background & Aims
        MAdCAM-1 is a 60 kD endothelial cell adhesion mol
ecule
        expressed on the surface of high endothelial venu
les in the
        gut, and in Peyers patches. MAdCAM-1 is expressed
 basally
        in these tissues and is dramatically increased in
        inflammatory bowel disease (IBD). In IBD, especia
lly
        Crohn's disease, MAdCAM-1 acts as the main ligand
 for
        a4b7-expressing lymphocytes and recruits these ly
mphocytes
        into the intestine where they initiate and sustai
n chronic
        inflammation. Several animal models and human stu
dies
        support an absolute requirement for both MAdCAM-1
 and a4b7
        in the production of immune models of colitis. MA
[user@sahara ~/docsearch/technical/biomed]$ ^C
```

```
less -X 1471-2261-1-6.txt  
      
        Background
        Nonadherence to drug therapy can undermine the
        attainment of therapeutic goals and contribute to
 the
        occurrence of medication side effects. Numerous a
dverse
        clinical outcomes have been linked to nonadherenc
e
        including loss of blood pressure control [ 1 2 ] 
, acute
        cardiac events [ 3 ] , renal transplant rejection
 [ 4 ] ,
        seizures [ 5 ] , and elevated Human Immunodeficie
ncy Virus
        RNA levels [ 6 ] . Efforts to enhance medicinal a
dherence
        have met with varying levels of success [ 7 8 9 ]
 .
        The detection of nonadherence to recommended trea
tment
        can be problematic. In the clinical setting askin
[user@sahara ~/docsearch/technical/biomed]$
```

