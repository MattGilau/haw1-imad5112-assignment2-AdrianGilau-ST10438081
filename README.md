Introduction
PURPOSE

The purpose of the application is to replicate the original virtual pet toy from the 1990s called Tamagotchi (IIE, 2024). According to the IIE (2024) a Tamagotchi app refers to the contemporary versions designed to replicate caring for a virtual pet on your smartphone. 
Subsequently, the aim of the assignment is to create an application that also imitates Tamagotchi using Android Studio and Kotlin as a platform and programing language respectively. The application must be tested and committed to GitHub to ensure effective execution, 
features, maintenance, and collaboration with other developers (IIE, 2024). Specifically, the user must be welcomed with a start screen and then prompted to care for their virtual pet on a second screen with the following functions as specified by the IIE (2024): 
−	Play (button) when a happiness meter gets low. 
−	Feed (button) when a hunger meter gets low.
−	Clean (button) when a cleanliness meter gets low.
−	In addition, an image of the virtual pet must be shown to represent each function. 
The target audience would be children or teenagers; therefore, the app should cater to their preferences. This would mean a UI that appeals to younger people and since this is a game it would need to be fun or engaging for them to use. Furthermore, 
the app should be simple and intuitive to operate to compensate for its young end-users. Finally, an engaging video highlighting the applications functions and features must be created and uploaded to YouTube (IIE, 2024). If the above-mentioned is 
implemented successfully the outcome of the assignment is achieved. 

MAIN OBJECTIVES

Considering the purpose, the main requirements to create a successful end-product as per IIE (2024) specifications would be: 
1.	Appealing and intuitive UI – graphics, fonts, colors, and backgrounds.
2.	Simple navigation.
3.	Engaging or dynamic interactions.
4.	Welcome screen – start button.
5.	Second screen – play, feed, and clean (minimum). 
6.	GitHub integration and testing.
7.	Captivating demonstration video

Design Considerations

The user interface was designed with the target audience and assignment specifications in mind. As seen in Figure 1, a subtle but inviting background that is pet themed was used and the title and button are contrasted against this with bright green. The font was changed 
from the default font which is too formal to the Baloo font which is more fun. The image I used was an AI generated Rottweiler which resulted in a realistic and captivating image of the user’s virtual pet. Furthermore, the images for each action are also AI generated and 
realistic – giving the app a more genuine feel. 
In Figure 2, I color coded each button with the corresponding text view, status view, and progress bar to ensure intuitive usability and increased engagement. The order and color coding also increases the appeal of the app and is not chaotic. The added palettes also make 
the app more visually stimulating, thus encouraging engagement with the user. In Addition, in Figures below you can observe the different screen views…

Code Structure

The code was structured with all the variables without access modifiers in order to allow for easy accessibility within the package, especially when coding manual tests. The code is also modular, with most functions being performed in methods which are also without any 
access modifiers. All the string resources are stored externally in string.xml in order to make the future developments or changes of the application more convenient. 
A handler was used in tandem with the main looper and two runnable objects in order to create the “ticking” or decreasing status value effect. A number of methods were used to update the “ticking” values on both the text views, progress bars, and within the other 
methods, to control the functions of the buttons, the warning messages, and play the barking sound if the values get to low.
Future Developments
As development continues, I would like to add additional screens for more interactions with virtual pets. Furthermore, the welcome screen could be changed to allow the user to select a different virtual pet at the start of the Tamagotchi app, thereby adding variety 
and increasing the replay ability of the game. Subsequently, this would require different themes and actions for the different types of animals in order to be implemented effectively. Finally, the app is still in the initial phases of development and there is much 
room for refinement, therefore, further collaboration on GitHub is needed. 

GitHub 

The code was continuously pushed to the GitHub repository link below as I developed it further.

AUTOMATED TESTING 

The automated testing links provided by the IIE (2024) assignment document were used along with other built in automated tests on GitHub which are all functioning and viable here:
https://github.com/MattGilau/haw1-imad5112-assignment2-AdrianGilau-ST10438081

YouTube Demo Video Link

For a short demonstration of the features and the manual testing:
https://www.youtube.com/watch?v=Vv3EolCihaE 

Report Reference List 

The IIE. 2024. Introduction to Mobile Application Development [IMAD5112 Module Manual]. The Independent Institution of Education: Unpublished.
Welcome Screen Reference List

Freepik. [s.a.]. Seamless pattern of cute dog puppy symbol toy, paw, footstep. cartoon funny and happy dog concept with simple shape. [Online]. Available at:
https://www.freepik.com/premium-vector/seamless-pattern-cute-dog-puppy-symbol-toy-paw-footstep-cartoon-funny-happy-dog-concept-with-simple-shape-style-illustration-background-wallpaper-textile-fabric_11733171.htm [Accessed 23 April 2024].

Meta. (2024). Meta AI (Llama 3 version). [AI Assistant]. Available on WhatsApp [Accessed 23 April 2024].

OpenAI. (2024). ChatGPT3.5 (Feb 13 version). [Large language model]. Available at: https://chat.openai.com/ [Accessed 01 May 2024].

The IIE. 2024. Introduction to Mobile Application Development [IMAD5112 Module Manual]. The Independent Institution of Education: Unpublished.


List of Figures:

Figure 1 (Image View): Meta. 2024. milawel.

Figure 2 (Background): user21574432. [s.a.]. Seamless pattern of cute dog puppy symbol, toy, paw, footstep. cartoon funny and happy dog concept with simple shape.
Second Screen Reference List
 
Developers. 2024. Handler. [Online]. Available At: https://developer.android.com
/reference/kotlin/android/os/Handler#postdelayed_1 [Accessed 06 May 2024].

Developers. 2024. Math. [Online]. Available At: https://developer.android.com/reference/java/lang/Math#min(float,%20float) [Accessed 06 May 2024].

How class Handler works Android, Kotlin. 2023. YouTube video, added by Simple Android Apps. [Online]. Available at: https://www.youtube.com/watch?v=WwOeoQMhtss [Accessed 29 April 2024].

LiberatorBuddy. 2024. Media player is not workIng is Android kotlin, Kotlin. [Online]. Available at: https://stackoverflow.com/questions/77832472/media-player-is-not-worklng-is-android-kotlin/78156013#78156013 [Accessed 30 April 2024].

Meta. (2024). Meta AI (Llama 3 version). [AI Assistant]. Available on WhatsApp [Accessed 23 April 2024].

Mhlanga, S. 2024. IMAD5112 Instructor, The Independent Institution of Education. [IMAD5112 Session]. March 2024.

OpenAI. (2024). ChatGPT3.5 (Feb 13 version). [Large language model]. https://chat.openai.com/ [Accessed 01 May 2024].

The IIE. 2024. Introduction to Mobile Application Development [IMAD5112 Module Manual]. The Independent Institution of Education: Unpublished.

Upload an audio file in Android Studio and also add audio to a button in Android Studio. 2023. YouTube video, added by Hint of everything. [Online]. Available at: https://www.youtube.com/watch?v=pGD3_O0ODTM [Accessed 29 April 2024].


List of Figures:

    Figure 1: Meta. 2024. milawel.
    Figure 2: Meta. 2024. milafeed.
    Figure 3: Meta. 2024. milabath.
    Figure 4: Meta. 2024. milaplay.

