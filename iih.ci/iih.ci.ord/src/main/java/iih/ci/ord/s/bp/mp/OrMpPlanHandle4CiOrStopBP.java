package iih.ci.ord.s.bp.mp;


import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 临床医嘱停止时，医嘱执行计划相关数据信息处理操作BP
 * (医嘱停止时：拆分数据的反向处理逻辑)
 * @author li_cheng
 *
 */
public class OrMpPlanHandle4CiOrStopBP {
	/**
	 * 临床医嘱停止时，医嘱执行计划相关数据信息处理
	 * (医嘱停止时：拆分数据的反向处理逻辑)
	 * @param needstopors
	 * @param dt_end
	 * @throws BizException
	 */
	public void exec(CiOrderDO[] needstopors,FDateTime dt_end_max) throws BizException{
		IResponseOrderHandelService responseOrderHandelService=ServiceFinder.find(IResponseOrderHandelService.class);
		/*String[] idors=new String[needstopors.length];
		int i=0;		
		for (CiOrderDO ciOrderDO : needstopors) {
			idors[i]=ciOrderDO.getId_or();
			i++;
		}*/
		String[]  idors = getIdOrdersListNotCancal(needstopors);
		if(idors != null && idors.length>0) {
		  responseOrderHandelService.responseOrStop(idors);
		}
	}
	
	/**
	 * 医嘱id
	 * @param ors
	 * @return
	 */
	private String[] getIdOrdersListNotCancal(CiOrderDO[] ors){
		if(ors == null) return null;
	    List<String> list = new ArrayList<String>();
		 int i =0;
		for(CiOrderDO order:ors){
			if(!FBoolean.TRUE.equals(order.getFg_chk_canc())) {
				list.add(order.getId_or());
			} 
		}
		if(list != null && list.size() >0) {
			return list.toArray(new String[0]);
		}else {
			return null;
		}
		
	}
}
