package iih.sc.scbd.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.EuStatus;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取科室参数BP
 * 
 * @author zhengcm
 * @date 2016-09-23 15:40:07
 *
 */
public class GetDeptParamsBP {

	/**
	 * 获取科室参数（所有提交版本）
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScdeptparamAggDO[] exec(String id_dept, String sd_sctp) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_dept", id_dept);
		ScValidator.validateParam("sd_sctp", sd_sctp);
		// 科室参数查询服务
		IScdeptparamRService paramSrv = ServiceFinder.find(IScdeptparamRService.class);
		String where = String.format("id_dep = '%s' and sd_sctp = '%s'", id_dept, sd_sctp);
		ScdeptparamAggDO[] paramAggDOs = paramSrv.find(where, "ver", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(paramAggDOs)) {
			return null;
		}
		// 如果有版本，则过滤掉为提交的数据
		List<ScdeptparamAggDO> list = new ArrayList<ScdeptparamAggDO>();
		for (ScdeptparamAggDO aggDO : paramAggDOs) {
			if (aggDO.getParentDO().getVer() == null
					|| (aggDO.getParentDO().getVer() != null && aggDO.getParentDO().getEu_status() == EuStatus.SUBMIT)) {
				list.add(aggDO);
			}
		}
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		// 过滤表体(未启用)
		this.filterBody(paramAggDOs);
		// 表体数据排序
		for (ScdeptparamAggDO aggDO : list) {
			ScDeptParamDsDO[] paramDsDOs = aggDO.getScDeptParamDsDO();
			// 排序
			Arrays.sort(paramDsDOs, new Comparator<ScDeptParamDsDO>() {
				@Override
				public int compare(ScDeptParamDsDO o1, ScDeptParamDsDO o2) {
					if (o1.getT_begin().after(o2.getT_begin()))
						return 1;
					return -1;
				}
			});
			aggDO.setChildren(ScDeptParamDsDO.class, paramDsDOs);
		}
		return list.toArray(new ScdeptparamAggDO[0]);
	}

	/**
	 * 过滤表体（未启用）
	 *
	 * @param aggDOs
	 * @throws BizException
	 * @author zhengcm
	 */
	private void filterBody(ScdeptparamAggDO[] aggDOs) throws BizException {
		if (ArrayUtil.isEmpty(aggDOs)) {
			return;
		}
		for (ScdeptparamAggDO aggDO : aggDOs) {
			ScDeptParamDsDO[] bodyDOs = aggDO.getScDeptParamDsDO();
			if (ArrayUtil.isEmpty(bodyDOs)) {
				continue;
			}
			List<ScDeptParamDsDO> bodyList = new ArrayList<ScDeptParamDsDO>();
			for (ScDeptParamDsDO bdo : bodyDOs) {
				if (bdo.getFg_active().booleanValue()) {
					bodyList.add(bdo);
				}
			}
			aggDO.setChildren(ScDeptParamDsDO.class, bodyList.toArray(new ScDeptParamDsDO[0]));
		}
	}

}
