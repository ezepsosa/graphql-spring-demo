package com.graphqltesting.demo.dto;

import java.util.List;

public record InsertBook(String title, int publicationYear, List<Long> authorIds) {

}
