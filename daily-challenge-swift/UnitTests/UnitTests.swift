//
//  UnitTests.swift
//  UnitTests
//
//  Created by Hesham Salman on 8/27/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import XCTest

class UnitTests: XCTestCase {
    let chapterOne = ChapterOne()
    
    func testPalindrome_Swifty() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        self.measureBlock {
            self.chapterOne.isPalindrome(word)
        }
    }
    
    func testPalindrome_Alt_WithArray() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        self.measureBlock {
            self.chapterOne.isPalindrome_Alt_WithArray(word)
        }
    }
}


extension Int {
    func times(operation: () -> Void) {
        for _ in 0..<self {
            operation()
        }
    }
}