package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.scapt.d.AptExChlDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取预约信息
 * 
 * @author liubin
 *
 */
public class GetAptInfoBP {
	/**
	 * 通过预约码获取预约Id
	 * 
	 * @param aptCode  预约编码
	 * @return
	 * @throws BizException
	 */
	public String getAptIdByAptCode(String aptCode) throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetAptInfoBP参数为:aptCode:"+aptCode);
		if(EnValidator.isEmpty(aptCode))
			return null;
		List<AptExChlDO> list = (List<AptExChlDO>) new DAFacade().findByAttrValString(AptExChlDO.class, AptExChlDO.CODE_APT, aptCode, 
				new String[]{AptExChlDO.ID_APTEXCHL, AptExChlDO.ID_APT, AptExChlDO.CODE_APT});
		if(!EnValidator.isEmpty(list))
			return list.get(0).getId_apt();
		return null;
	}
}
