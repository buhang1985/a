package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnDepDTO;
import xap.mw.core.data.BizException;

//TODO yankan TODO Delete(前台和后台均没有用到)
public class GetWillEnDepCountBP {
	/**
	 * 获取待入科病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	public Integer getWillEnDepCount(String nurId) throws BizException{
		GetEnDeptInfoBP endepBP = new GetEnDeptInfoBP();
		EnDepDTO[] endepdtos = endepBP.exec(nurId);
		if(EnValidator.isEmpty(endepdtos)){
			return 0;
		}
		return endepdtos.length;
	}
}
