/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import entities.Alimento;
import logic.AlimentoTestDataGenerator;
import logic.AlimentoImplementacion;
import logic.AlimentoInterface;

/**
 *
 * @author josue
 */
public interface AlimentoFactoria {

    /**
     *
     */
    public static final String REST_WEB_CLIENT_TYPE = "REST_WEB_CLIENT";

    /**
     *
     */
    public static final String TEST_MOCK_TYPE = "TEST_MOCK";

    /**
     *
     * @param type
     * @return
     */
    public static AlimentoInterface createAlimentoManager(String type) {
        //The object to be returned.
        AlimentoInterface tipoAlimento = null;
        //Evaluate type parameter.
        switch (type) {
            case REST_WEB_CLIENT_TYPE:
                //If rest web client type is asked for, use UsersManagerImplementation.
                tipoAlimento = new AlimentoImplementacion();
                break;
            case TEST_MOCK_TYPE:
                //If rest fake data test type is asked for, use UsersManagerTestDataGenerator.

                tipoAlimento = new AlimentoTestDataGenerator();
                break;
            default:
            //If type is not one of the types accepted.
        }
        return tipoAlimento;
    }

}
