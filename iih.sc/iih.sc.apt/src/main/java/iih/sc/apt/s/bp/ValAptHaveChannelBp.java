package iih.sc.apt.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 验证预约是否存在对应渠道
 * @author ccj
 *
 */
public class ValAptHaveChannelBp {
	/**
	 * 验证预约是否存在对应渠道
	 * @param sd_scchltp  渠道类型编码
	 * @throws BizException
	 */
	public SchedulechlDO[] exec(String sd_scchltp) throws BizException{
		if(StringUtil.isEmpty(sd_scchltp)) throw new BizException(IScMsgConst.SC_APT_SDSCCHLTP_ISNULL);
		ISchedulechlMDORService rService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] schedulechlDOs = rService.find(SchedulechlDODesc.TABLE_ALIAS_NAME+".sd_scchltp = '"+sd_scchltp+"'", "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(schedulechlDOs)){
			//TODO  ccj这里不存在对应的渠道信息 应该要退出预约页面 要关闭重量级的节点
			if(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ALL.equals(sd_scchltp)){
				throw new BizException(IScMsgConst.SC_APT_HOSPITAL_ALL);
			}else if(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_Triage.equals(sd_scchltp)){
				throw new BizException(IScMsgConst.SC_APT_HOSPITAL_Triage);
			}
		}
		return schedulechlDOs;
	}
}
