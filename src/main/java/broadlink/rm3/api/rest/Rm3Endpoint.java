package broadlink.rm3.api.rest;


import com.github.mob41.blapi.BLDevice;
import com.github.mob41.blapi.RM2Device;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Rm3Endpoint {
    byte[] signal;

    @GetMapping(value = "/broadlink/rm3-mini/api/test")
    public byte[] test() throws Exception {
        BLDevice[] devs = BLDevice.discoverDevices();
         Optional<RM2Device> a = Arrays.stream(devs)
                 .findAny()
                 .map(dev->RM2Device.class.cast(dev));
         a.ifPresent(dev->{
             System.out.println(dev.getDeviceDescription());
         });
         var auth = a.get().auth();
         if (auth) {
             a.get().enterLearning();
             var data1 = a.get().checkData();
             return data1;
         }


         /*if(a.isPresent() && a.get().enterLearning()) {
             return a.get().checkData();
         }*/
         return null;
    }


}
