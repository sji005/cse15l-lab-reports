# Vim
## After forking the repository, on terminal
### Step 4 
- `ssh siji@ieng-201.ucsd.edu` logs into the ieng machine
- `git git@github.com:sji005/lab7.git` clones repository to ieng machine
- `cd lab7` changes directory to lab7
- `bash test.sh` runs the initial test and let us know that something was wrong with the code
- `vim ListExamples.java` vims into ListExamples
- `44G, dw, I, index2 , esc, :wq` `44G` goes to the 44th line which was the line we need to change, `dw` deletes the word index1, `i` goes into insert mode, `index2` modifies it to the correct one, `esc` goes into normal mode, `:wq` saves and quits `vim`
- `up arrow, up arrow` goes to the 2nd most recent command which runs the `test.sh` file, this time it should return with no errors
- `git add ListExamples.java` puts the `ListExamples.java` into the list of files waiting to be commited
- `git commit -m sdkjfslk` commits the file with a random message
- `git push` push the file into the github git repository
