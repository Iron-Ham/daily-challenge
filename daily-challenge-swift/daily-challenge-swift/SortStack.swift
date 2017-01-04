//
//  SortStack.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation

extension Stack where T: Comparable {
    /// Sorts the stack by using one temporary stack. With more stacks, we could perform
    /// a modified merge sort or modified quick sort.
    /// O(n^2)
    func sort() {
        let tmpStack = Stack<T>()
        while !isEmpty() {
            let tmp = pop()!
            while (!tmpStack.isEmpty() && tmp < tmpStack.peek()!) {
                push(data: tmpStack.pop()!)
            }
            tmpStack.push(data: tmp)
        }
        while !tmpStack.isEmpty() {
            push(data: tmpStack.pop()!)
        }
    }
}
