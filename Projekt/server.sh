#!/bin/bash

source config.sh

# Starts the server application.
# Parameters:
# - Name of binary directory
# - Database file name (e.g. database.json).
# - IP address or host name (e.g. 127.0.0.1).
# - Port (e.g. 12000).
# - (Optional) Lab mode (true/false).
# - (Optional) Lab server authentication code.

binDir=$1

# Evaluate lab mode parameter
labModeParam=""
if [ "$#" -gt 4 ]; then
	labModeParam="-DLAB_MODE=$5"
fi

# Evaluate API token parameter
apiTokenParam=""
if [ "$#" -gt 5 ]; then
	apiTokenParam="-DAPI_TOKEN=$6"
fi

# Run server
cd $binDir/
exec $javaRuntime $labModeParam $apiTokenParam banking.server.ServerMain run $2 $3 $4
