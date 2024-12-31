package iih.ci.ord.s.external.bp.en;

import java.util.List;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.mrfp.cimrsugdto.d.CiMrSugDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 取就诊的最后一次有效手术医嘱的手术信息。
 * @author zhengqiang
 *
 */
public class GetEnLastSurgeryOrdBP {
	
	@SuppressWarnings("unchecked")
	public List<CiMrSugDTO> exe(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		List<CiMrSugDTO> listsug =(List<CiMrSugDTO>) daf.execQuery(this.getsql(id_ent), new BeanListHandler(CiMrSugDTO.class));
		if(listsug != null && listsug.size()>0){
			return listsug;
		}else{
			return null;
		}
	}
	
	private String getsql(String id_en) {
		SqlParamBuilder str = new SqlParamBuilder();
		str.appendSql(" select A.NAME as Name_sug, A.FDT as Dt_start_sug FROM ");
		str.appendSql(" (select srv.NAME,CONCAT(CONCAT(SUG.sugplandate ,' '),SUG.DT_B_PLAN) AS FDT from CI_ORDER C ");
		str.leftJoin("   CI_OR_SRV srv on c.ID_OR = srv.ID_OR ");
		str.leftJoin("   MP_ORM_APP_SUG SUG ON C.ID_OR = SUG.ID_OR ");
	    str.appendSql(" where 1=1 ").and();
	    str.appendSql(" c.FG_CHK = 'Y' and c.FG_SIGN = 'Y' and c.FG_CHK_CANC = 'N' and c.SD_SRVTP like '04%' ");
	    str.appendSqlParam(" and c.ID_EN = ? ",id_en);	
	    str.appendSql(" order by c.DT_EFFE desc) A where ROWNUM = 1 ");
		return str.toString();		
	}

}
