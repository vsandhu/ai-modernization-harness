#!/usr/bin/env python3
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "projects" / "sample-customer-onboarding"

def fail(message):
    print(f"FAIL: {message}")
    raise SystemExit(1)

inventory = PROJECT / "artifacts/inventory/code-inventory.json"
evidence = PROJECT / "artifacts/evidence/evidence.json"

if not inventory.exists():
    fail(f"missing {inventory}")
if not evidence.exists():
    fail(f"missing {evidence}")

inv = json.loads(inventory.read_text())
ev = json.loads(evidence.read_text())

if "repository" not in inv:
    fail("inventory.repository missing")
if not isinstance(ev, list):
    fail("evidence.json must contain an array")

print("PASS: artifact smoke validation")
