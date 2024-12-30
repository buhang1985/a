package iih.sc.apt.s.bp.ip;

import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院预约确认或拒绝
 * 
 * @author ccj
 *
 */
public class CfmOrRejectIpAptBP {
	/**
	 * 住院预约确认或拒绝
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
		StringBuffer sb = new StringBuffer(AptIpDODesc.TABLE_ALIAS_NAME);
		sb.append(".id_aptip = '");
		sb.append(id_aptip);
		sb.append("' and ");
		sb.append(AptIpDODesc.TABLE_ALIAS_NAME);
		sb.append(".sd_status = '");
		sb.append(EuStatus.ARRANG);
		sb.append("'");
		AptIpDO[] aptIpDOs = rService.find(sb.toString(), "", FBoolean.TRUE);
		if (ArrayUtils.isEmpty(aptIpDOs)) {
			throw new BizException(IScMsgConst.SC_APT_IP_IS_MODIFIED);
		}
		aptIpDOs[0].setId_emp_cfm(ScContextUtils.getPsnId()); // 确认人为当前登录人
		aptIpDOs[0].setDt_cfm(ScAppUtils.getServerDateTime()); // 确认时间
		aptIpDOs[0].setFg_cfm(FBoolean.TRUE);
		if(aptDTO.getDt_admit_plan() != null){
			aptIpDOs[0].setDt_admit_plan(new FDateTime(aptDTO.getDt_admit_plan() + " 00:00:00"));//计划入院时间-fanlq-add
		}
		if (StringUtil.isEmpty(aptDTO.getRsn_refuse())) {
			// 确认
			aptIpDOs[0].setSd_status(EuStatus.CONFIRM);
		} else {
			// 拒绝
			aptIpDOs[0].setSd_status(EuStatus.REJECT);
			aptIpDOs[0].setRsn_refuse(aptDTO.getRsn_refuse());
			UpdateBedFgApptBp bedFgApptBp = new UpdateBedFgApptBp();
			bedFgApptBp.exec(aptIpDOs[0].getId_bed(), FBoolean.TRUE);
		}
		aptIpDOs[0].setStatus(DOStatus.UPDATED);
		cudService.save(aptIpDOs);
	}
}
