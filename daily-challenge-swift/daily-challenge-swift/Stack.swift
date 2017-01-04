//
//  Stack.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


/// A standard, data-type agnostic stack
class Stack<T> {

    private var top: Node<T>?

    /// The size of the array. Works like the `count` property of an array.
    var count: Int = 0

    /// Pops the top of the stack
    ///
    /// O(1)
    /// - Returns: data of type T or nil if stack is empty
    func pop() -> T? {
        guard let top = top else { return nil }
        self.top = top.next
        count -= 1
        return top.data
    }


    /// Pushes new value to the top of the stack
    ///
    /// O(1)
    /// - Parameter data: T
    func push(data: T) {
        count += 1
        self.top = Node(data: data, next: self.top)
    }


    /// Returns the value at the top of the stack without removing it
    ///
    /// O(1)
    /// - Returns: T
    func peek() -> T? {
        return top?.data
    }


    /// Returns whether or not the stack is empty
    ///
    /// O(1)
    /// - Returns: Bool
    func isEmpty() -> Bool {
        return top == nil
    }
    
}
