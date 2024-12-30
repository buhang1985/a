package iih.sc.apt.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 验证患者在一个排班有没有预约
 * @author ccj
 *
 */
public class ValPatSchHaveAptBp {
	
	/**
	 * 验证患者在一个排班有没有预约
	 * @param id_pat  患者id
	 * @param id_sch	排班id
	 * @return   True 有  false 没有
	 * @throws BizException
	 */
	public void exec(String id_pat,String id_sch) throws BizException{
		if(StringUtil.isEmpty(id_pat) || StringUtil.isEmpty(id_sch)) throw new BizException(StringUtil.isEmpty(id_pat) ? IScMsgConst.SC_APT_SELECT_PAT : IScMsgConst.SC_SCH_ISNULl );
		IScaptMDORService mdorService = ServiceFinder.find(IScaptMDORService.class);
		StringBuffer sb = new StringBuffer(ScAptDODesc.TABLE_ALIAS_NAME);
		sb.append(".sd_sctp = '");
		sb.append(IScDictCodeConst.SD_SCTP_OP);
		sb.append("' and ");
		sb.append(ScAptDODesc.TABLE_ALIAS_NAME);
		sb.append(".id_sch = '");
		sb.append(id_sch);
		sb.append("' and ");
		sb.append(ScAptDODesc.TABLE_ALIAS_NAME);
		sb.append(".fg_canc = 'N' and ");
		sb.append(ScAptDODesc.TABLE_ALIAS_NAME);
		sb.append(".id_pat = '");
		sb.append(id_pat);
		sb.append("'");
		ScAptDO[] aptDOs = mdorService.find(sb.toString(), "", FBoolean.TRUE);
		if(ArrayUtils.isNotEmpty(aptDOs)) throw new BizException(IScMsgConst.SC_APT_HAVE_APT);
	}
}
