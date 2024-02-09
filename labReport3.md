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
this is useful since if you are opening up a manual for a command, it will be nice if you can refer to the document right there

less option -N Displays line numbers at the beginning of each line.

```
less -N 1471-2261-1-6.txt
       1 
      2   
      3     
      4       
      5         Background
      6         Nonadherence to drug therapy can undermin
      6 e the
      7         attainment of therapeutic goals and contr
      7 ibute to the
      8         occurrence of medication side effects. Nu
      8 merous adverse
      9         clinical outcomes have been linked to non
      9 adherence
     10         including loss of blood pressure control 
     10 [ 1 2 ] , acute
     11         cardiac events [ 3 ] , renal transplant r
     11 ejection [ 4 ] ,
     12         seizures [ 5 ] , and elevated Human Immun
     12 odeficiency Virus
     13         RNA levels [ 6 ] . Efforts to enhance med
     13 icinal adherence
     14         have met with varying levels of success [
     14  7 8 9 ] .
     15         The detection of nonadherence to recommen
     15 ded treatment
1471-2261-1-6.txt
```
```
less -N 1471-230X-2-23.txt
      3     
      4       
      5         Background
      6         The biliary system is more than a passive conduit
      7         transporting bile from the liver to the intestines. Hep
      7 atic
      8         bile is actively modified by the epithelial cells that 
      8 line
      9         the bile ducts and gallbladder. Biliary epithelial func
      9 tion
     10         is partially under the control of secretin and vasoacti
     10 ve
     11         intestinal peptide [ 1 ] . Other extracellular agonists
     12         that influence biliary function include neuropeptides [
     12  2 3
     13         ] , ATP [ 4 5 ] , and bile salts [ 6 ] . In addition to
     13  the
     14         well-documented role that cytokines play in the immune
     15         response and inflammation [ 7 8 ] , cytokines also modi
     15 fy
     16         the functioning of epithelial cells. For instance, tumo
     16 r
     17         necrosis factor-α (TNF-α) can modify intracellular sign
1471-230X-2-23.txt
```
this option is good because when the user is looking at code from the shell, it is convenient to know the lines of code




