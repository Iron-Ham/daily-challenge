//
//  chapter1.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 8/27/16.
//  Copyright © 2016 Hesham Salman. All rights reserved.
//

import Foundation

struct ChapterOne {
    
    func isUnique(word: String) -> Bool {
        let sizeOfCharSet = 128
        if (word.characters.count) > sizeOfCharSet { return false }
        return Set(word.characters.map { $0 }).count == word.characters.count ? true : false
    }
    
    // schwifty
    func isPalindrome(word: String) -> Bool {
        let word = word.lowercaseString.stringByReplacingOccurrencesOfString(" ", withString: "")
        let wordIsOdd = word.characters.count % 2 != 0
        var characterCount = [Character: Int]()
        word.characters.forEach { (c) in characterCount[c] = characterCount[c] ?? 0 + 1 }
        let oddsCount = characterCount.values.filter { $0 % 2 == 1 } .reduce(0) { (total, number) in total + number }
        return wordIsOdd ? oddsCount == 1 : oddsCount == 0
    }
    
    func isPalindrome_Alt_WithArray(word: String) -> Bool {
        let word = word.lowercaseString.stringByReplacingOccurrencesOfString(" ", withString: "")
        var numOdds = 0
        var count = [Int](count: 128, repeatedValue: 0)
        word.characters.forEach { count[Int(String($0))!] += 1 }
        
        for c in count where c % 2 != 0 {
            if numOdds == 1 { return false }
            numOdds += 1
        }
        return true
    }
    
}