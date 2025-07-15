package com.graphqltesting.demo.dto.request;

import java.util.List;

public record BookUpdateDTO(String title, int publicationYear, List<Long> authorIds) {

}
