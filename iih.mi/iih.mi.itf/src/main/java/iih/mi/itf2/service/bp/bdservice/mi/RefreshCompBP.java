package iih.mi.itf2.service.bp.bdservice.mi;

import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.refreshcomp.d.MiDirRefreshCompInParam;
import iih.mi.itf2.dto.refreshcomp.d.MiDirRefreshCompOutParam;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiResultUtil;
import xap.mw.core.data.BizException;

/**
 * 医保目录刷新对照
 * Title: RefreshCompBP.java
 * @author zhang.hw
 * @date 2019年6月2日  
 * @version 1.0
 */
public class RefreshCompBP {
	public MiResultOutParam<MiDirRefreshCompOutParam> exec(MiContext miContext, MiDirRefreshCompInParam inParam) throws BizException{
		MiFacade facade = new MiFacade(miContext);
		MiResultOutParam<MiDirRefreshCompOutParam> rlt = facade.refreshCompMiDir(inParam);
		MiResultUtil.check(rlt);
		return rlt;
	}
}
