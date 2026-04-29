package org.example.java_web_dgnl1_002.service;

import org.example.java_web_dgnl1_002.model.Artifact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArtifactService {
    Page<Artifact> getAll(String keyword, Pageable pageable);

    void save(Artifact artwork);

    Artifact findById(Long id);

    void delete(Long id);
}
