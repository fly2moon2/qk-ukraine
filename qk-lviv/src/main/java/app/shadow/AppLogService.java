package app.shadow;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;


import app.shadow.model.AppLog;

@Path("/applogs")
@RegisterRestClient(configKey="applogs-api")
@ClientHeaderParam(name = "class-level-param", value = "AppLogService-interface")
@RegisterClientHeaders
@Produces(MediaType.APPLICATION_JSON)
public interface AppLogService {

  @GET
  public List<AppLog> allAppLogs();

  @POST
  public Response createAppLog(AppLog appLog);

/*   @GET
  @Path("/{acctNumber}/balance")
  BigDecimal getBalance(@PathParam("acctNumber") Long accountNumber);

  @POST
  @Path("{accountNumber}/transaction")
  Map<String, List<String>> transact(@PathParam("accountNumber") Long accountNumber, BigDecimal amount) throws AccountNotFoundException;
 */
/*   @POST
  @Path("{accountNumber}/transaction")
  @ClientHeaderParam(name = "method-level-param", value = "{generateValue}")
  CompletionStage<Map<String, List<String>>> transactAsync(@PathParam("accountNumber") Long accountNumber, BigDecimal amount);

  default String generateValue() {
    return "Value generated in method for async call";
  } */
}
