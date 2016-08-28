//
//  LinkedListNode.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/27/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation

// Has to be a class because structs are not allowed to be self-referential
class LinkedListNode: Equatable {
    var next: LinkedListNode?
    var value: Int
    
    init(value: Int) {
        self.value = value
    }
    
    func appendToEnd(node: LinkedListNode) {
        guard var n = next else {
            next = node
            return
        }
        
        while n.next != nil { n = n.next! }
        n.next = node
    }

}

func == (lhs: LinkedListNode, rhs: LinkedListNode) -> Bool {
    if lhs.value == rhs.value && lhs.next == rhs.next {
        return true
    }
    return false
}
