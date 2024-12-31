package iih.bl.inc.bp;

import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.d.desc.BlCpnInDODesc;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 获取优惠券入库单编码的类，供打开优惠券入库单界面后  点击新增时使用
 * @author li_pengying
 *
 */
public class GetCpnInCodeBp {
    
	/**
	 * 获取优惠券入库单编码
	 * @throws BizException 
	 * */
	public String getBlCpnInCode() throws BizException{
		IBillcodeManage  codeS1=ServiceFinder.find(IBillcodeManage.class);
		//调用框架提供的方法来获取生成的入库单编码号
		String code_cg=codeS1.getBillCode_RequiresNew(BlCpnInDODesc.CLASS_FULLNAME,new BlCpnInDO());
		return code_cg;
	}
	
}
