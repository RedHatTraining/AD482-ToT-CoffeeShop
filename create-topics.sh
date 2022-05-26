#!/usr/bin/env bash

#In order to use the following commands you have to install Strimzi Kafka CLI
# with the following command that uses Python package installer.
# sudo pip install strimzi-kafka-cli

kfk topics --create --partitions 4 --replication-factor 1 --topic orders -c my-cluster -n coffee-shop
kfk topics --create --partitions 4 --replication-factor 1 --topic queue -c my-cluster -n coffee-shop
kfk topics --list -c my-cluster -n coffee-shop