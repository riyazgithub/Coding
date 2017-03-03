package com.hack.designpattern;

/**
 * Created by rafthab on 3/2/17.
 */
interface HousePlan {
    public void setBasement(String basement) ;
    public void setStructure(String structure) ;
    public void setRoof(String roof) ;
    public void setInterior(String interior);
}

class House implements HousePlan {
    private String basement;
    private String structure;
    private String roof;
    private String interior;


    @Override
    public void setBasement(String basement) {
        this.basement = basement;
    }

    @Override
    public void setStructure(String structure) {
        this.structure = structure;

    }

    @Override
    public void setRoof(String roof) {

        this.roof = roof;
    }

    @Override
    public void setInterior(String interior) {

        this.interior = interior;
    }
}

interface HouseBuilder {
    public void buildBasement();
    public void buildStructure();
    public void buildRoof();
    public void buildInterior();
    public House getHouse();
}

class iglooHouseBuilder implements HouseBuilder {
    private House house;
    public iglooHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildBasement() {
        house.setBasement("Ice Bars");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Ice Blocks");
    }

    @Override
    public void buildRoof() {
        house.setInterior("Ice Cravings");
    }

    @Override
    public void buildInterior() {
        house.setRoof("Ice doom");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

class CivilEngineer {
    private HouseBuilder houseBuilder;
    public CivilEngineer (HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    public House getHouse() {
        return this.houseBuilder.getHouse();
    }
    public void constructHouse() {
        this.houseBuilder.buildBasement();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildInterior();
    }
}
public class BuilderDesignPattern {
    public static void main(String[] args) {
        HouseBuilder igloo = new iglooHouseBuilder();
        CivilEngineer engineer = new CivilEngineer(igloo);
        engineer.constructHouse();

        House house = engineer.getHouse();

        System.out.println("builder contructed "+house);
    }
}
