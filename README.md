# oop-project-converting-json
Interpreting judgments in json and html files (data extraction, generating statistics).  
  
Final version of the project.  
  
Since there are spaces in e.g. judges' names, I decided to parse console input using comma.  
Explanation:  
if (command needs extra argument/arguments)  
type it like: judge,Mariusz Kotulski  
              content,II SA/Kr 2063/03  
              rubrum,II SA/Kr 2063/03,VIII Ka 299/14,I ACz 1094/14,II SA/Bd 205/04  
  
if (command does not need extra arguments)  
    simply type its name, e.g. regulations  
