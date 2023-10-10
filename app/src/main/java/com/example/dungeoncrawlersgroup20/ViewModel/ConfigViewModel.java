package com.example.dungeoncrawlersgroup20.ViewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import android.text.TextUtils;

import com.example.dungeoncrawlersgroup20.BR;
import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.Player;

public class ConfigViewModel extends BaseObservable {
    private String errorMessage = "You need to select an image, difficulty, "
            + "and/or enter a name before continuing";
    private String sprite1Message = "You Selected the First Character";
    private String sprite2Message = "You Selected the Second Character";
    private String sprite3Message = "You Selected the Third Character";
    private Player player;
    private Difficulty difficulty;
    public ConfigViewModel() {
        player = Player.getPlayer();
        difficulty = new Difficulty();
    }
    @Bindable
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }
    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }
    @Bindable
    public String getPlayerName() {
        return player.getName();
    }
    public void setPlayerName(String name) {
        player.setName(name);
        notifyPropertyChanged(BR.playerName);
    }
    public void onContinueClicked() {
        if (isInputDataInvalid())
            setToastMessage(errorMessage);
    }
    public void onEasyClicked() {
        difficulty.setEasy();
        player.setHealth(300);
    }
    public void onMediumClicked() {
        difficulty.setMedium();
        player.setHealth(200);
    }
    public void onHardClicked() {
        difficulty.setHard();
        player.setHealth(100);
    }
    public void onSprite1Clicked() {
        player.setSprite(1);
        setToastMessage(sprite1Message);
    }
    public void onSprite2Clicked() {
        player.setSprite(2);
        setToastMessage(sprite2Message);
    }
    public void onSprite3Clicked() {
        player.setSprite(3);
        setToastMessage(sprite3Message);
    }
    public boolean isInputDataInvalid() {
        return TextUtils.isEmpty(getPlayerName()) || TextUtils.isEmpty(difficulty.getDiff())
                || (player.getSprite() == 0);
    }
}
