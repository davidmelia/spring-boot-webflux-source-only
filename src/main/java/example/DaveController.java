package example;

import java.util.Map;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaveController {

  private StreamBridge streamBridge;

  public DaveController(StreamBridge streamBridge) {
    super();
    this.streamBridge = streamBridge;
  }

  @RequestMapping("/dave")
  public Map dave() {
    return Map.of("Response", streamBridge.send("test-out-0", "test"));
  }

}
