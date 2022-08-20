package com.urlshort.timyurl.UrlShortener.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.urlshort.timyurl.UrlShortener.model.url_map_table;



@Repository
public interface UrlRepo extends JpaRepository<url_map_table, Long>{

	@Query(nativeQuery=true,value="SELECT * FROM url_map_table WHERE url_map_table.uniq_string LIKE %:randomstring% ;")
    List<url_map_table> findurls(String randomstring);
    
    @Query(nativeQuery=true,value="SELECT * FROM url_map_table WHERE url_map_table.uniq_string = :randomstring LIMIT 1;")
    url_map_table getTinyurls(String randomstring);
	
}
