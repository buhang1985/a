package iih.ci.ord.s.listener;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.pub.listener.AbstractOrCancelCheckListener;
import iih.ci.ord.s.bp.OrConfirmBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱作废确认后，相关护嘱的作废确认操作
 * 
 * @author zhanwq
 *
 */
public class NurOrderCancelListener extends AbstractOrCancelCheckListener {

	/**
	 * 护嘱医嘱作废操作
	 */
	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		this.handle(ors);
	}

	/**
	 * 作废确认逻辑调用
	 * 
	 * @param ors
	 * @throws BizException
	 */
	private void handle(CiOrderDO[] orders) throws BizException {
		List<String> id_ors = new ArrayList<String>();
		for (CiOrderDO ci : orders) {
			id_ors.add(ci.getId_or());
		}
		// 查询相关的护嘱
		ICiorderMDORService rService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ciOrders = rService.findByAttrValStrings(CiOrderDO.ID_OR_REL, id_ors.toArray(new String[0]));
		if(ciOrders == null || ciOrders.length <= 0) {
			return;
		}
		List<CiOrderDO> isCanCancels = new ArrayList<CiOrderDO>();
		for (int i = ciOrders.length - 1; i >= 0; i--) {
			if (ICiDictCodeConst.SD_ORDSRCFUN_NUR.equals(ciOrders[i].getSd_orsrcfun())) {
				isCanCancels.add(ciOrders[i]);
			}
		}
		if (isCanCancels.size() > 0) {
			// 调用护嘱确认
			OrConfirmBP orConfirmBP = new OrConfirmBP();
			String errorMsg =orConfirmBP.runNurOrderCancelConfirm(isCanCancels.toArray(new CiOrderDO[0]));
			if(!StringUtils.isNullOrEmpty(errorMsg)){
				throw new BizException (errorMsg); 
			}
		}
	}
}
