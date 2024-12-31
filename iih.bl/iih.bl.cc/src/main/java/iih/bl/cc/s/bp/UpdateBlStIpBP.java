package iih.bl.cc.s.bp;

import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *  修改住院结算表的结账标示
 * @author LIM
 *
 */
public class UpdateBlStIpBP {
	/**
	 * 修改住院结算表的结账标示为已结账
	 * @param id_user
	 * @param id_cc
	 * @param end_time
	 * @throws BizException
	 * @author LIM
	 */
	public void exec(String id_user,String id_cc,FDateTime end_time) throws BizException{
		StringBuilder sf = new StringBuilder();
		sf.append("select distinct s.* from bl_st_ip s")
		  .append(" inner join bl_pay_pat_ip p on s.id_stip = p.id_stip")
		  .append(" where p.FG_CC = 'N'")
		  .append(" and p.ID_EMP_PAY = ?")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and p.DT_PAY < ?");
		SqlParam sp=new SqlParam();
		sp.addParam(id_user);
		sp.addParam(end_time);
		List<BlStIpDO> blStIpDOList = (List<BlStIpDO>)new DAFacade().execQuery(sf.toString(), sp, new BeanListHandler(BlStIpDO.class));
		if(blStIpDOList != null && blStIpDOList.size() > 0){
			IBlstipCudService stIpCService = ServiceFinder.find(IBlstipCudService.class);
			for(BlStIpDO blStIpDO : blStIpDOList){
				blStIpDO.setId_cc(id_cc);
				blStIpDO.setFg_cc(FBoolean.TRUE);
				blStIpDO.setStatus(DOStatus.UPDATED);
			}
			stIpCService.save(blStIpDOList.toArray(new BlStIpDO[]{}));
		}
	}
}
