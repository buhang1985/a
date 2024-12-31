package iih.bd.res.warehouse.s.bp;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.i.IPackageunitRService;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 仓库新增规则
 * 
 * @author dj.zhang
 *
 */
public class WarehouseSaveAfterBp {

	public void exec(WarehouseDO wareHouseDO) throws BizException {

		if (!IBdResDictCodeConst.SD_WHTP_HAOCAI.equals(wareHouseDO.getSd_whtp())) {
			return;
		}
		save(wareHouseDO);
	}

	/**
	 * 保存
	 * 
	 * @param wareHouseDO
	 * @throws BizException
	 * @throws DAException
	 */
	private void save(WarehouseDO wareHouseDO) throws BizException, DAException {
		WahouseUnitTypeDO wahouseUnitTypeDO = adapt(wareHouseDO);
		WahouseUnitTypeDO[] wahouseUnitTypeDOs = new WahouseUnitTypeDO[1];
		wahouseUnitTypeDOs[0] = wahouseUnitTypeDO;
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(wahouseUnitTypeDOs);
	}

	/**
	 * 适配填充数据
	 * 
	 * @param wareHouseDO
	 * @return
	 * @throws BizException
	 */
	private WahouseUnitTypeDO adapt(WarehouseDO wareHouseDO) throws BizException {
		WahouseUnitTypeDO wahouseUnitTypeDO = new WahouseUnitTypeDO();
		adaptIdmmpk(wahouseUnitTypeDO);
		wahouseUnitTypeDO.setId_org(Context.get().getGroupId());
		wahouseUnitTypeDO.setId_grp(Context.get().getGroupId());
		wahouseUnitTypeDO.setId_wh(wareHouseDO.getId_wh());
		wahouseUnitTypeDO.setFg_def(FBoolean.TRUE);
		wahouseUnitTypeDO.setId_operater(Context.get().getStuffId());
		return wahouseUnitTypeDO;
	}

	/**
	 * 设置包装单位id
	 * 
	 * @param wahouseUnitTypeDO
	 * @throws BizException
	 */
	private void adaptIdmmpk(WahouseUnitTypeDO wahouseUnitTypeDO) throws BizException {
		IPackageunitRService packageunitRService = ServiceFinder.find(IPackageunitRService.class);
		PackageUnitDO[] packageUnitDOs = packageunitRService.findByAttrValString("Code",
				IBdMmDictCodeConst.MM_PKGUNIT_TYPE_SELL);
		if (packageUnitDOs != null && packageUnitDOs.length > 0) {
			String id_mmpkgutp = packageUnitDOs[0].getId_mmpkgutp();
			wahouseUnitTypeDO.setId_mmpkgutp(id_mmpkgutp);
		}
	}

}
