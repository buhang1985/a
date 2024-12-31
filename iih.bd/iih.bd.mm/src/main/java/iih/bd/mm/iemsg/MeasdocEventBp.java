package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.MeasdocDTO;
import iih.bd.mm.iemsg.qry.MeasdocEventSql;
import xap.mw.core.data.BizException;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 获取物品包装单位计量单位修改后数据。
 * @author shao_yuan
 *
 */

public class MeasdocEventBp {

	public MeasdocDTO[] setMeasDTO(MeasDocDO[] mealist,String eventtype) throws BizException {		
		
		//获得物品包装单位计量单位数据信息
		MeasdocEventSql sql = new MeasdocEventSql();
		MeasdocDTO[] ors=sql.setByStatu(mealist,eventtype);
		return ors;
	}
}
