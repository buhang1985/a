package iih.sc.sch.s.bp;

import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 号位查询BP
 * @author yankan
 * @since 2015-11-21
 *
 */
public class GetTickBySchAndTickNoBP {
	public GetTickBySchAndTickNoBP(){}	

	/**
	 * 获取号位
	 * 统一排班，票号唯一
	 * @param schId 排班
	 * @param tickNo 票号
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO exec(String schId,Integer tickNo) throws BizException {
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		String whereStr = String.format("%s.id_sch=? and %s.queno=?", 
				ScSchTickDODesc.TABLE_ALIAS_NAME,ScSchTickDODesc.TABLE_ALIAS_NAME);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		param.addParam(tickNo);
		ScSchTickDO[] tickDOs = tickRService.find2(whereStr, param, null, FBoolean.TRUE);
		if(ArrayUtil.isEmpty(tickDOs)){
			return null;
		}
		return tickDOs[0];
	}
	
}
