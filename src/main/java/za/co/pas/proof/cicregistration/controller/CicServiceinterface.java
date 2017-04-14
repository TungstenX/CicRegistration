package za.co.pas.proof.cicregistration.controller;

/**
 * The contract to which we develop...
 *
 * @author Andre Labuschange
 */
public interface CicServiceinterface {

    /**
     * Constant value (implicit public static final ;-) )
     */
    String EMAIL_ADDRESS = "emailAddress";

    /**
     * This will register a Cic
     *
     * @param cicType the Cic type
     * @param subject the Cic's subject
     * @param body the Cic's body/message
     * @param sourceSystem the source system
     * @param name the entity's name
     * @param email the entity's email address
     * @return true if successful else, umh, false if not
     */
    boolean registerCic(String cicType, String subject, String body,
            String sourceSystem, String name, String email);
}
