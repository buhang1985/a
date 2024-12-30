package iih.sc.comm;

import iih.bd.fc.que.d.desc.QueDODesc;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * Sc编码生成帮助类
 * 
 * 
 * @author liubin
 * 
 * 下午7:22:24
 */
public class ScCodeUtils {
	
	/**
	 * 生成队列编码
	 * 
	 * @author liubin
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String createQueCode() throws BizException{
		return createCode(QueDODesc.CLASS_FULLNAME);
	}
	
	/**
	 * 生成预约申请单编码
	 * 
	 * @author liubin
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String createScApplCode() throws BizException{
		return createCode(ScAptApplDODesc.CLASS_FULLNAME);
	}
	
	/**
	}/**
	 * 生成编码
	 * @param doDescFullName 实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private static String createCode(String doDescFullName) throws BizException{
		IBillcodeManage  codeManage=ServiceFinder.find(IBillcodeManage.class);
		String code =codeManage.getBillCode_RequiresNew(doDescFullName,new PatiVisitDO());
		return code;
	}
}
