package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.d.desc.ScSchTicksDODesc;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 验证排班是否有使用
 * @author ccj
 *
 */
public class ValSchHaveUsedBp {
	
	
	/**根据排班id  验证排班是否使用
	 * @param id_sch
	 * @throws BizException
	 */
	public void exec(String id_sch) throws BizException{
		if(StringUtil.isEmpty(id_sch)) return;
		IScschMDORService iScschMDORService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = iScschMDORService.findById(id_sch);
		GetScplanBySchBp bySchBp = new GetScplanBySchBp();
		ScPlanDO planDO = bySchBp.exec(schDO); 
		if(planDO == null) throw new BizException(IScMsgConst.SC_SCH_SCPLAN_ISEMPY);
		if(IScDictCodeConst.SD_TICKMD_TICK.equals(planDO.getSd_tickmd())){
			//号位
			ISctickRService iSctickRService = ServiceFinder.find(ISctickRService.class);
			String whereStr = String.format("%s.id_sch=? and %s.eu_used=? ", ScSchTickDODesc.TABLE_ALIAS_NAME,ScSchTickDODesc.TABLE_ALIAS_NAME);
			SqlParamDTO param = new SqlParamDTO();
			param.addParam(schDO.getId_sch());
			param.addParam(EuUseState.SY);
			ScSchTickDO[] schTickDOs =  iSctickRService.find2(whereStr, param, null, FBoolean.FALSE);
			if(schTickDOs!=null && schTickDOs.length>0) throw new BizException(IScMsgConst.SC_SCH_USED_STATE);
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())){
			// 号段
			IScticksRService iScticksRService = ServiceFinder.find(IScticksRService.class);
			ScSchTicksDO[] schTicksDOs = iScticksRService.find(ScSchTicksDODesc.TABLE_ALIAS_NAME+".id_sch ='"+id_sch+"' and "+ScSchTicksDODesc.TABLE_ALIAS_NAME+".quecn_used > 0", "", FBoolean.FALSE);
			if(schTicksDOs!=null && schTicksDOs.length>0) throw new BizException(IScMsgConst.SC_SCH_USED_STATE);
		}
	}
}
