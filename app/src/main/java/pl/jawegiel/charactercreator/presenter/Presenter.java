package pl.jawegiel.charactercreator.presenter;

import android.content.Context;

import pl.jawegiel.charactercreator.CharacterCreator;
import pl.jawegiel.charactercreator.activities.ActivityCharacterCreator;
import pl.jawegiel.charactercreator.characterdecorator.SpriteElement;
import pl.jawegiel.charactercreator.interfaces.Contract;
import pl.jawegiel.charactercreator.interfaces.IOnAdditiveAdded;
import pl.jawegiel.charactercreator.model.Model;

public class Presenter implements Contract.IPresenter {

    Contract.IModel model;
    Contract.IModel.IModelFieldsHolder modelFieldsHolder;
    Contract.IView view;

    public Presenter(ActivityCharacterCreator view, Model model) {
        this.model = model;
        this.modelFieldsHolder = model;
        this.view = view;
    }

    public void initModel(Context context, IOnAdditiveAdded onAdditiveAdded) {
        model.init(context, onAdditiveAdded);
    }

    @Override
    public void setCharacterCreator(CharacterCreator characterCreator) {
        model.setCharacterCreator(characterCreator);
    }

    @Override
    public void changeBaseCharacter(SpriteElement spriteElement) {
        model.changeBaseCharacter(spriteElement);
    }

    @Override
    public void changeSkinIndex(int direction) {
        model.changeSkinIndex(direction);
    }

    @Override
    public void changeHairIndex(int direction) {
        model.changeHairIndex(direction);
    }

    @Override
    public void changePantsIndex(int direction) {
        model.changePantsIndex(direction);
    }

    @Override
    public void changeLongsleeveIndex(int direction) {
        model.changeLongsleeveIndex(direction);
    }

    @Override
    public void changeShortsleeveIndex(int direction) {
        model.changeShortsleeveIndex(direction);
    }

    @Override
    public void changeShoesIndex(int direction) {
        model.changeShoesIndex(direction);
    }

    @Override
    public void appendSkin() {
        model.appendSkin();
    }


    @Override
    public void appendAdditiveHair() {
        model.appendAdditiveHair();
    }

    @Override
    public void appendAdditivePants() {
        model.appendAdditivePants();
    }

    @Override
    public void appendAdditiveLongsleeve() {
        model.appendAdditiveLongsleeve();
    }

    @Override
    public void appendAdditiveShortsleeve() {
        model.appendAdditiveShortsleeve();
    }

    @Override
    public void appendAdditiveShoes() {
        model.appendAdditiveShoes();
    }

    @Override
    public void handleArrowLogic() {
        if (modelFieldsHolder.getCharacter().getBaseSpriteElement() == SpriteElement.MALE) {
            if (model.isMaleNude())
                view.ivArrowsRightOnClickForMaleOrFemaleNude();
            else
                view.ivArrowsRightOnClickForMaleOrFemaleNotNude();
        }
        if (modelFieldsHolder.getCharacter().getBaseSpriteElement() == SpriteElement.FEMALE) {
            if (model.isFemaleNude())
                view.ivArrowsRightOnClickForMaleOrFemaleNude();
            else
                view.ivArrowsRightOnClickForMaleOrFemaleNotNude();
        }
    }

    @Override
    public void doWhenResetButton(Context context, IOnAdditiveAdded onAdditiveAdded) {
        model.doWhenResetButton(context, onAdditiveAdded);
    }

    @Override
    public void prepareElementsRandomization() {
        model.prepareElementsRandomization();

        view.doOnSkinBtnsRandomization(modelFieldsHolder.getSkinIndex(), Model.MAX_INDEX_SKIN);
        view.doOnHairBtnsRandomization(modelFieldsHolder.getHairIndex(), Model.MAX_INDEX_HAIR);
        view.doOnPantsBtnsRandomization(modelFieldsHolder.getPantsIndex(), Model.MAX_INDEX_PANTS);
        view.doOnLongsleeveBtnsRandomization(modelFieldsHolder.getLongsleeveIndex(), Model.MAX_INDEX_LONGSLEEVE);
        view.doOnShortsleeveBtnsRandomization(modelFieldsHolder.getShortsleeveIndex(), Model.MAX_INDEX_SHORTSLEEVE);
        view.doOnShoesBtnsRandomization(modelFieldsHolder.getShoesIndex(), Model.MAX_INDEX_SHOES);
    }

