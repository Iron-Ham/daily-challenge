//
//  RemoveDuplicates.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/27/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation

/// Remove Duplicates:
/// Write code to remove duplicates from an unsorted linked list.
/// What if you can't use a temporary buffer?

struct DuplicateRemover {
    func removeDuplicates(fromHead head: LinkedListNode) {
        var integerSet = Set<Int>()
        var node: LinkedListNode = head
        
        while (node.next != nil) {
            integerSet.insert(node.value)
            if let value = node.next?.value, integerSet.contains(value) {
                node.next = node.next?.next
            } else if let next = node.next {
                node = next
            }
        }
    }
    
    func removeDuplicatesWithoutSet(fromHead head: LinkedListNode) {
        var head = head
        while (head.next != nil) {
            var runner: LinkedListNode? = head
            while (runner != nil) {
                if runner?.next?.value == head.value {
                    runner?.next = runner?.next?.next
                } else {
                    runner = runner?.next
                }
            }
            
            if let next = head.next {
                head = next
            }
        }
    }
}
