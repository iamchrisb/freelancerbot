package de.kottilabs.freelancebot.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Project {
   private String title;
   private String description;
   private String link;
   private String pubDate;

   public String getTitle() {
      return title;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public String getLink() {
      return link;
   }

   public void setLink(final String link) {
      this.link = link;
   }

   public String getPubDate() {
      return pubDate;
   }

   public void setPubDate(final String pubDate) {
      this.pubDate = pubDate;
   }

   @Override
   public String toString() {
      return "Project [" +
            "title='" + title +
            ", description='" + description +
            ", link='" + link +
            ", pubDate='" + pubDate +
            ']';
   }
}
