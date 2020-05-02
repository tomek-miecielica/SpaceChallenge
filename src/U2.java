public class U2 extends Rocket {

    public U2(){
        this.setExplosionFactor(0.04);
        this.setCrashFactor(0.08);
        this.setMaxWeight(29000);
        this.setWeight(18000);
        this.setCost(120);
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
