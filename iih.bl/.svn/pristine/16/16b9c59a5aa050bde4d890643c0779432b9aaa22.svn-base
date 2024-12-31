package iih.bl.cc.s.bp;

import java.util.List;

import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.i.IBlpayspclMDOCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 专用款表结账
 * @author LIM
 *@since 2019-05-23
 */
public class UpdatePaySpclBP {
	/**
	 * 修改专用款(bl_pay_spcl)中结账标志为结账
	 * @param id_user 操作员
	 * @param id_cc  结账id
	 * @param end_time 结账日期
	 * @throws BizException
	 */
	public void exec(String id_user, String id_cc, FDateTime end_time) throws BizException{
		StringBuilder sf = new StringBuilder();
		sf.append("select spcl.* from bl_pay_spcl spcl")
			.append(" where spcl.FG_CC = 'N'").append(" and spcl.ID_EMP_PAY = ?")
				.append(" and spcl.DT_PAY < ?");
		SqlParam sp = new SqlParam();
		sp.addParam(id_user);
		sp.addParam(end_time);
		Object obj=new DAFacade().execQuery(sf.toString(),sp, new BeanListHandler(BlPaySpclDO.class));
		@SuppressWarnings("unchecked")
		List<BlPaySpclDO> blPaySpclDOList = (List<BlPaySpclDO>) obj;
		if (!ListUtil.isEmpty(blPaySpclDOList)) {

			for (BlPaySpclDO  blPaySpclDO : blPaySpclDOList) {
				 blPaySpclDO.setId_cc(id_cc);
				 blPaySpclDO.setFg_cc(FBoolean.TRUE);
				 blPaySpclDO.setStatus(DOStatus.UPDATED);
			}
			IBlpayspclMDOCudService payspclService = ServiceFinder
					.find(IBlpayspclMDOCudService.class);
			payspclService.save(blPaySpclDOList.toArray(new BlPaySpclDO[] {}));
		}
	}

}
