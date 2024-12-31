package iih.mi.itf2.service.bp.bdservice.mi;

import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveInParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveOutParam;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiResultUtil;
import xap.mw.core.data.BizException;

/**
 * 保存医保目录
 * @author ly 2019/05/29
 *
 */
public class SaveMiDirBP {

	/**
	 * 保存医保目录
	 * @param miContext
	 * @param param
	 * @throws BizException
	 */
	public MiDirSaveOutParam exec(MiContext miContext, MiDirSaveInParam param) throws BizException{
		MiFacade facade = new MiFacade(miContext);
		MiResultOutParam<MiDirSaveOutParam> rlt = facade.saveMiDir(param);
		MiResultUtil.check(rlt);
		return rlt.getData();
	}
}
