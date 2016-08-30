//
//  SumLists.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/29/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation

struct SumLists {
    // Two numbers represented by a linked list where each node contains a single digit.
    // The digits are stored in reverse order, such that the 1's digit is at the head of
    // the list. Write a function that adds the two numbers and returns the sum as a linked list.
    
    func sumLists_ReverseOrder(listOne: LinkedListNode?, listTwo: LinkedListNode?) -> LinkedListNode {
        var sum = 0
        if let one = listOne?.value {
            sum += one
        }
        
        if let two = listTwo?.value {
            sum += two
        }
        
        let carry = sum / 10
        let head = LinkedListNode(value: sum % 10)
        
        sumList(currentNode: head, listOne: listOne?.next, listTwo: listTwo?.next, carry: carry)
        return head
    }
    
    private func sumList(currentNode: LinkedListNode, listOne: LinkedListNode?, listTwo: LinkedListNode?, carry: Int) {
        if listOne == nil && listTwo == nil {
            return
        }
        var sum = carry
        if let one = listOne?.value {
            sum += one
        }
        
        if let two = listTwo?.value {
            sum += two
        }
        let carry = sum / 10
        let node = LinkedListNode(value: sum % 10)
        currentNode.next = node
        sumList(currentNode: node, listOne: listOne?.next, listTwo: listTwo?.next, carry: carry)
    }
    
    // TODO :: 
    // What if they were stored in forward order?
    
}
