package iih.mi.itf2.service.bp.bdservice.mi;

import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.misavedircontrast.d.MiSaveDirContrastInParam;
import iih.mi.itf2.dto.misavedircontrast.d.MiSaveDirContrastOutParam;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiResultUtil;
import xap.mw.core.data.BizException;

public class MiSaveDirContrastBP {
	
	public MiResultOutParam<MiSaveDirContrastOutParam> exec(MiContext miContext,MiSaveDirContrastInParam inparam) throws BizException{
		MiFacade facade = new MiFacade(miContext);
		MiResultOutParam<MiSaveDirContrastOutParam> outParam = facade.miSaveDirContrast(inparam);
		MiResultUtil.check(outParam);
		return outParam;
	}
}
