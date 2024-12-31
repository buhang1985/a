package iih.bl.hp.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.hp.hpzeroreg.d.HpZeroRegDO;
import iih.bl.hp.hpzeroreg.i.IHpzeroregCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存零挂业务需要更新对应结算中的符合零挂记账标志FG_ZEROREG 为Y
 * 
 * @return
 * @throws BizException
 * @author yang.lu
 */
public class SaveHpZeroDosBP {

	/**
	 * 保存零挂业务需要更新对应结算中的符合零挂记账标志FG_ZEROREG 为Y
	 * 
	 * @param hzRegDos
	 *            零挂集合
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public HpZeroRegDO[] exec(HpZeroRegDO[] hzRegDos) throws BizException {
		// 1.保存当前零挂数据
		IHpzeroregCudService hpservice = ServiceFinder.find(IHpzeroregCudService.class);
		HpZeroRegDO[] zeroRegDOs = hpservice.insert(hzRegDos);
		// 2.通过结算编号获取记账数据 赋值fg_zeroreg 标志 修改后会影响付款  导致异常  占时屏蔽，在前台赋值fg_zeroreg
//		SetFgzeroregByCgItm(zeroRegDOs);
		// 3.返回零挂保存后数据
		return zeroRegDOs;
	}

	/**
	 * 获取符合零挂的数据并赋值零挂标识为Y
	 * 
	 * @param zeroRegDOs
	 * @throws BizException
	 */
	private void SetFgzeroregByCgItm(HpZeroRegDO[] zeroRegDOs) throws BizException {
		List<String> idsts = new ArrayList<String>();

		// 循环设置结算编号
		for (HpZeroRegDO hzRegDO : zeroRegDOs) {
			if (!idsts.contains(hzRegDO.getId_stoep())) {
				idsts.add(hzRegDO.getId_stoep());
			}
		}

		// 获取零挂超时时间
		FDateTime dtZero = AppUtils.getServerDateTime().getDateTimeBefore(3);//BlParamUtils.getOepPresCanStEarliestTime(); TODO

		// 拼装条件
		// 结算编号区间
		String strWhere = SqlUtils.getInSqlByBigIds(BlCgItmOepDO.ID_STOEP, idsts.toArray(new String[idsts.size()])) + "";
		// 开单时间是否大于零挂时间
		strWhere = strWhere + " AND " + BlCgItmOepDO.DT_OR + ">'" + dtZero.toStdString() + "'";
		// 费用来源是补费数据
		strWhere = strWhere + " AND " + BlCgItmOepDO.ID_OR + " IN (SELECT " + CiOrderDO.ID_OR + " FROM CI_ORDER WHERE " + CiOrderDO.EU_ORSRCMDTP + "='" + OrSourceFromEnum.IIHMEDTECHORDERS + "')";

		// 获取出对应的记账明细数据
		IBlCgItmOepDORService cgitmService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] itmOepDOs = cgitmService.find(strWhere, "", FBoolean.FALSE);

		if (!ArrayUtil.isEmpty(itmOepDOs)) {
			// 设置零挂标志
			for (BlCgItmOepDO cgItmDO : itmOepDOs) {
				cgItmDO.setFg_zeroreg(FBoolean.TRUE);
			}
			// 保存记账数据
			IBlCgItmOepDOCudService cudService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
			cudService.update(itmOepDOs);
		}

	}
}
