# Randusers 1.0

Randusers is a simple Android application that retrieves and displays a list of users from the following API:

[https://randomuser.me/api/?page=1&results=10&seed=weenect](https://randomuser.me/api/?page=1&results=10&seed=weenect)

## Features

- Display users as a list on the main page
- Implement a detailed view that appears upon tapping on a list item, presenting essential user information.
- Implement pagination to load more users as the user scrolls through the list
- Implement an offline mode to display previously fetched data when there is no internet connection.
- Manage network errors and other potential issues gracefully

The app has two screens from the feature_users module:

- User list screen - displays list of users
- User detail screen - display information about the selected user

<br/><br/>

<p>
  <img alt="Splash screen" src="https://github.com/amadiyawa/ennov_test_app/blob/main/app_screenshots/splash.png" width="250" />
  <img alt="User list screen in dark mode" src="https://github.com/amadiyawa/ennov_test_app/blob/main/app_screenshots/user_list_dark.png" width="250" />
  <img alt="User detail screen in dark mode" src="https://github.com/amadiyawa/ennov_test_app/blob/main/app_screenshots/user_detail_dark.png" width="250" />
  <img alt="User list screen in light mode" src="https://github.com/amadiyawa/ennov_test_app/blob/main/app_screenshots/user_list_light.png" width="250" />
  <img alt="User detail screen in light mode" src="https://github.com/amadiyawa/ennov_test_app/blob/main/app_screenshots/user_detail_light.png" width="250" />
</p>

## Architecture

The project follow the MVVM pattern, respects the standards of Clean Architecture and use Jetpack Compose.

## Getting Started

There are a few ways to open this project.

### Android Studio

1. `Android Studio` -> `File` -> `New` -> `From Version control` -> `Git`
2. Enter `https://github.com/amadiyawa/ennov_test_app.git` into URL field and press `Clone` button

### Command-line And Android Studio

1. Run `git clone https://github.com/amadiyawa/ennov_test_app.git` command to clone the project
2. Open `Android Studio` and select `File | Open...` from the menu. Select the cloned directory and press `Open` button

## License

No license
