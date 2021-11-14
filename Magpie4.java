import java.util.Scanner; 
import java.util.Random;
/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}

		// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
        else if(findKeyword(statement, "movies", 0) >= 0){
        talkAboutMovies();
        }
		else
		{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
		}
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String talkAboutMovies(){
        // if time, then make age reccomendations movies
        String[] Action_spy = new String [] {"Mission impossible", "Skyfall", "Johnny English", "Red Sparrow", "Atomic Blonde", "Casino Royale", "Kingsman", "Tehran", "Spy Kids", "I Spy"};
        int[] Random_spy = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Action_war = new String [] {"Hacksaw Ridge", "American Sniper", "Saving Private Ryan", "GI Joe", "Hyena Road", "1917", "Greyhound", "Apocalypse Now", "Midway", "Fury" };
        int[] Random_war = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Action_superhero = new String [] {"Avengers", "Suicide Squad", "Dark Knight", "Man of Steel", "Guardians of the Galaxy", "Justice League", "X-Men", "Captain America Civil War", "Iron Man 1-3", "Spider Man Homecoming"};
        int [] Random_superhero = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Action_wildwest = new String [] {"Django Unchained", "The Harder They Fall", "Rango", "Westworld", "The Magnificant Seven", "Cry Macho", "Wild Wild West", "The Good, The Bad, & The Ugly", "Stagecoach"};
        int[] Random_wildwest = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        

        String[] Romance_historical = new String [] {"Titanic", "Pride and Prejudice", "Brokeback Mountain", "Jane Eyre", "A Knight's Tale", "Even After", "Brooklyn", "A Room with a View", "Emma", "The Age of Innocence"};
        int[] Random_historical = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Romance_contemporary = new String [] {"Begin Again", "Ghost Town", "The Rewrite", "(500) Days of Summer", "Ruby Sparks", "Celeste and Jesse Forever", "Adam", "Music and Lyrics"};
        int[] Random_contemporary = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Romance_suspense = new String [] {"Siberia", "Die In a Gunfight", "Allied", "Safe Haven", "Queen & Slim", "Boy Next Door", "The Perfect Guy", "Frank & Lola", "All God's Creatures", "Wicker Park"};
        int[] Random_suspense = new int [] {0,0,0,0,0,0,0,0,0,0,0};


        String[] Comedy = new String [] {"Free Guy", "The Grinch", "Cruella", "22 Jump Street", "Grown Ups", "Jumanji", "ted", "Tag", "We're the Millers", "Anchorman", "Paul Blart: Mall Cop", "Daddy's Home", "Hangover", "Borat", "Hangover"};
        int[] Random_Comedy = new int [] {0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0};
        
        //findKeyword(statement, "you", 0)
        System.out.println("What kinds of Movies do you like to watch");
         Scanner myObj = new Scanner(System.in); 
         String userName = myObj.nextLine(); 

         if(findKeyword(userName, "action", 0) >= 0){
         Scanner Action2 = new Scanner(System.in); 
         System.out.println("What sub-geners do you like to watch");
         String typeAction = Action2.nextLine(); 

            if(findKeyword(typeAction, "Spy", 0) >= 0){
                ActionInterst("spy");
            }
            else if(findKeyword(typeAction, "war", 0) >= 0){
                ActionInterst("war");
                    }
            else if(findKeyword(typeAction, "superhero", 0) >= 0){
                ActionInterst("superhero");
                    }
          
            else if(findKeyword(typeAction, "wildwest", 0) >= 0){
                ActionInterst("wildwest");
                    }
           }
           else if(findKeyword(userName, "romance", 0) >= 0){
               Scanner Action2 = new Scanner(System.in); 
                System.out.println("What sub-geners do you like to watch");
                String typeAction = Action2.nextLine(); 
                if(findKeyword(typeAction, "historical", 0) >= 0){
               RomanceInterest("historical");
            }
           
            else if(findKeyword(typeAction, "contemporary", 0) >= 0){
                  RomanceInterest("contemporary");
                    }
          
            else if(findKeyword(typeAction, "suspense", 0) >= 0){
                 RomanceInterest("suspense");
                    }

           }
             else if(findKeyword(userName, "comedy", 0) >= 0){
                 comedyInterest("comedy");
             }
             else if(findKeyword(userName, "exit", 0) >= 0||findKeyword(userName, "anymore", 0) >= 0||findKeyword(userName, "don't", 0) >= 0||findKeyword(userName, "no", 0) >= 0){
              System.out.println("Alright");
              return "";
             }
         
    return "";
    }
    private void comedyInterest(String interest){
         String[] Comedy = new String [] {"Free Guy", "The Grinch", "Cruella", "22 Jump Street", "Grown Ups", "Jumanji", "ted", "Tag", "We're the Millers", "Anchorman", "Paul Blart: Mall Cop", "Daddy's Home", "Hangover", "Borat", "Hangover"};
          int[] Random_Comedy = new int [] {0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0};
         boolean isStillInterested = true;
                int counter = 0;
              
                
                while(isStillInterested){
                        Random Comedy2_random = new Random();
                    int randomInt = Comedy2_random.nextInt(Comedy.length);
                    int x = randomInt;
                     Random_Comedy[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Comedy[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                      isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
    }
    private void RomanceInterest(String interest){
        String[] Romance_historical = new String [] {"Titanic", "Pride and Prejudice", "Brokeback Mountain", "Jane Eyre", "A Knight's Tale", "Even After", "Brooklyn", "A Room with a View", "Emma", "The Age of Innocence"};
        int[] Random_historical = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Romance_contemporary = new String [] {"Begin Again", "Ghost Town", "The Rewrite", "(500) Days of Summer", "Ruby Sparks", "Celeste and Jesse Forever", "Adam", "Music and Lyrics"};
        int[] Random_contemporary = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Romance_suspense = new String [] {"Siberia", "Die In a Gunfight", "Allied", "Safe Haven", "Queen & Slim", "Boy Next Door", "The Perfect Guy", "Frank & Lola", "All God's Creatures", "Wicker Park"};
        int[] Random_suspense = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        if(interest.equals("historical")){
          System.out.println("OK, I have some recomendations: ");
                boolean isStillInterested = true;
                int counter = 0;
                
                
                while(isStillInterested){
                    Random Romance_historical_random = new Random();
                    int randomInt = Romance_historical_random.nextInt(Romance_historical.length);
                    int x = randomInt;
                     Random_historical[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Romance_historical[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                       isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
    }
    if (interest.equals("contemporary")){
         boolean isStillInterested = true;
                int counter = 0;
              
                
                while(isStillInterested){
                        Random Romance_contemporary_random = new Random();
                    int randomInt = Romance_contemporary_random.nextInt(Romance_contemporary.length);
                    int x = randomInt;
                     Random_contemporary[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Romance_contemporary[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                       isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
    }
    if (interest.equals("suspense")){
           boolean isStillInterested = true;
                int counter = 0;
    
                
                while(isStillInterested){
                       Random Romance_suspense_random = new Random();
                    int randomInt = Romance_suspense_random.nextInt(Romance_suspense.length);
                    int x = randomInt;
                     Random_suspense[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Romance_suspense[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                     isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
    }
    }
    private void ActionInterst(String interest){
        String[] Action_spy = new String [] {"Mission impossible", "Skyfall", "Johnny English", "Red Sparrow", "Atomic Blonde", "Casino Royale", "Kingsman", "Tehran", "Spy Kids", "I Spy"};
        int[] Random_spy = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Action_war = new String [] {"Hacksaw Ridge", "American Sniper", "Saving Private Ryan", "GI Joe", "Hyena Road", "1917", "Greyhound", "Apocalypse Now", "Midway", "Fury" };
        int[] Random_war = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Action_superhero = new String [] {"Avengers", "Suicide Squad", "Dark Knight", "Man of Steel", "Guardians of the Galaxy", "Justice League", "X-Men", "Captain America Civil War", "Iron Man 1-3", "Spider Man Homecoming"};
        int [] Random_superhero = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        String[] Action_wildwest = new String [] {"Django Unchained", "The Harder They Fall", "Rango", "Westworld", "The Magnificant Seven", "Cry Macho", "Wild Wild West", "The Good, The Bad, & The Ugly", "Stagecoach"};
        int[] Random_wildwest = new int [] {0,0,0,0,0,0,0,0,0,0,0};
        
      if(interest.equals("spy")){
          System.out.println("OK, I have some recomendations: ");
                boolean isStillInterested = true;
                int counter = 0;
                
                
                while(isStillInterested){
                    Random Action_spy_random = new Random();
                    int randomInt = Action_spy_random.nextInt(Action_spy.length);
                    int x = randomInt;
                    Random_spy[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Action_spy[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                      isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
             }
        }
    if (interest.equals("war")){
         boolean isStillInterested = true;
                int counter = 0;
              
                
                while(isStillInterested){
                    Random Action_war_random = new Random();
                    int randomInt = Action_war_random.nextInt(Action_war.length);
                    int x = randomInt;
                    Random_war[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Action_war[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                 isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
        }
    if (interest.equals("superhero")){
           boolean isStillInterested = true;
                int counter = 0;
    
                
                while(isStillInterested){
                    Random Action_superhero_random = new Random();
                    int randomInt = Action_superhero_random.nextInt(Action_superhero.length);
                    int x = randomInt;
                    Random_superhero[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Action_superhero[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                       isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
        }
     if (interest.equals("wildwest")){
           boolean isStillInterested = true;
                int counter = 0;
                boolean war;
                boolean superhero;
                boolean wildwest;
                
                while(isStillInterested){
                    Random Action_wildwest_random = new Random();
                    int randomInt = Action_wildwest_random.nextInt(Action_wildwest.length);
                    int x = randomInt;
                    Random_wildwest[counter] = x ;
                    
                    System.out.println("what are your thoughts on "+ Action_wildwest[randomInt]);
                   
                    Scanner input = new Scanner(System.in); 
                    String check1 = input.nextLine(); 
                    if(findKeyword(check1, "yes", 0) >= 0 || findKeyword(check1, "good", 0) >= 0 || findKeyword(check1, "nice", 0) >= 0){
                        System.out.println("alright! Let me show you some more you may be intersted in");
                        continue;
                    }
                    else{
                 isStillInterested = false;
                       System.out.println("Okay, lets go back to the movies category");
                       talkAboutMovies();
                    }
      }
        }
    }
    private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}
    
	
	
	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	

	
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		//  Refinement--make sure the goal isn't part of a word 
		while (psn >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			
			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
			
		}
		
		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}

}
