import socket
import struct

host = socket.gethostbyname(socket.gethostname())

sniffer = socket.socket(
    socket.AF_INET,
    socket.SOCK_RAW,
    socket.IPPROTO_IP
)

sniffer.bind((host, 0))

sniffer.setsockopt(
    socket.IPPROTO_IP,
    socket.IP_HDRINCL,
    1
)

sniffer.ioctl(socket.SIO_RCVALL, socket.RCVALL_ON)

print("Network Sniffer Started...")
print("Listening on:", host)

while True:

    raw_data, addr = sniffer.recvfrom(65535)

    ip_header = raw_data[0:20]

    iph = struct.unpack('!BBHHHBBH4s4s', ip_header)

    protocol = iph[6]

    src_ip = socket.inet_ntoa(iph[8])
    dst_ip = socket.inet_ntoa(iph[9])

    if protocol == 1:
        protocol_name = "ICMP"
    elif protocol == 6:
        protocol_name = "TCP"
    elif protocol == 17:
        protocol_name = "UDP"
    else:
        protocol_name = str(protocol)

    print("\n======================")
    print("Source IP:", src_ip)
    print("Destination IP:", dst_ip)
    print("Protocol:", protocol_name)