package camp.nextstep;

import com.interface21.webmvc.servlet.mvc.asis.Controller;
import com.interface21.webmvc.servlet.mvc.tobe.HandlerMapping;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManualHandlerMapping implements HandlerMapping {

    private static final Logger log = LoggerFactory.getLogger(ManualHandlerMapping.class);

    private final Map<String, Controller> controllers = new HashMap<>();

    public void initialize() {
        controllers.put("/logoutTest", new LogoutTestController());

        log.info("Initialized Handler Mapping!");
        controllers.keySet()
            .forEach(path -> log.info("Path : {}, Controller : {}", path,
                controllers.get(path).getClass()));
    }

    @Override
    public Object getHandler(HttpServletRequest httpServletRequest) {
        log.debug("Request Mapping Uri : {}", httpServletRequest.getRequestURI());
        return controllers.get(httpServletRequest.getRequestURI());
    }

}
