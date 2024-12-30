package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取最大可预约时间BP
 * @author yankan
 * @since
 *
 */
public class GetMaxAvlRegDateBP {
	/**
	 * 获取最大可挂号日期
	 * @param chlTp 渠道类型，参考：IScDictCodeConst
	 * @return
	 * @throws BizException
	 */
	public FDate exec(String chlTp) throws BizException{
		IScBdQryService scBdQryService = ServiceFinder.find(IScBdQryService.class);
		SchedulechlDO[] chlDOs = scBdQryService.getChlByTp(chlTp);
		if(ArrayUtil.isEmpty(chlDOs)){
			throw new BizException(IScMsgConst.SC_SCBD_SCCHL_NOT_EXIST);
		}
		
		FDate maxRegDate = scBdQryService.getChlMaxAptDateBP(chlDOs[0].getId_scchl(), IScDictCodeConst.SD_SCTP_OP);
		return maxRegDate;
	}
}
