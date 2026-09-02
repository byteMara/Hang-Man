# Simple Console Hangman Game

A lightweight, terminal-based Hangman game written in Java. This project was built as a prototype and beginner exercise to practice core Object-Oriented Programming (OOP) concepts, file I/O operations, and basic game logic.

## Features

* **Multiple Categories:** Choose from three word categories (Cars, Phones, or Video Game Characters).
* **Randomized Word Selection:** Each category dynamically selects a target word per session.
* **External Dictionary Validation:** Integrates a local text file (`words.txt`) to check and validate user guesses.
* **Trial Tracking:** Real-time feedback on remaining attempts and current word progress.

## Class Structure

* `Main`: Handles initial user input and navigates to the selected game category.
* `GameDictionary`: Reads `words.txt` into a `HashSet` to validate player input.
* `Cars`, `Phones`, `Characters`: Category classes containing game submenus and word-guessing loops.

## Setup & Running

1. **Prerequisites:** Ensure Java Development Kit (JDK) 21 or higher is installed on your system.
2. **Dictionary File:** Ensure the `words.txt` file is located in the root directory where the program runs.
3. **Compilation:**
   ```bash
   javac Main.java
