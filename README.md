
## Big O and Omega for two methods


App.FlagIndex: searchFlagsFromSet(Set<Integer> potentialIDS, String query) 
* Where n is the size of potentialIDS, the list of Flags
* Where m is the number of words in the description of each Flag
  
Big O: O(n * m). Big Omega: Omega(n)

App.RelationshipBar  pastFlagsToString()
* Where n is the size of flagHistory, the flags commited by the partner during the relationship

Big O: O(n). Big Omega: Omega(n) as well
