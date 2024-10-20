﻿# Ticket-Booking-IRCTC

A CLI-based ticket booking system written in Java, inspired by the Indian Railway Catering and Tourism Corporation (
IRCTC). This project simulates the core functionality of a ticket booking system, including searching for trains,
booking tickets, and managing bookings.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

The Ticket-Booking-IRCTC project is a Java-based command-line application that provides users with an interface to
search for trains, book tickets, and manage their bookings. The project is designed to simulate the experience of
booking train tickets through a system similar to IRCTC, offering a simplified and educational model for understanding
how such systems work.

## Features

- **Train Search**: Find trains between a source and destination.
- **Ticket Booking**: Book tickets for available trains.
- **Manage Bookings**: View, update, and cancel bookings.
- **Persistent Data Storage**: Train and booking information is stored in a JSON file.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/karanbadhwar/Ticket-booking-IRCTC.git
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd Ticket-booking-IRCTC
   ```
3. **Build the Project**:
    - Use your favorite Java IDE to open and build the project.
    - Alternatively, you can build the project using the command line:
      ```bash
      javac -d bin src/main/java/ticket/booking/irctc/*.java
      ```
4. **Run the Application**:
   ```bash
   java -cp bin ticket.booking.irctc.App
   ```

## Usage

Once the application is running, follow the command prompts to interact with the system. You can search for trains, book
tickets, view existing bookings, and update or cancel bookings.

## Project Structure

```plaintext
Ticket-booking-IRCTC/
│
├── src/
│   ├── main/javaticket/booking/irctc/entities/       # Entity classes (Train, Ticket, etc.)
│   ├── main/javaticket/booking/irctc/service/        # Service classes (TrainService, BookingService, etc.)
│   └── main/javaticket/booking/irctc/App.java       # Main entry point of the application
│
├── localDB/
│   └── trains.json And users.json                   # Sample data
│
└── README.md                          # Project README
```

## Technologies Used

- **Java**: Core language for the application logic.
- **Jackson**: For JSON parsing and data binding.
- **JSON**: Used for storing train and booking data.

## Contributing

Contributions are welcome! If you would like to improve the project or fix bugs, feel free to fork the repository and
submit a pull request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/YourFeature`)
3. Commit your Changes (`git commit -m 'Add Some Feature'`)
4. Push to the Branch (`git push origin feature/YourFeature`)
5. Open a Pull Request


## Contact

**Karan Badhwar** - [LinkedIn](https://www.linkedin.com/in/karan-badhwar-3b466684/) - [Email](mailto:karanbadhwar07@gmail.com)

---

Feel free to modify any sections to better fit your project! If there's anything specific you'd like to highlight or
change, let me know, and I can help refine it further.
