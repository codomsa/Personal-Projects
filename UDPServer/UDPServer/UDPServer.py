import socket

UDP_HOST = "127.0.0.1"
UDP_PORT = 5678


sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)


sock.bind((UDP_HOST, UDP_PORT))

print("Server started on {}:{}".format(UDP_HOST, UDP_PORT))

while True:
    
    data, addr = sock.recvfrom(1024)
    print("Received message: {}:{}".format(data.decode(), addr))

    
    response = "Message received".encode()
    sock.sendto(response, addr)
