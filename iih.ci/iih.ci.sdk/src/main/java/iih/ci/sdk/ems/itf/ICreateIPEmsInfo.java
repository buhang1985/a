package iih.ci.sdk.ems.itf;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ems.d.CiEnContextDTO;

public interface ICreateIPEmsInfo {

	public abstract EmsHeadDO CreateIPEmsInfo(CiEnContextDTO contextdto, String sd_srvtp ,String id_srv, String id_mm)throws BizException;
}
