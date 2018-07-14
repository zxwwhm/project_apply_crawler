package com.zxw.repository;

import com.zxw.entity.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    Project findByUrl(String url);

    long count();
    @Query("select distinct p.url from Project p")
    List<String> findDistinctUrl();
}
