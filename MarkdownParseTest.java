import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    /*@Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testNewFile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from test-file.md", List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void testImage() throws IOException {
        Path fileName = Path.of("image.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links in image.md which includes an image", List.of("google.com"), links);
    }

    @Test
    public void testLinkFirst() throws IOException {
        Path fileName = Path.of("link-first.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links in link-first.md which has a link on the first line", List.of("google.com"), links);
    }

    @Test
    public void testFileTwo() throws IOException {
        Path fileName = Path.of("test2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links in test2.md including link without parenthesis", List.of(), links);
    }

    @Test
    public void testFormatTwo() throws IOException {
        Path fileName = Path.of("format2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links in format2.md including link with space after brackets", List.of(), links);
    }*/

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // Expected output
        ArrayList<String> expectedoutput = new ArrayList<>();
        expectedoutput.add("`google.com");
        expectedoutput.add("google.com");
        expectedoutput.add("ucsd.edu");
        assertEquals(expectedoutput, links);
    }
    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // Expected output
        ArrayList<String> expectedoutput = new ArrayList<>();
        expectedoutput.add("a.com");
        expectedoutput.add("a.com(())");
        expectedoutput.add("example.com");
        assertEquals(expectedoutput, links);
    }
    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // Expected output
        ArrayList<String> expectedoutput = new ArrayList<>();
        expectedoutput.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expectedoutput, links);
    }
}
