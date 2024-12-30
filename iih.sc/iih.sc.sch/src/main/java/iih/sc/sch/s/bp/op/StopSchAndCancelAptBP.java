package iih.sc.sch.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.s.bp.SetActiveStateOfSchBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班停诊且取消预约BP
 * 
 * @author zhengcm
 * @date 2017-11-17 16:10:43
 *
 */
public class StopSchAndCancelAptBP {

	/**
	 * 排班停诊且取消预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 16:11:10
	 *
	 * @param id_sch
	 * @throws BizException
	 */
	public void exec(String id_sch) throws BizException {
		// 校验参数
		ScValidator.validateParam("id_sch", id_sch);
		// 获取当前排班预约数据
		SchCancDTO[] datas = new GetOpSchCancAptInfoBP().exec(id_sch, FBoolean.FALSE);
		// 允许退约的数据预约状态为：预约（1）和支付（2）
		this.cancelOpApt(datas);
		// 排班停诊
		new SetActiveStateOfSchBP().exec(new String[] { id_sch }, FBoolean.FALSE);
	}

	/**
	 * 门诊退约：允许退约的数据预约状态为：预约（1）和支付（2）
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 19:49:19
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void cancelOpApt(SchCancDTO[] datas) throws BizException {
		if (ArrayUtil.isEmpty(datas)) {
			return;
		}
		// 预约对外服务接口
		IScAptOutCmdService aptCmdService = ServiceFinder.find(IScAptOutCmdService.class);
		// 目前只能循环逐个退约
		for (SchCancDTO data : datas) {
			if (IScDictCodeConst.SD_APTSTATUS_ORDER.equals(data.getSd_status())
					|| IScDictCodeConst.SD_APTSTATUS_PAY.equals(data.getSd_status())) {
				OpAptDTO dto = new OpAptDTO();
				dto.setId_apt(data.getId_apt());
				dto.setId_tick(data.getId_tick());
				dto.setId_ent(data.getId_ent());
				dto.setType_msg(2);
				aptCmdService.cancOpApt(dto);
			}
		}
	}
}
