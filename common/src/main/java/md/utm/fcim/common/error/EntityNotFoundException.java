package md.utm.fcim.common.error;

public class EntityNotFoundException extends AbstractException {

    private static final String ENTITY_NOT_FOUND_MSG = "Entity '%s' with id '%s' Doesn't exist";

    public EntityNotFoundException(Class<?> clazz, Object id) {
        super();
        getMessageException().setMessage(String.format(ENTITY_NOT_FOUND_MSG, clazz.getName(), id));
    }
}
