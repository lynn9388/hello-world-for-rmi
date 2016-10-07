# hello world for rmi
A simple RMI project.

[![Build Status](https://travis-ci.org/lynn9388/hello-world-for-rmi.svg?branch=master)](https://travis-ci.org/lynn9388/hello-world-for-rmi)

## Installation

### v1.1 (Server and Client Communicate by Middle)
1. Config `serverIp` in middle.HelloWorldImpl class (default `serverPort` is `1099`) and `middleIp` in client.Client class (default `middlePort` is `1100`)
2. Run `gradlew :server:run` (or `./gradlew :server:run` in UNIX) in server machine
3. Run `gradlew :middle:run` (or `./gradlew :middle:run` in UNIX) in middle machine
4. Run `gradlew :client:run` (or `./gradlew :client:run` in UNIX) in client machine

### v1.0 (One Server and One Client)
1. Config `serverIp` in client.Client class (default `serverPort` is `1099`)
2. Run `gradlew :server:run` (or `./gradlew :server:run` in UNIX) in server machine
3. Run `gradlew :client:run` (or `./gradlew :client:run` in UNIX) in client machine



