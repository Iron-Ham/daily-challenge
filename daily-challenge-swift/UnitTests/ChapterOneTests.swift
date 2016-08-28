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
    // Xcode 7 + Swift 2.2 runs this @ 0.155s
    // Swift 3 & Xcode 8-beta6 @ 0.090s
    func testPalindrome_SwiftString() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        measure {
            self.chapterOne.isPalindrome(word: word)
        }
    }
    
    // Xcode 7 + Swift 2.2 runs this @ 0.136s
    // Swift 3 & Xcode 8-beta6 @ 0.080s
    func testPalindrome_Alt_WithArray() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        measure {
            self.chapterOne.isPalindrome_Alt_WithArray(word: word)
        }
    }
    
    func testPalindrome_NSString() {
        var word = ""
        10000.times {
            word += "0123456789"
        }
        let w = word
        measure {
            self.chapterOne.isPalindrome_NSString(word: w)
        }
    }
  
    func testPalindrome_SwiftStringx10() {
        var word = ""
        100000.times {
            word += "0123456789"
        }
        measure {
            self.chapterOne.isPalindrome(word: word)
        }
    }
    
    func testPalindrome_Alt_WithArrayx10() {
        var word = ""
        100000.times {
            word += "0123456789"
        }
        measure {
            self.chapterOne.isPalindrome_Alt_WithArray(word: word)
        }
    }
    
    func testPalindrome_NSStringx10() {
        var word = ""
        100000.times {
            word += "0123456789"
        }
        let w = word
        measure {
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
        measure {
            self.chapterOne.isPalindrome_NSString(word: w)
        }
    }
    
    // IsPermutationOfString UnitTests
    func testIsPermutationOfStringWhereIsPermutation() {
        let expected = true
        let wordOne = "y ellow", wordTwo = "wolyel"
        let actual = chapterOne.isPermutation(ofString: wordOne, string: wordTwo)
        XCTAssertEqual(expected, actual)
    }
    
    func testIsPermutationOfStringWhereIsNotPermutation() {
        let expected = false
        let wordOne = "magic city", wordTwo = "hippies"
        let actual = chapterOne.isPermutation(ofString: wordOne, string: wordTwo)
        XCTAssertEqual(expected, actual)
    }
    
    
    // IsOneEditAway UnitTests
    func testIsOneEditAwayWhereIsOneEditAway() {
        let expected = true
        let wordOne = "brasil", wordTwo = "brazil"
        let actual = chapterOne.isOneEditAway(fromString: wordOne, string: wordTwo)
        XCTAssertEqual(expected, actual)
    }
    
    func testIsOneEditAwayWhereIsNotOneEditAway() {
        let expected = false
        let wordOne = "espana", wordTwo = "spain"
        let actual = chapterOne.isOneEditAway(fromString: wordOne, string: wordTwo)
        XCTAssertEqual(expected, actual)
    }
    
    // CompressString UnitTests 
    func testCompress() {
        let word = "aaaaaaaaaa"
        let expected = "a10"
        let actual = chapterOne.compress(string: word)
        XCTAssertEqual(expected, actual)
    }
    
    func testCompressReturns() {
        let word = "abc"
        let expected = "abc"
        let actual = chapterOne.compress(string: word)
        XCTAssertEqual(expected, actual)
    }
    
    func testStringRotation() {
        let ofString = "erbottlewat", string = "waterbottle"
        let expected = true
        let actual = chapterOne.stringRotation(ofString: ofString, string: string)
        XCTAssertEqual(expected, actual)
    }
    
    func testZeroMatrix() {
        let matrix = [
            [1, 0, 3, 4],
            [0, 9, 8, 7],
            [2, 4, 6, 5],
            [1, 1, 1, 1]
        ]
        
        let expected = [
            [0, 0, 0, 0],
            [0, 0, 0, 0],
            [0, 0, 6, 5],
            [0, 0, 1, 1]
        ]
        
        let actual = chapterOne.zeroMatrix(matrix: matrix)
        
        for i in 0..<expected.count {
            for j in 0..<expected[0].count {
                XCTAssertEqual(expected[i][j], actual[i][j])
            }
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
