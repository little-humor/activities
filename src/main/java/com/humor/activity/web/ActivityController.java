package com.humor.activity.web;

import com.humor.activity.common.ServerResponse;
import com.humor.activity.entity.Activity;
import com.humor.activity.repository.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    /**
     * 保存更新 活动信息
     * @param activity
     * @return
     */
    @PostMapping("saveOrUpdate.do")
    public ServerResponse saveOrUpdate(@RequestBody Activity activity){
        Activity data = activityRepository.saveAndFlush(activity);
        return ServerResponse.createBySuccess(data);
    }

    /**
     * 发现页 活动展示
     * @return
     */
    @GetMapping("findAll.do")
    public ServerResponse findAll(){
        List<Activity> all = activityRepository.findAll();
        all.stream().map(activity -> {
            String[] img = activity.getImg().split(";");
            //主图
            if(StringUtils.isEmpty(activity.getMainImg())){
                activity.setMainImg(img[0]);
            }
            //轮播图
            if(StringUtils.isEmpty(activity.getSlideImg())){
                List<String> slideImg = new ArrayList<>();
                List<String> activityImg = new ArrayList<>();
                for(int i=0;i<img.length;i++){
                    if(i<3){
                        slideImg.add(img[i]);
                    }
                    activityImg.add(img[i]);
                }
                activity.setSlideImg(slideImg);
            }
            return activity;
        }).collect(Collectors.toList());
        return ServerResponse.createBySuccess(all);
    }

    /**
     * 根据活动id获取activityInfo
     * @param id
     * @return
     */
    @GetMapping("findById.do")
    public ServerResponse findById(Integer id){
        Optional<Activity> optional = activityRepository.findById(id);
        if(optional.isPresent()){
            return ServerResponse.createBySuccess(optional.get());
        }else{
            return ServerResponse.createByErrorMessage("该活动已下线！");
        }
    }


}
