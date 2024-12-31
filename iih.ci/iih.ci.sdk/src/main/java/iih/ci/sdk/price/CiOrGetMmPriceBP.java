package iih.ci.sdk.price;

import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 获得物品结存价 (有待优化）
 * @author wangqingzhu
 *
 */
public class CiOrGetMmPriceBP {
	/**
	 * 获得物品结存价
	 * @param id_dep
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	public  FDouble exec(String id_dep,String id_mm,String id_unit)  throws BizException{
		GetStockReqDTO  reqdto=new GetStockReqDTO();
		reqdto.setId_dep(id_dep);
		reqdto.setId_mm(id_mm);
		reqdto.setReq_unit_id(id_unit);
		//获得对应仓库物品结存与价格信息  
		//特别注意传入的条数与传出的条数可能不一致
		MaterialStockDTO[] stockdtos=CiOrdAppUtils.getMaterialStockQryService().getMaterialStocks(new GetStockReqDTO[]{reqdto}); 
		if(stockdtos==null || stockdtos.length==0)return null;
		return stockdtos[0].getPrice_act();
	}
}
