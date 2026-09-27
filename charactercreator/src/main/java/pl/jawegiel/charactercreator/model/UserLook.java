package pl.jawegiel.charactercreator.model;

import pl.jawegiel.charactercreator.characterdecorator.CharacterDecorator;
import pl.jawegiel.charactercreator.characterdecorator.SpriteElement;

public class UserLook {

    public static final int NO_ELEMENT = 17170445;

    private SpriteElement sex;
    private CharacterDecorator skin;
    private CharacterDecorator hair;
    private CharacterDecorator pants;
    private CharacterDecorator longSleeve;
    private CharacterDecorator shortSleeve;
    private CharacterDecorator shoes;

    public SpriteElement getSex() {
        return sex;
    }

    public void setSex(SpriteElement sex) {
        this.sex = sex;
    }

    public CharacterDecorator getSkin() {
        return skin;
    }

    public void setSkin(CharacterDecorator skin) {
        this.skin = skin;
    }

    public CharacterDecorator getHair() {
        return hair;
    }

    public void setHair(CharacterDecorator hair) {
        this.hair = hair;
    }

    public CharacterDecorator getPants() {
        return pants;
    }

    public void setPants(CharacterDecorator pants) {
        this.pants = pants;
    }

    public CharacterDecorator getLongSleeve() {
        return longSleeve;
    }

    public void setLongSleeve(CharacterDecorator longSleeve) {
        this.longSleeve = longSleeve;
    }

    public CharacterDecorator getShortSleeve() {
        return shortSleeve;
    }

    public void setShortSleeve(CharacterDecorator shortSleeve) {
        this.shortSleeve = shortSleeve;
    }

    public CharacterDecorator getShoes() {
        return shoes;
    }

    public void setShoes(CharacterDecorator shoes) {
        this.shoes = shoes;
    }

    public UserLook(SpriteElement sex, CharacterDecorator skin, CharacterDecorator hair, CharacterDecorator pants, CharacterDecorator longSleeve, CharacterDecorator shortSleeve, CharacterDecorator shoes) {
        this.sex = sex;
        this.skin = skin;
        this.hair = hair;
        this.pants = pants;
        this.longSleeve = longSleeve;
        this.shortSleeve = shortSleeve;
        this.shoes = shoes;
    }
}
