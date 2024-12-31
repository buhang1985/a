package iih.mi.inst.factory.sd.linyicity.lanlingcounty;

import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLHpInnerServiceImpl;
import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLHpSettingImpl;
import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLIpChargeImpl;
import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLIpRegisterImpl;
import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLLogInOutImpl;
import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLOepChargeImpl;
import iih.mi.inst.bizgrp.sd.linyicity.lanlingcounty.LLOepRegImpl;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.LogInOutItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.OepRegItf;
import iih.mi.itf.factory.InsureInstanceFactory;

public class LLInsureFactory implements InsureInstanceFactory {

	@Override
	public HpSettingItf createHpSettingServiceInstance() {
		return new LLHpSettingImpl();
	}

	@Override
	public LogInOutItf createLogInOutInstance() {
		return new LLLogInOutImpl();
	}

	@Override
	public OepRegItf createOepRegInstance() {
		return new LLOepRegImpl();
	}

	@Override
	public IpRegisterItf createIpRegisterInstance() {
		return new LLIpRegisterImpl();
	}

	@Override
	public OepChargeItf createOepChargeInstance() {
		return new LLOepChargeImpl();
	}

	@Override
	public IpChargeItf createIpChargeInstance() {
		return new LLIpChargeImpl();
	}

	@Override
	public HpInnerService createHpInnerServiceInstance() {
		return new LLHpInnerServiceImpl();
	}

}
