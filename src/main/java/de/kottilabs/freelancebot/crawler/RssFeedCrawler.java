package de.kottilabs.freelancebot.crawler;

import de.kottilabs.freelancebot.data.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class RssFeedCrawler implements Crawler {
   public static final String ITEM = "item";

   private final XMLInputFactory factory = XMLInputFactory.newInstance();
   private List<Project> projects = new ArrayList<>();

   @Override
   public List<Project> getProjects(final String urlString) throws IOException, XMLStreamException {
      URL url = new URL(urlString);
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

      final XMLEventReader xmlEventReader = factory.createXMLEventReader(reader);

      while (xmlEventReader.hasNext()) {
         final XMLEvent xmlEvent = xmlEventReader.nextEvent();
         if (xmlEvent.isStartElement() && xmlEvent.asStartElement()
               .getName()
               .getLocalPart()
               .equals(ITEM)) {
            parseItem(xmlEventReader);
         }
      }
      return projects;
   }

   private void parseItem(final XMLEventReader xmlEventReader) throws XMLStreamException {
      final Project project = new Project();

      while (xmlEventReader.hasNext()) {
         final XMLEvent xmlEvent = xmlEventReader.nextEvent();
         if (xmlEvent.isEndElement() && xmlEvent.asEndElement()
               .getName()
               .getLocalPart()
               .equals(ITEM)) {
            return;
         }

         if (xmlEvent.isStartElement()) {

            final StartElement startElement = xmlEvent.asStartElement();
            final String elementKey = startElement.getName()
                  .getLocalPart();

            switch (elementKey) {
               case "title":
                  project.setTitle(xmlEventReader.getElementText());
                  //               case "description":
                  //                  project.setDescription(xmlEventReader.getElementText());
                  //               case "link":
                  //                  project.setLink(xmlEventReader.getElementText());
                  //               case "pubDate":
                  //                  project.setPubDate(xmlEventReader.getElementText());
            }

         }

      }
      projects.add(project);
   }
}
