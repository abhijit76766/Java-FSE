# Exercise 5 - Cleanup and Push to Remote

**Objective:** Verify a clean local state, then sync any pending
commits (from the branching/merge-conflict exercises) with the remote
repository.

## Steps

```bash
cd GitDemo

# 1. verify master is in a clean state (no pending changes)
git status

# 2. list all available branches
git branch -a

# 3. pull the latest changes from the remote into master
git pull origin master

# 4. push the local commits (from the "Git-T03-HOL_002" exercise,
#    i.e. Exercise 4's branch merge + conflict resolution) to the remote
git push origin master

# 5. verify the changes landed on the remote
git log origin/master --oneline --graph --decorate
```

Open the remote repository in GitLab/GitHub in a browser and confirm
that `hello.xml`, the resolved merge commit, and the `.gitignore`
update from Exercise 4 are all visible in the commit history.
