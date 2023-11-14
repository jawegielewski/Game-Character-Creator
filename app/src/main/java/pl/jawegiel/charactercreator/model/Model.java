package pl.jawegiel.charactercreator.model;

import android.content.Context;

import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import pl.jawegiel.charactercreator.CharacterCreator;
import pl.jawegiel.charactercreator.characterdecorator.AdditiveEmpty;
import pl.jawegiel.charactercreator.characterdecorator.BaseCharacter;
import pl.jawegiel.charactercreator.characterdecorator.Black;
import pl.jawegiel.charactercreator.characterdecorator.CharacterDecorator;
import pl.jawegiel.charactercreator.characterdecorator.SpriteElement;
import pl.jawegiel.charactercreator.characterdecorator.White;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairCourtainBlack;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairCourtainBlond;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairCourtainBrown;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairCurlyLongBlack;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairCurlyLongBlond;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairCurlyLongBrown;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairHighAndTightBlack;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairHighAndTightBlond;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairHighAndTightBrown;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairLongMessyBlack;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairLongMessyBlond;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairLongMessyBrown;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairLooseBlack;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairLooseBlonde;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairLooseBrown;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairNaturalBlack;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairNaturalBlond;
import pl.jawegiel.charactercreator.characterdecorator.hair.AdditiveHairNaturalBrown;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveFemaleBrown;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveFemaleForest;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveFemaleLavender;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveFemaleSky;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveMaleBrown;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveMaleForest;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveMaleLavender;
import pl.jawegiel.charactercreator.characterdecorator.longsleeve.AdditiveLongsleeveMaleSky;
import pl.jawegiel.charactercreator.characterdecorator.pants.AdditivePantsFemaleBlack;
import pl.jawegiel.charactercreator.characterdecorator.pants.AdditivePantsFemaleGreen;
import pl.jawegiel.charactercreator.characterdecorator.pants.AdditivePantsMaleBlack;
import pl.jawegiel.charactercreator.characterdecorator.pants.AdditivePantsMaleGreen;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesFemaleBrown;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesFemaleSky;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesFemaleWhite;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesFemaleYellow;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesMaleBrown;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesMaleSky;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesMaleWhite;
import pl.jawegiel.charactercreator.characterdecorator.shoes.AdditiveShoesMaleYellow;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveFemaleBlue;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveFemaleGreen;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveFemaleSlate;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveFemaleTan;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveMaleBlue;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveMaleGreen;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveMaleSlate;
import pl.jawegiel.charactercreator.characterdecorator.shortsleeve.AdditiveShortsleeveMaleTan;
import pl.jawegiel.charactercreator.interfaces.Contract;
import pl.jawegiel.charactercreator.interfaces.IOnAdditiveAdded;

@Getter
@Setter
public class Model implements Contract.IModel, Contract.IModel.IModelFieldsHolder {

    public static final int MIN_INDEX = 0;
    public static final int MAX_INDEX_SKIN = 1;
    public static final int MAX_INDEX_HAIR = 18;
    public static final int MAX_INDEX_PANTS = 2;
    public static final int MAX_INDEX_LONGSLEEVE = 4;
    public static final int MAX_INDEX_SHORTSLEEVE = 4;
    public static final int MAX_INDEX_SHOES = 4;
    public static final int PREVIOUS = -1;
    public static final int NEXT = 1;

    private int skinIndex = 0, hairIndex = 0, pantsIndex = 0, longsleeveIndex = 0, shortsleeveIndex = 0, shoesIndex = 0;
    private List<CharacterDecorator> skinsList;
    private List<CharacterDecorator> hairList;
    private List<CharacterDecorator> pantsList;
    private List<CharacterDecorator> longsleeveList;
    private List<CharacterDecorator> shortsleeveList;
    private List<CharacterDecorator> shoesList;
    private BaseCharacter character;
    private CharacterCreator characterCreator;

    @Override
    public BaseCharacter getCharacter() {
        return character;
    }

    @Override
    public int getSkinIndex() {
        return skinIndex;
    }

    @Override
    public int getHairIndex() {
        return hairIndex;
    }

    @Override
    public int getPantsIndex() {
        return pantsIndex;
    }

    @Override
    public int getLongsleeveIndex() {
        return longsleeveIndex;
    }

    @Override
    public int getShortsleeveIndex() {
        return shortsleeveIndex;
    }

    @Override
    public int getShoesIndex() {
        return shoesIndex;
    }

