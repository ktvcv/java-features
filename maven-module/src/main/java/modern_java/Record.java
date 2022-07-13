package modern_java;

//getter/setter/equals/hashcode fot these
public record Record(String name, int year) {

    boolean isAfter2000() {
        return this.year > 2000;
    }

    public static boolean t2(){
        return true;
    }
}
