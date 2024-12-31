package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.MmUdidocDTO;
import iih.bd.mm.iemsg.qry.MmUdiEventSql;
import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 获取物品类别修改后数据。
 * @author shao_yuan
 *
 */

public class MmUdiEventBp {

	public MmUdidocDTO[] setUdiDTO(UdidocDO[] udilist,String eventtype) throws BizException {		
		
		//获得物品类别数据信息
		MmUdiEventSql sql = new MmUdiEventSql();
		MmUdidocDTO[] ors=sql.setByStatu(udilist,eventtype);
		return ors;
	}

}
