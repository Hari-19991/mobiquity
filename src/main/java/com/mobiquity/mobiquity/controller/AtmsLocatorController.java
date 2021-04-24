package com.mobiquity.mobiquity.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.mobiquity.entity.AtmsLocator;
import com.mobiquity.mobiquity.exception.DataFoundException;
import com.mobiquity.mobiquity.exception.NoDataFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mobiquity")
public class AtmsLocatorController {

    private ResponseEntity responseEntity;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    RestTemplate restTemplate = new RestTemplate();
    final String uri = "https://www.ing.nl/api/locator/atms/";

    @GetMapping(value="/atms")
    public ResponseEntity<List<AtmsLocator>> getAllAtms() throws DataFoundException {

        try {
        String result =  restTemplate.getForObject(uri, String.class);
        System.out.println("working"+result);
        result = result.substring(5);
        List<AtmsLocator> atmsLocator = null;
            atmsLocator =  new ObjectMapper().readValue(result, new TypeReference<List<AtmsLocator> >() { });
            responseEntity = new ResponseEntity(atmsLocator, HttpStatus.OK);
        }catch(NoDataFoundException nofe){
            logger.error(nofe.getMessage());
            throw new NoDataFoundException();
        }catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }

    @GetMapping(value="/atmsbycity/{city}")
    public ResponseEntity<List<AtmsLocator>> getAtmsByCity(@PathVariable(value = "city") String cityName) throws DataFoundException {

        try {
            String result =  restTemplate.getForObject(uri, String.class);
            System.out.println("working"+result);
            result = result.substring(5);
            List<AtmsLocator> atmsLocator = null;
            List<AtmsLocator>  res =null;
            atmsLocator =  new ObjectMapper().readValue(result, new TypeReference<List<AtmsLocator> >() { });
           res =  atmsLocator.stream().filter(e -> e.getAddress().getCity().equals(cityName))
                    .collect(Collectors.toList());
            responseEntity = new ResponseEntity(res, HttpStatus.OK);
        }catch(NoDataFoundException nofe){
            logger.error(nofe.getMessage());
            throw new NoDataFoundException();
        }catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }
}
