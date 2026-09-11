package main.java.string.class_problems;
public class Duplicate {
    static String findDuplicateTeam(String[] teamnames){
        for(int i = 0; i < teamnames.length; i++){
            for(int j = i + 1; j < teamnames.length; j++){
                if(teamnames[i].equals(teamnames[j])){
                    return teamnames[i];
                }
            }
        }
        return (String) "No Duplicates found" ;
    }
    public static void main(String[] args){
        String[] teamnames = {"ByteForce", "CodeCrafters", "ByteForce", "HackMasters"};
        String[] teamnames2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teamnames));
        System.out.println(findDuplicateTeam(teamnames2));

    }
}
