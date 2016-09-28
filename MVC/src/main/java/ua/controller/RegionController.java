package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.dto.RegionJson;
import ua.entity.Country;
import ua.service.CountryService;
import ua.service.RegionService;

@RestController
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/region", method=RequestMethod.GET)
	public List<RegionJson> getAll(){
		return regionService.findAll();
	}
	
	@RequestMapping(value="/country", method=RequestMethod.GET)
	public List<Country> getAllCountry(){
		return countryService.findAll();
	}
	
	@RequestMapping(value="/country/region/{id}", method=RequestMethod.GET)
	public List<RegionJson> getRegions(@PathVariable int id){
		return regionService.findAll(id);
	}
	
	@RequestMapping(value="/region/{id}", method=RequestMethod.GET)
	public RegionJson getOne(@PathVariable int id){
		return regionService.findOne(id);
	}
	
	@RequestMapping(value="/region", method=RequestMethod.PUT)
	public HttpStatus save(@RequestBody RegionJson json){
		regionService.save(json);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/region", method=RequestMethod.POST)
	public HttpStatus update(@RequestBody RegionJson json){
		regionService.save(json);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/region/{id}", method=RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable int id){
		regionService.delete(id);
		return HttpStatus.OK;
	}
}
