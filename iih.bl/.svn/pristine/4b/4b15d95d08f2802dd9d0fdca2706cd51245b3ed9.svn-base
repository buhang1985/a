package iih.bl.pay.s.ep;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.blspclpat.d.desc.BlSpclPatDODesc;
import iih.bl.pay.blspclpat.i.IBlspclpatCudService;
import iih.bl.pay.blspclpat.i.IBlspclpatRService;

/**
 * 患者专用款EP
 * @author ly 2018/05/19
 *
 */
public class PatSpclEP {

	/**
	 * 保存
	 * @param dos
	 * @return
	 * @throws Bizexception
	 */
	public BlspclpatAggDO[] save(BlspclpatAggDO[] dos) throws BizException{
		IBlspclpatCudService service = ServiceFinder.find(IBlspclpatCudService.class);
		BlspclpatAggDO[] newDos = service.save(dos);
		return newDos;
	}
	
	/**
	 * 根据专用款来源查询专用款
	 * @param srcId
	 * @return
	 * @throws BizException
	 */
	public BlspclpatAggDO findBySrcId(String srcId) throws BizException {
		IBlspclpatRService service = ServiceFinder.find(IBlspclpatRService.class);
		String whereSql = BlSpclPatDODesc.TABLE_ALIAS_NAME + "." + BlSpclPatDO.ID_SRC + " = '%s'";
		whereSql = String.format(whereSql, srcId);

		BlspclpatAggDO[] dos = service.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(dos))
			return null;

		// 暂时卡来源只有一条数据
		return dos[0];
	}
}
