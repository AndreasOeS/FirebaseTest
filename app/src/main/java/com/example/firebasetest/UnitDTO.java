package com.example.firebasetest;



public class UnitDTO implements IUnitDTO {

    private String unitType;
    //private int amount;

    public UnitDTO(){

    }

    public UnitDTO(String unitType){

        this.unitType = unitType;
        //this.amount = amount;

    }


    @Override
    public String getUnitType() {
        return unitType;
    }

    @Override
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
/*
    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmout(int amount) {
        this.amount = amount;
    }

 */
}
