# Streaming_APP

## Overview
Streaming_APP is a Java-based streaming application that implements object-oriented programming (OOP) principles and utilizes five design patterns. The application supports two types of users:
- **Streamers**: Users who create and manage streams.
- **Regular Users**: Users who listen to streams and receive recommendations.

## Features
### Streamer Features:
- Add a stream
- List all streams
- Delete a stream

### User Features:
- View listening history
- Watch a stream
- Get 5 recommended streams based on preferences
- Get 3 surprise stream recommendations

## Data Structure
### Streamer Attributes:
- `streamerType`: (1 - Musician, 2 - Podcast Host, 3 - Audiobook Author)
- `id`
- `name`

### Stream Attributes:
- `streamType`: (1 - Music, 2 - Podcast, 3 - Audiobook)
- `id`
- `streamGenre`:
  - Music: (1 - pop, 2 - latin, 3 - house, 4 - dance, 5 - trap)
  - Podcast: (1 - documentary, 2 - celebrities, 3 - tech)
  - Audiobook: (1 - fiction, 2 - personal development, 3 - children)
- `noOfStreams`
- `streamerId`
- `length`
- `dateAdded`
- `name`

### User Attributes:
- `id`
- `name`
- `streams`: History of listened streams

## Design Patterns Used
- **Command Pattern**: Encapsulates commands for better flexibility and reusability.
- **Singleton Pattern**: Ensures a single instance of the `Data` class for managing application data.
- **Factory Pattern**: Creates commands dynamically based on input.
- **Decorator Pattern**: Enhances functionality for streamers and users without modifying base classes.
- **Iterator Pattern**: Simplifies traversal of collections like user history and stream lists.

## Project Structure
```
traianis-streaming_app/
├── Stream_APP/
│   ├── gradle/
│   ├── src/
│   │   ├── main/java/
│   │   │   ├── commands/
│   │   │   ├── data/
│   │   │   ├── models/
│   │   │   ├── utils/
│   │   ├── main/resources/
│   │   │   ├── inputs/
│   │   │   ├── test_cases/
│   │   ├── test/java/
│   ├── build.gradle
│   ├── settings.gradle
└── README.md
```

## Setup and Execution
### Prerequisites:
- Java 8+
- Gradle 7.4+

### Build & Run:
1. Clone the repository:
   ```sh
   git clone <repository_url>
   cd traianis-streaming_app
   ```
2. Build the project using Gradle:
   ```sh
   gradle build
   ```
3. Run the application:
   ```sh
   java -jar build/libs/Streaming_APP.jar <streamers.csv> <streams.csv> <users.csv> <commands.txt>
   ```

## Testing
- The project includes JUnit test cases in the `src/test/java/` directory.
- Run tests using:
  ```sh
  gradle test
  ```
