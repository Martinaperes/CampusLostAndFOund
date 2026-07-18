# Campus Lost and Found

A modern Android application built with **Kotlin**, **Jetpack Compose**, and **Firebase** to help students report, search for, and reclaim lost and found items on campus.

---

##  Overview

Campus Lost and Found is designed to simplify the process of reporting and recovering lost items within a university environment. The application allows users to create an account, report lost or found items, and browse available listings in an intuitive interface.

---

##  Features

###  Authentication
- User registration
- User login
- Firebase Authentication
- Secure email and password authentication

###  User Management
- Create a personal account
- Store user information using Firebase Firestore

###  Lost & Found Management *(In Progress)*
- Report lost items
- Report found items
- View available items
- Search for items
- View item details

###  User Interface
- Built entirely using Jetpack Compose
- Material 3 Design
- Clean and modern interface
- Primary application color: **#55AB55**

---

##  Technologies Used

- Kotlin
- Jetpack Compose
- Material 3
- Firebase Authentication
- Firebase Firestore
- Firebase Storage *(planned)*
- Android Studio
- Gradle Kotlin DSL

---

## 📂 Project Structure

```
app
│
├── firebase
│   └── AuthRepository.kt
│
├── navigation
│   ├── AppNavigation.kt
│   └── Routes.kt
│
├── screens
│   ├── splash
│   ├── login
│   ├── register
│   ├── home
│   ├── reportlost
│   ├── reportfound
│   └── profile
│
├── ui
│   └── theme
│
└── MainActivity.kt
```

---

## Getting Started

### Prerequisites

- Android Studio
- JDK 11 or later
- Android SDK
- Firebase Project

### Installation

1. Clone the repository

```bash
git clone https://github.com/Martinaperes/CampusLostAndFound.git
```

2. Open the project in Android Studio.

3. Connect your Firebase project.

4. Download the `google-services.json` file from Firebase.

5. Place it inside the `app/` folder.

6. Sync Gradle.

7. Run the application on an emulator or Android device.

---

##  Screens

The application includes:

- Splash Screen
- Login Screen
- Registration Screen
- Home Screen *(Coming Soon)*
- Lost Item Reporting *(Coming Soon)*
- Found Item Reporting *(Coming Soon)*
- Profile Screen *(Coming Soon)*

---

##  Firebase Services

This project uses:

- Firebase Authentication
- Cloud Firestore

Future updates will include:

- Firebase Storage for item images

---

## Future Improvements

- Upload item images
- Search and filter functionality
- Push notifications
- Dark mode
- Item claim requests
- User profile editing
- Admin dashboard





## 📄 License

This project is intended for educational and learning purposes.
