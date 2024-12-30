package iih.sc.apt.s.bp;

import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取预约渠道最大可预约日期BP
 * 
 * @author zhengcm
 * @date 2017-06-08 14:54:22
 *
 */
public class GetAptChlMaxDateBP {

	/**
	 * 获取渠道最大可预约日期
	 *
	 * @param sd_scchltp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public FDate exec(String sd_scchltp, String sd_sctp) throws BizException {
		if (StringUtil.isEmptyWithTrim(sd_scchltp) || StringUtil.isEmptyWithTrim(sd_sctp)) {
			return null;
		}
		IScBdQryService bdQryService = ServiceFinder.find(IScBdQryService.class);
		SchedulechlDO[] schedulechlDOs = bdQryService.getChlByTp(sd_scchltp);
		FDate fDate = null;
		try {
			if (ArrayUtils.isNotEmpty(schedulechlDOs)) {
				fDate = bdQryService.getChlMaxAptDateBP(schedulechlDOs[0].getId_scchl(), sd_sctp);
			}
		} catch (Exception e) {
			return fDate;
		}
		return fDate;
	}

}
