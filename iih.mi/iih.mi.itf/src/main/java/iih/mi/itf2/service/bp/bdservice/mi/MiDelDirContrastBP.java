package iih.mi.itf2.service.bp.bdservice.mi;

import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.mideldircontrast.d.MiDelDirContrastInParam;
import iih.mi.itf2.dto.mideldircontrast.d.MiDelDirContrastOutParam;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiResultUtil;
import xap.mw.core.data.BizException;

public class MiDelDirContrastBP {
	public MiResultOutParam<MiDelDirContrastOutParam> exec(MiContext miContext, MiDelDirContrastInParam param)
			throws BizException {
		MiFacade facade = new MiFacade(miContext);
		MiResultOutParam<MiDelDirContrastOutParam> outParam = facade.miDelDirContrast(param);
		MiResultUtil.check(outParam);
		return outParam;
	}
}
