package com.zxw.repository;

import com.zxw.entity.Appendix;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppendixRepo extends JpaRepository<Appendix,Long> {
    Appendix findByUrl(String url);

    @Query("select distinct p.url from Appendix p")
    List<String> findDistinctUrl(Pageable pageable);

}
