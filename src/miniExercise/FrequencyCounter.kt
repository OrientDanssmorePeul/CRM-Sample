package com.example.crm.app.miniExercise

class FrequencyCounter {
    /**
     * Counts frequency of each character in a string.
     *
     * Rules:
     * - Case insensitive (A == a)
     * - DO NOT allow spaces (will throw exception)
     *
     * Example:
     * Input: "aabccc"
     * Output: {a=2, b=1, c=3}
     */
    fun countFrequency(text: String): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        if(text == ""){
            throw IllegalArgumentException("Input cannot be blank")
        }
        for(char in text){
            if(char == ' '){
                throw IllegalArgumentException("Input cannot contain spaces")
            }
            result[char] = result.getOrDefault(char, 0) + 1
            println(result)
        }
        return result
    }
}