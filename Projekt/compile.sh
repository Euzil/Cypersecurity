#!/bin/bash

source config.sh

# Compiles client and server, and optionally generates a new database file.
# Parameters:
# - Name of binary directory
# - (Optional) Database file name (e.g. database.json).
# - (Optional) Man-in-the-Middle password file name (e.g. mitm.txt).
# - (Optional) Client configuration file name (e.g. config.json).
# - (Optional) Credentials file name (e.g. credentials.txt).

binDir=$1

mkdir -p $binDir/

# Server
$javaCompiler -d $binDir -sourcepath src/ src/banking/server/ServerMain.java

# Client
$javaCompiler -d $binDir -sourcepath src/ src/banking/client/ClientMain.java

# Generate new database, if desired
if [ "$#" -lt 5 ]; then
	exit
fi
cd $binDir/
exec $javaRuntime banking.server.ServerMain generate $2 $3 $4 $5