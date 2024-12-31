package iih.bd.fc.s.bp;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.mdwfor.d.desc.MdWfOrDODesc;
import iih.bd.fc.pub.BdFcAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 根据就诊类型获得医嘱流向开立参数数据操作BP
 */
public class GetOrWfParaDO8EntpBP {
	/**
	 * 根据就诊类型获得医嘱流向开立参数数据
	 * @param param
	 * @param sd_wftp
	 * @return
	 * @throws BizException
	 */
	public  MdWfOrDO[] exec(String code_entp,String sd_srvtp,String sd_wftp)  throws BizException{
		String id_entp=BdFcAppUtils.getEntpId(code_entp);
		if(id_entp == null || sd_srvtp == null) return null;
		//String whereStr=MdWfOrDODesc.TABLE_ALIAS_NAME+".id_entp='"+id_entp+"' and " +MdWfOrDODesc.TABLE_ALIAS_NAME+".sd_srvtp like'"+sd_srvtp+"%'";
		String whereStr=MdWfOrDODesc.TABLE_ALIAS_NAME+".id_entp='"+id_entp+"'";
		return BdFcAppUtils.getMdwforQryService().find(whereStr, "id_wf,sortno", FBoolean.FALSE);
	}
}
