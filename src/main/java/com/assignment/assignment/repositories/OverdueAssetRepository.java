package com.assignment.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.assignment.assignment.custom.OverDuePerMonthCount;
import com.assignment.assignment.models.OverdueAsset;

public interface OverdueAssetRepository extends PagingAndSortingRepository<OverdueAsset, Integer>{
	@Query(value = "SELECT overdue_asset.overdue_month as month, COUNT(overdue_asset.id) as num_overdue FROM overdue_asset GROUP BY overdue_asset.overdue_month", nativeQuery = true)
	List<OverDuePerMonthCount> countOverduePerMonth();
	
}
