//
//  Node.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation

/// Linked List Node
class Node<T> {
    var next: Node?
    var data: T

    init(data: T, next: Node? = nil) {
        self.data = data
        self.next = next
    }

}

