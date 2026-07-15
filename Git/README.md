# Git

Solutions for the 5 Git Hands-On Lab (HOL) exercises. These are
command-line labs (no application source code), so each numbered
folder contains a `README.md` walking through the exact Git Bash
commands that complete the exercise, in order.

| # | Folder | Topic |
|---|--------|-------|
| 1 | 01-git-setup-and-first-commit | git config, default editor, git init/add/commit, remote push/pull |
| 2 | 02-gitignore | Ignoring `.log` files and a `log/` folder with `.gitignore` |
| 3 | 03-branching-and-merging | Creating a branch, committing on it, merging into master, P4Merge |
| 4 | 04-merge-conflict-resolution | Simulating and resolving a merge conflict with a 3-way merge tool |
| 5 | 05-cleanup-and-push | Verifying clean state, pulling, and pushing pending changes to remote |

All five exercises build on the same local repository ("GitDemo"),
carried across folders in sequence — Exercise 1 creates it, Exercises
2-4 modify it, and Exercise 5 syncs the final state with the remote.
