package iih.sc.apt.s.bp;

import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.EuStatus;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约取消预约时间校验BP
 * 
 * @author zhengcm
 * @date 2017-10-17 19:03:04
 *
 */
public class CancelAptTimeCheckBP {

	/**
	 * 检查取消预约时间
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt 预约ID
	 * @return
	 * @throws BizException
	 */
	public FBoolean check(String id_apt) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_apt", id_apt);
		// 当前日期
		FDate nowDate = ScAppUtils.getServerDate();
		// 预约DO
		ScAptDO aptDO = new AptEP().getById(id_apt);
		// 排班DO
		ScSchDO schDO = new OralAptEP().getSch(aptDO.getId_sch());
		// 是否当天
		if (!schDO.getD_sch().toLocalString().equals(nowDate.toLocalString())) {
			return FBoolean.TRUE;
		}
		// 计划DO
		ScPlanDO planDO = new OralAptEP().getScPlan(schDO.getId_scpl());
		// 参数版本（口腔科）
		String ver = schDO.getVer() == null ? null : schDO.getVer().toString();
		// 预约开始时间
		FTime beginTime = new FTime(aptDO.getDt_b().toLocalString().substring(11));
		// 预约结束时间
		FTime endTime = new FTime(aptDO.getDt_e().toLocalString().substring(11));
		// 取消预约时间
		FTime cancTime = this.getCancelTime(planDO.getId_dep(), aptDO.getSd_sctp(), ver, beginTime, endTime);
		// 当前时间
		FTime nowTime = new FTime(ScAppUtils.getServerDateTime().toLocalString().substring(11));
		// 比较：退的号是当前且当前时间大于取消预约时间
		if (null != cancTime && nowTime.compareTo(cancTime) > 0) {
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}

	/**
	 * 获取取消预约时间
	 *
	 * @author zhengcm
	 * 
	 * @param id_dep 科室ID
	 * @param sd_sctp 排班类型编码
	 * @param ver 参数版本
	 * @param beginTime 预约开始时间
	 * @param endTime 预约结束时间
	 * @return
	 * @throws BizException
	 */
	private FTime getCancelTime(String id_dep, String sd_sctp, String ver, FTime beginTime, FTime endTime)
			throws BizException {
		// 科室参数查询服务
		IScdeptparamRService paramSrv = ServiceFinder.find(IScdeptparamRService.class);
		String where = String.format("id_dep = '%s' and sd_sctp = '%s'", id_dep, sd_sctp);
		ScdeptparamAggDO[] paramAggDOs = paramSrv.find(where, "ver", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(paramAggDOs)) {
			return null;
		}
		// 如果有版本，则过滤掉为提交的数据（口腔科）
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
		ScdeptparamAggDO curAggDO = list.get(0);
		if (null != ver) {
			curAggDO = null;
			for (ScdeptparamAggDO aggDO : list) {
				if (aggDO.getParentDO().getVer() != null && aggDO.getParentDO().getVer().toString().equals(ver)) {
					curAggDO = aggDO;
					break;
				}
			}
		}
		if (null == curAggDO) {
			return null;
		}
		ScDeptParamDsDO[] bdos = curAggDO.getScDeptParamDsDO();
		if (null == bdos) {
			return null;
		}
		for (ScDeptParamDsDO bdo : bdos) {
			FTime t_b = bdo.getT_begin();
			FTime t_e = bdo.getT_end();
			if (t_b.compareTo(beginTime) <= 0 && (null == t_e || t_e.compareTo(endTime) > 0)) {
				return bdo.getT_canc();
			}
		}
		return null;
	}
}
