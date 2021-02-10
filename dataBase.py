from redis import Redis
import os, json
import Client

db = {}

REDIS_HOST = os.getenv("REDIS_HOST", None)
conn = Redis(host=REDIS_HOST, port=6379, decode_responses=True)