#!/usr/bin/python

import urllib2
import sys

response = urllib2.urlopen("http://127.0.0.1:9200/_cat/health")
body = response.read()
response.close()
if "green" in body:
    sys.exit(0)
else:
    sys.exit(1)