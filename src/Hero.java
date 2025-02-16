public class Hero {
    private String name;
    public int hitPoints;

   public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString() {
        return "Hero{" +
                "name='" + this.name + '\'' +
                ", hitPoints=" + this.hitPoints +
                '}';
    }

    public void attack(Hero opponent){
        double randomNumber = Math.random();
        if (randomNumber < 0.5){
            opponent.hitPoints -= 10;
        }
        else{
            hitPoints -= 10;
        }
    }

    public void senzuBean(){
        this.hitPoints = 100;
    }

    public void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath (Hero opponent){
        this.senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return opponent.getName() + ": " + opponent.getHitPoints() + "   " + this.name + ": " + hitPoints;
    }

    public int[] nFightsToTheDeathHelper (Hero opponent, int n){
        int[] wins = new int[2];
        int heroWins = 0;
        int opponentWins = 0;
        for (int i = 0; i < n; i++){
            fightUntilTheDeath(opponent);
            if (hitPoints > 0){
                heroWins++;
            }
            if (opponent.getHitPoints() > 0){
                opponentWins++;
            }
        }
        this.senzuBean();
        opponent.senzuBean();
        wins[0] = heroWins;
        wins[1] = opponentWins;
        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] score = nFightsToTheDeathHelper(opponent, n);
        if (score[0] != score[1]){
            return this.name + ": " + score[0] + " wins \n" + opponent.name + ": " + score[1] + " wins";
        }
        else{
            return "OMG! It was actually a draw!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
       this.senzuBean();
        opponent.senzuBean();
       while (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
            attack(opponent);
            System.out.println(opponent.getName() + ": " + opponent.getHitPoints() + "   " + this.name + ": " + hitPoints);
            Thread.sleep(1000);
        }
    }
}
