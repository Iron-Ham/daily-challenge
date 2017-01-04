//
//  Queue.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation



/// A standard, data-type agnostic queue
class Queue<T> {

    private var head: Node<T>?
    private var tail: Node<T>?


    /// Adds an item to the tail of the queue
    ///
    /// O(1)
    /// - Parameter item: T
    func add(item: T) {
        let node = Node(data: item)
        if let tail = tail {
            tail.next = node
        }
        tail = node
        if head == nil {
            head = tail
        }
    }


    /// Removes the item at the head of the queue
    ///
    /// O(1)
    /// - Returns: T
    func remove() -> T? {
        guard let head = head else { return nil }
        self.head = head.next
        return head.data
    }


    /// Shows the item at the head of the queue without removing it
    ///
    /// O(1)
    /// - Returns: T
    func peek() -> T? {
        return head?.data
    }


    /// Shows whether or not the queue is empty, based on the value of the queue's `head`
    ///
    /// O(1)
    /// - Returns: Bool
    func isEmpty() -> Bool {
        return head == nil
    }
    
}
