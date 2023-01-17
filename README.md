# gcp-svcacct-to-accesstoken
Code to fetch an access token for a given GCP service account by using its key JSON file

# Compilation
```shell
mvn package assembly:single
```

# How to run
```shell
$ java -jar target/gcp-svcacct-to-accesstoken-1.0.0-jar-with-dependencies.jar gcp-svcacct-artifact-registry-ro-f3f233b0c9b5.json

Token is ya29.c.b0AT7lpjCFdx0Y5EsU-35pM-15P9pBc4uW4SmZuXH-MeSRcq3hdbsUV6xgmec43uvO0iXaGDhRXFw3pMVtw1rzMpux2ltrVicq4fD3N4MnXHofwA1In1b_vZ-gLZQm-fRelcdrlPp9lqGiDxU0pmVGBWNQB-N6KGvp9nw3RIvwg7uIQEpb1cYrp-99pMAs2IXyH1IL2wJMmEL3snLk8wx8s9Wi4qGNCW4........................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................
Token expiration time is Wed Jan 18 02:55:17 IST 2023
```
