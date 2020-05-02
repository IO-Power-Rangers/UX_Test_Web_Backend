package com.uxtest.backend.repository;

import com.uxtest.backend.model.uxmodel.UxModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.URL;

public interface UxModelRepository extends JpaRepository<UxModel, URL> {
}
