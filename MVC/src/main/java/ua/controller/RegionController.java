package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.entity.Region;
import ua.repository.RegionRepository;

@Controller
public class RegionController {

	@Autowired
	private RegionRepository regionRepository;
	
	@RequestMapping("/admin/region")
	public String show(){
		return "adminRegion";
	}
	
	@RequestMapping(value = "/admin/region.json", method=RequestMethod.GET)
	public @ResponseBody List<Region> findAll(){
		return regionRepository.findAll();
	}
	
	@RequestMapping(value = "/admin/region/{id}.json", method=RequestMethod.GET)
	public @ResponseBody Region findOne(@PathVariable int id){
		return regionRepository.findOne(id);
	}
	
	@RequestMapping(value = "/admin/region.json", method=RequestMethod.PUT)
	public @ResponseBody void save(@RequestBody Region region){
		regionRepository.save(region);
	}
	
	@RequestMapping(value = "/admin/region.json", method=RequestMethod.POST)
	public @ResponseBody void update(@RequestBody Region region){
		regionRepository.save(region);
	}
	
	@RequestMapping(value = "/admin/region.json", method=RequestMethod.DELETE)
	public @ResponseBody void delete(@RequestBody Region region){
		regionRepository.delete(region);
	}
}
