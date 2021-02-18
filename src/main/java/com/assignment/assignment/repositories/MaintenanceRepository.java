package com.assignment.assignment.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.custom.CountAssetStatus;
import com.assignment.assignment.models.Maintenance;

@Repository
public interface MaintenanceRepository extends PagingAndSortingRepository<Maintenance, Integer> {
	//Native SQL    
  @Query(value = "SELECT asset, program, overdue_num_day FROM `overdue_asset`, `maintenance` WHERE maintenance.id = overdue_asset.id_asset", nativeQuery = true)
  List<Object> listAssetOverdue();
  
  @Query(value = "SELECT status, COUNT(id) as num_count FROM maintenance GROUP BY(status)", nativeQuery = true)
  List<CountAssetStatus> countAssetStatus();
}
