# ClearScoreTechTask
## Introduction 

This is my submission for the ClearScore Tech Task that is part of the interview process.

The task was to create an Android app that is a scaled down version of ClearScores Android app.

The app connects to an API that responds with JSON. Some of that data is then presented in a dashboard as can be seen below.

![This is an image](https://uc8416965b0f36608cecb580ce5e.previews.dropboxusercontent.com/p/thumb/ABYiT8wV22FRDG05oCn7GWAaMUjxs3U_hn15cH_K86_O9q_4sCHlHfknNV62Tgr3hby1FckZuA68rJdc0aq7RUKfq1KC-Sgnq_cTJgQH1zLjlfaALnvedScu6ex1NLkGO-G_UvKFC1ijjLpUrRzkUjgCJqLkpCCNWnbP6qTbJX6iX9dbEu7IT0WpwNZ7MRzu_6BVZR4gQHHUZZuS-ILvT3Q8FlkL_igLucTlHDL1bDOm_ppmYbcWBpxcZ6-HmSZqA__0f7yaBGkuWqSffS3VcEkyNOggLaH5pclbpO_2v2cqixI-ylJfgsZEnW9_qAKtxbsznR2Kmd_rPAxwVnM37M8-q456M1FR4oT4LXUyrCIn9h0K_ptxQ9nbPQW3hoKOGAj5q9go5ni6nIJZ-IKbn4s0/p.jpeg?fv_content=true&size_mode=2)

## Technical decisions made
I tried to use as much techical approaches that are recommended by Google. Some of these decisions are listed below:
- MVVM for the architecture
- The repository pattern to pull data into ViewModels
- Retrofit to make API calls
- MockWebServer for testing the HTTP client
- Hilt for Dependency Injection
- NavComponent for displaying fragments
- LiveData for updating the UI
- JUnit4, Android Test Library, Android Architecture Components Core Test Library, and Robolectric for writing unit tests

## What I would've done differently if I had more time
- My Mock Web Server is making an actual api call. I would change that because making api calls in a unit test it down
- I would implement Okhttp for logging to logcat
- I would implement Room for caching data so that I wouldn't have to make an api call every time the app starts
- I would add a MediatorLiveData to my Repository, and add a Room LiveData and API LiveData as a source so that if the Room LiveData is null, I could make an API call
- I would obfuscate the code with Proguard to protect the codebase
- I would add Leak Canary to the app to notify me of any memory leaks
- I would implement better error handling for my API call by taking into account failed responses or the type of throwable that is thrown in the onFailure method
- I would check if the device has an internet connection before making a api call
- I would extract library version numbers in app.gradle because some libraries share version numbers and it's nice to be able to update multiple libraries in one place
- I would create styles for my views
- I would test the app on devices of different screen sizes
- I would extract colors and dimensions into their respective files
