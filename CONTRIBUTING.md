# Contributing Guide (Personal Projects)

## Branching
- Use prefixes: `feat/`, `fix/`, `chore/`, `docs/`, `refactor/`
- Keep branches short-lived; 1–3 commits ideally

## Commit Messages
- Use imperative mood: `Add word count command`
- Keep subject ≤ 72 chars; add a body if needed with *what/why*

## Pull Requests
- Keep PRs small (≤ 200–300 lines of diff)
- Link issues with `Closes #123`
- Ensure checklist is ✅ before requesting review
- Rebase before merge (`git pull --rebase origin main`)
- Use squash-merge for tidy history

## Definition of Done
- Code compiles and tests pass locally
- Updated docs/README where relevant
- No secrets in code or logs
- Lint passes (when set up)

## Labels (suggested)
- `type: feature`, `type: bug`, `type: chore`
- `priority: high|medium|low`
- `size: S|M|L`
- `status: blocked|in progress|ready`
