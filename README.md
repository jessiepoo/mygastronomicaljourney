# *My Gastronomical Journey*

## A diary curated just for food  experiences <3


**What is it?**    
    
The project I am proposing to design this term is one that is centered around personalizing one's own food 
experiences. Much like the application yelp, this application will allow users to add restaurants they have been to, 
along with the menu items they chose and a rating / review of each food item. The application will calculate and keep 
track of the overall rating of the restaurant, and add the restaurant to the list of restaurants in corresponding order. 
The user will also be able to add restaurants that they want to try to another list, and can check off and transfer the
restaurant to the "already tried" list when the user has eaten at the restaurant. 


**Who is it for and why is it useful?**

This project is dedicated for people who are passionate about food and would like to remember their personal experiences 
with restaurants they have been to. Foodies like myself often struggle with remembering restaurants I enjoyed when 
choosing a place to eat at. Applications like yelp can be quite subjective as everyone has different tastes of what 
types of food they like. I believe an application like this one is necessary to providing everyone with a personalized
documentation of their experiences with food. 


**Application functions:**
- Add restaurants the user has been to
- Add / remove restaurants the user wants to try
- Rate restaurants based on taste, price and service.
- Sorts restaurants based on alphabetical order, taste, price, and service. 

##User Story
- As a user, I want to be able to add a restaurant I have already tried to the "tried-collection" along with ratings"
  for the restaurant's taste, price and service.
- As a user, I want to be able to add a restaurant I want to try to the "to-try collection"
- As a user, I want to be able to remove a restaurant I don't want to try anymorefrom the "to-try collection"
- As a user, I want to be able to view the list of restaurants in the specified collection sorted by taste, price,
  service and overall (average of the 3 fields) rating.
- As a user, I want to be able to select a restaurant and add a booking for the restaurant.
- As a user, I want to be able to save my restaurant collection list to file.
- As a user, I want to be able to optionally load my restaurant collection from file when the problem starts.


##Instructions for Grader 

(Once in a while, it takes multiple clicks on a button to trigger the event. I think it is probably
a lagging issue with intellij but it works fine otherwise.)

- When the program starts, you can trigger my audio component by clicking the enter button.

- First, click the restaurants you have tried to access that collection.
- You can generate the first required event by clicking add a restaurant and entering the fields
  required (restaurant names start with capitalized letters and ratings out of 5) and clicking done.
  
- You can generate the second required event by clicking view restaurant where you can 
  choose how you want the restaurants to be sorted by. When done, click the back button.
  
- You can generate a third event by making a booking for the restaurant. First click the booking
  button, select the restaurant you would like to book and choose a time and seats, then click done.
  
- You can save the state of the restaurants by clicking the save button.
- To reload the restaurants, all you have to do is go back to the view restaurants where you can view
  the restaurant names and ratings.

- All of this can also be done when accessing the "restaurants to try" collection.

  
  



