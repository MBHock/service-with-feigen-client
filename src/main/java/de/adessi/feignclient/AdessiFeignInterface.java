package de.adessi.feignclient;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("adessi-mhock")
public interface AdessiFeignInterface {

    /*
     * Feign ist in der Lage, aus Spring MVC-annotierten Request Mappings direkt den Client zu erzeugen.
     * Wenn man den Builder verwendet, muss hierfür allerdings der Contract new SpringMvcContract()
     * in der Aufruf-Kette mitgegeben werden. Hat man den Contract nicht, kann man die Methoden mit
     * @RequestLine annotieren, Feign macht dann daraus den Client (siehe getFristName() unten, hier
     * sind beide Varianten aufgeführt).
     */

    /**
     * @return the adessi's first name.
     */
    @RequestLine("GET /adessi/firstName")
    @GetMapping("/adessi/firstName")
    String getFirstName();

    /**
     * @return the adessi's last name.
     */
    @GetMapping(value = "/adessi/lastName")
    String getLastName();

    /**
     * @return the adessi's line of business.
     */
    @GetMapping(value = "/adessi/lob")
    String getLineOfBusiness();

    /**
     * @return the adessi's competence center.
     */
    @GetMapping(value = "/adessi/cc")
    String getCompetenceCenter();

    /**
     * @return leader of the adessi's competence center.
     */
    @GetMapping(value = "/adessi/ccleader")
    String getCompetenceCenterLeader();

    /**
     * @return the adessi's job description. Everything that has to be or can be said about the adessi's work at adesso.
     */
    @GetMapping(value = "/adessi/job")
    String getJobDescription();
}
