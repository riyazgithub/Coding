package com.hack.designpattern;

/**
 * Created by rafthab on 3/2/17.
 */

interface biriyani {
    public String makeBiriyani();
}
class simpleBiriyani implements biriyani {
    @Override
    public String makeBiriyani() {
        return "Kuska";
    }
}
class biriyaniDecorator implements biriyani {
    public biriyani specialBiriyani;
    public biriyaniDecorator (biriyani specialBiriyani) {
        this.specialBiriyani = specialBiriyani;
    }
    public String makeBiriyani(){
        return specialBiriyani.makeBiriyani();
    }
}

class eggBiriyani extends biriyaniDecorator {
    public eggBiriyani(biriyani typeOfBiriyani) {
        super(typeOfBiriyani);
    }
    public String makeBiriyani() {
        return specialBiriyani.makeBiriyani() + addEgg();
    }
    public String addEgg() {
        return "Egg";
    }
}

class muttonBiriyani extends biriyaniDecorator {
    public muttonBiriyani (biriyani typeBiriyani) {
        super(typeBiriyani);
    }
    public String makeBiriyani() {
        return specialBiriyani.makeBiriyani() + addMutton();
    }
    public String addMutton() {
        return "Mutton";
    }
}

public class DecoratorPattern {

    public static void main(String[] args) {
        biriyani finalBiriyani = new muttonBiriyani(new eggBiriyani(new simpleBiriyani()));
        System.out.println(finalBiriyani.makeBiriyani());
    }


}
