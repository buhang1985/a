package iih.sc.apt.s.bp.ip;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消住院申请
 * 
 * @author yank
 * @author ccj
 *
 */
public class CancIpAppBP {
	/**
	 * 取消住院申请
	 * 
	 * @param aptIpDTO 住院预约DTO
	 * @throws BizException
	 */
	public void exec(AptIpDTO aptIpDTO) throws BizException {
		ScValidator.validateParam("aptIpDTO", aptIpDTO);
		ScValidator.validateParam("住院预约id", aptIpDTO.getId_scaptip());
		IAptipMDORService aptIpRService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO[] aptIpDOs = aptIpRService.find(
				AptIpDODesc.TABLE_ALIAS_NAME + ".id_aptip = '" + aptIpDTO.getId_scaptip() + "' and "
						+ AptIpDODesc.TABLE_ALIAS_NAME + ".sd_status in (" + EuStatus.APPY + "," + EuStatus.REJECT
						+ "," + EuStatus.ARRANG + ") and " + AptIpDODesc.TABLE_ALIAS_NAME + ".fg_canc = 'N'", null,
				FBoolean.TRUE);
		if (ArrayUtils.isEmpty(aptIpDOs)) {
			throw new BizException(IScMsgConst.SC_APT_IP_NOT_EXISTS);
			// 住院预约已经取消，不能 重复操作！
		} else if (FBoolean.TRUE.equals(aptIpDOs[0].getFg_canc())) {
			throw new BizException(IScMsgConst.SC_APT_IP_HAS_CANCELED);
			// 住院预约非申请或拒绝状态，不能取消！
		} else if (!IScDictCodeConst.SD_APTIP_STATUS_APPLY.equals(aptIpDOs[0].getSd_status())
				&& !IScDictCodeConst.SD_APTIP_STATUS_REJECT.equals(aptIpDOs[0].getSd_status())
				&& !IScDictCodeConst.SD_APTIP_STATUS_ARRANGE.equals(aptIpDOs[0].getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_IP_NOT_APPLY_OR_REJECT);
		}
		// 标记为取消
		aptIpDOs[0].setFg_canc(FBoolean.TRUE);
		// 取消时间
		aptIpDOs[0].setDt_canc(ScAppUtils.getServerDateTime());
		// 取消人
		aptIpDOs[0].setId_emp_canc(ScContextUtils.getPsnId());
		aptIpDOs[0].setStatus(DOStatus.UPDATED);
		IAptipMDOCudService aptIpCudService = ServiceFinder.find(IAptipMDOCudService.class);
		aptIpCudService.save(aptIpDOs);

		// add by zhengcm 2018-04-16 修改床位的预约状态
		if (null != aptIpDOs[0].getId_bed()) {
			// 修改床位状态
			IBedMDORService bedRService = ServiceFinder.find(IBedMDORService.class);
			IBedMDOCudService bedCudService = ServiceFinder.find(IBedMDOCudService.class);
			Bdbed bdbed = bedRService.findById(aptIpDOs[0].getId_bed());
			if (bdbed == null) {
				throw new BizException(IScMsgConst.SC_QUERY_FAIL);
			}
			bdbed.setFg_appt(FBoolean.FALSE);// 修改预约状态为否
			bedCudService.update(new Bdbed[] { bdbed });
		}
	}
}
