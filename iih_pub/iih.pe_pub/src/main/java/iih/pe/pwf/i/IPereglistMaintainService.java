package iih.pe.pwf.i;

import iih.pe.papt.pepsncatsel.d.PePsnapptCatDO;
import xap.mw.core.data.BizException;

public interface IPereglistMaintainService {

	public void peRegister(String Id_pepsnappt, String Id_pediroom, String fg_pay) throws BizException;

	public void peRegisterCancel(String Id_pepsnappt) throws BizException;
	
	            
}
