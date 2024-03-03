package AISD;

import java.util.NoSuchElementException;

public class CircularQueue {
    int size;
    int capacity;
    int [] queue;
    int front;
    int rear;
    public CircularQueue(int capacity){
        this.capacity = capacity;
        queue = new int [capacity];
    }

    public boolean isFull(){
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            throw new NoSuchElementException();
        }

        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
}
