package broadlink.rm3.api.rest;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Rm3Endpoint {
    @GetMapping(value = "/broadlink/rm3-mini/api/test")
    public String test() {
        return "test";
    }
}
