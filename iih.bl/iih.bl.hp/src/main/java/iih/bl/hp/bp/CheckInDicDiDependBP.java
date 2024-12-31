package iih.bl.hp.bp;

import iih.bl.hp.bp.Qry.GetCiSrvInDicQry;
import iih.bl.hp.dto.d.DiDependDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 判断医嘱适应症依赖
 * @author LIM
 * @since date 2017-9-4
 */
public class CheckInDicDiDependBP {
	public DiDependDTO[] exec(String id_ent,String[] diIds,String[] diIdsAll)throws BizException{
		GetCiSrvInDicQry qry=new GetCiSrvInDicQry(id_ent,diIds,diIdsAll);
		DAFacade da=new DAFacade();
		List<DiDependDTO> payRecordList = (List<DiDependDTO>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(DiDependDTO.class));
		return payRecordList.toArray(new DiDependDTO[0]);
	}
}