    @Override
    public void init(Context context, IOnAdditiveAdded onAdditiveAdded) {
        character = new BaseCharacter(context, () -> {
            characterCreator.modifySprite(character.getBitmapFinal());
            characterCreator.createBitmapFrames(CharacterCreator.COL_COUNT);
        }, onAdditiveAdded);
        prepareElementsList();
    }

    private void prepareElementsList() {
        skinsList = List.of(new White(character), new Black(character));
        hairList = List.of(
                new AdditiveEmpty(character, SpriteElement.HAIR),
                new AdditiveHairNaturalBlack(character),
                new AdditiveHairNaturalBlond(character),
                new AdditiveHairNaturalBrown(character),
                new AdditiveHairHighAndTightBlack(character),
                new AdditiveHairHighAndTightBlond(character),
                new AdditiveHairHighAndTightBrown(character),
                new AdditiveHairCourtainBlack(character),
                new AdditiveHairCourtainBlond(character),
                new AdditiveHairCourtainBrown(character),
                new AdditiveHairLongMessyBlack(character),
                new AdditiveHairLongMessyBlond(character),
                new AdditiveHairLongMessyBrown(character),
                new AdditiveHairCurlyLongBlack(character),
                new AdditiveHairCurlyLongBlond(character),
                new AdditiveHairCurlyLongBrown(character),
                new AdditiveHairLooseBlack(character),
                new AdditiveHairLooseBlonde(character),
                new AdditiveHairLooseBrown(character));

        pantsList = character.getBaseSpriteElement() == SpriteElement.FEMALE ?
                List.of(new AdditiveEmpty(character, SpriteElement.PANTS_FEMALE), new AdditivePantsFemaleBlack(character), new AdditivePantsFemaleGreen(character))
                : List.of(new AdditiveEmpty(character, SpriteElement.PANTS_MALE), new AdditivePantsMaleBlack(character), new AdditivePantsMaleGreen(character));

        longsleeveList = character.getBaseSpriteElement() == SpriteElement.FEMALE ?
                List.of(new AdditiveEmpty(character, SpriteElement.LONGSLEEVE_FEMALE), new AdditiveLongsleeveFemaleForest(character), new AdditiveLongsleeveFemaleLavender(character), new AdditiveLongsleeveFemaleBrown(character), new AdditiveLongsleeveFemaleSky(character))
                : List.of(new AdditiveEmpty(character, SpriteElement.LONGSLEEVE_MALE), new AdditiveLongsleeveMaleForest(character), new AdditiveLongsleeveMaleLavender(character), new AdditiveLongsleeveMaleBrown(character), new AdditiveLongsleeveMaleSky(character));
        shortsleeveList = character.getBaseSpriteElement() == SpriteElement.FEMALE ?
                List.of(new AdditiveEmpty(character, SpriteElement.SHORTSLEEVE_FEMALE), new AdditiveShortsleeveFemaleBlue(character), new AdditiveShortsleeveFemaleTan(character), new AdditiveShortsleeveFemaleGreen(character), new AdditiveShortsleeveFemaleSlate(character))
                : List.of(new AdditiveEmpty(character, SpriteElement.SHORTSLEEVE_MALE), new AdditiveShortsleeveMaleBlue(character), new AdditiveShortsleeveMaleTan(character), new AdditiveShortsleeveMaleGreen(character), new AdditiveShortsleeveMaleSlate(character));
        shoesList = character.getBaseSpriteElement() == SpriteElement.FEMALE ?
                List.of(new AdditiveEmpty(character, SpriteElement.SHOES_FEMALE), new AdditiveShoesFemaleBrown(character), new AdditiveShoesFemaleSky(character), new AdditiveShoesFemaleWhite(character), new AdditiveShoesFemaleYellow(character))
                : List.of(new AdditiveEmpty(character, SpriteElement.SHOES_MALE), new AdditiveShoesMaleBrown(character), new AdditiveShoesMaleSky(character), new AdditiveShoesMaleWhite(character), new AdditiveShoesMaleYellow(character));
    }

    @Override
    public void setCharacterCreator(CharacterCreator characterCreator) {
        this.characterCreator = characterCreator;
    }

    @Override
    public void changeBaseCharacter(SpriteElement spriteElement) {
        character.changeBase(spriteElement);
    }

