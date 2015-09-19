package Crauler;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bogdan Kukharskiy on 17.09.2015.
 */
public class HTMLLinkExtractor {

//ПРИМЕР <a href="http://www.mkyong.com/linux/check-debian-installed-version/">Check Debian installed version</a>

    private Pattern patternTag, patternLink;
    private Matcher matcherTag, matcherLink;

    private static final String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
    private static final String HTML_A_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";


    public HTMLLinkExtractor() {
        patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
        patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
    }

    public Set<HtmlLink> grabHTMLLinks(String html) {
        Set<HtmlLink> result = new LinkedHashSet<HtmlLink>();
        matcherTag = patternTag.matcher(html);

        while (matcherTag.find()) {
            String href = matcherTag.group(1);  //href
            String linkText = matcherTag.group(2);  //link text
            HtmlLink obj;

            matcherLink = patternLink.matcher(href);
            while (matcherLink.find()) {
                String link = matcherLink.group(1); //link
                obj = new HtmlLink();
                obj.setLink(link);
                obj.setLinkText(linkText);
                result.add(obj);
            }
        }
        return result;
    }
}
