package bdbt_project.SpringApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
//public class GlobalExceptionHandler {
//    private static final Logger logger = Logger.getLogger(MyErrorController.class.getName());
//
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String handleDataIntegrityViolation(DataIntegrityViolationException ex Model model) {
//        logger.log(Level.SEVERE, "Błąd spójności danych: " + ex.getMessage(), ex);
//        model.addAttribute("errorMessage",
//                "Operacja nie może zostać wykonana, ponieważ rekord jest powiązany z innymi danymi.");
//        return "error/naruszono_wiezy";
//    }
//}

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "errors/403";
            }
            else if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errors/404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errors/500";
            }
            else if(statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
                return "errors/504";
            }
            else {
//                logger.warning("Unexpected error code: " + statusCode);
                return "error/others";
            }
        }
        return "error/others";
    }
}