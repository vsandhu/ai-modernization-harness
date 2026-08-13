#!/usr/bin/env bash
set -euo pipefail
echo "PRE-IMPLEMENTATION: implementation is allowed only after approved architecture"
test -f projects/sample-customer-onboarding/artifacts/architecture/architecture-decisions.yaml
