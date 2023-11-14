import sys
input = sys.stdin.readline
import queue as q

N = int(input())

queue = q.Queue()

for i in range(N):
    order = input().split()
    if order[0] == 'push':
        queue.put(order[1])
    elif order[0] == 'pop':
        if queue.qsize() == 0:
            print('-1')
        else: print(queue.get())
    elif order[0] == 'size':
        print(queue.qsize())
    elif order[0] == 'empty':
        if queue.qsize() == 0:
            print('1')
        else:print('0')
    elif order[0] == 'front':
        if queue.qsize() == 0:
            print('-1')
        else:print(queue.queue[0])
    elif order[0] == 'back':
        if queue.qsize() == 0:
            print('-1')
        else:print(queue.queue[-1])