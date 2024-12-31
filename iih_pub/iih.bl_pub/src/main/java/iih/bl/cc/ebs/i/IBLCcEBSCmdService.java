package iih.bl.cc.ebs.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

/**
 * 执行EBS接口
 * 
 * @author lu.yang
 * 
 */
public interface IBLCcEBSCmdService {

	/**
	 * 执行接口数据对接
	 */
	void execEBSDB() throws BizException;

	/**
	 * 执行接口数据对接
	 */
	void execEBSDBByDate(FDate fDate) throws BizException;
}
