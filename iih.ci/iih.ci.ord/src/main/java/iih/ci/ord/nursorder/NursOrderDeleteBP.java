package iih.ci.ord.nursorder;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class NursOrderDeleteBP {
	private String ErrorMsg = "没有可删除的数据，请刷新界面重试！";
	public boolean delete(String[] id_ors) throws BizException{
		if(id_ors==null||id_ors.length==0){
			return false;
		}
		//获得医嘱聚集
		CiorderAggDO[] aggdos=CiOrdAppUtils.getOrAggQryService().findByIds(id_ors,FBoolean.FALSE);
		List<CiorderAggDO> delList = new ArrayList<CiorderAggDO>();
		for(CiorderAggDO agg :aggdos){
			CiOrderDO order = agg.getParentDO();
			if(FBoolean.FALSE.equals(order.getFg_chk())){
				delList.add(agg);
			}
		}
		if(delList.size()>0){
			CiOrdAppUtils.getOrAggService().delete(delList.toArray(new CiorderAggDO[0]));
		}else{
			throw new BizException(ErrorMsg);
		}
		return true;
	}
}
