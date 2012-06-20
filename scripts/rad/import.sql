-- import.sql is executed by Hibernate when the app starts, to populate some sample data

-- Add Pete and Marius
insert into Member (id, name, email, phone_number) values (1, 'Pete', 'pmuir@redhat.com', '012345678912')
insert into Member (id, name, email, phone_number) values (2, 'Marius', 'mariusb@redhat.com', '012345678912')

-- Add JBoss World
insert into Event (id, name, description, picture) values (1, 'JBoss World & Red Hat Summit', 'The best conference to learn about JBoss, ever!', 'http://www.redhat.com/summit/img/logo-banner-small_new3.png')

-- Add Pete to JBoss World
insert into Event_Member (events_id, attendees_id) values (1, 1)

-- Add Marius to JBoss World
insert into Event_Member (events_id, attendees_id) values (1, 2)