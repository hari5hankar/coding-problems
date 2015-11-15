import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    String rootURL;

    public WebCrawler(String rootURL) {
	this.rootURL = rootURL;
    }

    public void crawl() {
	breadthFirstSearch(rootURL);
    }

    private void breadthFirstSearch(String rootURL) {
	Queue<String> queue = new LinkedList<>();
	Set<String> marked = new HashSet<>();
	queue.add(rootURL);
	marked.add(rootURL);
	while (!queue.isEmpty()) {
	    String url = queue.remove();
	    System.out.println(url); // traversing the link
	    for (String link : getLinks(url)) {
		if (!marked.contains(link)) {
		    marked.add(link);
		    queue.add(link);
		}
	    }

	}
    }

    // returns the http(s) links in inputURL
    private List<String> getLinks(String inputURL) {
	List<String> links = new ArrayList<>();
	String HTML = getHTML(inputURL);
	Pattern pattern = Pattern.compile("http://(\\w+\\.)+(\\w+)");
	Matcher matcher = pattern.matcher(HTML);
	while (matcher.find()) {
	    links.add(matcher.group());
	}

	return links;
    }

    // get HTML content of inputURL
    private String getHTML(String inputURL) {
	StringBuilder HTML = new StringBuilder();
	String line = null;
	try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(new URL(inputURL).openStream()));
	    while ((line = br.readLine()) != null) {
		HTML.append(line + "\n");
	    }
	    br.close();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
	return HTML.toString();
    }

    public static void main(String[] args) {
	WebCrawler wc = new WebCrawler("http://harishankarv.github.io/");
	wc.crawl();
    }
}
