package com.washpost.heideltime.heideltimeapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import de.unihd.dbs.heideltime.standalone.exceptions.*;

@RestController
public class HeideltimeController {

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public String greeting(@RequestBody HeideltimeInput input) {

        // TODO: ensure input.tagger is ['none', 'stanford', 'tree']

        try {
            return HeideltimeFactory.process(input.text, input.dct, input.tagger);
        } catch (DocumentCreationTimeMissingException e) {
            return "DocumentCreationTimeMissingException";
        } catch (ParseException e) {
            return "failed to parse document creation time (dct)";
        }

    }

}
