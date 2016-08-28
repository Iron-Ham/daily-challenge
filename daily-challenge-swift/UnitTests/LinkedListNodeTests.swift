//
//  LinkedListNodeTests.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/27/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation
import XCTest


class LinkedListNodeTests: XCTestCase {
    let node = LinkedListNode(value: 5)
    
    func testAppendToEnd() {
        let newNode = LinkedListNode(value: 3)
        node.appendToEnd(node: newNode)
        let newerNode = LinkedListNode(value: 5)
        node.appendToEnd(node: newerNode)
        let p = node.next
        let q = p!.next
        XCTAssertEqual(newNode, p)
        XCTAssertEqual(newerNode, q)
    }
    
    func testEquality() {
        var newNode = LinkedListNode(value: 5)
        XCTAssertEqual(newNode, node)
        node.appendToEnd(node: newNode)
        XCTAssertNotEqual(node, newNode)
    }
}
