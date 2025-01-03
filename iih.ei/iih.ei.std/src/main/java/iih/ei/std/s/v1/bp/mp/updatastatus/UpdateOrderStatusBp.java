package iih.ei.std.s.v1.bp.mp.updatastatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.BillsupplyDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.OrderstateDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpdateStatusParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.wf.af.dftimpl.BpmnFlowRequest;

public class UpdateOrderStatusBp extends IIHServiceBaseBP<UpdateStatusParamDTO, NoParamDTO> {

	/**
	 * 入参校验
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void checkParam(UpdateStatusParamDTO param) throws BizException {
		OrderstateDTO[] paramList = (OrderstateDTO[]) param.getOrderstate().toArray(new OrderstateDTO[0]);
		List<String> reList = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		if (paramList == null || paramList.length < 1) {
			throw new BizException("参数空异常！");
		}

		Integer index = 0;
		for (OrderstateDTO orderstate : paramList) {

			if (StringUtil.isEmptyWithTrim(orderstate.getNo_applyform())) {
				reList.add("医嘱执行状态更新：第【" + index + "】行申请单号空异常！");
			}

			String msgStatus = paramValidation(map, "Code_status", orderstate.getCode_status(), "状态编码", index);
			if (!StringUtil.isEmptyWithTrim(msgStatus)) {
				reList.add(msgStatus);
			}

			String msgDtExe = paramValidation(map, "Dt_exe", orderstate.getDt_exe(), "执行时间", index);
			if (!StringUtil.isEmptyWithTrim(msgDtExe)) {
				reList.add(msgDtExe);
			}
			index++;
		}
		if (reList.size() > 0) {
			throw new BizException(reList.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected NoParamDTO process(UpdateStatusParamDTO param) throws BizException {
		OrderstateDTO[] orderstateDTOs = (OrderstateDTO[]) param.getOrderstate().toArray(new OrderstateDTO[0]);
		UpdateOrderStatusAndChargeBp bp = new UpdateOrderStatusAndChargeBp();
		if (param.getBillsupply() != null) {
			BillsupplyDTO[] billsupplyDTOs = (BillsupplyDTO[]) param.getBillsupply().toArray(new BillsupplyDTO[0]);
			bp.exec(orderstateDTOs, billsupplyDTOs);
		} else {
			bp.exec(orderstateDTOs, null);
		}
		return new NoParamDTO();
	}

	/**
	 * 不允许重复信息校验
	 * 
	 * @param map
	 * @param key
	 * @param value
	 * @return
	 */
	private String paramValidation(HashMap<String, String> map, String key, Object value, String msg, Integer index) {
		if (value == null || StringUtil.isEmptyWithTrim(value.toString())) {
			return "医嘱执行状态更新：第【" + index + "】行" + msg + "空异常！";
		}
		if (map.containsKey(key)) {
			if (!value.toString().equals(map.get(key))) {
				return "医嘱执行状态更新：第【" + index + "】行" + msg + "不一致异常！";
			}
		} else {
			map.put(key, value.toString());
		}
		return "";
	}

}
