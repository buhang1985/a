package iih.bd.fc.wf.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.s.bp.qry.getWfByCodeSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class ValidatWfSrvtpSd {

	/**
	 * 验证同一就诊类型、同一流向,服务类型编码是否重复
	 * 
	 * @param AggDO
	 * @throws BizException
	 */
	public void exec(WfAggDO AggDO) throws BizException {

		// 1.验证
		if (AggDO == null) {
			return;
		}

		// 2.获取服务类型编码集合
		String[] Sd_Srvtp = getWfSrvtpSd(AggDO.getWfSrvtpDO());

		// 3.验证是否存在重复数据
		ValidatDO(AggDO.getParentDO().getId_wf(), AggDO.getParentDO().getCode_entp(), AggDO.getParentDO().getEu_wftp(), Sd_Srvtp, AggDO);

	}

	/**
	 * 获取服务类型编码
	 * 
	 * @param DOs
	 * @return
	 * @throws BizException
	 */
	private String[] getWfSrvtpSd(WfSrvtpDO[] DOs) throws BizException {

		List<String> SdSrvtps = new ArrayList<String>();

		for (WfSrvtpDO wfSrvtpDO : DOs) {
			
			if(wfSrvtpDO.getStatus()==DOStatus.DELETED){
				
				continue;
			}
			SdSrvtps.add(wfSrvtpDO.getSd_srvtp());
		}
		return SdSrvtps.toArray(new String[SdSrvtps.size()]);
	}

	/**
	 * 验证是否有返回值
	 * 
	 * @param id_entp
	 *            就诊id
	 * @param code
	 *            流向编码
	 * @param sd_srvtps
	 *            服务编码
	 * @throws BizException
	 */
	private void ValidatDO(String id_wf, String code_entp, Integer eu_wftp, String[] sd_srvtps, WfAggDO AggDO) throws BizException {

		getWfByCodeSql sql = new getWfByCodeSql(id_wf, code_entp, eu_wftp, sd_srvtps);

		WfSrvtpDO[] wfSrvtpDOs = (WfSrvtpDO[]) AppFwUtil.getDORstWithDao(sql, WfSrvtpDO.class);

		if (wfSrvtpDOs != null && wfSrvtpDOs.length > 0) {

			String Sd_srvtps = "";

			for (WfSrvtpDO wfSrvtpDO : wfSrvtpDOs) {

				Sd_srvtps += ((StringUtil.isEmptyWithTrim(Sd_srvtps) ? "" : "|") + getSvrtpNameBySd(AggDO, wfSrvtpDO.getSd_srvtp()));
			}
			throw new BizException("服务类型：【" + Sd_srvtps + "】 编码重复！");
		}
	}

	/**
	 * 有指定服务类型编码获取服务类型名称
	 * 
	 * @param AggDO
	 * @param Sd_srvtp
	 *            服务类型编码
	 * @return
	 * @throws BizException
	 */
	private String getSvrtpNameBySd(WfAggDO AggDO, String Sd_srvtp) throws BizException {

		WfSrvtpDO[] DOS = AggDO.getWfSrvtpDO();

		if (DOS == null)
			return null;

		for (WfSrvtpDO DO : DOS) {

			if (Sd_srvtp.equals(DO.getSd_srvtp())) {

				return DO.getName();
			}
		}
		return null;
	}
}
