package iih.ci.preop.ems.treat;

import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.sdk.driver.BaseEmsDriver;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊预住院治疗申请业务处理驱动
 * 
 * @author wangqingzhu
 *
 */
public class EmsTreatDriver extends BaseEmsDriver {

	public EmsTreatDriver() {
		this.setEmsAction(new EmsTreatAction());
	}

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		// TODO Auto-generated method stub
		EmsRstDTO rstInfo = super.create(ctx, arg);

		// 装配驱动信息
		EmsDriverInfo driverInfo = new EmsDriverInfo();
		driverInfo.setId_ems("@@@@");
		driverInfo.setDll("iih.ci.preop.dll");
		driverInfo.setEmsFrontDriver("iih.ci.preop.ems.treat.EmsTreatDriver");
		driverInfo.setJar("iih.ci.preop.jar");
		driverInfo.setEmsBackendDriver("iih.ci.preop.ems.treat.EmsTreatDriver");
		driverInfo.setFg_quickwflow(FBoolean.TRUE);
		driverInfo.setEu_execmode(-1);
		rstInfo.setDriverInfo(driverInfo);

		return rstInfo;
	}

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		// TODO Auto-generated method stub
		EmsRstDTO rstInfo = super.load(ctx, arg);

		if(!ObjectUtils.isEmpty(rstInfo)) {
			// 装配驱动信息
			EmsDriverInfo driverInfo = new EmsDriverInfo();
			driverInfo.setId_ems("@@@@");
			driverInfo.setDll("iih.ci.preop.dll");
			driverInfo.setEmsFrontDriver("iih.ci.preop.ems.treat.EmsTreatDriver");
			driverInfo.setJar("iih.ci.preop.jar");
			driverInfo.setEmsBackendDriver("iih.ci.preop.ems.treat.EmsTreatDriver");
			driverInfo.setFg_quickwflow(FBoolean.TRUE);
			driverInfo.setEu_execmode(-1);
			rstInfo.setDriverInfo(driverInfo);
		}
		

		return rstInfo;
	}

	@Override
	public EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException {
		// TODO Auto-generated method stub
		EmsRstDTO rstInfo = super.save(ctx, arg);

		// 装配驱动信息
		EmsDriverInfo driverInfo = new EmsDriverInfo();
		driverInfo.setId_ems("@@@@");
		driverInfo.setDll("iih.ci.preop.dll");
		driverInfo.setEmsFrontDriver("iih.ci.preop.ems.treat.EmsTreatDriver");
		driverInfo.setJar("iih.ci.preop.jar");
		driverInfo.setEmsBackendDriver("iih.ci.preop.ems.treat.EmsTreatDriver");
		driverInfo.setFg_quickwflow(FBoolean.TRUE);
		driverInfo.setEu_execmode(-1);
		rstInfo.setDriverInfo(driverInfo);

		return rstInfo;
	}

}
