package iih.mm.itf.listener;

import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.bl.stockbl.i.IStockblCudService;
import iih.mm.bl.stockbl.i.IStockblRService;

import java.util.HashMap;
import java.util.Map;

import xap.lui.core.mq.IMQListener;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 结存更新MQ消息监听类
 * @author ly 2017/07/17
 *
 */
public class UpdateStockblListener implements IMQListener {

	@Override
	public void doListener(Object arg0) throws Exception {
		
		StockBlDO[] stockDOs = (StockBlDO[])arg0;
		if(ArrayUtil.isEmpty(stockDOs))
			return;
		
		Map<String,StockBlDO> oldMap = new HashMap<String,StockBlDO>();
		for (StockBlDO stockBlDO : stockDOs) {
			oldMap.put(stockBlDO.getId_bl(), stockBlDO);
		}
		
		IStockblCudService iStockblCudService = ServiceFinder.find(IStockblCudService.class);
		IStockblRService iStockblRService = ServiceFinder.find(IStockblRService.class);
		
		
		StockBlDO[] newStockDos = iStockblRService.findByIds(oldMap.keySet().toArray(new String[0]), FBoolean.FALSE);
		for (StockBlDO stockBlDO : newStockDos) {
			
			StockBlDO oldBlDo = oldMap.get(stockBlDO.getId_bl());
			
			stockBlDO.setStatus(DOStatus.UPDATED);
			stockBlDO.setQuan_reserve(stockBlDO.getQuan_reserve().add(oldBlDo.getReq_num()));
			stockBlDO.setQuan_usable(stockBlDO.getQuan_stock().sub(stockBlDO.getQuan_reserve()));
		}
		
		iStockblCudService.update(newStockDos);
	}

	@Override
	public String getListenerType() {
		
		return "UpdateStockbl";
	}

}
