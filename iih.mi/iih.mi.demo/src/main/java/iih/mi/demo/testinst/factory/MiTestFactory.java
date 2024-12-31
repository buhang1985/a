package iih.mi.demo.testinst.factory;

import iih.mi.demo.testinst.bizgrp.MiTestOepChargeImpl;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.LogInOutItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.OepRegItf;
import iih.mi.itf.factory.InsureInstanceFactory;

public class MiTestFactory implements InsureInstanceFactory {

	@Override
	public LogInOutItf createLogInOutInstance() {
		return null;
	}

	@Override
	public OepRegItf createOepRegInstance() {
		return null;
	}

	@Override
	public IpRegisterItf createIpRegisterInstance() {
		return null;
	}

	@Override
	public OepChargeItf createOepChargeInstance() {
		MiTestOepChargeImpl impl = new MiTestOepChargeImpl();
		return impl;
	}

	@Override
	public IpChargeItf createIpChargeInstance() {
		return null;
	}

	@Override
	public HpInnerService createHpInnerServiceInstance() {
		return null;
	}

	@Override
	public HpSettingItf createHpSettingServiceInstance() {
		return null;
	}
}
