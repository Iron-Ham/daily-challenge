//
//  PathFinder.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


extension TreeNode {


    /// A direction-agnostic convenience method to find a path between two nodes
    ///
    /// - Parameter node: target node
    /// - Returns: Bool
    func routeExists(between node: TreeNode) -> Bool {
        return route(from: self, to: node) || route(from: node, to: self)
    }


    /// A method to find if a path exists between the `from` node and
    /// the `to` node.
    ///
    /// - Parameters:
    ///   - from: start node
    ///   - to: end node
    /// - Returns: Bool
    private func route(from: TreeNode, to: TreeNode) -> Bool {
        let nodeQueue = Queue<TreeNode>()
        nodeQueue.add(item: from)

        while !nodeQueue.isEmpty() {
            let node = nodeQueue.remove()!
            if node === to {
                return true
            }
            for child in node.children {
                nodeQueue.add(item: child)
            }
        }
        return false
    }
}

