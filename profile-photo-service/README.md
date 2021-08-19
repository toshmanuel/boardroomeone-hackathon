#Boardroomone Profile Image Service (Backend)
***

This application is will collect a user's profile image from a client side application and change the background to black, and likwise remove crop the image to detect the face of the user and crop it.
This application creates a single endpoint that can be used on any client side application.
This backend application is accessible via -> [BoardRoomOne Profile Picture](https://boardroom-one-image.herokuapp.com/profile-photo/add-image)
---
***
### APIs USED

* Cloudinary:
    * Usage include
        * To upload images
        * To crop image based on an individual face
        * To change the background image color to black after the image background has been removed by remove.bg

    <details>
        <summary>Cloudinary Dependency</summary> 
  
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpmime</artifactId>
            <version>4.5.13</version>
        </dependency>
    </details>

* Remove.bg: 
    * Usage
        * Removes the background image
    <details>
        <summary>Remove Bg Dependency</summary>

  The dependency can be accessible from [maven repository](https://mvnrepository.com/artifact/org.apache.httpcomponents/fluent-hc)

        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>fluent-hc</artifactId>
            <version>4.5.13</version>
        </dependency>
    </details>


### The backend application can be tested with the following
    Frontend:

* [Link to frontend page](https://boardroomone.netlify.app/)
    
        Postman Documentation:

