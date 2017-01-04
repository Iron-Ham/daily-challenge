//
//  AnimalShelter.swift
//  daily-challenge-swift
//
//  Created by Hesham Salman on 1/3/17.
//  Copyright © 2017 Hesham Salman. All rights reserved.
//

import Foundation


protocol Animal {
    var date: Date { get }
}

struct Dog: Animal {
    var date: Date = Date()
}

struct Cat: Animal {
    var date: Date = Date()
}


/// A struct which houses two kinds of `Animal`: `Cat` and `Dog`.
/// Functions to house these animals, and allow persons to adopt an animal.
/// Persons can choose between the oldest animal -- by length of stay in the shelter
/// -- or they can choose to adopt the oldest cat or oldest dog.
/// The shelter can also accept new pets.
struct AnimalShelter {

    var dogs = Queue<Dog>()
    var cats = Queue<Cat>()


    /// Shelters a new animal into the shelter
    ///
    /// - Parameter animal: Animal
    func shelter(animal: Animal) {
        if let dog = animal as? Dog {
            dogs.add(item: dog)
        } else if let cat = animal as? Cat {
            cats.add(item: cat)
        }
    }


    /// Returns the oldest animal by length of stay in the shelter
    /// or nil if there are no animals in the shelter
    ///
    /// - Returns: Animal
    func adoptAnimal() -> Animal? {
        guard let cat = cats.peek(), let dog = dogs.peek() else {
            return nil
        }

        return cat.date < dog.date ? cats.remove() : dogs.remove()
    }


    /// Returns the oldest cat by length of stay in the shelter
    /// or nil if there are no cats in the shelter.
    ///
    /// - Returns: Cat
    func adoptCat() -> Cat? {
        guard let cat = cats.remove() else {
            return nil
        }
        return cat
    }


    /// Returns the oldest dog by length of stay in the shelter
    /// or nil if there are no dogs in the shelter.
    ///
    /// - Returns: Dog
    func adoptDog() -> Dog? {
        guard let dog = dogs.remove() else {
            return nil
        }
        return dog
    }
    
}

