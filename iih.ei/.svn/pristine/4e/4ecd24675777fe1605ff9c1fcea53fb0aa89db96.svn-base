package iih.ei.std.s.v1.bp.mp.updatestatusbylab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.OrderstateDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpLabStatusDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpLabStatusParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.updatastatus.UpdateOrderStatusAndChargeBp;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: ApUpdateStatusByLabBp
* @Description: 修改状态接口按标本维度 检验专用
* @author zhy
* @date 2019年9月29日
*
 */
public class ApUpdateStatusByLabBp extends IIHServiceBaseBP<UpLabStatusParamDTO, NoParamDTO> {
	
	/**
	 * 入参校验
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void checkParam(UpLabStatusParamDTO param) throws BizException {
		 UpLabStatusDTO[] paramList = (UpLabStatusDTO[]) param.getUplabstatus().toArray(new UpLabStatusDTO[0]);

			List<String> reList = new ArrayList<String>();
			HashMap<String, String> map = new HashMap<String, String>();
			if (paramList == null || paramList.length < 1) {
				throw new BizException("参数空异常！");
			}

			Integer index = 0;
			for (UpLabStatusDTO orderstate : paramList) {

				if (StringUtil.isEmptyWithTrim(orderstate.getNo_bar())) {
					reList.add("医嘱执行状态更新：第【" + index + "】行标本号空异常！");
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


	/**
	 * 核心业务
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected NoParamDTO process(UpLabStatusParamDTO param) throws BizException {
		List<UpLabStatusDTO> paramList = new ArrayList<>(param.getUplabstatus());
		LabConverToAppBp appBp = new LabConverToAppBp();
		OrderstateDTO[] states = appBp.getApplyform(paramList);
		new UpdateOrderStatusAndChargeBp().exec(states,null);
		return new NoParamDTO();
	}
	
	/**
	 * 不允许重复信息校验
	 * @param map
	 * @param string
	 * @param code_status
	 * @param string2
	 * @param index
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
