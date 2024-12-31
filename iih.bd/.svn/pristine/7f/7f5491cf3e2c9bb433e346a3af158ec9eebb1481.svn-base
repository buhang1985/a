package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.ext.IMedSrvEnableService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 药品基本信息启用后启用通用名逻辑
 * 
 * @author hao_wu
 *
 */
public class EnableMaterialNamesAfterMaterialEnabledBp {

	public void exec(MeterialDO[] meterialDOs) throws BizException {
		if (meterialDOs == null || meterialDOs.length <= 0) {
			return;
		}
		for (MeterialDO meterialDO : meterialDOs) {
			if(meterialDO.getSd_mmtp().substring(0,1).equals(IBdMmDictCodeConst.SD_MMTP_WEISHENG) || meterialDO.getSd_mmtp().substring(0,1).equals(IBdMmDictCodeConst.SD_MMTP_QIXIE))//耗材的没有通用名，不进行处理
				return;
		}
		EnableMaterialNames(meterialDOs);
	}

	/**
	 * 启用通用名
	 * 
	 * @param meterialDOs
	 * @throws BizException
	 */
	private void EnableMaterialNames(MeterialDO[] meterialDOs) throws BizException {
		MeterialDO[] activeMaterials = GetActiveMaterial(meterialDOs);
		if (activeMaterials != null && activeMaterials.length > 0) {
			EnableMaterialNamesByActiveMaterials(activeMaterials);
		}
	}

	/**
	 * 获取启用的药品
	 * 
	 * @param meterialDOs
	 * @return
	 */
	private MeterialDO[] GetActiveMaterial(MeterialDO[] meterialDOs) {
		ArrayList<MeterialDO> activeMaterialList = new ArrayList<MeterialDO>();
		for (MeterialDO meterialDO : meterialDOs) {
			if (FBoolean.TRUE.equals(meterialDO.getFg_active())) {
				activeMaterialList.add(meterialDO);
			}
		}
		return activeMaterialList.toArray(new MeterialDO[0]);
	}

	/**
	 * 根据启用的物品启用药品通用名
	 * 
	 * @param activeMaterials
	 * @throws BizException
	 */
	private void EnableMaterialNamesByActiveMaterials(MeterialDO[] activeMaterials) throws BizException {
		MedSrvDO[] needActiveMaterialNames = GetNeedActiveMaterialNames(activeMaterials);
		EnableMaterialNames(needActiveMaterialNames);
	}

	/**
	 * 获取需要启用的药品通用名
	 * 
	 * @param activeMaterials
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private MedSrvDO[] GetNeedActiveMaterialNames(MeterialDO[] activeMaterials) throws BizException {
		String wherePart = GetWherePart(activeMaterials);
		DAFacade daFacade = new DAFacade();
		Collection result = daFacade.findByCond(MedSrvDO.class, wherePart);
		return result == null ? null : (MedSrvDO[]) result.toArray(new MedSrvDO[0]);
	}

	/**
	 * 获取条件语句
	 * 
	 * @param activeMaterials
	 * @return
	 */
	private String GetWherePart(MeterialDO[] activeMaterials) {
		StringBuilder wherePartBuilder = new StringBuilder("fg_active <> 'Y'");

		String[] srvIds = GetSrvIds(activeMaterials);
		if (srvIds != null && srvIds.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, srvIds);
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 获取医疗服务主键集合
	 * 
	 * @param activeMaterials
	 * @return
	 */
	private String[] GetSrvIds(MeterialDO[] activeMaterials) {
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (MeterialDO meterialDO : activeMaterials) {
			if (meterialDO != null && StringUtils.isNotEmpty(meterialDO.getId_srv())) {
				srvIdList.add(meterialDO.getId_srv());
			}
		}
		return srvIdList.toArray(new String[0]);
	}

	/**
	 * 启用药品通用名
	 * 
	 * @param needActiveMaterialNames
	 * @throws BizException
	 */
	private void EnableMaterialNames(MedSrvDO[] needActiveMaterialNames) throws BizException {
		IMedSrvEnableService medSrvEnableService = ServiceFinder.find(IMedSrvEnableService.class);
		medSrvEnableService.Enable(needActiveMaterialNames);
	}
}
