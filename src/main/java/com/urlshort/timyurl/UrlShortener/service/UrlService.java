package com.urlshort.timyurl.UrlShortener.service;

import java.util.UUID;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshort.timyurl.UrlShortener.model.url_map_table;
import com.urlshort.timyurl.UrlShortener.repo.UrlRepo;
import com.urlshort.timyurl.UrlShortener.utils.UrlConvertor;

@Service
@Transactional
public class UrlService {

	
	public UrlConvertor urlconvertor =new UrlConvertor();
	private final UrlRepo urlrepo;
	
	@Autowired
	public UrlService(UrlRepo urlrepo) {
		this.urlrepo = urlrepo;
	}
	
	public url_map_table addUrl(url_map_table ut) {
		ut.setUniq_string(checkRandomString());
		ut.setUrl_name(urlconvertor.checkIfHttp(ut.getUrl_name()));
		return urlrepo.save(ut);
	}
	
	public List<url_map_table> findurls(String randomstring) {
		return urlrepo.findurls(randomstring);
	}
	
	public String checkRandomString() {
		String randomstring = urlconvertor.randomStringGenerator();
		
		List<url_map_table> ulist = findurls(randomstring);
		
		if(ulist.size()>0) {
			checkRandomString();
		}

		return randomstring;
	}
	
	public url_map_table getTinyAndBigUrl(String uniqString) {
		return urlrepo.getTinyurls(uniqString);
	}
	
	
}
