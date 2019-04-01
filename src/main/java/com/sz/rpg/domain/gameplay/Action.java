package com.sz.rpg.domain.gameplay;

import java.util.UUID;

public class Action {

    private UUID actionUuid;
    private ActionType actionType;

    public UUID getActionUuid() {
        return actionUuid;
    }

    public void setActionUuid(UUID actionUuid) {
        this.actionUuid = actionUuid;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}