    @Override
    public void changeSkinIndex(int direction) {
        if (direction == Model.PREVIOUS) {
            skinIndex--;
        } else if (direction == Model.NEXT) {
            skinIndex++;
        }
    }

    @Override
    public void changeHairIndex(int direction) {
        if (direction == Model.PREVIOUS) {
            hairIndex--;
        } else if (direction == Model.NEXT) {
            hairIndex++;
        }
    }

    @Override
    public void changePantsIndex(int direction) {
        if (direction == Model.PREVIOUS) {
            pantsIndex--;
        } else if (direction == Model.NEXT) {
            pantsIndex++;
        }
    }

    @Override
    public void changeLongsleeveIndex(int direction) {
        if (direction == Model.PREVIOUS) {
            longsleeveIndex--;
        } else if (direction == Model.NEXT) {
            longsleeveIndex++;
        }
    }

    @Override
    public void changeShortsleeveIndex(int direction) {
        if (direction == Model.PREVIOUS) {
            shortsleeveIndex--;
        } else if (direction == Model.NEXT) {
            shortsleeveIndex++;
        }
    }

    @Override
    public void changeShoesIndex(int direction) {
        if (direction == Model.PREVIOUS) {
            shoesIndex--;
        } else if (direction == Model.NEXT) {
            shoesIndex++;
        }
    }

    @Override
    public void appendSkin() {
        character.appendSkin(skinsList.get(skinIndex));
    }

    @Override
    public void appendAdditiveHair() {
        character.appendAdditive(hairList.get(hairIndex));
    }

    @Override
    public void appendAdditivePants() {
        if (pantsIndex == 0) {
            character.appendAdditive(new AdditiveEmpty(character, character.getBaseSpriteElement() == SpriteElement.MALE ?
                    SpriteElement.PANTS_MALE :
                    SpriteElement.PANTS_FEMALE));
        } else {
            character.appendAdditive(pantsList.get(pantsIndex));
        }
    }

    @Override
    public void appendAdditiveLongsleeve() {
        if (longsleeveIndex == 0) {
            character.appendAdditive(new AdditiveEmpty(character, character.getBaseSpriteElement() == SpriteElement.MALE ?
                    SpriteElement.LONGSLEEVE_MALE :
                    SpriteElement.LONGSLEEVE_FEMALE));
        } else {
            character.appendAdditive(longsleeveList.get(longsleeveIndex));
        }
    }

    @Override
    public void appendAdditiveShortsleeve() {
        if (shortsleeveIndex == 0) {
            character.appendAdditive(new AdditiveEmpty(character, character.getBaseSpriteElement() == SpriteElement.MALE ?
                    SpriteElement.SHORTSLEEVE_MALE :
                    SpriteElement.SHORTSLEEVE_FEMALE));
        } else {
            character.appendAdditive(shortsleeveList.get(shortsleeveIndex));
        }
    }

    @Override
    public void appendAdditiveShoes() {
        if (shoesIndex == 0) {
            character.appendAdditive(new AdditiveEmpty(character, character.getBaseSpriteElement() == SpriteElement.MALE ?
                    SpriteElement.SHOES_MALE :
                    SpriteElement.SHOES_FEMALE));
        } else {
            character.appendAdditive(shoesList.get(shoesIndex));
        }
    }

    @Override
    public void doWhenResetButton(Context context, IOnAdditiveAdded onAdditiveAdded) {
        character.doOnStartBase(context, onAdditiveAdded);
        character.changeBase(SpriteElement.MALE);

        skinIndex = 0;
        hairIndex = 0;
        pantsIndex = 0;
        longsleeveIndex = 0;
        shortsleeveIndex = 0;
        shoesIndex = 0;
    }

    @Override
    public void prepareElementsRandomization() {
        int randomizedHairIndex = new Random().nextInt(hairList.size());
        character.appendAdditive(hairList.get(randomizedHairIndex));
        hairIndex = randomizedHairIndex;

        int randomizedPantsIndex = new Random().nextInt(pantsList.size() - 1) + 1;
        character.appendAdditive(pantsList.get(randomizedPantsIndex));
        pantsIndex = randomizedPantsIndex;

        int shortOrLong = new Random().nextInt(2);
        if (shortOrLong == 0) {
            appendLongsleeve();
        } else {
            appendShortsleeve();
        }

        int randomizedShoesIndex = new Random().nextInt(shoesList.size());
        character.appendAdditive(shoesList.get(randomizedShoesIndex));
        shoesIndex = randomizedShoesIndex;
    }

