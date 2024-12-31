package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊诊断列表BP
 * @author yank
 *
 */
public class GetEnDiListBP {
	/**
	 * 获取就诊诊断列表
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EntDiDO[] exec(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}		
		String whereStr = String.format("Id_ent='%s'", entId);
		String orderStr = "Fg_maj desc,Dt_diag desc,Sd_cdsystp";//诊断日期倒序，学科类型正序
		IEntdiRService entDiRService = ServiceFinder.find(IEntdiRService.class);
		EntDiDO[] entDiDOArray = entDiRService.find(whereStr, orderStr, FBoolean.FALSE);
		//增加症候诊断的显示，fanlq-2018-05-31
		if(entDiDOArray != null && entDiDOArray.length > 0){
			for(EntDiDO entDiDO : entDiDOArray){
				if(!EnValidator.isEmpty(entDiDO.getName_didef_syn()))
				  entDiDO.setName_didef_dis(entDiDO.getName_didef_dis() +"("+entDiDO.getName_didef_syn()+")");
			}
		}
		return entDiDOArray;
	}
}
