#!/bin/bash
set -euo pipefail

PROFILE_RESULT=$(cat profile-out/benchmark.csv)

SLACK_MESSAGE=$(cat << EOF
:hammer_and_wrench: Android build measurement complete:
```
$PROFILE_RESULT
```
EOF
)

echo $PROFILE_RESULT

echo "SLACK_MESSAGE<<EOF" >> $GITHUB_ENV
echo "$SLACK_MESSAGE" >> $GITHUB_ENV
echo "EOF" >> $GITHUB_ENV
