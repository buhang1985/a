package iih.mi.demo.testinst.bizgrp;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.inst.bizbase.OepChargeBaseImpl;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class MiTestOepChargeImpl  extends OepChargeBaseImpl implements OepChargeItf{

	@Override
	public FArrayList savePayPropDataOep(OepSettleRtnValDTO hpPayRtnValDto, HisPropertyRefHpDTO hisPropertyDTO)
			throws BizException {
		return null;
	}
	
	@Override
	public FArrayList getHpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException {
		return null;
	}
	
	public FArrayList saveBackPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		return null;
	}
}
