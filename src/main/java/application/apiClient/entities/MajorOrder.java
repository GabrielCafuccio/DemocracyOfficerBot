package application.apiClient.entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class MajorOrder {
    private static boolean isPublished = false;

    private long id32;
    private int[] progress;
    private int expiresIn;
    private MajorOrderDetails setting;

    public static boolean isPublished() {
        return isPublished;
    }

    public static void setPublished(boolean published) {
        isPublished = published;
    }

    public long getId32() {
        return id32;
    }

    public void setId32(int id32) {
        this.id32 = id32;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public MajorOrderDetails getSetting() {
        return setting;
    }

    public void setSetting(MajorOrderDetails setting) {
        this.setting = setting;
    }

    public static MajorOrder fromJson(String json){
        Gson gson = new Gson();
        Type classType = new TypeToken<MajorOrder>(){}.getType();
        MajorOrder majorOrder = gson.fromJson(json, classType);

        return majorOrder;
    }

}

/*
[
        {
        "id32": 3541580460,
        "progress": [
        866701315
        ],
        "expiresIn": 493960,
        "setting": {
        "type": 4,
        "overrideTitle": "MAJOR ORDER",
        "overrideBrief": "The Automaton invasion has slowed, thanks to valiant defense efforts. We must take this chance to refill our E-710 reserves in order to stage a counter-offensive.",
        "taskDescription": "Kill 2,000,000,000 Terminids.",
        "tasks": [
        {
        "type": 3,
        "values": [
        2,
        1,
        2000000000,
        0,
        0,
        0,
        0,
        0,
        0,
        0
        ],
        "valueTypes": [
        1,
        2,
        3,
        4,
        6,
        5,
        8,
        9,
        11,
        12
        ]
        }
        ],
        "reward": {
        "type": 1,
        "id32": 897894480,
        "amount": 45
        },
        "flags": 0
        }
        }
        ]
 */