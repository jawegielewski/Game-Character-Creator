package pl.jawegiel.charactercreator.interfaces;

import android.content.Context;

import pl.jawegiel.charactercreator.CharacterCreator;
import pl.jawegiel.charactercreator.characterdecorator.BaseCharacter;
import pl.jawegiel.charactercreator.characterdecorator.SpriteElement;

public interface Contract {

    interface IModel {

        interface IModelFieldsHolder {

            BaseCharacter getCharacter();

            int getSkinIndex();

            int getHairIndex();

            int getPantsIndex();

            int getLongsleeveIndex();

            int getShortsleeveIndex();

            int getShoesIndex();
        }

        void init(Context context, IOnAdditiveAdded onAdditiveAdded);

        void setCharacterCreator(CharacterCreator characterCreator);

        void changeBaseCharacter(SpriteElement spriteElement);

        void changeSkinIndex(int direction);

        void changeHairIndex(int direction);

        void changePantsIndex(int direction);

        void changeLongsleeveIndex(int direction);

        void changeShortsleeveIndex(int direction);

        void changeShoesIndex(int direction);

        void appendSkin();

        void appendAdditiveHair();

        void appendAdditivePants();

        void appendAdditiveLongsleeve();

        void appendAdditiveShortsleeve();

        void appendAdditiveShoes();

        void doWhenResetButton(Context context, IOnAdditiveAdded onAdditiveAdded);

        void prepareElementsRandomization();

        boolean isMaleNude();

        boolean isFemaleNude();

        void managePantsWhenSwitchToMale();

        void manageLongsleeveWhenSwitchToMale();

        void manageShortsleeveWhenSwitchToMale();

        void manageShoesWhenSwitchToMale();

        void managePantsWhenSwitchToFemale();

        void manageLongsleeveWhenSwitchToFemale();

        void manageShortsleeveWhenSwitchToFemale();

        void manageShoesWhenSwitchToFemale();
    }


    interface IView {

        void ivArrowsRightOnClickForMaleOrFemaleNude();

        void ivArrowsRightOnClickForMaleOrFemaleNotNude();

        void doOnSkinBtnsRandomization(int skinIndex, int maxIndexSkin);

        void doOnHairBtnsRandomization(int hairIndex, int maxIndexHair);

        void doOnPantsBtnsRandomization(int pantsIndex, int maxIndexPants);

        void doOnLongsleeveBtnsRandomization(int longsleeveIndex, int maxIndexLonglseeve);

        void doOnShortsleeveBtnsRandomization(int shortsleeveIndex, int maxIndexShortsleeve);

        void doOnShoesBtnsRandomization(int shoesIndex, int maxIndexShoes);

        void doOnSkinBtnOnAddedBase(int skinIndex, int maxIndexSkin);

        void doOnHairBtnOnAddedBase(int hairIndex, int maxIndexHair);

        void doOnPantsBtnOnAddedBase(int pantsIndex, int maxIndexPants);

        void doOnLongsleeveBtnOnAddedBase(int longsleeveIndex, int maxIndexLonglseeve);

        void doOnShortsleeveBtnOnAddedBase(int shortsleeveIndex, int maxIndexShortsleeve);

        void doOnShoesBtnOnAddedBase(int shoesIndex, int maxIndexShoes);

        void doOtherOnAddedBase();

        void doSexSwitchWhenAddedMaleFemale();

        void doOnSkinViewsOnAddedSkin(String decoratorItemDesc, int skinIndex, int maxIndexSkin);

        void doOnHairViewsOnAddedHair(String decoratorItemDesc, int hairIndex, int maxIndexHair);

        void doOnPantsViewsOnAddedPants(String decoratorItemDesc, int pantsIndex, int maxIndexPants);

        void doOnLongsleeveViewsOnAddedLongsleeve(String decoratorItemDesc, int longsleeveIndex, int maxIndexLonglseeve);

        void doOnShortsleeveViewsOnAddedLongsleeve(String decoratorItemDesc, int shortsleeveIndex, int maxIndexShortsleeve);

        void doOnShoesViewsOnAddedShoes(String decoratorItemDesc, int shoesIndex, int maxIndexShoes);
    }


    interface IPresenter {

        void setCharacterCreator(CharacterCreator characterCreator);

        void changeBaseCharacter(SpriteElement spriteElement);

        void changeSkinIndex(int direction);

        void changeHairIndex(int direction);

        void changePantsIndex(int direction);

        void changeLongsleeveIndex(int direction);

        void changeShortsleeveIndex(int direction);

        void changeShoesIndex(int direction);

        void appendSkin();

        void appendAdditiveHair();

        void appendAdditivePants();

        void appendAdditiveLongsleeve();

        void appendAdditiveShortsleeve();

        void appendAdditiveShoes();

        void handleArrowLogic();

        void doWhenResetButton(Context context, IOnAdditiveAdded onAdditiveAdded);

        void prepareElementsRandomization();

        void onAdded(SpriteElement spriteElement);
    }
}
