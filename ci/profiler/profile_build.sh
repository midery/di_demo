#!/bin/bash
set -euo pipefail

gradle-profiler --benchmark --scenario-file ci/profiler/benchmarks.scenarios --warmups 1 --iteration 1