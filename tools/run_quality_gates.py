#!/usr/bin/env python3
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "projects" / "sample-customer-onboarding"

rules_dir = PROJECT / "artifacts/business-rules"
evidence_file = PROJECT / "artifacts/evidence/evidence.json"

if not rules_dir.exists():
    print("BLOCKED: business-rules directory does not exist")
    raise SystemExit(1)

if not evidence_file.exists():
    print("BLOCKED: evidence file does not exist")
    raise SystemExit(1)

evidence = json.loads(evidence_file.read_text())
evidence_ids = {e["evidenceId"] for e in evidence}

missing = []
for path in rules_dir.glob("*.json"):
    rule = json.loads(path.read_text())
    for evidence_id in rule.get("evidence", []):
        if evidence_id not in evidence_ids:
            missing.append((rule.get("ruleId"), evidence_id))

if missing:
    for rule_id, evidence_id in missing:
        print(f"BLOCKED: {rule_id} references missing evidence {evidence_id}")
    raise SystemExit(1)

print("PASS: business-rule evidence gate")
