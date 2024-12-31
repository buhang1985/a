package iih.mi.inst.factory.beijingcity;

import iih.mi.inst.bizgrp.beijingcity.BJHpInnerServiceImpl;
import iih.mi.inst.bizgrp.beijingcity.BJIpChargeImpl;
import iih.mi.inst.bizgrp.beijingcity.BJIpRegisterImpl;
import iih.mi.inst.bizgrp.beijingcity.BJLogInOutImpl;
import iih.mi.inst.bizgrp.beijingcity.BJOepChargeImpl;
import iih.mi.inst.bizgrp.beijingcity.BJOepRegImpl;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.LogInOutItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.OepRegItf;
import iih.mi.itf.factory.InsureInstanceFactory;

public class BJInsureFactory implements InsureInstanceFactory {

	@Override
	public HpSettingItf createHpSettingServiceInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogInOutItf createLogInOutInstance() {
		return new BJLogInOutImpl();
	}

	@Override
	public OepRegItf createOepRegInstance() {
		return new BJOepRegImpl();
	}

	@Override
	public IpRegisterItf createIpRegisterInstance() {
		return new BJIpRegisterImpl();
	}

	@Override
	public OepChargeItf createOepChargeInstance() {
		return new BJOepChargeImpl();
	}

	@Override
	public IpChargeItf createIpChargeInstance() {
		return new BJIpChargeImpl();
	}

	@Override
	public HpInnerService createHpInnerServiceInstance() {
		return new BJHpInnerServiceImpl();
	}


}
