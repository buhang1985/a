package iih.bl.pay.bp.qry;

import iih.pi.acc.account.d.PiPatAccDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPiPatAccDOByIdpatBp {
	
	/**
	 * 
	 * 通过患者banner所提供id_ent,id_pat来得到患者的门诊账户的余额信息， 用于显示门诊账户（左侧余额）
	 * @param id_pat
	 * @param  li_pengying
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO  execQryPiPatAccDOByIdpat(String id_pat)throws BizException{   // 门诊账户（左侧余额）
		StringBuffer sb=new StringBuffer();
	    sb.append("	select  t1.id_patacc,t1.id_pat,t1.id_accsta,t1.acc_lock,t1.code,t1.name,t1.prepay,t1.cred,t1.fg_active,t1.createdby,t1.createdtime,t1.sd_accsta,t1.ds,t1.modifiedby,t1.modifiedtime");
		sb.append("	FROM PI_PAT_ACC t1");
	    sb.append("	WHERE ID_PAT = ?");
	    SqlParam sp=new SqlParam();
		sp.addParam(id_pat);
	    @SuppressWarnings("unchecked")
		List<PiPatAccDO> list= (List<PiPatAccDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(PiPatAccDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 PiPatAccDO[] bldos= list.toArray(new PiPatAccDO[0]);
			 return bldos[0]; 
		 }else {
			 return null;
		 }
	}
}
