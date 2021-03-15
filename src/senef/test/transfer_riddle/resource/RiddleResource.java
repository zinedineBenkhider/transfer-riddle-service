package senef.test.transfer_riddle.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import senef.test.transfer_riddle.domaine.Step;
import senef.test.transfer_riddle.service.IRiddleService;

@Path("/solution")
public class RiddleResource {
	@Inject
	IRiddleService riddleService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Step> solution( @QueryParam("tankASize") int tankASize,@QueryParam("tankBSize") int tankBSize,@QueryParam("t") int t) {
		riddleService.init(tankASize, tankBSize, t);
    	List<Step> steps=riddleService.solution();
		return steps;
	}
 
	@GET
	@Path("/exist")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean solutionExist(@QueryParam("tankASize") int tankASize,@QueryParam("tankBSize") int tankBSize,@QueryParam("t") int t) {
		riddleService.init(tankASize, tankBSize, t);
		return riddleService.solutionExist();
	}
}
