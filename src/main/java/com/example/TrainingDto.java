/*
* File: TrainingDto.java
* Author: Nagy János
* Copyright: 2026, Nagy János
* Group: szit
* Date: 2026-11-19
* Github: https://github.com/oktatrefakt/retrainingplan
* Licenc: MIT
*/

package com.example;

public class TrainingDto {
    String date;
    String timeOfDay;
    String training;
    public TrainingDto(String date, String timeOfDay, String training) {
        this.date = date;
        this.timeOfDay = timeOfDay;
        this.training = training;
    }
}
