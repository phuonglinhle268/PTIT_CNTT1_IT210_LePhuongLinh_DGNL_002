package org.example.java_web_dgnl1_002.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java_web_dgnl1_002.model.Artifact;
import org.example.java_web_dgnl1_002.repository.ArtifactRepository;
import org.example.java_web_dgnl1_002.service.ArtifactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtifactServiceImpl implements ArtifactService {
    private final ArtifactRepository repository;

    @Override
    public Page<Artifact> getAll(String keyword, Pageable pageable){

        if (keyword != null && !keyword.isEmpty()){
            return repository.findByNameContainingIgnoreCaseOrOriginContainingIgnoreCase
                    (keyword, keyword, pageable);
        }
        return repository.findAll(pageable);
    }

    @Override
    public void save(Artifact artifact){
        repository.save(artifact);
    }

    @Override
    public Artifact findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
