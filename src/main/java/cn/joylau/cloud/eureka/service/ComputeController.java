package cn.joylau.cloud.eureka.service;

/**
 * Created by JoyLau on 4/14/2017.
 * cn.joylau.cloud.eureka.service
 * fa.liu@gtafe.com
 */
@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
}
