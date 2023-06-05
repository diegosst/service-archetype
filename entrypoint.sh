#!/bin/bash
set -e

# Export environment variables from .env file
set -o allexport
source .env
set +o allexport

# Run the command passed as arguments
exec "$@"