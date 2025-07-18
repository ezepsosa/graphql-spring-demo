package com.graphqltesting.demo.dto.request;

import java.util.List;

public record BookUpdateDTO(Long id, String title, int publicationYear, List<Long> authorIds) {

}
