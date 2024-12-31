package iih.mi.itf.factory;

import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.LogInOutItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.OepRegItf;

//工厂接口
public interface InsureInstanceFactory {
	 public abstract LogInOutItf createLogInOutInstance();
	 public abstract OepRegItf createOepRegInstance();
	// 住院登记相关
	 public abstract IpRegisterItf createIpRegisterInstance();
	 public abstract OepChargeItf createOepChargeInstance();
	 public abstract IpChargeItf createIpChargeInstance();
	 
	 public abstract HpInnerService createHpInnerServiceInstance();
	 //获取医保配置服务项
	 public abstract HpSettingItf createHpSettingServiceInstance();
}



