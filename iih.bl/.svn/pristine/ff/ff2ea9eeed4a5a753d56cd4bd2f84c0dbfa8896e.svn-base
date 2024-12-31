package iih.bl.pay.bp.qry;

import iih.en.pv.enfee.d.EnAccountDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获得住院就诊账户实体
 * @author li_pengying
 *
 */
public class GetEnAccountDOBp {
	/**
	 * 通过患者banner所提供id_ent,id_pat来得到患者的门诊账户的收付款明细信息，即得到门诊账户下的所有收付款信息，用于显示【住院账户（右侧余额）】
	 * @param id_ent
	 * @param id_pat
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public EnAccountDO  execQryEnAccountDOByIdentidpat(String id_ent,String id_pat)throws BizException{   // 住院账户（右侧余额）
        StringBuffer sb=new StringBuffer();
	  
	    sb.append("	SELECT  B.amt_cred,B.amt_owelimit,B.amt_prepay,B.amt_uncg,B.ds,B.dt_backcg,B.dt_backcglastact,B.id_ent,B.id_entacc,B.id_pat,B.sv ");
		sb.append("	FROM EN_ENT A");
	    sb.append("	JOIN EN_ENT_ACC B ON A.ID_ENT = B.ID_ENT  WHERE  A.ID_ENT =? AND A.ID_PAT =? ");
	    SqlParam sp=new SqlParam();
	    sp.addParam(id_ent);
		sp.addParam(id_pat);
	   
		@SuppressWarnings("unchecked")
		List<EnAccountDO> list= (List<EnAccountDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(EnAccountDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 EnAccountDO[] bldos= list.toArray(new EnAccountDO[0]);
			 return bldos[0]; 
		 }else {
			  return null;
		 }
	}
}
