package iih.mi.inst.factory.country.ruralcooperinsure;

import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralHpInnerServiceImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralHpSettingImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralIpChargeImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralIpRegisterImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralLogInOutImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralOepChargeImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.RuralOepRegImpl;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.LogInOutItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.OepRegItf;
import iih.mi.itf.factory.InsureInstanceFactory;

public class RuralInsureFactory implements InsureInstanceFactory {

	@Override
	public HpSettingItf createHpSettingServiceInstance() {
		// TODO Auto-generated method stub
		return new RuralHpSettingImpl();
	}

	@Override
	public LogInOutItf createLogInOutInstance() {
		return new RuralLogInOutImpl();
	}

	@Override
	public OepRegItf createOepRegInstance() {
		return new RuralOepRegImpl();
	}

	@Override
	public IpRegisterItf createIpRegisterInstance() {
		return new RuralIpRegisterImpl();
	}

	@Override
	public OepChargeItf createOepChargeInstance() {
		return new RuralOepChargeImpl();
	}

	@Override
	public IpChargeItf createIpChargeInstance() {
		return new RuralIpChargeImpl();
	}
	
	@Override
	public HpInnerService createHpInnerServiceInstance() {
		return new RuralHpInnerServiceImpl();
	}


}

