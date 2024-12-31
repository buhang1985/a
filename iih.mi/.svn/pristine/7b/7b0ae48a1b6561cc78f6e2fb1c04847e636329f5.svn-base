package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp;

import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.qry.GetCiSrvSpecillQry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 获取医嘱特殊病诊断依赖信息
 * @author LIM
 * @since 2019-10-09
 */
public class MiCheckSpecillDiDependBP {
	/**
	 * 获取医嘱特殊病诊断依赖信息
	 * @param id_ent 就诊id
	 * @param id_hp 医保计划id
	 * @param delDiIds 删除诊断id
	 * @param idDisSur 剩余诊断id
	 * @return
	 * @throws BizException
	 */
	public List<MiMcDiDependOutParamDTO> exec(String id_ent,String id_hp,String[] delDiIds,String[] idDisSur)throws BizException{
		GetCiSrvSpecillQry qry=new GetCiSrvSpecillQry(id_ent,id_hp,delDiIds,idDisSur);
		DAFacade da=new DAFacade();
		List<MiMcDiDependOutParamDTO> payRecordList = (List<MiMcDiDependOutParamDTO>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(MiMcDiDependOutParamDTO.class));
		return payRecordList;
	}
}
