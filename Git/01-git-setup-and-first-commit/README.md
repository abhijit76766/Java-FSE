# Exercise 1 - Git Setup and First Commit

**Objective:** Configure Git, set a default editor, and add a file to
a source-controlled repository, then push it to a remote (GitLab).

## Step 1: Configure Git

```bash
# verify Git is installed
git --version

# set user-level identity
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# verify configuration
git config --list
```

## Step 2: Set Notepad++ as the default Git editor (Windows)

```bash
# check if notepad++ launches from Git Bash
notepad++

# if not recognized, add the Notepad++ install folder
# (e.g. C:\Program Files\Notepad++) to the Windows PATH
# environment variable, then restart Git Bash.

# create an alias so 'notepad++' resolves cleanly
echo 'alias notepad++="/c/Program\ Files/Notepad++/notepad++.exe"' >> ~/.bashrc
source ~/.bashrc

# configure it as Git's default editor
git config --global core.editor "notepad++ -multiInst -notabbar -nosession -noPlugin"

# verify
git config -e
# or
git config --global -e
```

## Step 3: Add a file to the repository

```bash
# create and initialize a new local repository
mkdir GitDemo
cd GitDemo
git init

# verify the .git folder was created
ls -la

# create a file with content
echo "Welcome to Git Hands-on Lab" > welcome.txt

# verify the file exists and check its content
ls -la
cat welcome.txt

# check status - welcome.txt shows as untracked
git status

# stage the file so Git tracks it
git add welcome.txt

# commit with a multi-line message using the default editor
git commit

# in the editor that opens, type a commit message, e.g.:
#   Add welcome.txt
#
#   This is the first file added to the GitDemo repository.
# then save and close the editor to complete the commit

# verify the working directory is clean
git status
```

## Step 4: Connect to a remote repository and sync

```bash
# after creating a "GitDemo" project on GitLab and copying its
# remote URL:
git remote add origin <remote-repository-url>

# pull any existing history from the remote (e.g. README/license)
git pull origin master

# push local commits to the remote
git push origin master
```
