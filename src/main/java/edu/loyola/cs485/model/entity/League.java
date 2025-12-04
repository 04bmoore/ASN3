package edu.loyola.cs485.model.entity;

public class League extends AbstractEntity{
    private Integer ID = null;
    private String name_league;
    private String country;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName_league() {
        return name_league;
    }

    public void setName_league(String name_league) {
        this.name_league = name_league;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return getID().toString()+": "+getName_league()+" <"+getCountry()+">";
    }
}
