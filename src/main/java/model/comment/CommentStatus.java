package model.comment;

import java.io.Serializable;

public enum CommentStatus implements Serializable {
    WAITING_FOR_CONFIRM,
    CONFIRMED,
    NOT_CONFIRMED_FORM_MANAGER
}