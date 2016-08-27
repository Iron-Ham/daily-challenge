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
    
    //isUnique Unit Test
    func testIsUniqueWhereIsUnique() {
        let expected = true
        let word = "abdelin"
        let actual = chapterOne.isUnique(word: word)
        XCTAssertEqual(expected, actual)
    }
    
    func testIsUniqueWhereIsNotUnique() {
        let expected = false
        let word = "abdicate"
        let actual = chapterOne.isUnique(word: word)
        XCTAssertEqual(expected, actual)
    }
    
    // Palindrome Unit Tests
    func testIsPalindromeWhereIsPalindrome_SwiftString() {
        let word = "t caotac"
        let expected = true
        var actual = false
        measure {
            actual = self.chapterOne.isPalindrome(word: word)
        }
        XCTAssertEqual(expected, actual)
    }
    
    func testIsPalindromeWhereIsPalindrome_NSString() {
        let word = "t caotac"
        let expected = true
        var actual = false
        measure {
            actual = self.chapterOne.isPalindrome_NSString(word: word)
        }
        XCTAssertEqual(expected, actual)
    }
    
    func testIsPalindromeWhereIsPalindrome_Alt() {
        let word = "t caotac"
        let expected = true
        var actual = false
        measure {
            actual = self.chapterOne.isPalindrome_Alt_WithArray(word: word)
        }
        XCTAssertEqual(expected, actual)
    }
    
    func testIsPalindromeWhereIsNotPalindrome_SwiftString() {
        let word = "t caotaec"
        let expected = false
        var actual = false
        measure {
            actual = self.chapterOne.isPalindrome(word: word)
        }
        XCTAssertEqual(expected, actual)
    }
    
    func testIsPalindromeWhereIsNotPalindrome_NSString() {
        let word = "t caotace"
        let expected = false
        var actual = false
        measure {
            actual = self.chapterOne.isPalindrome_NSString(word: word)
        }
        XCTAssertEqual(expected, actual)
    }
    
    func testIsPalindromeWhereIsNotPalindrome_Alt() {
        let word = "t caotace"
        let expected = false
        var actual: Bool = false
        measure {
             actual = self.chapterOne.isPalindrome_Alt_WithArray(word: word)
        }
        
        XCTAssertEqual(expected, actual)
    }
    
    // Palindrome Performance Stress Tests
    func testPalindrome_SwiftString() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        self.measure {
            self.chapterOne.isPalindrome(word: word)
        }
    }
    
    func testPalindrome_Alt_WithArray() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        self.measure {
            self.chapterOne.isPalindrome_Alt_WithArray(word: word)
        }
    }
    
    func testPalindrome_NSString() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        let w = word
        self.measure {
            self.chapterOne.isPalindrome_NSString(word: w)
        }
    }
  
    func testPalindrome_SwiftStringx10() {
        var word = ""
        100000.times {
            word += "0123456789"
        }
        self.measure {
            self.chapterOne.isPalindrome(word: word)
        }
    }
    
    func testPalindrome_Alt_WithArrayx10() {
        var word = ""
        100000.times {
            word += "0123456789"
        }
        self.measure {
            self.chapterOne.isPalindrome_Alt_WithArray(word: word)
        }
    }
    
    func testPalindrome_NSStringx10() {
        var word = ""
        100000.times {
            word += "0123456789"
        }
        let w = word
        self.measure {
            self.chapterOne.isPalindrome_NSString(word: w)
        }
    }
    
    // Only NSString will scale to this point -- and will still do it
    // faster than the methods using Swift String at the previous benchmark
    func testPalindrome_NSStringx100() {
        var word = ""
        1000000.times {
            word += "0123456789"
        }
        let w = word
        self.measure {
            self.chapterOne.isPalindrome_NSString(word: w)
        }
    }
}


extension Int {
    func times(_ operation: () -> Void) {
        for _ in 0..<self {
            operation()
        }
    }
}
