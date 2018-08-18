package com.washpost.heideltime.heideltimeapi;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import de.unihd.dbs.heideltime.standalone.*;
import de.unihd.dbs.heideltime.standalone.exceptions.*;
import de.unihd.dbs.uima.annotator.heideltime.resources.Language;

public class HeideltimeFactory {

    private static HeidelTimeStandalone ht_none = new HeidelTimeStandalone(
        Language.ENGLISH,
        DocumentType.NEWS,
        OutputType.TIMEML, // OutputType.TIMEML, OutputType.XMI
        "src/main/resources/config.props",
        POSTagger.NO);

    private static HeidelTimeStandalone ht_stanford = new HeidelTimeStandalone(
        Language.ENGLISH,
        DocumentType.NEWS,
        OutputType.TIMEML,
        "src/main/resources/config.props",
        POSTagger.STANFORDPOSTAGGER);

    private static HeidelTimeStandalone ht_treetagger = new HeidelTimeStandalone(
        Language.ENGLISH,
        DocumentType.NEWS,
        OutputType.TIMEML,
        "src/main/resources/config.props",
        POSTagger.TREETAGGER);

    public static String process(String text, String dctString, String tagger) throws DocumentCreationTimeMissingException, ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dct = df.parse(dctString);
        if (tagger.equals("none")) {
            return ht_none.process(text, dct);
        } else if (tagger.equals("stanford")) {
            return ht_stanford.process(text, dct);
        } else if (tagger.equals("tree")) {
            return ht_treetagger.process(text, dct);
        } else {
            return null;
        }
    }

}
