package iih.bl.cg.service.s.bp;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.ep.OepCgEP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 销账功能
 * @author yang.lu2018年3月30日
 *
 */
public class SetOrderRefundBillToCgBP {
	
	/**
	 * 销账功能
	 * @param idEnt就诊编号
	 * @param cgType记账类别（预交金，高端商保，科研项目）
	 * @param idEmp当前操作人员
	 * @param idOrs医嘱号
	 * @return
	 * @throws BizException
	 */
	public String exec(String idEnt, String cgType, String idEmp, String[] idOrs) throws BizException {
		//调用EP 获取未执行结算的记账数据
		OepCgEP ep = new OepCgEP();
		
		BlOrderAppendBillParamDTO[] cgDTOs = ep.getCgOrderDTO(idEnt, cgType, idOrs, idEmp);
	
		if (ArrayUtil.isEmpty(cgDTOs)) {
			throw new BizException("没有获取到可以销账的数据！");
		}
		
		CancelReserveBP bp = new CancelReserveBP();
		// 3、调用销账函数进行销账
		String tip = bp.exec(cgDTOs, cgDTOs[0].getCode_enttp());
		return tip;
	}
}
