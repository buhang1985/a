package iih.bd.fc.s.bp;

import iih.bd.fc.mdwfconfig.d.MdWfDO;
import iih.bd.fc.mdwfconfig.d.desc.MdWfDODesc;
import iih.bd.fc.pub.BdFcAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 根据医嘱流向类型获得对应医嘱流向集合数据操作BP
 */
public class GetMdWf8SdWfTpBP {
	/**
	 * 根据医嘱流向类型获得对应医嘱流向集合数据
	 * @param sd_wftp
	 * @return
	 * @throws BizException
	 */
	public  MdWfDO[] exec(String sd_wftp)  throws BizException{
		String whereStr=MdWfDODesc.TABLE_ALIAS_NAME+".sd_wftp='"+sd_wftp+"'";
		return BdFcAppUtils.getMdWfQryService().find(whereStr, "", FBoolean.FALSE);
	}
}
