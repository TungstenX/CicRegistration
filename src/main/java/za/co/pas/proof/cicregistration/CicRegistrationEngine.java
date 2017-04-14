package za.co.pas.proof.cicregistration;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import za.co.pas.proof.cicregistration.controller.CicService;

/**
 * The interface layer, aka the web services.<p>
 * It contains two entry points<p>
 * <ul>
 * <li>registerCic - Fully implemented</li>
 * <li>registerCicInfo - Not implemented</li>
 * </ul>
 *
 * @author Andre Labuschagne
 */
@WebService(serviceName = "CicRegistrationEngine")
@Stateless
public class CicRegistrationEngine {

    @EJB
    private CicService cicService;

    /**
     * This will be the interface layer to register a Cic
     *
     * @param cicType the Cic type
     * @param subject the Cic's subject
     * @param body the Cic's body/message
     * @param sourceSystem the source system
     * @param name the entity's name
     * @param email the entity's email address
     * @return true if successful else, umh, false if not
     */
    @WebMethod(operationName = "RegisterCic")
    public Boolean registerCic(@WebParam(name = "cicType") String cicType,
            @WebParam(name = "subject") String subject,
            @WebParam(name = "body") String body,
            @WebParam(name = "sourceSystem") String sourceSystem,
            @WebParam(name = "name") String name,
            @WebParam(name = "email") String email) {
        return cicService.registerCic(cicType, subject, body, sourceSystem, name, email);
    }

    /**
     * Stubby! Not implemented 
     *
     * @return an awkward string
     */
    @WebMethod(operationName = "RegisterCicInfo")
    public String registerCicInfo() {
        return "This is awkward!";
    }
}
