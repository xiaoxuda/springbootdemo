package cn.fundertech.demo.service;

import cn.fundertech.demo.api.StockInfoService;
import cn.fundertech.demo.util.CacheRpcAttachment;
import cn.fundertech.demo.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxuda 2020/1/26
 */
@Service("stockInfoService")
public class StockInfoServiceImpl implements StockInfoService {
    @Override
    @CacheRpcAttachment
    public List<String> getRecommendStockCode() {
        System.out.println(ThreadLocalUtil.getApiRpcContextAttach("userName"));
        return new ArrayList();
    }
}
