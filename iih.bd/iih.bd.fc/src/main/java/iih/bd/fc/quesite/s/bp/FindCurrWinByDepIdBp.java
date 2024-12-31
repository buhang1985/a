package iih.bd.fc.quesite.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * 根据药房科室主键获取当前计算机对应的药房窗口信息业务逻辑
 * 
 * @author hao_wu 2018-11-23
 *
 */
public class FindCurrWinByDepIdBp {

	public QueSiteDO exec(String depId) throws BizException {
		WorkStationPcDO workStation = findStationByPcId(Context.get().getClientHost());

		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		String wherePart = String.format("id_pc = '%s' and sd_quesitetp = '%s' and id_dep = '%s'",
				workStation.getId_pc(), IBdFcDictCodeConst.SD_QUESITETP_SENDM, depId);
		QueSiteDO[] sites = quesiteRService.find(wherePart, null, FBoolean.FALSE);

		if (ArrayUtil.isEmpty(sites)) {
			String msg = String.format("当前计算机未注册药房窗口信息,工作站主键:%s.", workStation.getId_pc());
			throw new BizException(msg);
		}

		if (sites.length > 1) {
			String msg = String.format("当前计算机存在多个窗口信息,工作站主键:%s.", workStation.getId_pc());
			throw new BizException(msg);
		}

		return sites[0];
	}

	/**
	 * 根据计算机标识查询工作站信息
	 * 
	 * @param pcid 计算机标识
	 * @return
	 * @throws BizException
	 */
	private WorkStationPcDO findStationByPcId(String pcid) throws BizException {

		if (StringUtils.isEmpty(pcid)) {
			throw new BizException("参数pcid不能为空");
		}

		IWorkstationRService workstationService = ServiceFinder.find(IWorkstationRService.class);
		String wherePart = String.format("pcid = '%s' and fg_active = 'Y'", pcid);
		WorkStationPcDO[] result = workstationService.find(wherePart, null, FBoolean.FALSE);

		if (ArrayUtil.isEmpty(result)) {
			String msg = String.format("当前计算机未在系统中注册，计算机标识:%s.", pcid);
			throw new BizException(msg);
		}

		if (result.length > 1) {
			String msg = String.format("当前计算机在系统中重复注册，重复注册次数:%s,计算机标识:%s.", result.length, pcid);
			throw new BizException(msg);
		}

		return result[0];
	}
}
