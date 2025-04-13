

     DELHI METRO PATH FINDER


Project Description:
---------------------
The MetroGraph project models the metro network of a city, specifically focusing on the metro stations, lines, and travel times between them. The graph is implemented as an undirected graph with stations as vertices and travel connections as edges, where each edge holds information about the travel time and metro line color.

This project also includes a web interface built using Flask, where users can interact with the metro graph to find the shortest travel path between two stations.

Demo :
---------

![alt text](image-1.png)
Features:
----------
-Graph Representation: Metro stations and their connections (edges) are represented using an adjacency list.

-Dijkstra's Algorithm: Used to find the shortest path between two stations based on travel time.

-Web Interface: Built using Flask, allowing users to input stations and view the shortest path between them.

-Station Details: Displays information such as the stations, travel time, and the lines taken to complete the journey.

Project Structure
-------------------
Metro_flask_app/
│
├── app.py              # Main Flask web application
├── templates/          # HTML templates for web interface
│   └── index.html      
├── java/               #java algo
    └── main.java
    └── MetroGraph.java
    └── Edge.java
├── stations.py
└── README.md           # Project overview 
└── image.png


Installation
1.Clone the repository:
git clone <repository_url>
cd MetroGraph

2.Install the required dependencies:
pip install flask

3.Start the Flask web application:
python app.py

4.Open your browser and visit http://127.0.0.1:5000/ to access the web interface.


Customization:
---------------
- You can add more stations and connections using the addEdge() method.
- To modify the graph size, change the constructor argument in: new MetroGraph(int totalStations);

Author:
--------
Developed by [pranay vohra,nandini Y]

License:
---------
This project is for educational purposes only.
