# AI Modernization Harness (AMH)

A controlled, evidence-backed pipeline for analyzing legacy applications, extracting business behavior, building a Golden Business Model, reimagining the target architecture, implementing the target application, and validating business parity.

## Design principles

1. Observation is separated from interpretation.
2. Every business rule must have evidence.
3. Legacy behavior is not automatically treated as business intent.
4. Agents produce durable artifacts; the orchestrator owns pipeline state.
5. Quality gates, not agents, determine whether a stage can advance.
6. Human decisions are recorded as durable artifacts.
7. The Golden Business Model is the technology-neutral intermediate representation.

## Pipeline

INTAKE -> DISCOVERY -> BUSINESS_ANALYSIS -> WORKFLOW_ANALYSIS -> DOMAIN_ANALYSIS
-> RECONCILIATION -> HUMAN_REVIEW -> ARCHITECTURE -> TEST_MINING
-> IMPLEMENTATION -> VALIDATION -> COMPLETE

## Prototype

The sample project is `projects/sample-customer-onboarding`.

The legacy application intentionally contains:
- nested conditions
- duplicated validation
- magic numbers
- an external risk integration
- database access
- exception handling
- tests

The first milestone is not autonomous code generation. It is proving that the harness can create a traceable chain:

legacy code -> evidence -> business rules -> workflows -> domain model
-> golden model -> target architecture -> tests -> implementation -> parity report

## Suggested execution

The repository is intentionally framework-light in this first cut.

1. Open the repository in GitHub Copilot CLI / supported Copilot agent environment.
2. Start with `orchestrator.agent.md`.
3. Run discovery against the sample project.
4. Validate artifacts after every stage.
5. Resolve human-review artifacts before architecture.
6. Generate target code only from the approved Golden Business Model.

## Enterprise evolution

Replace the prototype shell tools under `tools/` with MCP servers for:
- AST/symbol analysis
- dependency and call graphs
- database metadata
- evidence retrieval
- knowledge graph queries
- test execution
- security and architecture policy checks

The artifact contracts under `schemas/` should remain stable while the tools and models evolve.
