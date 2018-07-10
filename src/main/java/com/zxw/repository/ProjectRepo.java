package com.zxw.repository;

import com.zxw.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
}
