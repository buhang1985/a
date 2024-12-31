package iih.ci.mrm.i.splitfouraddress;

import iih.bd.srv.mrarea.d.MrAreaDO;
import xap.mw.core.data.BizException;

public interface ICiMrmSplitFourAddressService {

	/**
	 * 获取四级地址byid
	 * @param id_adminarea
	 * @return
	 */
	MrAreaDO[]  getLevelFourAddressById(String id_adminarea) throws BizException;
	

	/**
	 * 获取四级地址bysd
	 * @param id_adminarea
	 * @return
	 */
	MrAreaDO[]  getLevelFourAddressBySd(String code) throws BizException;
}
