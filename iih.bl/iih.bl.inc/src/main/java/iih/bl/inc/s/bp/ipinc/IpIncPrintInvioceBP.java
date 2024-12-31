package iih.bl.inc.s.bp.ipinc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.s.ep.IncIpEP;
import iih.bl.inc.s.util.InvoicePrintUtil;

import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院发票打印bp
 * 
 * @author wq.li
 * @date 2018年8月13日
 */
public class IpIncPrintInvioceBP {
	/**
	 * 住院发票打印
	 * 
	 * @param stIds
	 * @return
	 * @throws BizException
	 * @date 2018年8月13日
	 * @author wq.li
	 */
	public BlincipAggDO[] exec(String[] stIds) throws BizException {

		if (ArrayUtil.isEmpty(stIds)) {
			throw new ArgumentNullException("住院发票打印处理", "结算id");
		}

		// 查询结算发票信息
		BlincipAggDO[] aggDos = new IncIpEP().findIncByStId(stIds);
		if (ArrayUtil.isEmpty(aggDos)) {
			throw new BizException("住院发票打印：未查询到对应的结算发票信息");
		}

		// 获取当前发票号，并进行跳号
		// 2.打印
		Entry<String, String[]> printInfo = InvoicePrintUtil.print(IBdPpCodeTypeConst.ID_INHOS_INVOICE, aggDos.length,
				Context.get().getStuffId(),Context.get().getClientHost());

		String codePkg = printInfo.getKey();
		String[] incnos = printInfo.getValue();

		// 更新发票数据
		aggDos = this.updateIncData(aggDos, codePkg, incnos);

		return aggDos;
	}

	private BlincipAggDO[] updateIncData(BlincipAggDO[] aggDos, String codePkg, String[] incnos) throws BizException {

		for (int i = 0; i < aggDos.length; i++) {
			BlincipAggDO aggDo = aggDos[i];
			BlIncIpDO incDo = aggDo.getParentDO();
			incDo.setIncno(incnos[0]);
			incDo.setCode_incpkg(codePkg);
			incDo.setFg_print(FBoolean.TRUE); 
			incDo.setTimes_prn(1);
			incDo.setId_emp_inc(Context.get().getStuffId());
			incDo.setId_dep_inc(Context.get().getDeptId());
			incDo.setDt_inc(BlFlowContextUtil.getNowTime());
			incDo.setStatus(DOStatus.UPDATED);
		}

		IBlincipCudService cudService = ServiceFinder.find(IBlincipCudService.class);
		aggDos = cudService.update(aggDos);

		return aggDos;
	}
}
