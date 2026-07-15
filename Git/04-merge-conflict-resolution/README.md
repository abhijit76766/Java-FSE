# Exercise 4 - Merge Conflict Resolution

**Objective:** Simulate and resolve a merge conflict that occurs when
both a branch and master modify the same file differently.

## Steps

```bash
cd GitDemo

# 1. verify master is clean
git status

# 2. create a branch "GitWork" and add hello.xml
git checkout -b GitWork
cat > hello.xml << 'XML'
<greeting>
  <message>Hello from GitWork branch - version A</message>
</greeting>
XML

# 3. update the content further and observe status
echo "<!-- updated on GitWork -->" >> hello.xml
git status

# 4. commit the changes on the branch
git add hello.xml
git commit -m "Add and update hello.xml on GitWork"

# 5. switch to master
git checkout master

# 6. add hello.xml to master with different content
cat > hello.xml << 'XML'
<greeting>
  <message>Hello from master - version B</message>
</greeting>
XML

# 7. commit the changes to master
git add hello.xml
git commit -m "Add hello.xml on master"

# 8. observe the diverging history
git log --oneline --graph --decorate --all

# 9. check differences with the diff tool
git diff master GitWork -- hello.xml

# 10. visualize differences with P4Merge
git difftool master GitWork -- hello.xml

# 11. merge the branch into master (this will conflict)
git merge GitWork
```

## Resolving the conflict

`git status` after the failed merge will show `hello.xml` as
**both modified**, and the file itself will contain conflict markers:

```
<<<<<<< HEAD
<message>Hello from master - version B</message>
=======
<message>Hello from GitWork branch - version A</message>
>>>>>>> GitWork
```

```bash
# 12. observe the git status / conflict markup
git status

# 13. launch the 3-way merge tool to resolve interactively
git mergetool
```

In P4Merge, pick the correct combined content (or edit it manually),
save, and close the tool. This removes the conflict markers and stages
the resolved file.

```bash
# 14. commit the resolution
git add hello.xml
git commit -m "Resolve merge conflict in hello.xml"

# 15. add the mergetool backup file (hello.xml.orig) to .gitignore
echo "*.orig" >> .gitignore

# 16. commit the .gitignore update
git add .gitignore
git commit -m "Ignore mergetool backup files"

# 17. list all available branches
git branch -a

# 18. delete the branch that was merged into master
git branch -d GitWork

# 19. observe the final log
git log --oneline --graph --decorate
```
