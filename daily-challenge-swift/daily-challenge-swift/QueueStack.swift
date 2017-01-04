//
//  QueueStack.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


/// A queue composed of two stacks
class QueueStack<T> {

    private var new = Stack<T>()
    private var old = Stack<T>()


    /// Adds item to the queue by adding it to the `new` stack
    /// O(1)
    /// - Parameter item: T
    func add(item: T) {
        new.push(data: item)
    }


    /// Removes the oldest item in the queue
    /// O(n) while `old` is empty, otherwise O(1)
    /// - Returns: T
    func remove() -> T? {
        shiftNewToOld()
        return old.peek()
    }


    /// Shows the oldest item in the queue without removing it
    /// O(n) while `old` is empty, otherwise O(1)
    /// - Returns: T
    func peek() -> T? {
        shiftNewToOld()
        return old.peek()
    }


    /// Returns whether both internal stacks are empty
    /// O(1)
    /// - Returns: Bool
    func isEmpty() -> Bool {
        return new.isEmpty() && old.isEmpty()
    }


    /// Lazily shifts items from new to old
    /// O(n)
    private func shiftNewToOld() {
        if old.isEmpty() {
            while !new.isEmpty() {
                old.push(data: new.pop()!)
            }
        }
    }
    
}
