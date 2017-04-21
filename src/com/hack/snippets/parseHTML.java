package com.hack.snippets;
import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// http://auto7.dev.mobileiron.com/reports/pfr_kocab/kocab_ldap_sync/release/44.0.0/
/**
 * Created by rafthab on 4/20/17.
 */
public class parseHTML {
    public static void main(String[] args) throws Exception{
        String FAILURE = " — failed";

        File input = new File("resource/TestNG_Unit_Test.html");
        Document doc = Jsoup.parse(input, null);
        Elements tbodyElements = doc.getElementsByTag("tbody").get(1).getAllElements();
        int count =0;
        Element searchResult = tbodyElements.stream()
                .filter(elem -> (elem.text().contains(FAILURE) && elem.childNodeSize() > 1))
                .findAny()
                .orElse(null);

        Elements adLDAP = new Elements();
        Elements openLDAP = new Elements();
        Elements childNodes = searchResult.children();
        for (Element ele : childNodes) {
            if(ele.text().contains(FAILURE)) {
                count++;
            } else if (count == 1) {
                adLDAP.add(ele);
            } else {
                openLDAP.add(ele);
            }
        }
        adLDAP = adLDAP.select("failed");
        System.out.println("Count " + count);



//        Elements elemFailedEven = doc.getElementsByClass("failedeven");
//        Elements elemFailedOdd = doc.getElementsByClass("failedodd");
//        Elements combineElements = new Elements();
//        combineElements.addAll(elemFailedEven); combineElements.addAll(elemFailedOdd);
//
//        String packageName = new String();
//        for (Element element : combineElements) {
//            String failedTestcase = new String();
//            if(element.childNodeSize() == 5) {
//                packageName = element.select("td").get(0).text() + ".";
//                failedTestcase = packageName + element.select("td").get(1).select("b").get(0).text();
//            } else if(element.childNodeSize() == 4) {
//                failedTestcase = packageName + element.select("td").get(0).select("b").get(0).text();
//            }
//            System.out.println(failedTestcase);
//        }
        System.out.println(doc.title());
    }
}
