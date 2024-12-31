package iih.bl.cc.s.bp;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;

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
 * 修改门诊结算表的结账标示
 * 
 * @author LIM
 *
 */
public class UpdateBlStOepBP {
	/**
	 * 修改门诊结算表的结账标示为已结算
	 * 
	 * @param id_user
	 * @param id_cc
	 * @param end_time
	 * @throws BizException
	 * @author LIM
	 */
	public void exec(String id_user, String id_cc, FDateTime end_time)
			throws BizException {
		StringBuilder sf = new StringBuilder();
		sf.append("select s.* from bl_st_oep s")
				.append(" inner join bl_pay_pat_oep p on s.id_paypatoep = p.id_paypatoep")
			.append(" where p.FG_CC = 'N'").append(" and p.ID_EMP_PAY = ?")
				// .append(" and a0.ID_ORG = '").append(id_org).append("'")
				.append(" and p.DT_PAY < ?");
		SqlParam sp = new SqlParam();
		sp.addParam(id_user);
		sp.addParam(end_time);
		Object obj=new DAFacade().execQuery(sf.toString(),sp, new BeanListHandler(BlStOepDO.class));
		List<BlStOepDO> blStOepDOList = (List<BlStOepDO>) obj;
		if (blStOepDOList != null && blStOepDOList.size() > 0) {

			for (BlStOepDO blStOepDO : blStOepDOList) {
				blStOepDO.setId_cc(id_cc);
				blStOepDO.setFg_cc(FBoolean.TRUE);
				blStOepDO.setStatus(DOStatus.UPDATED);
			}
			IBlstoepCudService stOepCService = ServiceFinder
					.find(IBlstoepCudService.class);
			stOepCService.save(blStOepDOList.toArray(new BlStOepDO[] {}));
		}
	}	

}
