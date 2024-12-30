package iih.sc.scbd.s.bp;

import java.util.Arrays;
import java.util.Comparator;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取科室参数BP
 * 
 * @author zhengcm
 *
 */
public class GetDeptParamByDateBP {

	/**
	 * 获取科室参数
	 *
	 * @param id_dept 科室id
	 * @param date 日期
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScdeptparamAggDO exec(String id_dept,FDate date,String sd_sctp) throws BizException {
		ScValidator.validateParam("id_dept", id_dept);
		if(date==null){
			FDateTime currentTime = ScAppUtils.getServerDateTime();
			date = currentTime.getDate();
		}
		
		// 科室参数查询服务
		IScdeptparamRService paramSrv = ServiceFinder.find(IScdeptparamRService.class);
		String where = String.format("id_dep = '%s' and sd_sctp ='"+sd_sctp+"'", id_dept);
		ScdeptparamAggDO[] paramAggDO = paramSrv.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(paramAggDO)) {
			return null;
		}
		ScDeptParamDsDO[] paramDsDOs = paramAggDO[0].getScDeptParamDsDO();
		// 排序
		Arrays.sort(paramDsDOs, new Comparator<ScDeptParamDsDO>() {
			@Override
			public int compare(ScDeptParamDsDO o1, ScDeptParamDsDO o2) {
				if (o1.getT_begin().after(o2.getT_begin()))
					return 1;
				return -1;
			}
		});
		paramAggDO[0].setChildren(ScDeptParamDsDO.class, paramDsDOs);
		return paramAggDO[0];
	}

}
