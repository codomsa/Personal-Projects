import os
import socket

HOST = '0.0.0.0'
PORT = 65432

def base10_to_base2(num):
    return bin(num)[2:]

def handle_client(cs, addr):
    print('Connected by', addr)
    while True:
        data = cs.recv(1024)
        if not data:
            break
        try:
            num = int(data.decode())
            result = base10_to_base2(num)
            cs.sendall(str.encode(result))
        except NameError:
            cs.sendall(str.encode("Error: Invalid input. Please enter a numeric value."))
    print('Disconnected by', addr)
    cs.close()

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen(10)
print('Server started. Listening on', (HOST, PORT))
while True:
    cs, addr = s.accept()
    childpr = os.fork()
    if childpr == 0:
        s.close()
        handle_client(cs, addr)
        cs.close()
        os._exit(0)
    else:
        cs.close()