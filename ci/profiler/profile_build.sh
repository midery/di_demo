#!/bin/bash
set -euo pipefail

gradle-profiler --benchmark --scenario-file ci/profiler/benchmarks.scenarios --warmups 3 --iteration 5