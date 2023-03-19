import socket

HOST = '0.0.0.0'
PORT = 65432

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))

while True:
    try:
        num_str = input("Enter a base 10 number: ")
        num = int(num_str)
    except NameError :
        print("Error: Invalid input. Please enter a numeric value.")
        continue

    s.sendall(str.encode(str(num)))
    data = s.recv(1024)
    result = data.decode()
    if result.startswith("Error:"):
        print(result)
    else:
        print("Base 2 representation:", str(result))

s.close()