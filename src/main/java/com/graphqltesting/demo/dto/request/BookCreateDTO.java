package com.graphqltesting.demo.dto.request;

import java.util.List;

public record BookCreateDTO(String title, int publicationYear, List<Long> authorIds) {

}
