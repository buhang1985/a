package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.scbd.s.bp.dayslot.GetNowDaysLotBP;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据排班分类和执行科室医技预约记录开始时间判断当前属于正常退约 or 限制时间退约 or 爽约
 * @author yzh
 */
public class GetCancMtAptTypeBP {
	/**
	 * 根据排班分类和执行科室医技预约记录开始时间判断当前属于正常退约 or 限制时间退约 or 爽约
	 * @param id_scca
	 * @param id_dep_mp
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_scca,String id_dep_mp,String id_apt) throws BizException {
		if(StringUtil.isEmpty(id_scca) || StringUtil.isEmpty(id_dep_mp) || StringUtil.isEmpty(id_apt)) return null;
		ScdeptparamAggDO agg = this.getScDepParamAgg(id_scca, id_dep_mp);
		ScAptDO aptDO = new AptEP().getById(id_apt);
		if(agg == null || aptDO == null) return null;
		return this.getCancAptType(agg.getParentDO(), agg.getScDeptParamDsDO(), aptDO);
	}
	
	/**
	 * 获取医技排班参数agg
	 * @param id_scca
	 * @param id_dep_mp
	 * @return
	 * @throws BizException
	 */
	private ScdeptparamAggDO getScDepParamAgg(String id_scca,String id_dep_mp) throws BizException{
		IScdeptparamRService iscdeptparamrservice = ServiceFinder.find(IScdeptparamRService.class);
		StringBuffer condtion = new StringBuffer();
		condtion.append("id_dep ='").append(id_dep_mp).append("' and id_scca='").append(id_scca).append("'");
		ScdeptparamAggDO[] aggs = iscdeptparamrservice.find(condtion.toString(), null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(aggs)){
			return aggs[0];
		}
		return null;
	}
	
	private String getCancAptType(ScDeptParamDO scdepparamDO,ScDeptParamDsDO[] scdepparamdsDOs,ScAptDO aptDO) throws BizException{
		FDateTime dt_b = aptDO.getDt_b();
		FDateTime now = ScAppUtils.getServerDateTime();
		//退约时间类型 为 按午别设置时
		if(IScDictCodeConst.DAYSLOT_TP.equals(scdepparamDO.getSd_canc_time_tp())){
			//预约的日期在当前日期之后正常退约
			if(dt_b.getBeginDate().compareTo(now.getBeginDate()) > 0){
				return IScDictCodeConst.SC_CANC_APT_NORM;
			}
			//预约的日期在当前日期之前 爽约
			if(dt_b.getBeginDate().compareTo(now.getBeginDate()) < 0){
				return IScDictCodeConst.SC_CANC_APT_BREAK;
			}
			//当天取当前午别的科室参数的 取消预约时间 判断预约时间在取消预约时间之前或相等为正常退约 否则为爽约
			String id_dayslot = aptDO.getId_dateslot();
			FTime canc_time = null;
			for (ScDeptParamDsDO scDeptParamDsDO : scdepparamdsDOs) {
				if(scDeptParamDsDO.getId_dayslot().equals(id_dayslot)){
					canc_time = scDeptParamDsDO.getT_canc();
				}
			}
			if(canc_time == null) return null;
			FDateTime canc_time_point = new FDateTime(now.getBeginDate(), canc_time);
			if(dt_b.compareTo(canc_time_point) <= 0){
				return IScDictCodeConst.SC_CANC_APT_NORM;
			}else{
				return IScDictCodeConst.SC_CANC_APT_BREAK;
			}
		}
		//退约时间类型为排班时间
		if(IScDictCodeConst.SCH_TIME_TP.equals(scdepparamDO.getSd_canc_time_tp())){
			int period_canc_norm = scdepparamDO.getPeriod_canc_norm();//正常退约时间
			int period_canc_limit = scdepparamDO.getPeriod_canc_limit();//限制退约时间
			FDateTime canc_norm_point = dt_b.addSeconds(-1 * period_canc_norm * 60);//计算出正常退约的时间点
			FDateTime canc_limit_point = dt_b.addSeconds(period_canc_limit * 60);//计算出限制退约的时间点
			//当前时间在正常时间点前为正常退约
			if(now.compareTo(canc_norm_point) <= 0){
				return IScDictCodeConst.SC_CANC_APT_NORM;
			}
			//如果限制退约时间点在正常退约时间点之后
			if(canc_limit_point.compareTo(canc_norm_point) > 0){
			//当前时间 退约时间在限制时间点前 在正常退约时间点后 为限制退约
			if(now.compareTo(canc_norm_point) > 0 && now.compareTo(canc_limit_point) <= 0){
				return IScDictCodeConst.SC_CANC_APT_LIMIT;
			}
			//当前时间 在限制时间点后为爽约
			if(now.compareTo(canc_limit_point) > 0){
				return IScDictCodeConst.SC_CANC_APT_BREAK;
			}
		}
			//如果限制退约时间在正常退约时间点之前
			if(canc_limit_point.compareTo(canc_norm_point) < 0){
				if(now.compareTo(canc_limit_point)<=0){
					return IScDictCodeConst.SC_CANC_APT_NORM;
				}
				if(now.compareTo(canc_limit_point)>0 && now.compareTo(canc_norm_point)<=0){
					return IScDictCodeConst.SC_CANC_APT_LIMIT;
				}
				if(now.compareTo(canc_norm_point) > 0){
					return IScDictCodeConst.SC_CANC_APT_BREAK;
				}
			}
			
		}
		return null;
	}
}
