package net.rooban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    Service service = new Service();

    @RequestMapping(value = "/rename", method = RequestMethod.GET)
    public ResponseEntity<?> renameMethod() throws Exception {
        service.renameMethod();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

