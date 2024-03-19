public class Sage {

    private String name;

    public Sage(String name) {
        this.name = name;
    }

    public void sageEating(){
        System.out.printf("%s кушает", name);
    }
    public void sageThinking(){
        System.out.printf("%s думает", name);
    }
}
