package iih.bd.pp.com.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * @author yangyang
 *获取基础档案接口集合
 */
public class UdidocHelperBp {

	
	/**
	 * @param id_udidoclist 通过基础档案记录集主键查找基础档案
	 * @return
	 */
	public UdidocDO[] getUdidocByIdlist(String id_udidoclist) throws BizException
	{
		StringBuffer sql=new StringBuffer();
		//TODO 杨扬 这里需要添加id_org,以及id_grp
		sql.append("id_udidoclist='").append(id_udidoclist).append("'");
		IUdidocRService service=ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidocDoArr=service.find(sql.toString(), null, FBoolean.FALSE);
		return udidocDoArr;
	}
}
