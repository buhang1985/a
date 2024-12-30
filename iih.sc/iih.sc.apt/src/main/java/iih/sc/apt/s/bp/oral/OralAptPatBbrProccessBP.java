package iih.sc.apt.s.bp.oral;

import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrRService;
import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.comm.ScSqlUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 口腔科预约信息的患者不良行为处理BP
 * 
 * @author zhengcm
 * @date 2016-10-20 13:37:00
 *
 */
public class OralAptPatBbrProccessBP {

	/**
	 * 口腔科预约信息的患者不良行为处理
	 *
	 * @param oralAptDTOList 口腔科预约信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(List<AptOralDTO> oralAptDTOList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return;
		}
		List<String> ids = this.getPatIds(oralAptDTOList);
		if (ListUtil.isEmpty(ids)) {
			return;
		}
		// 患者不良行为查询服务
		IPatbbrRService qryService = ServiceFinder.find(IPatbbrRService.class);
		PiPatBbrDO[] bbrDOs = qryService.find(ScSqlUtils.getInSqlByIds("id_pat", ids), null,
				FBoolean.FALSE);
		if (ArrayUtil.isEmpty(bbrDOs)) {
			return;
		}
		List<String> hasIds = new ArrayList<String>();
		for (PiPatBbrDO bbrDO : bbrDOs) {
			String patId = bbrDO.getId_pat();
			if (!hasIds.contains(patId)) {
				hasIds.add(patId);
			}
		}
		// 处理是否有不良行为
		for (AptOralDTO oralAptDTO : oralAptDTOList) {
			String patId = oralAptDTO.getId_pat();
			if (!StringUtil.isEmptyWithTrim(patId) && hasIds.contains(patId)) {
				oralAptDTO.setFg_hasbbr(FBoolean.TRUE);
			} else {
				oralAptDTO.setFg_hasbbr(FBoolean.FALSE);
			}
		}
	}

	/**
	 * 获取患者id
	 *
	 * @param oralAptDTOList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getPatIds(List<AptOralDTO> oralAptDTOList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return null;
		}
		List<String> ids = new ArrayList<String>();
		for (AptOralDTO oralAptDTO : oralAptDTOList) {
			String patId = oralAptDTO.getId_pat();
			if (!StringUtil.isEmptyWithTrim(patId) && !ids.contains(patId)) {
				ids.add(patId);
			}
		}
		return ids;
	}
}
