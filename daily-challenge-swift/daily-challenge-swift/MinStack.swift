//
//  MinStack.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


/// A stack which supplies a `min()` method that returns the minimum value in the stack
/// in constant time.
/// Only accepts types that implement `Comparable`
class MinStack<T: Comparable>: Stack<T> {
    private var minStack: Stack<T> = Stack()


    /// Pushes the value onto the internal minimum stack if the value is smaller.
    ///
    /// Also pushes onto the standard, accessible stack.
    /// O(1)
    /// - Parameter data: T
    override func push(data: T) {
        if minStack.peek() == nil {
            minStack.push(data: data)
        } else if let min = minStack.peek(), data < min {
            minStack.push(data: data)
        }
        super.push(data: data)
    }


    /// Returns the value at the top of the stack, removing it from the minimum stack if
    /// applicable
    /// O(1)
    /// - Returns: T
    override func pop() -> T? {
        if let peek = self.peek(), let minPeek = minStack.peek(), peek == minPeek {
            minStack.pop()
        }
        return super.pop()
    }


    /// Returns the smallest item in the stack
    ///
    /// O(1)
    /// - Returns: T
    func min() -> T? {
        return minStack.peek()
    }
    
}
