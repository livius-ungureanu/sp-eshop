package com.lun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lun.model.Location;

public interface LocationRepo  extends JpaRepository<Location, Long> {

}
