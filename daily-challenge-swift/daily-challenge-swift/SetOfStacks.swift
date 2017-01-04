//
//  SetOfStacks.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


/// A self-sizing collection of size limited stacks
class SetOfStacks<T> {
    private var stacks = [Stack<T>]()


    /// The maximum size of each stack in the collection
    let maximumSize: Int


    /// Initializes the collection with a default size of 5 for each internal stack
    ///
    /// - Parameter maximumSize: the maximum size of each stack in the collection
    init(maximumSize: Int = 5) {
        self.maximumSize = maximumSize
    }


    /// Pushes onto the first stack with an empty space, or creates a new one
    ///
    /// O(1)
    /// - Parameter item: T
    func push(item: T) {
        if stacks.isEmpty {
            stacks.append(Stack<T>())
        }
        var stack = stacks.first { $0.count < self.maximumSize }
        if stack == nil {
            stacks.append(Stack<T>())
            stack = stacks.last
        }
        stack?.push(data: item)
    }


    /// Pops an item from the last stack that isn't empty.
    ///
    /// O(n)
    /// - Returns: T
    func pop() -> T? {
        for i in stride(from: stacks.count - 1, through: 0, by: -1) {
            if !stacks[i].isEmpty() {
                return stacks[i].pop()
            }
        }
        return nil
    }


    /// Pops an item from the stack at the specified index
    /// Compresses items into the minimum number of stacks afterwards
    /// in order to maintain stack behavior
    ///
    /// O(1)
    /// - Parameter index: Int, index of the stack to remove the item from
    /// - Returns: T
    func pop(at index: Int) -> T? {
        guard index < stacks.count, stacks[index].count > 0 else { return nil }
        let value = stacks[index].pop()
        compress(at: index)
        return value
    }


    /// Returns the item from the last internal stack that isn't empty without removing it.
    ///
    /// O(n)
    /// - Returns: T
    func peek() -> T? {
        for i in stride(from: stacks.count - 1, through: 0, by: -1) {
            if !stacks[i].isEmpty() {
                return stacks[i].peek()
            }
        }
        return nil
    }


    /// Returns whether or not all internal stacks are empty.
    ///
    /// O(n)
    /// - Returns: Bool
    func isEmpty() -> Bool {
        return stacks.map({ $0.isEmpty() }).count == stacks.count
    }


    /// Recursively compresses the collection by using a temporary stack to move elements
    /// added later to their respective positions
    ///
    /// - Parameter index: the index where an out-of-order pop was carried out
    private func compress(at index: Int) {
        compress(at: index, next: index + 1)
    }


    /// Recursively compresses the collection by using a temporary stack to move elements
    /// added later to their respective positions
    ///
    /// - Parameters:
    ///   - current: The current index of the stack being operated on
    ///   - next: The index of the next stack to borrow elements from
    private func compress(at current: Int, next: Int) {
        if next == stacks.count { return }
        let stack = Stack<T>()
        while !stacks[next].isEmpty() {
            stack.push(data: stacks[next].pop()!)
        }
        while stacks[current].count < maximumSize, !stack.isEmpty() {
            stacks[current].push(data: stack.pop()!)
        }

        while !stack.isEmpty() {
            stacks[next].push(data: stack.pop()!)
        }
        compress(at: next, next: next + 1)
    }
    
}

