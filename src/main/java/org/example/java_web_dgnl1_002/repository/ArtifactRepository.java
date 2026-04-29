package org.example.java_web_dgnl1_002.repository;

import org.example.java_web_dgnl1_002.model.Artifact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    Page<Artifact> findByNameContainingIgnoreCaseOrOriginContainingIgnoreCase(
            String name, String origin, Pageable pageable
    );
}
