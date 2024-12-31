package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp;

import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.qry.GetCiSrvInDicQry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医嘱适应症依赖判断
 * 
 * @author LIM
 * @since 2019-10-09
 */
public class MiCheckInDicDiDependBP {
	/**
	 * 医嘱适应症依赖判断
	 * @param id_ent 就诊id
	 * @param id_hp 医保计划id
	 * @param entType 就诊类型
	 * @param delDiIds 删除诊断
	 * @param diIdsAll 全部诊断
	 * @return
	 * @throws BizException
	 */
	public List<MiMcDiDependOutParamDTO> exec(String id_ent, String id_hp,String entType, String[] delDiIds, String[] diIdsAll)
			throws BizException {
		GetCiSrvInDicQry qry = new GetCiSrvInDicQry(id_ent,id_hp, delDiIds, diIdsAll, entType);
		DAFacade da = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MiMcDiDependOutParamDTO> payRecordList = (List<MiMcDiDependOutParamDTO>) da.execQuery(qry.getQrySQLStr(),
				qry.getQryParameter(null), new BeanListHandler(MiMcDiDependOutParamDTO.class));
		return payRecordList;
	}
}
