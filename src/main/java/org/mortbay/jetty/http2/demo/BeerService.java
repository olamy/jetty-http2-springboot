package org.mortbay.jetty.http2.demo;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/beer" )
public class BeerService
{

    @RequestMapping( value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE } )
    public Beer getBeer( @RequestParam(required = false) String name )
    {
        return StringUtils.isEmpty( name ) ? new Beer( "Mountain Goat" ) : new Beer( name );
    }

}
