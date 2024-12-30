package iih.sc.sch.s.bp;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 检查是否已过停止挂号时间
 * @author yank
 *
 */
public class CheckAfterEndRegTimeBP {
	/**
	 * 检查是否已过停止挂号时间
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String schId) throws BizException{
		ScValidator.validateParam("排班ID", schId);
		ScSchDO schDO = (ScSchDO) new DAFacade().findByPK(ScSchDO.class, schId, new String[]{ScSchDO.ID_SCH, ScSchDO.D_SCH, ScSchDO.ID_DAYSLOT, ScSchDO.T_E_REG});
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}
		IDayslotMDORService daysLotServ = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO dayslot = daysLotServ.findById(schDO.getId_dayslot());
		FDateTime curDateTime = ScAppUtils.getServerDateTime();
		FDateTime endDateTime = new FDateTime(schDO.getD_sch(), schDO.getT_e_reg());
		if(dayslot.getTime_begin().after(dayslot.getTime_end()))
			endDateTime = new FDateTime(schDO.getD_sch().getDateAfter(1), schDO.getT_e_reg());
		return  new FBoolean(curDateTime.after(endDateTime));
	}
}
