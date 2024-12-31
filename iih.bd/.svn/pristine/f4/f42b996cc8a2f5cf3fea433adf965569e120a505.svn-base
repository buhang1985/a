package iih.bd.fc.que.bp;

import iih.bd.fc.que.d.desc.QueDODesc;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 队列编码帮助类
 * 
 * @author liubin
 *
 */
public class QueCodeUtils {
	
	/**
	 * 获取队列的编码
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getNewQueCode() throws BizException{
		return createCode(QueDODesc.CLASS_FULLNAME);
	}
	
	/**
	 * 生成编码
	 * @param doDescFullName 实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private static String createCode(String doDescFullName) throws BizException{
		IBillcodeManage  codeManage=ServiceFinder.find(IBillcodeManage.class);
		String code =codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
}
