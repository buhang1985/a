package iih.pe.por.i;

import iih.pe.por.pepsnmerge.d.PePsnMergeDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IPePsnMergeMaintainService {

	public void merge(String id_pepsnbinfo_from, String id_pepsnbinfo_to, FDateTime dt_merge, String mergereason) throws BizException;
}
