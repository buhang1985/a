package iih.mi.bd.s;

import iih.mi.bd.i.IMIBdudidocCudService;
import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.s.bp.SaveMIudidocCompBP;
import iih.mi.bd.s.bp.SaveMiUdidocBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医保档案相关维护服务
 * 
 * @author wq.li
 *
 */
@Service(serviceInterfaces = { IMIBdudidocCudService.class }, binding = Binding.JSONRPC)
public class IMIBdudidocCudServiceImpl implements IMIBdudidocCudService {
	/**
	 * 维护该医保计划下的档案类型
	 * @param hpId
	 * @param udidocArr
	 * @throws BizException
	 */
	@Override
	public void saveMiUdidoc(String hpId, MiUdidoclistDO[] udidocArr) throws BizException {
		SaveMiUdidocBP bp=new SaveMiUdidocBP();
		bp.exec(hpId, udidocArr);

	}
	/**
	 * 保存医保档案对照信息
	 * 
	 * @param compArr
	 * @throws BizException
	 */
	@Override
	public MiUdidocCompDO[] saveMIudidocComp(MiUdidocCompDO[] compArr) throws BizException {
		SaveMIudidocCompBP bp=new SaveMIudidocCompBP();
		return bp.exec(compArr);
		
	}
}
