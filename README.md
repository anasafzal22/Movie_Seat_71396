# MovieMobileCA

<b>Student Name: Anas Afzal</b>
<b>Student ID: 71396</b>
<b>Student Email: 71396@student.dorset-college.ie</b>


<h1>Report</h1>

This app is designed to display a list of movies in a recycler view and allow users to select seats for each movie. It comprises two main features: the movie recycler view and the seat selection feature.

The movie recycler view presents data for each movie, including title, rating, duration, and description. A random number between 0 and 15 is generated for each movie and assigned to seats_remaining, with an initial default value of 0 for seats_selected. The app utilizes Glide Image loader to fetch and display movie posters from myvue.com, contributing to the visual appeal of the interface.

Clicking on a movie item opens a new MovieActivity, where users can view plus and minus icons alongside the seats_selected value, enabling them to adjust their seat selection. Validation logic disables the minus icon when no seats are selected and the plus icon when no seats remain. Additionally, a "filling fast" badge is dynamically added if less than 3 seats are available.

Retaining selected seats upon returning from the MovieActivity to the main screen was achieved by calling the adapter's notifyItemChanged method. Relevant movie data is sourced from Vue or other providers, with credits displayed at the bottom of the app.

In addressing challenges, I encountered difficulties with displaying images from an internet source and transferring data between screens. To resolve these issues, I referred to educational resources on my Mobile App moodle and YouTube, ultimately implementing Glide Image loader for image loading tasks.

<b>Key Learnings:</b>
1. Technical Skills: Improved understanding of data handling between activities and integrating external data sources into Android apps.
2. Problem-solving Strategies: Learned to troubleshoot and find alternative solutions, such as using Glide for efficient image loading.
3. UI/UX Design: Gained insights into replicating design styles and enhancing user experience through visual elements like badges.
4. Resource Utilization: Leveraged online resources for guidance and learning, enhancing overall development efficiency.

<b>Conclusion:</b>
This project has been a valuable learning experience, deepening my skills in Android app development, UI design, and problem-solving. By overcoming challenges and adopting effective strategies, I've gained practical insights that will inform future app development endeavors.

