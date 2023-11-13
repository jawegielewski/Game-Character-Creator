package pl.jawegiel.charactercreator.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SwitchCompat;

import lombok.Getter;
import lombok.Setter;
import pl.droidsonroids.gif.GifImageView;
import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.SpriteElement;
import pl.jawegiel.charactercreator.interfaces.Contract;
import pl.jawegiel.charactercreator.interfaces.IOnAdditiveAdded;
import pl.jawegiel.charactercreator.model.Model;
import pl.jawegiel.charactercreator.presenter.Presenter;
import pl.jawegiel.charactercreator.views.CharacterCreatorBgView;
import pl.jawegiel.charactercreator.views.CharacterCreatorView;

public final class ActivityCharacterCreator extends ActivityBase implements Contract.IView, IOnAdditiveAdded {

    private Button bReset, bSkinPrevious, bSkinNext, bHairPrevious, bHairNext, bPantsPrevious, bPantsNext, bLongsleevePrevious, bLongsleeveNext, bShortsleevePrevious, bShortsleeveNext, bShoesPrevious, bShoesNext, bRandomize;
    private TextView tvActivityTitle, tvElementSkin, tvElementHair, tvElementPants, tvElementLongsleeve, tvElementShortsleeve, tvElementShoes;
    private SwitchCompat switchSex;
    private ProgressBar pb;
    private ImageView ivArrowsRight;
    private GifImageView gifRandomize;
    private CharacterCreatorView characterCreatorView;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);

        initFields();

        presenter = new Presenter(this, new Model());

        characterCreatorView = findViewById(R.id.character_creator_view);
        characterCreatorView.setOnCharacterCreatorCreated(characterCreator -> {
            presenter.setCharacterCreator(characterCreator);
            ((CharacterCreatorBgView) findViewById(R.id.character_creator_bg_view)).setCharacterCreator(characterCreator);
            setViewsListeners();
        });

        characterCreatorView.setVisibility(View.GONE);

        presenter.initModel(this, this);
    }


    private void initFields() {
        initPreviousElementsButtons();
        initNextElementsButtons();
        initElementNamesTextviews();
        initAnotherViews();
        setViewsProperties();
    }

    @SuppressLint("SetTextI18n")
    private void setViewsProperties() {
        tvActivityTitle.setText("Customize your character.", TextView.BufferType.SPANNABLE);
        switchSex.setEnabled(false);
        bSkinNext.setEnabled(false);
        bHairNext.setEnabled(false);
        bPantsNext.setEnabled(false);
        bLongsleeveNext.setEnabled(false);
        bShortsleeveNext.setEnabled(false);
        bShoesNext.setEnabled(false);
        pb.setVisibility(View.VISIBLE);

        setImageViewArrowsProperties();
    }

    private void initAnotherViews() {
        tvActivityTitle = findViewById(R.id.tv_activity_title);
        bReset = findViewById(R.id.b_reset);
        switchSex = findViewById(R.id.sw_sex);
        gifRandomize = findViewById(R.id.gif_randomize);
        bRandomize = findViewById(R.id.b_randomize);
        pb = findViewById(R.id.pb);
        ivArrowsRight = findViewById(R.id.iv_arrows_right);
    }

    private void initElementNamesTextviews() {
        tvElementSkin = findViewById(R.id.tv_element_skin);
        tvElementHair = findViewById(R.id.tv_element_hair);
        tvElementPants = findViewById(R.id.tv_element_pants);
        tvElementLongsleeve = findViewById(R.id.tv_element_longsleeve);
        tvElementShortsleeve = findViewById(R.id.tv_element_shortsleeve);
        tvElementShoes = findViewById(R.id.tv_element_shoes);
    }

    private void initNextElementsButtons() {
        bSkinNext = findViewById(R.id.b_next_skin);
        bHairNext = findViewById(R.id.b_next_hair);
        bPantsNext = findViewById(R.id.b_next_pants);
        bLongsleeveNext = findViewById(R.id.b_next_longsleeve);
        bShortsleeveNext = findViewById(R.id.b_next_shortsleeve);
        bShoesNext = findViewById(R.id.b_next_shoes);
    }

    private void initPreviousElementsButtons() {
        bSkinPrevious = findViewById(R.id.b_previous_skin);
        bHairPrevious = findViewById(R.id.b_previous_hair);
        bPantsPrevious = findViewById(R.id.b_previous_pants);
        bLongsleevePrevious = findViewById(R.id.b_previous_longsleeve);
        bShortsleevePrevious = findViewById(R.id.b_previous_shortsleeve);
        bShoesPrevious = findViewById(R.id.b_previous_shoes);
    }

    private void setViewsListeners() {
        setSwitchSexListener();
        setButtonsSkinListener();
        setButtonsHairListener();
        setButtonsPantsListener();
        setButtonsLongsleeveListener();
        setButtonsShortsleeveListener();
        setButtonsShoesListener();
        setButtonResetListener();
        setButtonRandomizeListener();
    }

    private void setImageViewArrowsProperties() {
        ivArrowsRight.setVisibility(View.VISIBLE);
        ivArrowsRight.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));
        ivArrowsRight.setOnClickListener(view -> presenter.handleArrowLogic());
    }

    @Override
    public void ivArrowsRightOnClickForMaleOrFemaleNude() {
        Toast.makeText(ActivityCharacterCreator.this, "Dress your character", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ivArrowsRightOnClickForMaleOrFemaleNotNude() {
        Toast.makeText(ActivityCharacterCreator.this, "Have a nice day!", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    private void setButtonResetListener() {
        bReset.setOnClickListener(view -> {
            presenter.doWhenResetButton(this, this);

            switchSex.setChecked(false);
            bSkinPrevious.setEnabled(false);
            bSkinNext.setEnabled(true);
            tvElementSkin.setText("white");
            bHairPrevious.setEnabled(false);
            bHairNext.setEnabled(true);
            tvElementHair.setText("no hair");
            bPantsPrevious.setEnabled(false);
            bPantsNext.setEnabled(true);
            tvElementPants.setText("no pants");
            bLongsleevePrevious.setEnabled(false);
            bLongsleeveNext.setEnabled(true);
            tvElementLongsleeve.setText("no longsleeve");
            bShortsleevePrevious.setEnabled(false);
            bShortsleeveNext.setEnabled(true);
            tvElementShortsleeve.setText("no shortsleeve");
            bShoesPrevious.setEnabled(false);
            bShoesNext.setEnabled(true);
            tvElementShoes.setText("no shoes");
        });
    }

    private void setButtonRandomizeListener() {
        bRandomize.setEnabled(true);
        bRandomize.setOnClickListener(view -> {
            presenter.prepareElementsRandomization();
            bRandomize.setEnabled(false);
            gifRandomize.setVisibility(View.VISIBLE);
            view.postDelayed(() -> {
                gifRandomize.setVisibility(View.GONE);
                bRandomize.setEnabled(true);
            }, 500);
        });
    }

    @Override
    public void doOnSkinBtnsRandomization(int skinIndex, int maxIndexSkin) {
        bSkinPrevious.setEnabled(skinIndex > 0);
        bSkinNext.setEnabled(skinIndex < maxIndexSkin);
    }

    @Override
    public void doOnHairBtnsRandomization(int hairIndex, int maxIndexHair) {
        bHairPrevious.setEnabled(hairIndex > 0);
        bHairNext.setEnabled(hairIndex < maxIndexHair);
    }

    @Override
    public void doOnPantsBtnsRandomization(int pantsIndex, int maxIndexPants) {
        bPantsPrevious.setEnabled(pantsIndex > 0);
        bPantsNext.setEnabled(pantsIndex < maxIndexPants);
    }

    @Override
    public void doOnLongsleeveBtnsRandomization(int longsleeveIndex, int maxIndexLonglseeve) {
        bLongsleevePrevious.setEnabled(longsleeveIndex > 0);
        bLongsleeveNext.setEnabled(longsleeveIndex < maxIndexLonglseeve);
    }

    @Override
    public void doOnShortsleeveBtnsRandomization(int shortsleeveIndex, int maxIndexShortsleeve) {
        bShortsleevePrevious.setEnabled(shortsleeveIndex > 0);
        bShortsleeveNext.setEnabled(shortsleeveIndex < maxIndexShortsleeve);
    }

    @Override
    public void doOnShoesBtnsRandomization(int shoesIndex, int maxIndexShoes) {
        bShoesPrevious.setEnabled(shoesIndex > 0);
        bShoesNext.setEnabled(shoesIndex < maxIndexShoes);
    }

    private void setSwitchSexListener() {
        switchSex.setOnCheckedChangeListener((buttonView, isWoman) -> {
            switchSex.setEnabled(false);
            presenter.changeBaseCharacter(isWoman ? SpriteElement.FEMALE : SpriteElement.MALE);
        });
    }

    private void setButtonsSkinListener() {
        bSkinPrevious.setOnClickListener(v -> onSkinChangeListener(-1));
        bSkinNext.setOnClickListener(v -> onSkinChangeListener(1));
    }

    private void onSkinChangeListener(int direction) {
        presenter.changeSkinIndex(direction);

        bSkinPrevious.setEnabled(false);
        bSkinNext.setEnabled(false);

        presenter.appendSkin();
    }

    private void setButtonsHairListener() {
        bHairPrevious.setOnClickListener(v -> onHairChangeListener(-1));
        bHairNext.setOnClickListener(v -> onHairChangeListener(1));
    }

    private void onHairChangeListener(int direction) {
        presenter.changeHairIndex(direction);

        bHairPrevious.setEnabled(false);
        bHairNext.setEnabled(false);

        presenter.appendAdditiveHair();
    }

    private void setButtonsPantsListener() {
        bPantsPrevious.setOnClickListener(v -> onPantsChangeListener(-1));
        bPantsNext.setOnClickListener(v -> onPantsChangeListener(1));
    }

    private void onPantsChangeListener(int direction) {
        presenter.changePantsIndex(direction);

        bPantsPrevious.setEnabled(false);
        bPantsNext.setEnabled(false);

        presenter.appendAdditivePants();
    }

    private void setButtonsLongsleeveListener() {
        bLongsleevePrevious.setOnClickListener(v -> onLongsleeveChangeListener(-1));
        bLongsleeveNext.setOnClickListener(v -> onLongsleeveChangeListener(1));
    }

    private void onLongsleeveChangeListener(int direction) {
        presenter.changeLongsleeveIndex(direction);

        bLongsleevePrevious.setEnabled(false);
        bLongsleeveNext.setEnabled(false);

        presenter.appendAdditiveLongsleeve();
    }

    private void setButtonsShortsleeveListener() {
        bShortsleevePrevious.setOnClickListener(v -> onShortsleeveChangeListener(-1));
        bShortsleeveNext.setOnClickListener(v -> onShortsleeveChangeListener(1));
    }

    private void onShortsleeveChangeListener(int direction) {
        presenter.changeShortsleeveIndex(direction);

        bShortsleevePrevious.setEnabled(false);
        bShortsleeveNext.setEnabled(false);

        presenter.appendAdditiveShortsleeve();
    }

    private void setButtonsShoesListener() {
        bShoesPrevious.setOnClickListener(v -> onShoesChangeListener(-1));
        bShoesNext.setOnClickListener(v -> onShoesChangeListener(1));
    }

    private void onShoesChangeListener(int direction) {
        presenter.changeShoesIndex(direction);

        bShoesPrevious.setEnabled(false);
        bShoesNext.setEnabled(false);

        presenter.appendAdditiveShoes();
    }

    @Override
    public void onAdded(SpriteElement spriteElement) {
        presenter.onAdded(spriteElement);
    }

    @Override
    public void doSexSwitchWhenAddedMaleFemale() {
        switchSex.setEnabled(true);
    }

    @Override
    public void doOtherOnAddedBase() {
        switchSex.setEnabled(true);
        bRandomize.setEnabled(true);
        characterCreatorView.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
    }

    @Override
    public void doOnSkinBtnOnAddedBase(int skinIndex, int maxIndexSkin) {
        bSkinNext.setEnabled(skinIndex < maxIndexSkin);
    }

    @Override
    public void doOnHairBtnOnAddedBase(int hairIndex, int maxIndexHair) {
        bHairNext.setEnabled(hairIndex < maxIndexHair);
    }

    @Override
    public void doOnPantsBtnOnAddedBase(int pantsIndex, int maxIndexPants) {
        bPantsNext.setEnabled(pantsIndex < maxIndexPants);
    }

    @Override
    public void doOnLongsleeveBtnOnAddedBase(int longsleeveIndex, int maxIndexLonglseeve) {
        bLongsleeveNext.setEnabled(longsleeveIndex < maxIndexLonglseeve);
    }

    @Override
    public void doOnShortsleeveBtnOnAddedBase(int shortsleeveIndex, int maxIndexShortsleeve) {
        bShortsleeveNext.setEnabled(shortsleeveIndex < maxIndexShortsleeve);
    }

    @Override
    public void doOnShoesBtnOnAddedBase(int shoesIndex, int maxIndexShoes) {
        bShoesNext.setEnabled(shoesIndex < maxIndexShoes);
    }

    @Override
    public void doOnSkinViewsOnAddedSkin(String decoratorItemDesc, int skinIndex, int maxIndexSkin) {
        tvElementSkin.setText(decoratorItemDesc);
        bSkinPrevious.setEnabled(skinIndex > 0);
        bSkinNext.setEnabled(skinIndex < maxIndexSkin);
    }

    @Override
    public void doOnHairViewsOnAddedHair(String decoratorItemDesc, int hairIndex, int maxIndexHair) {
        tvElementHair.setText(decoratorItemDesc);
        bHairPrevious.setEnabled(hairIndex > 0);
        bHairNext.setEnabled(hairIndex < maxIndexHair);
    }

    @Override
    public void doOnPantsViewsOnAddedPants(String decoratorItemDesc, int pantsIndex, int maxIndexPants) {
        tvElementPants.setText(decoratorItemDesc);
        bPantsPrevious.setEnabled(pantsIndex > 0);
        bPantsNext.setEnabled(pantsIndex < maxIndexPants);
    }

    @Override
    public void doOnLongsleeveViewsOnAddedLongsleeve(String decoratorItemDesc, int longsleeveIndex, int maxIndexLonglseeve) {
        tvElementLongsleeve.setText(decoratorItemDesc);
        bLongsleevePrevious.setEnabled(longsleeveIndex > 0);
        bLongsleeveNext.setEnabled(longsleeveIndex < maxIndexLonglseeve);
    }

    @Override
    public void doOnShortsleeveViewsOnAddedLongsleeve(String decoratorItemDesc, int shortsleeveIndex, int maxIndexShortsleeve) {
        tvElementShortsleeve.setText(decoratorItemDesc);
        bShortsleevePrevious.setEnabled(shortsleeveIndex > 0);
        bShortsleeveNext.setEnabled(shortsleeveIndex < maxIndexShortsleeve);
    }

    @Override
    public void doOnShoesViewsOnAddedShoes(String decoratorItemDesc, int shoesIndex, int maxIndexShoes) {
        tvElementShoes.setText(decoratorItemDesc);
        bShoesPrevious.setEnabled(shoesIndex > 0);
        bShoesNext.setEnabled(shoesIndex < maxIndexShoes);
    }
}