    @Override
    public void onAdded(SpriteElement spriteElement) {
        if (spriteElement == SpriteElement.BASE) {
            doOnBaseAdded();
        }
        if (spriteElement == SpriteElement.MALE) {
            doOnMaleAdded();
        }
        if (spriteElement == SpriteElement.FEMALE) {
            doOnFemaleAdded();
        }


        if (spriteElement == SpriteElement.SKIN) {
            view.doOnSkinViewsOnAddedSkin(modelFieldsHolder.getCharacter().getDecoratorItemDescription(SpriteElement.SKIN), modelFieldsHolder.getSkinIndex(), Model.MAX_INDEX_SKIN);
        } else if (spriteElement == SpriteElement.HAIR) {
            view.doOnHairViewsOnAddedHair(modelFieldsHolder.getCharacter().getDecoratorItemDescription(SpriteElement.HAIR), modelFieldsHolder.getHairIndex(), Model.MAX_INDEX_HAIR);
        } else if (spriteElement == SpriteElement.PANTS_MALE || spriteElement == SpriteElement.PANTS_FEMALE) {
            view.doOnPantsViewsOnAddedPants(modelFieldsHolder.getCharacter().getDecoratorItemDescription(spriteElement == SpriteElement.PANTS_MALE ?
                    SpriteElement.PANTS_MALE
                    : SpriteElement.PANTS_FEMALE), modelFieldsHolder.getPantsIndex(), Model.MAX_INDEX_PANTS);
        } else if (spriteElement == SpriteElement.LONGSLEEVE_MALE || spriteElement == SpriteElement.LONGSLEEVE_FEMALE) {
            view.doOnLongsleeveViewsOnAddedLongsleeve(modelFieldsHolder.getCharacter().getDecoratorItemDescription(spriteElement == SpriteElement.LONGSLEEVE_MALE ?
                    SpriteElement.LONGSLEEVE_MALE
                    : SpriteElement.LONGSLEEVE_FEMALE), modelFieldsHolder.getLongsleeveIndex(), Model.MAX_INDEX_LONGSLEEVE);
        } else if (spriteElement == SpriteElement.SHORTSLEEVE_MALE || spriteElement == SpriteElement.SHORTSLEEVE_FEMALE) {
            view.doOnShortsleeveViewsOnAddedLongsleeve(modelFieldsHolder.getCharacter().getDecoratorItemDescription(spriteElement == SpriteElement.SHORTSLEEVE_MALE ?
                    SpriteElement.SHORTSLEEVE_MALE
                    : SpriteElement.SHORTSLEEVE_FEMALE), modelFieldsHolder.getShortsleeveIndex(), Model.MAX_INDEX_SHORTSLEEVE);
        } else if (spriteElement == SpriteElement.SHOES_MALE || spriteElement == SpriteElement.SHOES_FEMALE) {
            view.doOnShoesViewsOnAddedShoes(modelFieldsHolder.getCharacter().getDecoratorItemDescription(spriteElement == SpriteElement.SHOES_MALE ?
                    SpriteElement.SHOES_MALE
                    : SpriteElement.SHOES_FEMALE), modelFieldsHolder.getShoesIndex(), Model.MAX_INDEX_SHOES);
        }
    }

    private void doOnFemaleAdded() {
        view.doSexSwitchWhenAddedMaleFemale();
        model.managePantsWhenSwitchToFemale();
        model.manageLongsleeveWhenSwitchToFemale();
        model.manageShortsleeveWhenSwitchToFemale();
        model.manageShoesWhenSwitchToFemale();
    }

    private void doOnMaleAdded() {
        view.doSexSwitchWhenAddedMaleFemale();
        model.managePantsWhenSwitchToMale();
        model.manageLongsleeveWhenSwitchToMale();
        model.manageShortsleeveWhenSwitchToMale();
        model.manageShoesWhenSwitchToMale();
    }

    private void doOnBaseAdded() {
        view.doOtherOnAddedBase();
        view.doOnSkinBtnOnAddedBase(modelFieldsHolder.getSkinIndex(), Model.MAX_INDEX_SKIN);
        view.doOnHairBtnOnAddedBase(modelFieldsHolder.getHairIndex(), Model.MAX_INDEX_HAIR);
        view.doOnPantsBtnOnAddedBase(modelFieldsHolder.getPantsIndex(), Model.MAX_INDEX_PANTS);
        view.doOnLongsleeveBtnOnAddedBase(modelFieldsHolder.getLongsleeveIndex(), Model.MAX_INDEX_LONGSLEEVE);
        view.doOnShortsleeveBtnOnAddedBase(modelFieldsHolder.getShortsleeveIndex(), Model.MAX_INDEX_SHORTSLEEVE);
        view.doOnShoesBtnOnAddedBase(modelFieldsHolder.getShoesIndex(), Model.MAX_INDEX_SHOES);
    }
}
