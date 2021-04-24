#!/usr/bin/env bash

rm truststore.jks user.p12

oc extract secret/my-cluster-cluster-ca-cert --keys=ca.crt --to=- > ca.crt

echo "yes" | keytool -import -trustcacerts -file ca.crt -keystore truststore.jks -storepass test1234 -alias CARoot

rm user.crt user.key ca.crt