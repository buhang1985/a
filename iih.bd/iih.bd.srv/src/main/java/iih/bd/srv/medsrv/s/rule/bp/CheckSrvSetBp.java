package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 检查服务套业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckSrvSetBp {

	public void exec(MedsrvAggDO[] medSrvAggArr) throws BizException {
		if (medSrvAggArr == null || medSrvAggArr.length <= 0) {
			return;
		}

		CheckSrvSet(medSrvAggArr);
	}

	/**
	 * 检查医疗服务列表中服务套信息
	 * 
	 * @param medSrvAggArr
	 * @throws BizException
	 */
	private void CheckSrvSet(MedsrvAggDO[] medSrvAggArr) throws BizException {
		for (MedsrvAggDO medsrvAggDO : medSrvAggArr) {
			MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
			if (medSrvDO.getFg_set() != null && medSrvDO.getFg_set().equals(FBoolean.TRUE)) {
				CheckSrvSet(medsrvAggDO);
			}
		}
	}

	/**
	 * 检查医疗服务中服务套信息
	 * 
	 * @param medsrvAggDO
	 * @throws BizException
	 */
	private void CheckSrvSet(MedsrvAggDO medsrvAggDO) throws BizException {
		CheckSetOrd(medsrvAggDO);
		CheckSrvSetItem(medsrvAggDO);
	}

	/**
	 * 检查医疗服务中服务套项
	 * 
	 * @param medsrvAggDO
	 * @throws BizException
	 */
	private void CheckSrvSetItem(MedsrvAggDO medsrvAggDO) throws BizException {
		CheckSrvSetItemSdSrvTp(medsrvAggDO);
	}

	/**
	 * 检查医疗服务中服务套项的医疗服务类型
	 * 
	 * @param medsrvAggDO
	 * @throws BizException
	 */
	private void CheckSrvSetItemSdSrvTp(MedsrvAggDO medsrvAggDO) throws BizException {
		MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
		String sdSrvTp = medSrvDO.getSd_srvtp();
		String owerSdSrvTp = GetOwerSdSrvTp(sdSrvTp);
		if (StringUtils.isNotEmpty(owerSdSrvTp)
				&& (owerSdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)
						|| owerSdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)
						|| owerSdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
						|| owerSdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS))) {
			// 只对检查、检验、备血服务套进行服务类型的校验
			String[] setItemSrvIds = GetSetItemSrvIds(medsrvAggDO);
			CheckSrvSetItemSdSrvTp(medSrvDO, setItemSrvIds);
		}
	}

	/**
	 * 检查医疗服务中服务套项的医疗服务类型
	 * 
	 * @param medSrvDO
	 * @param setItemSrvIds
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void CheckSrvSetItemSdSrvTp(MedSrvDO medSrvDO, String[] setItemSrvIds) throws BizException {
		if (setItemSrvIds == null || setItemSrvIds.length <= 0) {
			return;
		}
		String sdSrvTp = medSrvDO.getSd_srvtp();
		String owerSdSrvTp = GetOwerSdSrvTp(sdSrvTp);
		String wherePart = GetWherePart(owerSdSrvTp, setItemSrvIds);
		DAFacade daFacade = new DAFacade();
		Collection collection = daFacade.findByCond(MedSrvDO.class, wherePart);
		MedSrvDO[] result = collection == null ? null : (MedSrvDO[]) collection.toArray(new MedSrvDO[0]);
		if (result != null && result.length > 0) {
			ThrowSetItemErrorException(owerSdSrvTp, medSrvDO, result[0]);
		}
	}

	/**
	 * 抛出服务套内项目错误异常
	 * 
	 * @param owerSdSrvTp
	 * @param medSrvDO
	 * @param setItem
	 * @throws BizException
	 */
	private void ThrowSetItemErrorException(String owerSdSrvTp, MedSrvDO medSrvDO, MedSrvDO setItem)
			throws BizException {
		String srvTpName = GetSrvTpName(owerSdSrvTp);
		String msg = String.format("服务套\"%s\"内项目\"%s\"服务类型不属于\"%s\",不允许添加为该服务套的临床套内临床项目。", medSrvDO.getName(),
				setItem.getName(), srvTpName);
		throw new BizException(msg);
	}

	/**
	 * 获取服务类型名称
	 * 
	 * @param sdSrvTp
	 * @return
	 * @throws BizException
	 */
	private String GetSrvTpName(String sdSrvTp) throws BizException {
		UdidocDO result = UdidocUtils.getUdidocByCode(IBdSrvDictCodeTypeConst.SD_SRVTP, sdSrvTp);
		return result.getName();
	}

	/**
	 * 构建条件语句
	 * 
	 * @param sdSrvTp
	 * @param setItemSrvIds
	 * @return
	 */
	private String GetWherePart(String sdSrvTp, String[] setItemSrvIds) {
		sdSrvTp = GetOwerSdSrvTp(sdSrvTp);

		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("sd_srvtp not like '%s%%'", sdSrvTp);
		wherePartBuilder.append(wherePart);

		wherePart = SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, setItemSrvIds);
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		return wherePartBuilder.toString();
	}

	/**
	 * 获取所属服务类型
	 * 
	 * @param sdSrvTp
	 * @return
	 */
	private String GetOwerSdSrvTp(String sdSrvTp) {
		if (sdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
			// 140101 备血
			return IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE;
		} else if (sdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
			// 0207 病理
			return IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI;
		} else if (sdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
			// 02 检查
			return IBdSrvDictCodeConst.SD_SRVTP_RIS;
		} else if (sdSrvTp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
			// 03 检验
			return IBdSrvDictCodeConst.SD_SRVTP_LIS;
		}
		return null;
	}

	/**
	 * 获取临床标识为true的套内服务项目主键集合
	 * 
	 * @param medsrvAggDO
	 * @return
	 */
	private String[] GetSetItemSrvIds(MedsrvAggDO medsrvAggDO) {
		ArrayList<String> SetItemSrvIdList = new ArrayList<String>();

		MedSrvSetItemDO[] setItems = medsrvAggDO.getMedSrvSetItemDO();
		if (setItems == null || setItems.length <= 0) {
			return SetItemSrvIdList.toArray(new String[0]);
		}
		for (MedSrvSetItemDO medSrvSetItemDO : setItems) {
			if (medSrvSetItemDO != null && medSrvSetItemDO.getFg_clinical() != null
					&& FBoolean.TRUE.equals(medSrvSetItemDO.getFg_clinical())) {
				// 对临床标识为true的套内项目检查服务类型
				SetItemSrvIdList.add(medSrvSetItemDO.getId_srv_itm());
			}
		}
		return SetItemSrvIdList.toArray(new String[0]);
	}

	/**
	 * 检查服务套
	 * 
	 * @param medsrvAggDO
	 * @throws BizException
	 */
	private void CheckSetOrd(MedsrvAggDO medsrvAggDO) throws BizException {
		MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
		CheckSetOrd(medSrvDO);
	}

	/**
	 * 检查服务套开立方式
	 * 
	 * @param medSrvDO
	 * @return
	 * @return
	 * @throws BizException
	 */
	private void CheckSetOrd(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO != null && StringUtils.isEmpty(medSrvDO.getId_setord())) {
			String msg = String.format("医疗服务\"%s\"是服务套，服务套开立方式不允许为空。", medSrvDO.getName());
			throw new BizException(msg);
		}
	}
}
