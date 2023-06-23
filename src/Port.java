public class Port {
    public String portA;
    public String portNameA;
    public String portB;
    public String portNameB;

    public boolean isOrange(){
        if(portNameA.contains("Disabled") || portNameA.contains("disabled") 
            ||portNameB.contains("Disabled") || portNameB.contains("disabled")){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isYellow(){
        Integer differences = portNameA.compareTo(portNameB);
        if(differences >= 3){
            return true;
        }
        else if(portNameA.substring(portNameA.length() - 1) == "."){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isRed(){
        if(portNameA.substring(portNameA.length() - 1) == "." && 
            !(portNameA.contains("PORT"))){
                return true;
            }
        else{
            return false;
        }
    }

}
