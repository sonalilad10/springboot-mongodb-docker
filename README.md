1. Pull the MongoDB Docker Image
**docker pull mongodb/mongodb-community-server:latest**

2. Run the Image as a Container
**docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:latest**

The -p 27017:27017 in this command maps the container port to the host port. This allows you to connect to MongoDB with a localhost:27017 connection string.

To install a specific version of MongoDB, specify the version after the : in the Docker run command. Docker pulls and runs the specified version.

3. Run the springboot app
