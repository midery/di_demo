#!/bin/bash
set -euo pipefail

gradle-profiler --benchmark \
  --cli \
  --scenario-file ci/profiler/benchmarks.scenarios \
  --warmups $WARM_UPS_COUNT --iteration $ITERATIONS_COUNT