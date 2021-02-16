package com.assignment.assignment.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assignment.assignment.models.OverdueAsset;

public interface OverdueAssetRepository extends PagingAndSortingRepository<OverdueAsset, Integer>{

}
