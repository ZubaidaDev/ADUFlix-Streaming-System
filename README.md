# ADUFlix Streaming System (Java)

A console-based media streaming system developed for **CSC202: Programming 2** at **Abu Dhabi University**. It simulates a simple streaming platform where users can browse media, watch content, store watch history, and receive recommendations.

## 🚀 Key Features

- **Age Validation**: Restricts access for users below the minimum age using a custom exception.
- **Media Catalog**: Loads movies, series, and documentaries from a text file.
- **Watch History**: Stores watched content in a user-specific history file.
- **Recommendations**: Suggests media based on the user's last watched genre.
- **OOP Concepts**: Applies abstraction, inheritance, polymorphism, interfaces, and file handling.

## 📋 Requirements
- **Java** (`javac` / `java`)
- `mediaList.txt` must remain available when running the program

## 💻 How to Run (Terminal)

### Option A — compile and run (single folder)
From the project root (where the `.java` files are):

```bash
javac *.java
java Main
```

### Option B — compile into an output folder
```bash
mkdir -p out
javac -d out *.java
java -cp out CoursePrerequisitesApp
```
## Usage
This is an **interactive console menu** program. Run it, then follow the on-screen prompts and enter the requested numbers/text in the terminal.

## ⚠️ Notes
- This repository is shared publicly as a portfolio/class-project reference. If you’re currently taking a similar course, please follow your course’s academic integrity policy.
