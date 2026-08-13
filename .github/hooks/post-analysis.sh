#!/usr/bin/env bash
set -euo pipefail
echo "POST-ANALYSIS: running artifact validation"
python3 tools/validate_artifacts.py
