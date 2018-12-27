package com.humor.activity.repository;

import com.humor.activity.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ActivityRepository extends JpaRepository<Activity,Integer>, JpaSpecificationExecutor<Activity> {



}
