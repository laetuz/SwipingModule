Project structure

| domain
| └─ Person.kt
| └─ PersonDummy.kt

| navigation
| └─ NavGraph.kt
| └─ NavigationItem.kt
| └─ Screen.kt

| presentation
| ├─ components
| │  └─ ActionButton.kt
| │  └─ ActionRowButton.kt
| │  └─ ChoiceChips.kt
| │  └─ InfoTag.kt
| │  └─ OptionsMenu.kt
| ├─ profilecard
| │  └─ ProfileCard.kt
| ├─ screen
| │ ├─ home
| │ │   └─ HomeView.kt
| │ ├─ profiledetail
| │ │   └─ ProfileDetailView.kt
| │ ├─ ChatView.kt
| │ ├─ LikedView.kt
| │ └─ ProfileView.kt
| └─ MainView.kt


Logic:
The app starts in MainView.kt, which sets up the scaffold layout and navigation.
•	Navigation is defined in NavGraph.kt using a NavController.
•	Users swipe cards (ProfileCard.kt) to trigger actions like Like, Reject, or View Profile.
•	Taps and swipes are handled locally and trigger screen transitions through the NavController.

Known Issues:
•	No ViewModel or repository layers — local state is handled with remember { mutableStateOf(...) }.
•	All profile data is static and defined in PersonDummy.kt.
•	No networking or local database — everything runs in memory.
•	Image placeholders are currently used instead of real photos.
•	Swipe actions aren’t saved — state resets when the app restarts.
•	The navigation logic is basic and may need improvements for deeper stacks or more screens.