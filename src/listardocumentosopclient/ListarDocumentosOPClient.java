/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listardocumentosopclient;

import com.siebel.fins.OCSListadoDocumentosWS;
import com.siebel.fins.OcSListadoDeDocumentos;
import com.siebel.xml.ocs_20listado_20de_20reportes_20io.ListOfOcsListadoDeReportesIoTopElmt;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

/**
 *
 * @author oscar
 */
public class ListarDocumentosOPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OcSListadoDeDocumentos service = new OcSListadoDeDocumentos();
        OCSListadoDocumentosWS port = service.getOCSListadoDocumentosWS();

        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> rc = bp.getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://lasiewebsit.ccaf.andes:8080/enterprise/EntListadoDocumentosService?WSDL");

        String quoteId = "1-1BSUGQU";
        Holder<String> ocsTemplateFirmaDigId = new Holder<String>();
        ocsTemplateFirmaDigId.value="1-1BSUGWM";
        Holder<String> errorSpcCode = new Holder<String>();

        Holder<String> errorSpcMessage = new Holder<String>();
        Holder<ListOfOcsListadoDeReportesIoTopElmt> responseSpcIO = new Holder<ListOfOcsListadoDeReportesIoTopElmt>();
        port.ocsSpcListadoSpcdeSpcDocumentosSpcWF(quoteId, ocsTemplateFirmaDigId, errorSpcCode, errorSpcMessage, responseSpcIO);

        System.out.println("Codigo " + errorSpcCode.value);
        System.out.println("Mensaje " + errorSpcMessage.value);
        System.out.println("Mensaje " + responseSpcIO.value.getListOfOcsListadoDeReportesIo().getQuote().size());
    }

}
