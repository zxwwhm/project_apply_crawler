package com.zxw.pipeline;

import com.zxw.entity.Project;
import com.zxw.repository.ProjectRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component
public class ProjectPipeLine implements Pipeline {

  @Resource
  private ProjectRepo projectRepo;

  @Override
  public void process(ResultItems resultItems, Task task) {
    List<Project> projectList=resultItems.get("projectLists");
    if(projectList!=null){
      projectRepo.save(projectList);
    }
  }
}
