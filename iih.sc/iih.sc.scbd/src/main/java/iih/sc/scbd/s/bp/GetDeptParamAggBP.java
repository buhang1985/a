package iih.sc.scbd.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.sc.scbd.s.bp.GetDeptParamBP;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 获取时间段内科室参数agg
 * @author renying
 *
 */
public class GetDeptParamAggBP {

	/**
	 * 获取时间段内科室参数agg
	 * @param d_b
	 * @param d_e
	 * @return
	 * @throws BizException
	 */
	public ScdeptparamAggDO[] exec(String d_b,String d_e,String sd_sctp) throws BizException{
		GetDeptParamBP getParamBp = new GetDeptParamBP();
		ScDeptParamDO[]  scDept =  getParamBp.exec(d_b, d_e, sd_sctp);
		if(scDept == null || scDept.length == 0)
			return null;
		List<String> strList = new ArrayList<String>();
		for(ScDeptParamDO paramDO:scDept){
			strList.add(paramDO.getId_deptparam());
		}
		IScdeptparamRService rService = ServiceFinder.find(IScdeptparamRService.class);
		ScdeptparamAggDO[] aggDOs = rService.findByIds(strList.toArray(new String[strList.size()]), FBoolean.FALSE);
		return aggDOs;
	}

}
