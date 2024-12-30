package iih.sc.apt.s.bp.ip;

import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院预约取消确认或取消拒绝
 * 
 * @author ccj
 *
 */
public class CancCfmOrRejectIpAptBP {
	/**
	 * 住院预约取消确认或取消拒绝
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	public void exec(AptIpDTO aptDTO) throws BizException {
		if (aptDTO == null || StringUtil.isEmpty(aptDTO.getId_scaptip())) {
			return;
		}
		IAptipMDORService rService = ServiceFinder.find(IAptipMDORService.class);
		IAptipMDOCudService cudService = ServiceFinder.find(IAptipMDOCudService.class);
		String id_aptip = aptDTO.getId_scaptip(); // 住院住院do id
		AptIpDO[] aptIpDO = null;
		if (EuStatus.CONFIRM.equals(aptDTO.getSd_status())) {
			aptIpDO = rService.find(AptIpDODesc.TABLE_ALIAS_NAME + ".id_aptip = '" + id_aptip + "' and "
					+ AptIpDODesc.TABLE_ALIAS_NAME + ".sd_status = " + EuStatus.CONFIRM + "", "", FBoolean.TRUE);
			if (ArrayUtil.isEmpty(aptIpDO)) {
				throw new BizException(IScMsgConst.SC_APT_IP_IS_MODIFIED);
			}
		} else if (EuStatus.REJECT.equals(aptDTO.getSd_status())) {
			aptIpDO = rService.find(AptIpDODesc.TABLE_ALIAS_NAME + ".id_aptip = '" + id_aptip + "' and "
					+ AptIpDODesc.TABLE_ALIAS_NAME + ".sd_status = " + EuStatus.REJECT + "", "", FBoolean.TRUE);
			if (ArrayUtil.isEmpty(aptIpDO)) {
				throw new BizException(IScMsgConst.SC_APT_IP_IS_MODIFIED);
			}
			// 如果是取消拒绝
			UpdateBedFgApptBp bedFgApptBp = new UpdateBedFgApptBp();
			bedFgApptBp.exec(aptIpDO[0].getId_bed(), FBoolean.FALSE);
		}
		aptIpDO[0].setFg_cfm(FBoolean.FALSE);
		aptIpDO[0].setId_emp_cfm(null); // 确认人为当前登录人
		aptIpDO[0].setDt_cfm(null); // 确认时间
		aptIpDO[0].setSd_status(EuStatus.ARRANG); // 申请单状态
		aptIpDO[0].setRsn_refuse(null); // 拒绝原因
		aptIpDO[0].setStatus(DOStatus.UPDATED);
		cudService.save(aptIpDO);
	}
}
