package pl.jawegiel.charactercreator.model;

import java.io.Serializable;
import java.util.Locale;

public class UserLookDTO implements Serializable {

    public static final int NO_ELEMENT = 17170445;

    private String sex;
    private int skinDesc;

    private int hairDesc;
    private int hairColor = NO_ELEMENT;

    private int pantsDesc;
    private int pantsColor = NO_ELEMENT;

    private int longSleeveDesc;
    private int longSleeveColor = NO_ELEMENT;

    private int shortSleeveDesc;
    private int shortSleeveColor = NO_ELEMENT;

    private int shoesDesc;
    private int shoesColor = NO_ELEMENT;

    public UserLookDTO() {
    }

    public static UserLookDTO fromUserLook(UserLook userLook) {
        if (userLook == null) return null;
        UserLookDTO dto = new UserLookDTO();
        if (userLook.getSex() != null) {
            dto.sex = String.valueOf(userLook.getSex()).toLowerCase(Locale.ROOT);
        }
        if (userLook.getSkin() != null) {
            dto.skinDesc = userLook.getSkin().getElementDescription();
        }
        if (userLook.getHair() != null) {
            dto.hairDesc = userLook.getHair().getElementDescription();
            dto.hairColor = userLook.getHair().getColor();
        }
        if (userLook.getPants() != null) {
            dto.pantsDesc = userLook.getPants().getElementDescription();
            dto.pantsColor = userLook.getPants().getColor();
        }
        if (userLook.getLongSleeve() != null) {
            dto.longSleeveDesc = userLook.getLongSleeve().getElementDescription();
            dto.longSleeveColor = userLook.getLongSleeve().getColor();
        }
        if (userLook.getShortSleeve() != null) {
            dto.shortSleeveDesc = userLook.getShortSleeve().getElementDescription();
            dto.shortSleeveColor = userLook.getShortSleeve().getColor();
        }
        if (userLook.getShoes() != null) {
            dto.shoesDesc = userLook.getShoes().getElementDescription();
            dto.shoesColor = userLook.getShoes().getColor();
        }
        return dto;
    }

    public String getSex() {
        return sex;
    }

    public int getSkinDesc() {
        return skinDesc;
    }

    public int getHairDesc() {
        return hairDesc;
    }

    public int getHairColor() {
        return hairColor;
    }

    public int getPantsDesc() {
        return pantsDesc;
    }

    public int getPantsColor() {
        return pantsColor;
    }

    public int getLongSleeveDesc() {
        return longSleeveDesc;
    }

    public int getLongSleeveColor() {
        return longSleeveColor;
    }

    public int getShortSleeveDesc() {
        return shortSleeveDesc;
    }

    public int getShortSleeveColor() {
        return shortSleeveColor;
    }

    public int getShoesDesc() {
        return shoesDesc;
    }

    public int getShoesColor() {
        return shoesColor;
    }
}
