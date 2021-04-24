#!/usr/bin/env bash
kfk topics --create --partitions 4 --replication-factor 1 --topic orders -c my-cluster -n kafka
kfk topics --create --partitions 4 --replication-factor 1 --topic queue -c my-cluster -n kafka
kfk topics --list -c my-cluster -n kafka