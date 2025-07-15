package com.graphqltesting.demo.dto.response;

import java.util.List;

public record BookResponseDTO(Long id, String title, int publicationYear, List<AuthorResponseDTO> authors) {

}
