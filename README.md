# Telegram-bot-shelter

_**Telegram project**_ 

Telegram-a shelter bot for the selection of _**pets**_, which will be able to answer popular 

questions from people about what you need to know and be able

**to pick up an _animal_ from the shelter**.
 


## Functionality for the user

**Stage 0. Request definition**

*This is the input point of the bot's communication with the user.*

- The bot welcomes a new user, tells about itself and asks the user to choose a shelter:
- Shelter for cats
- Shelter for dogs

You cannot choose both shelters.

- Next, the bot can give a menu to choose from, with which request the user came:
- Find out information about the shelter (stage 1)
- How to take an animal from the shelter (stage 2)
- Send a pet report (step 3)
- Call a volunteer
- If none of the options is suitable, then the bot can call a volunteer.
- If the user has already contacted the bot before, then a new appeal begins with the selection of the shelter that the user wants to know about.

 
  **Stage 1. Consultation with a new user**

*At this stage, the bot should give introductory information about the shelter: where it is located, how and when it works, what are the rules for admission to the shelter, the rules for being inside and communicating with the animal. The functionality of the shelter for cats and dogs is identical, but the information inside will be different, since the shelters are located in different places and they have different restrictions and rules for staying with animals.*

- The bot welcomes the user.
- The bot can tell you about the shelter.
- The bot can give out the shelter's work schedule and address, driving directions.
- The bot can give out the contact details of the security for registration of a car pass.
- The bot can issue general safety recommendations on the territory of the shelter.
- The bot can accept and record contact details for communication.
- If the bot cannot answer the client's questions, then you can call a volunteer.

*After the new adoptive parent has taken the animal from the shelter, he is obliged to send information within a month about how the animal feels in the new place. The daily report includes the following information:*

- *Photo of the animal.*
- *The animal's diet.*
- *General well-being and getting used to a new place.*
- *Change in behavior: abandoning old habits, acquiring new ones.*

*The report must be sent every day, there are no restrictions in days on the time of submission of the report. Every day, volunteers review all submitted reports after 21:00. If the adoptive parent filled out the report improperly, the volunteer through the bot can give feedback in a standard form: "Dear adoptive parent, we noticed that you are not filling out the report in as much detail as necessary. Please take a more responsible approach to this lesson. Otherwise, the shelter's volunteers will be obliged to personally check the animal's conditions."*

*The user gets into the database of new adoptive parents through a volunteer who puts him there

 
**Stage 2. Consultation with the potential owner of the animal from the shelter**

*At this stage, the bot helps potential adoptive parents of an animal from a shelter to deal with bureaucratic (contract execution) and household (how to prepare for life with an animal) issues.*

*The main task: to give the most complete information about how a person has to prepare for a meeting with a new family member.*

- The bot welcomes the user.
- The bot can give out the rules for getting to know the animal before taking it from the shelter.
- The bot can issue a list of documents required to take an animal from the shelter.
- The bot can issue a list of recommendations for transporting the animal.
- The bot can give a list of recommendations for home improvement for a puppy/kitten.
- The bot can give a list of recommendations for home improvement for an adult animal.
- The bot can issue a list of recommendations on home improvement for an animal with disabilities (vision, movement).
- The bot can give out the advice of a dog handler on primary communication with a dog * (not relevant for a feline
- - *shelter, implement only for a shelter for dogs).*
- The bot can issue recommendations on proven dog handlers for further reference to them * (irrelevant for a cat shelter, implemented only for a shelter for dogs).*
- The bot can give a list of reasons why they may refuse and not let you take the dog from the shelter.
- The bot can accept and record contact details for communication.
- If the bot cannot answer the client's questions, then you can call a volunteer.
 
- **Stage 3. Pet management**

*After the new adoptive parent has taken the animal from the shelter, he is obliged to send information within a month about how the animal feels in the new place. The daily report includes the following information:*

- *Photo of the animal.*
- *The animal's diet.*
- *General well-being and getting used to a new place.*
- *Change in behavior: abandoning old habits, acquiring new ones.*

*The report must be sent every day, there are no restrictions in days on the time of submission of the report. Every day, volunteers review all submitted reports after 21:00. If the adoptive parent filled out the report improperly, the volunteer through the bot can give feedback in a standard form: "Dear adoptive parent, we noticed that you are not filling out the report in as much detail as necessary. Please take a more responsible approach to this lesson. Otherwise, the shelter's volunteers will be obliged to personally check the animal's conditions."*

*The user gets into the database of new adoptive parents through a volunteer who puts him there. There is one base for adoptive parents of a cat shelter, another for a dog shelter.*

*The task of the bot is to accept information for input and, if the user does not send information, remind them about it, and if more than 2 days pass, then send a request to the volunteer to contact the adopter.*

*As soon as the 30-day period ends, the volunteers decide whether the animal remains with the owner or not. The probation period may be completed, may be extended for another 14 or 30 days, or may not be completed.*

- The bot can send a daily report form.
- If the user has sent only a photo, then the bot can request a text.
- If the user has sent only text, then the bot can request a photo.
- The bot may issue a warning that the report is being filled out badly (done by a volunteer):
  "* Dear adoptive parent, we noticed that you are not filling out the report in as much detail as necessary. 
- * Please take a more responsible approach to this lesson. Otherwise, the shelter's volunteers will be obliged to personally check the animal's conditions."*
- If the adoptive parent has passed the probation period, the bot congratulates him with a standard message.
- If the adoptive parent has been assigned an additional probation period, the bot informs him and indicates the number of additional days (14 or 30 days).
- If the adoptive parent has not passed the probation period, the bot notifies him about it and gives instructions on further steps.
- If the bot cannot answer the client's questions, then you can call a volunteer.


### Happy animal adoption and we are waiting for you again!!!