package com.acme.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("serial")
@Entity
public class Event implements java.io.Serializable
{

   @Id
   @GeneratedValue(strategy = IDENTITY)
   @Column(updatable = false, nullable = false)
   private Long id = null;

   private String name;

   private String description;

   private String picture;

   @ManyToMany
   private Collection<Member> attendees = new ArrayList<Member>();

   public String getDescription()
   {
      return this.description;
   }

   public Long getId()
   {
      return this.id;
   }
   public String getName()
   {
      return this.name;
   }

   public String getPicture()
   {
      return this.picture;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public void setPicture(final String picture)
   {
      this.picture = picture;
   }

   public Collection<Member> getAttendees()
   {
      return attendees;
   }

   public void setAttendees(Collection<Member> attendees)
   {
      this.attendees = attendees;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Event other = (Event) obj;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      String result = "";
      if (name != null && !name.trim().isEmpty())
         result += name;
      if (description != null && !description.trim().isEmpty())
         result += " " + description;
      if (picture != null && !picture.trim().isEmpty())
         result += " " + picture;
      return result;
   }
}