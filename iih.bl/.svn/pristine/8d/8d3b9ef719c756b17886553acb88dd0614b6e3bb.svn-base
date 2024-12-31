package iih.bl.hp.bp;

import iih.bl.hp.bp.Qry.GetCiSrvSpecillQry;
import iih.bl.hp.dto.d.DiDependDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 获取医嘱特殊病诊断依赖信息
 * @author LIM
 *
 */
public class CheckSpecillDiDependBP {
	public DiDependDTO[] exec(String id_ent,String[] diIds,String[] diIdsAll)throws BizException{
		GetCiSrvSpecillQry qry=new GetCiSrvSpecillQry(id_ent,diIds,diIdsAll);
		DAFacade da=new DAFacade();
		List<DiDependDTO> payRecordList = (List<DiDependDTO>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(DiDependDTO.class));
		return payRecordList.toArray(new DiDependDTO[0]);
	}
}