    private void appendShortsleeve() {
        character.deleteAdditive(character.getBaseSpriteElement() == SpriteElement.MALE ?
                SpriteElement.LONGSLEEVE_MALE
                : SpriteElement.LONGSLEEVE_FEMALE);
        int randomizedShortsleeveIndex = character.getBaseSpriteElement() == SpriteElement.MALE ?
                new Random().nextInt(shortsleeveList.size()) :
                new Random().nextInt(shortsleeveList.size() - 1) + 1;
        character.appendAdditive(shortsleeveList.get(randomizedShortsleeveIndex));
        shortsleeveIndex = randomizedShortsleeveIndex;
    }

    private void appendLongsleeve() {
        character.deleteAdditive(character.getBaseSpriteElement() == SpriteElement.MALE ?
                SpriteElement.SHORTSLEEVE_MALE
                : SpriteElement.SHORTSLEEVE_FEMALE);
        int randomizedLongsleeveIndex = character.getBaseSpriteElement() == SpriteElement.MALE ?
                new Random().nextInt(longsleeveList.size()) :
                new Random().nextInt(longsleeveList.size() - 1) + 1;
        character.appendAdditive(longsleeveList.get(randomizedLongsleeveIndex));
        longsleeveIndex = randomizedLongsleeveIndex;
    }

    @Override
    public boolean isMaleNude() {
        return character.getDecorationsMap().get(SpriteElement.PANTS_MALE) == null;
    }

