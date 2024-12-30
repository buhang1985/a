package iih.sc.apt.s.bp;

import com.mysql.fabric.xmlrpc.base.Array;

import iih.sc.apt.i.IScAptQryService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约检查BP：校验当前日期是否超过午别时间
 * 
 * @author yzh
 * @date 2019年3月6日 09:25:17
 *
 */
public class AptCheckDaysLotBP {

	/**
	 * 预约检查BP：校验当前日期是否超过午别时间
	 * @param id_scca
	 * @param id_dep_mp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_scca, String id_dep_mp,String sd_sctp) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_scca", id_scca);
		ScValidator.validateParam("id_dep_mp", id_dep_mp);
		FDateTime now = ScAppUtils.getServerDateTime();
		
		IScAptQryService qry = ServiceFinder.find(IScAptQryService.class);
		ScdeptparamAggDO[] aggDOs = qry.getDeptParamList(id_dep_mp, sd_sctp);
		if(ArrayUtil.isEmpty(aggDOs)){
			throw new BizException("排班科室参数为空!");
		}
		for (ScdeptparamAggDO scdeptparamAggDO : aggDOs) {
			ScDeptParamDO deptParamDO = scdeptparamAggDO.getParentDO();
			if(id_scca.equals(deptParamDO.getId_scca())){
				ScDeptParamDsDO[] deptParamDs = scdeptparamAggDO.getScDeptParamDsDO();
				if(ArrayUtil.isEmpty(deptParamDs)){
					throw new BizException("排班科室参数为空");
				}
				for (ScDeptParamDsDO scDeptParamDsDO : deptParamDs) {
					FDate nowDate = now.getBeginDate();
					if(now.compareTo(new FDateTime(nowDate, scDeptParamDsDO.getT_end())) < 0){
						return FBoolean.TRUE;  
					}
				}
				return FBoolean.FALSE;
			}
		}
		return FBoolean.TRUE;
	}


}
