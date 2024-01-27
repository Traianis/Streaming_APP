# Streaming_APP

A Java streaming application with two types of users, streamers and users, implemented using Object-Oriented Programming, employing 5 design patterns.

A streamer has 3 attributes:
  1)streamerType :1 - Musician, 2 - Podcast Host, 3 - Audiobook Author
  2)id
  3)name

A stream has 8 attributes:
  1)streamType: 1 - Music, 2 - Podcast, 3 - Audiobook
  2)id
  3)streamGenre: a) Music: 1 - pop, 2 - latin, 3 - house, 4 - dance, 5 - trap
                b) Podcast: 1 - documentary, 2 - celebrities, 3 - tech
                c) Audiobook: 1 - fiction, 2 - personal development, 3 - children
  -noOfStreams
  -streamerId
  -length
  -dateAdded
  -name

A user has 3 attributes:
  -id
  -name
  -streams: the history of listened streams

Commands for streamer:
  -add stream
  -list streams
  -delete stream

Commands for users:
  -list history
  -watch a stream
  -recommend 5 streams based on preferences
  -recommend 3 surprise streams

In the implementation of the application, I used several design patterns:
  -Command
  -Singleton
  -Factory
  -Decorator
  -Iterator

For reading data about users, streamers, streams, and commands, I created a Read class responsible for reading data from files, and a Data class that stores this data. I used Singleton for the Data class because only one instance of this class is needed. Besides the collections it has as attributes, I implemented a method in this class to find a stream by its ID.

For commands, I used Factory, also using Singleton, to easily create all types of commands, letting the subclasses decide which type to return. Within it, the type of command to be read is decided and constructed. All commands will implement the Command interface, which has an execute method.

I considered users and streamers as application users, so I created an interface that contains the common actions they have and created a Decorator for each. In the decorator, I implemented actions that users do not have in common. I used Decorator because if I wanted to expand the application, perhaps introducing subscribers or different types of streamers with different actions, or even different types of subscribers/users with different permissions, it would be easier to implement this.

I implemented Iterator to traverse the arrays specific to the Data, User, and Streamer classes, making traversal easier.
