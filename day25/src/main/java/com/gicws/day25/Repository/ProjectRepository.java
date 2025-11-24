package com.gicws.day25.Repository;

import com.gicws.day25.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects,Long> {
}
