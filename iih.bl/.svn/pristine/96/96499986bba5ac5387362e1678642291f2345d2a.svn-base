package iih.bl.inc.s.util;

import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.s.ep.CancIncEP;
import iih.bl.inc.s.ep.IncIssEP;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.lock.PKLock;

/**
 * 发票打印工具类
 * @author ly 2018/04/19
 *
 */
public class InvoicePrintUtil {

	/**
	 * 发票打印
	 * 包括计算发票号，跳号处理
	 * @param inccaId
	 * @param incNum
	 * @return key:票据包编号 value:发票好
	 * @throws BizException
	 */
	public static Entry<String,String[]> print(String inccaId,Integer incNum,String empId,String pcId) throws BizException{
		
		// 查询票据包信息
		BlIncIssDO incInfo = new IncIssEP().findUsingInc(empId, pcId, inccaId);

		// 票据包加锁
		boolean lock = PKLock.getInstance().addDynamicLock(incInfo.getId_inciss());
		if(!lock){
			throw new BizException(IBlMsgConst.ERROR_INCISS_LOCK_ALERT);
		}
	
		// 查询作废发票信息
		BlIncCancDO[] cancInfo = new CancIncEP().findCancInc(
				incInfo.getId_incca(), incInfo.getCode_incpkg(),
				incInfo.getIncno_cur());
		
		// 计算发票号
		String[] incnos = InvoiceCalUtil.nextInvoice(incNum, incInfo, cancInfo);
		
		// 更新票据包信息
		new IncIssEP().updateNextProvince(incInfo, cancInfo, incnos[incnos.length - 1]);
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put(incInfo.getCode_incpkg(), incnos);
		return map.entrySet().iterator().next();
	}
	
}
