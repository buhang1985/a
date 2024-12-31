package iih.ci.mr.s.bp;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class AmrBP {
	/**
	 * 获取就诊病案
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public AMrDO getAmrDO(String entId) throws BizException {
		ICiamrRService amrRService = ServiceFinder.find(ICiamrRService.class);
		String whereStr = String.format("Id_ent='%s'", entId);
		AMrDO[] amrDOs = amrRService.find(whereStr, null, FBoolean.FALSE);

		AMrDO amrDO = null;
		if (!ArrayUtils.isEmpty(amrDOs)) {
			amrDO = amrDOs[0];
		}

		return amrDO;
	}

	/**
	 * 保存就诊病案
	 * 
	 * @param amrDO 病案
	 * @throws BizException
	 */
	public void saveAmr(AMrDO amrDO) throws BizException {
		ICiamrCudService amrCudservice = ServiceFinder.find(ICiamrCudService.class);
		amrCudservice.save(new AMrDO[] { amrDO });
	}
	/**
	 * 批量保存
	 * @param amrDO
	 * @throws BizException
	 */
	public void saveAmr(AMrDO[] amrDOs) throws BizException {
		ICiamrCudService amrCudservice = ServiceFinder.find(ICiamrCudService.class);
		amrCudservice.save(amrDOs);
	}
	/**
	 * 批量查询
	 * @param entIdList
	 * @return
	 * @throws BizException
	 */
	public AMrDO[] getAmrDO(ArrayList<String> entIdList) throws BizException {
		if(ListUtil.isEmpty(entIdList))
			return null;
		String entIdStr = buildIdStr(entIdList);
		ICiamrRService amrRService = ServiceFinder.find(ICiamrRService.class);
		String whereStr = String.format("Id_ent in (%s)", entIdStr);
		AMrDO[] amrDOs = amrRService.find(whereStr, null, FBoolean.FALSE);
		return amrDOs;
	}
	
	private String buildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}

}

