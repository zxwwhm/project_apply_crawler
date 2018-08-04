package com.zxw.repository;

import com.zxw.entity.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    Project findByUrl(String url);

    @Modifying
    @Transactional
    @Query("UPDATE Project p " +
        "SET p.detail = :detail " +
        "WHERE p.id = :id")
    void updateProjectById(@Param("id") Long id, @Param("detail") String detail);
}
