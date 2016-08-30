//
//  SumListsTests.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/29/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation
import XCTest

class SumListsTests: XCTestCase {
    let sumLists = SumLists()
    
    func testSumLists_ReverseOrder() {
        let l1 = LinkedListNode(value: 7)
        l1.appendToEnd(node: LinkedListNode(value: 1))
        l1.appendToEnd(node: LinkedListNode(value: 6))
        
        let l2 = LinkedListNode(value: 5)
        l2.appendToEnd(node: LinkedListNode(value: 9))
        l2.appendToEnd(node: LinkedListNode(value: 2))
        
        var expected: LinkedListNode? = LinkedListNode(value: 2)
        expected?.appendToEnd(node: LinkedListNode(value: 1))
        expected?.appendToEnd(node: LinkedListNode(value: 9))
        
        var actual: LinkedListNode? = sumLists.sumLists_ReverseOrder(listOne: l1, listTwo: l2)
        
        while (expected != nil && actual != nil) {
            XCTAssertEqual(expected, actual)
            expected = expected?.next
            actual = actual?.next
        }
    }
}
