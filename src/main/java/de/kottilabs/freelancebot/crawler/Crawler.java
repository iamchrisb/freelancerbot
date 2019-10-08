package de.kottilabs.freelancebot.crawler;

import de.kottilabs.freelancebot.data.Project;

import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public interface Crawler {

   List<Project> getProjects(String url) throws IOException, XMLStreamException;

}
