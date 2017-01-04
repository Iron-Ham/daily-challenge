//
//  TreeNode.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


/// A node for use in a tree or graph
class TreeNode<T> {
    var data: T
    var children = [TreeNode<T>]()

    init(data: T) {
        self.data = data
    }


    /// Adds single node to children array
    ///
    /// - Parameter child: TreeNode
    func add(child: TreeNode) {
        children.append(child)
    }


    /// Convenience method to add multiple children to children array
    ///
    /// - Parameter children: [TreeNode]
    func add(children: [TreeNode]) {
        self.children.append(contentsOf: children)
    }
}
