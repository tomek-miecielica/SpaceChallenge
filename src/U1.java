public class U1 extends Rocket {

    public U1(){
        this.setExplosionFactor(0.05);
        this.setCrashFactor(0.01);
        this.setMaxWeight(18000);
        this.setWeight(10000);
        this.setInitialWeight(10000);
        this.setCost(100);
    }


    @Override
    public boolean launch() {
        double launchChance = this.generateRandomNumber();
        if (launchChance > this.calculateExplosionRisk()){
            return true;
        } else {
            return false;
        }
    }

    public boolean land() {
        double landChance = this.generateRandomNumber();
        if (landChance > this.calculateCrashRisk()){
            return true;
        }else {
            return false;
        }
    }

}
