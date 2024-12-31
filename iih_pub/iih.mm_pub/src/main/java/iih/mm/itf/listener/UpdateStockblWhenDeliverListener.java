package iih.mm.itf.listener;

import iih.bd.bc.i.IQuanPriAmtConst;
import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.bl.stockbl.i.IStockblCudService;
import iih.mm.bl.stockbl.i.IStockblRService;

import java.util.HashMap;
import java.util.Map;

import xap.lui.core.mq.IMQListener;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预留发药结存更新MQ消息监听类
 * @author ly 2017/07/17
 *
 */
public class UpdateStockblWhenDeliverListener implements IMQListener {

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
			
			//结存数据更新
			stockBlDO.setQuan_stock(stockBlDO.getQuan_stock().sub(oldBlDo.getReq_num()).setScale(IQuanPriAmtConst.QPA_QUAN4INV_PRECISION, FDouble.ROUND_HALF_UP));
			//预留量
			stockBlDO.setQuan_reserve(stockBlDO.getQuan_reserve().sub(oldBlDo.getReq_num()).setScale(IQuanPriAmtConst.QPA_QUAN4INV_PRECISION, FDouble.ROUND_HALF_UP));
			//可用量
			stockBlDO.setQuan_usable(stockBlDO.getQuan_stock().sub(stockBlDO.getQuan_reserve()).setScale(IQuanPriAmtConst.QPA_QUAN4INV_PRECISION, FDouble.ROUND_HALF_UP));
			//金额成本
			stockBlDO.setAmt_cost(stockBlDO.getQuan_stock().multiply(stockBlDO.getPri_act()).setScale(IQuanPriAmtConst.QPA_AMT_PRECISION, FDouble.ROUND_HALF_UP));
		}
		
		iStockblCudService.update(newStockDos);
	}

	@Override
	public String getListenerType() {
		
		return "UpdateStockblWhenDeliver";
	}

}
