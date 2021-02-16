package com.assignment.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.custom.IntimePerMonthCount;
import com.assignment.assignment.models.IntimeAsset;

@Repository
public interface IntimeAssetRepository extends JpaRepository<IntimeAsset, Integer>{
	@Query(value = "SELECT intime_asset.intime_month as month, COUNT(intime_asset.id) as num_intime from intime_asset GROUP BY intime_asset.intime_month", nativeQuery = true)
	List<IntimePerMonthCount> countIntimePerMonth();
}
