package iih.mi.inst.factory.tonglingcity;

import iih.mi.inst.bizgrp.tonglingcity.TLHpInnerServiceImpl;
import iih.mi.inst.bizgrp.tonglingcity.TLIpChargeImpl;
import iih.mi.inst.bizgrp.tonglingcity.TLIpRegisterImpl;
import iih.mi.inst.bizgrp.tonglingcity.TLLogInOutImpl;
import iih.mi.inst.bizgrp.tonglingcity.TLOepChargeImpl;
import iih.mi.inst.bizgrp.tonglingcity.TLOepRegImpl;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.LogInOutItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.OepRegItf;
import iih.mi.itf.factory.InsureInstanceFactory;

public class TLInsureFactory implements InsureInstanceFactory {

	@Override
	public HpSettingItf createHpSettingServiceInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogInOutItf createLogInOutInstance() {
		return new TLLogInOutImpl();
	}

	@Override
	public OepRegItf createOepRegInstance() {
		return new TLOepRegImpl();
	}

	@Override
	public IpRegisterItf createIpRegisterInstance() {
		return new TLIpRegisterImpl();
	}

	@Override
	public OepChargeItf createOepChargeInstance() {
		return new TLOepChargeImpl();
	}

	@Override
	public IpChargeItf createIpChargeInstance() {
		return new TLIpChargeImpl();
	}
	
	@Override
	public HpInnerService createHpInnerServiceInstance() {
		return new TLHpInnerServiceImpl();
	}


}
