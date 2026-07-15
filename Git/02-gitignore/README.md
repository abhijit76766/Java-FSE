# Exercise 2 - .gitignore

**Objective:** Ignore unwanted files/folders (`.log` files and a `log`
folder) using `.gitignore`, and verify the working directory, local
repository, and Git status all reflect that they are ignored.

## Steps

```bash
cd GitDemo   # existing repo from Exercise 1

# create a .log file and a log folder with a file inside it
echo "sample log entry" > app.log
mkdir log
echo "debug log entry" > log/debug.log

# check status - both currently show as untracked
git status
```

Create/update `.gitignore` in the repository root:

```bash
notepad++ .gitignore
```

Add the following rules:

```
# ignore all .log files
*.log

# ignore the log folder entirely
log/
```

Save the file, then verify:

```bash
# stage and commit the .gitignore file itself
git add .gitignore
git commit -m "Add .gitignore to ignore log files and log folder"

# confirm app.log and log/ no longer appear as untracked
git status

# double check individual paths are ignored
git check-ignore -v app.log
git check-ignore -v log/debug.log
```

`git status` should now show a clean working directory (no mention of
`app.log` or the `log/` folder), confirming both the working directory
and the local repository agree these paths are excluded from version
control.

## .gitignore used
See [.gitignore](./.gitignore) in this folder for the exact rules.
