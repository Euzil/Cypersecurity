#!/bin/bash

source config.sh

# Starts the client application.
# Parameters:
# - Name of binary directory
# - Client configuration file
# - Server IP address
# - Server port
# - Directory for storing device codes

binDir=$1

# Run client
cd $binDir/
exec $javaRuntime banking.client.ClientMain $2 $3 $4 $5
