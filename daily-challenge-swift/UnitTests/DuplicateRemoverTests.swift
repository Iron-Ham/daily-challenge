//
//  DuplicateRemoverTests.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/28/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation
import XCTest

class DuplicateRemoverTests: XCTestCase {
    let duplicateRemover = DuplicateRemover()
    
    func testRemoveDuplicates_All() {
        let head = LinkedListNode(value: 3)
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 3))
        
        let expected = LinkedListNode(value: 3)
        duplicateRemover.removeDuplicates(fromHead: head)
        XCTAssertEqual(expected, head)
    }
    
    func testRemoveDuplicates_Interspersed() {
        let head = LinkedListNode(value: 3)
        head.appendToEnd(node: LinkedListNode(value: 5))
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 5))
        head.appendToEnd(node: LinkedListNode(value: 3))
        
        let expected = LinkedListNode(value: 3)
        expected.appendToEnd(node: LinkedListNode(value: 5))
        duplicateRemover.removeDuplicates(fromHead: head)
        XCTAssertEqual(expected, head)
    }
    
    func testRemoveDuplicatesWithoutSet_All() {
        let head = LinkedListNode(value: 3)
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 3))
        
        let expected = LinkedListNode(value: 3)
        duplicateRemover.removeDuplicatesWithoutSet(fromHead: head)
        XCTAssertEqual(expected, head)
    }
    
    func testRemoveDuplicatesWithoutSet_Interspersed() {
        let head = LinkedListNode(value: 3)
        head.appendToEnd(node: LinkedListNode(value: 5))
        head.appendToEnd(node: LinkedListNode(value: 3))
        head.appendToEnd(node: LinkedListNode(value: 5))
        head.appendToEnd(node: LinkedListNode(value: 3))
        
        let expected = LinkedListNode(value: 3)
        expected.appendToEnd(node: LinkedListNode(value: 5))
        duplicateRemover.removeDuplicatesWithoutSet(fromHead: head)
        XCTAssertEqual(expected, head)
    }
}
