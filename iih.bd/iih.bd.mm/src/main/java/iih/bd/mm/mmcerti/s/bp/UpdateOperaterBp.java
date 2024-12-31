package iih.bd.mm.mmcerti.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.MeterialMDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 更新业务逻辑
 * 
 * @author chma 20190312
 *
 */
public class UpdateOperaterBp {

	public FBoolean exec(String id_mm, String cfno) throws BizException {
		//通过id_mm 获取耗材基本信息
		MeterialMDOCrudServiceImpl mmsvr = new MeterialMDOCrudServiceImpl();
		MeterialDO mmdo = mmsvr.findById(id_mm);
		mmdo.setApprno(cfno);
		mmsvr.update(mmdo);
		return FBoolean.TRUE;
	}
}
