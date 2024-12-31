package iih.ci.ord.s.bp.validate.skintest;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

public interface ISaveSkinBP {
	CiOrderDO[] saveOrder(CiEmsDTO skinems,CiEnContextDTO ciEnContextDTO) throws BizException ;
}
