# Exercise 3 - Branching and Merging

**Objective:** Create a branch, make changes, and merge it back into
master/trunk, using P4Merge to visualize differences.

## Branching

```bash
cd GitDemo

# 1. create a new branch
git branch GitNewBranch

# 2. list all local and remote branches (the '*' marks the current branch)
git branch -a

# 3. switch to the new branch and add a file
git checkout GitNewBranch
echo "Content added on GitNewBranch" > branchfile.txt

# 4. commit the changes to the branch
git add branchfile.txt
git commit -m "Add branchfile.txt on GitNewBranch"

# 5. check status
git status
```

## Merging

```bash
# 1. switch back to master
git checkout master

# 2. list command-line differences between master and the branch
git diff master GitNewBranch

# 3. configure and use P4Merge for a visual diff (one-time setup)
git config --global diff.tool p4merge
git config --global difftool.p4merge.cmd \
  "p4merge \$LOCAL \$REMOTE"
git difftool master GitNewBranch

# 4. merge the branch into master
git merge GitNewBranch

# 5. observe the commit graph after merging
git log --oneline --graph --decorate

# 6. delete the branch now that it's merged, and confirm via status/branch list
git branch -d GitNewBranch
git status
git branch -a
```
