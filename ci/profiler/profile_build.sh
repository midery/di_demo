#!/bin/bash
set -euo pipefail

gradle-profiler --benchmark --scenario-file benchmarks.scenarios --warmups 3 --iteration 5