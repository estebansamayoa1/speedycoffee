from flask import Flask, render_template, request, url_for, redirect
from jinja2 import Template, FileSystemLoader, Environment
from typing import Dict, Text
import Client
import Coffee
import dataBase

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"] )
def register ():
    name = request.args.get("name", "")
    phone = request.args.get("phone", "")
    email = request.args.get("email", "")
    user = request.args.get("user", "")
    password = request.args.get("name", "")
    store = request.args.get("store", "")
    newClient = Client(user, name, phone, email, store, password, 0)
    #setNewClient(newClient) que se mande a un diccionario


@app.route("/login", methods=["GET", "POST"] )
def login ():
    user = request.args.get("user", "")
    password = request.args.get("name", "")
    #que se vaya al diccionario a buscar al cliente y comparar user y password
    #redirect a /home/user

#<user> es la variable pq cada pagina del home depende de que user este ingresado
@app.route("/home/<user>", methods=["GET", "POST"])
def home():
    pass

if __name__ == "__main__":
    app.run(host="0.0.0.0",debug=True)
