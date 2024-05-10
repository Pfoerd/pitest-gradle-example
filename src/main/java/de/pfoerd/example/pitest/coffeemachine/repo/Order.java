package de.pfoerd.example.pitest.coffeemachine.repo;

import java.time.LocalDate;

public record Order(String name, LocalDate date) {
}
