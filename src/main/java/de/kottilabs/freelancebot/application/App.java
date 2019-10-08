/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package de.kottilabs.freelancebot.application;

import de.kottilabs.freelancebot.crawler.Crawler;
import de.kottilabs.freelancebot.crawler.RssFeedCrawler;
import de.kottilabs.freelancebot.data.Project;

import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public class App {
   public String getGreeting() {
      return "Hello world.";
   }

   public static void main(String[] args) {
      System.out.println(new App().getGreeting());

      String rssUrlString = "https://www.it-ausschreibung.de/ausschreibungen-auftraege/rss_software.xml";
      Crawler crawler = new RssFeedCrawler();
      try {
         final List<Project> projects = crawler.getProjects(rssUrlString);

         for (Project project : projects) {
            System.out.println(project.toString());
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }
   }
}