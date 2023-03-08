package be.intecbrussel;

public enum PriorityLevel {
    LOW("low priority, not very imporatnt."),
    MEDIUM("medium priority, we got a problem chief!"),
    HIGH("high priority, PANIC PANIC PANIC!!!"),
    NO_ISSUE("it's not a bug, it's a feature!");
    private final String description;

    PriorityLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
