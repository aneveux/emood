eTeam Mood
==========
About
-----
This project aims at providing an Eclipse embedded solution, synchronized from a server component in order to know the team's mood. This comes from visual management practices using smilies pictures to illustrate the various team member's moods.
Contact
-------
Don't hesitate to contact me if you'd like to participate to this small project. You can use for example the [issue mechanism of this project](https://github.com/aneveux/org.eteam.mood/issues), or contact me from twitter: [@antoineneveux](http://twitter.com/antoineneveux).
Documentation
-------------
All the technical documentation related to this project will be provided on [our wiki](https://github.com/aneveux/org.eteam.mood/wiki). All the user related documentation will be available on our github website.
Build
-----
This project is using Maven, so everything you should have to do in order to build it is to get the source code, and run `mvn clean package` from the root of the project. Then, the Eclipse part will be built under the `org.eteam.mood.repository/target` folder, and the server part under `org.eteam.mood.server/target` folder.