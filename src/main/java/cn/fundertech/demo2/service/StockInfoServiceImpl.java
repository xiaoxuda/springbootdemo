package cn.fundertech.demo2.service;

import cn.fundertech.demo2.api.StockInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxuda 2020/1/26
 */
@Service("stockInfoService")
public class StockInfoServiceImpl implements StockInfoService {
    @Override
    public List<String> getRecommendStockCode() {
        return new ArrayList();
    }
}
