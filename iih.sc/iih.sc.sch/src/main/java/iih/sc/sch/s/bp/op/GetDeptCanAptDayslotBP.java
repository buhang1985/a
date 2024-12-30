package iih.sc.sch.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取当前科室可预约的午别BP
 * 
 * @author zhengcm
 * @date 2017-11-27 13:45:43
 *
 */
public class GetDeptCanAptDayslotBP {

	/**
	 * 获取当前科室可预约的午别
	 * 
	 * @author zhengcm
	 * @date 2017-11-27 13:45:07
	 *
	 * @param id_dept
	 * @param d_sch
	 * @return
	 * @throws BizException
	 */
	public List<String> exec(String id_dept, FDate d_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_dept) || null == d_sch) {
			return null;
		}
		FDateTime nowDateTime = ScAppUtils.getServerDateTime();
		IScBdOutQryService qryService = ServiceFinder.find(IScBdOutQryService.class);
		ScdeptparamAggDO[] params = qryService.getDeptParamList(id_dept, IScDictCodeConst.SD_SCTP_OP);
		if (ArrayUtil.isEmpty(params)) {
			return null;
		}
		List<String> dayslotIdList = new ArrayList<String>();
		ScDeptParamDsDO[] bdos = params[0].getScDeptParamDsDO();
		if (nowDateTime.getBeginDate().compareTo(d_sch) != 0) {
			for (ScDeptParamDsDO bdo : bdos) {
				dayslotIdList.add(bdo.getId_dayslot());
			}
		} else {
			for (ScDeptParamDsDO bdo : bdos) {
				FDateTime dt = new FDateTime(d_sch.toLocalString() + " " + bdo.getT_end().toLocalString());
				if(bdo.getT_begin().compareTo(bdo.getT_end()) > 0){
					dayslotIdList.add(bdo.getId_dayslot());
				}else if (bdo.getT_begin().compareTo(bdo.getT_end()) < 0 && nowDateTime.compareTo(dt) <= 0) {
					dayslotIdList.add(bdo.getId_dayslot());
				}
			}
		}
		return dayslotIdList;
	}

}
