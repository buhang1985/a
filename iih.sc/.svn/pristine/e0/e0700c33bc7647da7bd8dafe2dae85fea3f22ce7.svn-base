package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeTypeConst;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.scapt.d.AptOpOralDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 设置口腔科预约状态BP
 * 
 * @author zhengcm
 * @date 2016-10-09 17:07:27
 *
 */
public class SetOralAptStatusTagBP {

	/**
	 * 设置口腔科预约状态
	 *
	 * @param id_apt 预约id
	 * @param sd_statustag 状态编码
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String id_apt, String sd_statustag) throws BizException {
		// 1、参数校验
		ScValidator.validateParam("id_apt", id_apt);
		ScValidator.validateParam("sd_statustag", sd_statustag);

		// 2、更新状态
		this.updateAptStatusTag(id_apt, sd_statustag);
	}

	/**
	 * 更新预约状态
	 *
	 * @param id_apt 预约id
	 * @param sd_statustag 状态编码
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateAptStatusTag(String id_apt, String sd_statustag) throws BizException {
		OralAptEP oralAptEP = new OralAptEP();
		String where = String.format("id_apt = '%s'", id_apt);
		AptOpOralDO[] oralAptDOs = oralAptEP.findAptOpOralByWhere(where);
		if (ArrayUtil.isEmpty(oralAptDOs)) {
			return;
		}
		for (AptOpOralDO oralAptDO : oralAptDOs) {
			oralAptDO.setStatus(DOStatus.UPDATED);
			oralAptDO.setSd_statustag(sd_statustag);
			oralAptDO.setId_statustag(this.getTagIdByCode(sd_statustag));
			oralAptDO.setId_emp_lastmdf(ScContextUtils.getPsnId());
			oralAptDO.setDt_lastmdf(ScAppUtils.getServerDateTime());
		}
		// 保存状态
		oralAptEP.saveAptOpOral(oralAptDOs);
	}

	/**
	 * 根据状态类型编码取得状态类型id
	 *
	 * @param sd_statustag 状态类型编码
	 * @return 状态类型id
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getTagIdByCode(String sd_statustag) throws BizException {
		if (StringUtil.isEmptyWithTrim(sd_statustag)) {
			return null;
		}
		// 自定义档案查询服务
		IUdidocRService qryService = ServiceFinder.find(IUdidocRService.class);
		String cond = String.format("id_udidoclist = '%s'", IScDictCodeTypeConst.ID_ORAL_APT_STATUS_TAG);
		UdidocDO[] docDOs = qryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(docDOs)) {
			return null;
		}
		String tagId = null;
		for (UdidocDO docDO : docDOs) {
			if (docDO.getCode().equals(sd_statustag)) {
				tagId = docDO.getId_udidoc();
				break;
			}
		}
		return tagId;
	}

}
