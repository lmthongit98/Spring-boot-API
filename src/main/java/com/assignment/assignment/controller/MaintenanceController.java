package com.assignment.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.assignment.models.Maintenance;
import com.assignment.assignment.repositories.MaintenanceRepository;
import com.assignment.assignment.service.MaintenanceService;

@RestController
@RequestMapping("api/maintenance")
public class MaintenanceController {

	// Pagination and sorting
	@Autowired
	MaintenanceService service;

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private MaintenanceRepository maintenanceRepository;

	@GetMapping
	public ResponseEntity<PaginationAsset> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<Maintenance> list = service.getAll(pageNo, pageSize, sortBy);
		PaginationAsset pagination = new PaginationAsset();
		long totalRows = maintenanceRepository.count();
		pagination.setList(list);
		pagination.setTotalRows(totalRows);
		pagination.setPagesize(5);
		return new ResponseEntity<PaginationAsset>(pagination, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public List<Maintenance> findAll() {
		// This returns a JSON or XML with the users
		return (List<Maintenance>) maintenanceRepository.findAll();
	}

	@PostMapping(path = "/add")
	public Maintenance AddAssetMaintenance(@RequestBody Maintenance m) {
		Maintenance maintenance = new Maintenance(m.getAsset(), m.getProgram(), m.getStatus(), m.getLon(), m.getLat());
		return this.maintenanceRepository.save(maintenance);
	}

	@GetMapping("{id}")
	public Optional<Maintenance> getById(@PathVariable int id) {
		return maintenanceRepository.findById(id);
	}

	@GetMapping("overdueList")
	public List<Object> Custom() {
		return maintenanceRepository.listAssetOverdue();
	}
}

class PaginationAsset {
	private List<Maintenance> list;
	private long totalRows;
	private int Pagesize;
	
	PaginationAsset(){
		
	}
	
	public List<Maintenance> getList() {
		return list;
	}
	public void setList(List<Maintenance> list) {
		this.list = list;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public int getPagesize() {
		return Pagesize;
	}
	public void setPagesize(int pagesize) {
		Pagesize = pagesize;
	}
}