    @Override
    public boolean isFemaleNude() {
        return (character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_FEMALE) == null
                || character.getDecorationsMap().get(SpriteElement.PANTS_FEMALE) == null)
                && (character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_FEMALE) == null
                || character.getDecorationsMap().get(SpriteElement.PANTS_FEMALE) == null);
    }

    @Override
    public void managePantsWhenSwitchToFemale() {
        pantsList = List.of(new AdditiveEmpty(character, SpriteElement.PANTS_FEMALE), new AdditivePantsFemaleBlack(character), new AdditivePantsFemaleGreen(character));
        if (character.getDecorationsMap().get(SpriteElement.PANTS_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.PANTS_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.PANTS_MALE) != null)
                character.deleteAdditive(SpriteElement.PANTS_MALE);
            switch (pantsIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.PANTS_FEMALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(pantsList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(pantsList.get(2));
                    break;
                }
            }
        }
    }

    @Override
    public void managePantsWhenSwitchToMale() {
        pantsList = List.of(new AdditiveEmpty(character, SpriteElement.PANTS_MALE), new AdditivePantsMaleBlack(character), new AdditivePantsMaleGreen(character));
        if (character.getDecorationsMap().get(SpriteElement.PANTS_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.PANTS_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.PANTS_FEMALE) != null)
                character.deleteAdditive(SpriteElement.PANTS_FEMALE);
            switch (pantsIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.PANTS_MALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(pantsList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(pantsList.get(2));
                    break;
                }
            }
        }
    }

    @Override
    public void manageLongsleeveWhenSwitchToFemale() {
        longsleeveList = List.of(new AdditiveEmpty(character, SpriteElement.LONGSLEEVE_FEMALE), new AdditiveLongsleeveFemaleForest(character), new AdditiveLongsleeveFemaleLavender(character), new AdditiveLongsleeveFemaleBrown(character), new AdditiveLongsleeveFemaleSky(character));
        if (character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_MALE) != null)
                character.deleteAdditive(SpriteElement.LONGSLEEVE_MALE);
            switch (longsleeveIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.LONGSLEEVE_FEMALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(longsleeveList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(longsleeveList.get(2));
                    break;
                }
                case 3: {
                    character.appendAdditive(longsleeveList.get(3));
                    break;
                }
                case 4: {
                    character.appendAdditive(longsleeveList.get(4));
                    break;
                }
            }
        }
    }

    @Override
    public void manageLongsleeveWhenSwitchToMale() {
        longsleeveList = List.of(new AdditiveEmpty(character, SpriteElement.LONGSLEEVE_MALE), new AdditiveLongsleeveMaleForest(character), new AdditiveLongsleeveMaleLavender(character), new AdditiveLongsleeveMaleBrown(character), new AdditiveLongsleeveMaleSky(character));
        if (character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.LONGSLEEVE_FEMALE) != null)
                character.deleteAdditive(SpriteElement.LONGSLEEVE_FEMALE);
            switch (longsleeveIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.LONGSLEEVE_MALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(longsleeveList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(longsleeveList.get(2));
                    break;
                }
                case 3: {
                    character.appendAdditive(longsleeveList.get(3));
                    break;
                }
                case 4: {
                    character.appendAdditive(longsleeveList.get(4));
                    break;
                }
            }
        }
    }

    @Override
    public void manageShortsleeveWhenSwitchToFemale() {
        shortsleeveList = List.of(new AdditiveEmpty(character, SpriteElement.SHORTSLEEVE_FEMALE), new AdditiveShortsleeveFemaleBlue(character), new AdditiveShortsleeveFemaleTan(character), new AdditiveShortsleeveFemaleGreen(character), new AdditiveShortsleeveFemaleSlate(character));
        if (character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_MALE) != null)
                character.deleteAdditive(SpriteElement.SHORTSLEEVE_MALE);
            switch (shortsleeveIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.SHORTSLEEVE_FEMALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(shortsleeveList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(shortsleeveList.get(2));
                    break;
                }
                case 3: {
                    character.appendAdditive(shortsleeveList.get(3));
                    break;
                }
                case 4: {
                    character.appendAdditive(shortsleeveList.get(4));
                    break;
                }
            }
        }
    }

    @Override
    public void manageShortsleeveWhenSwitchToMale() {
        shortsleeveList = List.of(new AdditiveEmpty(character, SpriteElement.SHORTSLEEVE_MALE), new AdditiveShortsleeveMaleBlue(character), new AdditiveShortsleeveMaleTan(character), new AdditiveShortsleeveMaleGreen(character), new AdditiveShortsleeveMaleSlate(character));
        if (character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.SHORTSLEEVE_FEMALE) != null)
                character.deleteAdditive(SpriteElement.SHORTSLEEVE_FEMALE);
            switch (shortsleeveIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.SHORTSLEEVE_MALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(shortsleeveList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(shortsleeveList.get(2));
                    break;
                }
                case 3: {
                    character.appendAdditive(shortsleeveList.get(3));
                    break;
                }
                case 4: {
                    character.appendAdditive(shortsleeveList.get(4));
                    break;
                }
            }
        }
    }

    @Override
    public void manageShoesWhenSwitchToFemale() {
        shoesList = List.of(new AdditiveEmpty(character, SpriteElement.SHOES_FEMALE), new AdditiveShoesFemaleBrown(character), new AdditiveShoesFemaleSky(character), new AdditiveShoesFemaleWhite(character), new AdditiveShoesFemaleYellow(character));
        if (character.getDecorationsMap().get(SpriteElement.SHOES_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.SHOES_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.SHOES_MALE) != null)
                character.deleteAdditive(SpriteElement.SHOES_MALE);
            switch (shoesIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.SHOES_FEMALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(shoesList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(shoesList.get(2));
                    break;
                }
                case 3: {
                    character.appendAdditive(shoesList.get(3));
                    break;
                }
                case 4: {
                    character.appendAdditive(shoesList.get(4));
                    break;
                }
            }
        }
    }

    @Override
    public void manageShoesWhenSwitchToMale() {
        shoesList = List.of(new AdditiveEmpty(character, SpriteElement.SHOES_MALE), new AdditiveShoesMaleBrown(character), new AdditiveShoesMaleSky(character), new AdditiveShoesMaleWhite(character), new AdditiveShoesMaleYellow(character));
        if (character.getDecorationsMap().get(SpriteElement.SHOES_MALE) != null ||
                character.getDecorationsMap().get(SpriteElement.SHOES_FEMALE) != null) {
            if (character.getDecorationsMap().get(SpriteElement.SHOES_FEMALE) != null)
                character.deleteAdditive(SpriteElement.SHOES_FEMALE);
            switch (shoesIndex) {
                case 0: {
                    character.appendAdditive(new AdditiveEmpty(character, SpriteElement.SHOES_MALE));
                    break;
                }
                case 1: {
                    character.appendAdditive(shoesList.get(1));
                    break;
                }
                case 2: {
                    character.appendAdditive(shoesList.get(2));
                    break;
                }
                case 3: {
                    character.appendAdditive(shoesList.get(3));
                    break;
                }
                case 4: {
                    character.appendAdditive(shoesList.get(4));
                    break;
                }
            }
        }
    }
}
