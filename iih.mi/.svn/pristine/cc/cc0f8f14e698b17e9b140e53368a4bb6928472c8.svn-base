package iih.mi.itf2.service.bp.bdservice.mi;

import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.midirautocomp.d.MiDirAutoCompInParam;
import iih.mi.itf2.dto.midirautocomp.d.MiDirAutoCompOutParam;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiResultUtil;
import xap.mw.core.data.BizException;

/**
 * 医保目录自动对照
 * Title: AutoCompMiDirBP.java
 * @author zhang.hw
 * @date 2019年6月2日  
 * @version 1.0
 */
public class AutoCompMiDirBP {
	
	public MiResultOutParam<MiDirAutoCompOutParam> exec(MiContext miContext, MiDirAutoCompInParam inParam) throws BizException{
		MiFacade facade = new MiFacade(miContext);
		MiResultOutParam<MiDirAutoCompOutParam> rlt = facade.autoCompMiDir(inParam);
		MiResultUtil.check(rlt);
		return rlt;
	}
}
