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
    
    func isPalindrome(word: String) -> Bool {
        let word = word.lowercaseString
        let wordIsOdd = word.characters.count % 2 != 0
        var characterCount = [Character: Int]()
        word.characters.forEach { (c) in characterCount[c] = characterCount[c] ?? 0 + 1 }
        let oddsCount = characterCount.values.filter { $0 % 2 == 1 } .reduce(0) { (total, number) in total + number }
        return wordIsOdd ? oddsCount == 1 : oddsCount == 0
    }
    
}