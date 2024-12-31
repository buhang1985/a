package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除医疗服务前删除票据分类项目对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DelIncCaItmRelBeforeDelMedSrvMDOBp {

	public void exec(MedSrvDO[] medSrvArray) throws BizException {
		MedSrvDO[] drugSrvArray = GetDrugSrvArray(medSrvArray);
		String[] srvIdArray = GetSrvIdArray(drugSrvArray);
		if (srvIdArray == null || srvIdArray.length <= 0) {
			return;
		}
		String wherePart = GetWherePart(srvIdArray);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(IncCaItmRelDO.class, wherePart);
	}

	/**
	 * 获取过滤条件
	 * 
	 * @param srvIdArray
	 */
	private String GetWherePart(String[] srvIdArray) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");

		String BDModeSql = BdEnvContextUtil.processEnvContext(new IncCaItmRelDO(), false);
		if (BDModeSql != null && !BDModeSql.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(BDModeSql);
		}

		String wherePart = SqlUtils.getInSqlByIds(IncCaItmRelDO.ID_SRV, srvIdArray);
		if (wherePart != null && !wherePart.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 从医疗服务列表中获取药品服务列表
	 * 
	 * @param medSrvArray
	 * @return
	 */
	private MedSrvDO[] GetDrugSrvArray(MedSrvDO[] medSrvArray) {
		ArrayList<MedSrvDO> drugSrvList = new ArrayList<MedSrvDO>();
		for (MedSrvDO medSrvDO : medSrvArray) {
			if (medSrvDO != null && medSrvDO.getSd_srvtp() != null
					&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				drugSrvList.add(medSrvDO);
			}
		}
		return drugSrvList.toArray(new MedSrvDO[0]);
	}

	/**
	 * 获取服务Id数组
	 * 
	 * @param drugSrvArray
	 * @return
	 */
	private String[] GetSrvIdArray(MedSrvDO[] drugSrvArray) {
		if (drugSrvArray == null || drugSrvArray.length <= 0) {
			return null;
		}
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (MedSrvDO medSrvDO : drugSrvArray) {
			if (medSrvDO != null && StringUtils.isNotBlank(medSrvDO.getId_srv())) {
				srvIdList.add(medSrvDO.getId_srv());
			}
		}
		return srvIdList.toArray(new String[0]);
	}
}
