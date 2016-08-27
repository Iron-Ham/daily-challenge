//
//  chapter1.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/27/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation

struct ChapterOne {
    // ASCII only
    func isUnique(word: String) -> Bool {
        let sizeOfCharSet = 128
        if (word.characters.count) > sizeOfCharSet { return false }
        return Set(word.characters.map { $0 }).count == word.characters.count ? true : false
    }
    // ASCII Only
    func isPalindrome(word: String) -> Bool {
        let word = word.lowercased().replacingOccurrences(of: " ", with: "")
        let wordIsOdd = word.characters.count % 2 != 0
        var count = [Int](repeating: 0, count: 128)
        word.characters.forEach { count[Int($0.unicodeScalarCodePoint())] += 1 }
        let oddsCount = count.filter { $0 % 2 == 1 }.reduce(0) { $0 + $1 }
        return wordIsOdd ? oddsCount == 1 : oddsCount == 0
    }
    // ASCII Only
    func isPalindrome_Alt_WithArray(word: String) -> Bool {
        let word = word.lowercased().replacingOccurrences(of: " ", with: "")
        var numOdds = 0
        var count = [Int](repeating: 0, count: 128)
        word.characters.forEach { count[Int($0.unicodeScalarCodePoint())] += 1 }
        
        for c in count where c % 2 != 0 {
            if numOdds == 1 { return false }
            numOdds += 1
        }
        return true
    }
    // ASCII Only
    func isPalindrome_NSString(word: String) -> Bool {
        let word = word.lowercased().replacingOccurrences(of: " ", with: "") as NSString
        var count = [Int](repeating: 0, count: 128)
        for i in 0..<word.length {
            count[Int(word.character(at: i))] += 1
        }
        
        var numOdds = 0
        for c in count where c % 2 != 0 {
            if numOdds == 1 { return false }
            numOdds += 1
        }
        return true
    }
    
    func urlify(word: String) -> String {
        return word.replacingOccurrences(of: " ", with: "%20")
    }
    
    func isPermutation(ofString: String, string: String) -> Bool {
        if string.characters.count != ofString.characters.count { return false }
        return Set(string.characters).count == Set(ofString.characters).count
    }
    
    func isOneEditAway(fromString: String, string: String) -> Bool {
        if abs(fromString.characters.count - string.characters.count) > 1 { return false }
        var i = 0, j = 0, numDifferences = 0
        let fromString = fromString as NSString, string = string as NSString
        while i < fromString.length && j < string.length {
            if fromString.character(at: i) != string.character(at: j) {
                numDifferences += 1
                if fromString.length > string.length { j -= 1 }
                else if fromString.length < string.length { i -= 1 }
            }
            if numDifferences > 1 { return false }
            i += 1
            j += 1
        }
        return true
    }
    
}

extension Character
{
    func unicodeScalarCodePoint() -> UInt32
    {
        let characterString = String(self)
        let scalars = characterString.unicodeScalars
        
        return scalars[scalars.startIndex].value
    }
}
