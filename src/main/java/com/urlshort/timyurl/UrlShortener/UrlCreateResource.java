package com.urlshort.timyurl.UrlShortener;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.urlshort.timyurl.UrlShortener.model.url_map_table;
import com.urlshort.timyurl.UrlShortener.service.UrlService;
import com.urlshort.timyurl.UrlShortener.utils.UrlConvertor;

@RestController
@RequestMapping("/ur")
public class UrlCreateResource {
	
    private final UrlService urlservice;
	public UrlConvertor urlconvertor =new UrlConvertor();
	
	public UrlCreateResource(UrlService urlservice) {
		this.urlservice = urlservice;
	}

	@PostMapping("/createurl")
	public ResponseEntity<url_map_table> createShortURL(@RequestBody url_map_table bigurl){
		url_map_table newurl = urlservice.addUrl(bigurl);
		return new ResponseEntity<>(newurl,HttpStatus.CREATED);
	}
	
	@GetMapping("/{uniqString}")
	public ResponseEntity<Void> getOriginalUrl(@PathVariable("uniqString") String uniqString) {
		try {
		     url_map_table geturl = urlservice.getTinyAndBigUrl(uniqString);
		     return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://"+geturl.getUrl_name())).build();
		}
		catch(Exception mn) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
