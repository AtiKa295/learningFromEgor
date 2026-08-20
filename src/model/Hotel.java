package model;

import java.util.UUID;

public record Hotel(
        UUID id,
        String name,
        String city
) {
}