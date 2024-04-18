package application.apiClient.utils;

public class MajorOrderDetails {
    private int type;
    private String overrideTitle;
    private String overrideBrief;
    private String taskDescription;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOverrideTitle() {
        return overrideTitle;
    }

    public void setOverrideTitle(String overrideTitle) {
        this.overrideTitle = overrideTitle;
    }

    public String getOverrideBrief() {
        return overrideBrief;
    }

    public void setOverrideBrief(String overrideBrief) {
        this.overrideBrief = overrideBrief;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
