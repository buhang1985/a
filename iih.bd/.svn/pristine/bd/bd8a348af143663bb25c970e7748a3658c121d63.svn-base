package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
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
public class DelIncCaItmRelBp {

	public void exec(MedSrvDO[] medSrvArray) throws BizException {
		MedSrvDO[] drugSrvArray = GetDrugSrvArray(medSrvArray);
		if (drugSrvArray == null || drugSrvArray.length <= 0) {
			return;
		}

		deleteOpIncCaItmRel(drugSrvArray);
		deleteIpIncCaItmRel(drugSrvArray);
	}

	/**
	 * 删除门诊账单对照
	 * 
	 * @param drugSrvArray
	 * @throws BizException
	 */
	private void deleteOpIncCaItmRel(MedSrvDO[] drugSrvArray) throws BizException {
		String[] srvIdArray = getOpSrvIdArray(drugSrvArray);
		if (srvIdArray == null || srvIdArray.length <= 0) {
			return;
		}

		String wherePart = getDelOpWherePart(srvIdArray);
		this.deleteIncCaItemRel(wherePart);
	}

	/**
	 * 删除住院账单对照
	 * 
	 * @param drugSrvArray
	 * @throws BizException
	 */
	private void deleteIpIncCaItmRel(MedSrvDO[] drugSrvArray) throws BizException {
		String[] srvIdArray = getIpSrvIdArray(drugSrvArray);
		if (srvIdArray == null || srvIdArray.length <= 0) {
			return;
		}

		String wherePart = getDelIpWherePart(srvIdArray);
		this.deleteIncCaItemRel(wherePart);
	}

	/**
	 * 获取门诊医疗服务主键集合
	 * 
	 * @param drugSrvArray
	 * @return
	 */
	private String[] getOpSrvIdArray(MedSrvDO[] drugSrvArray) {
		if (drugSrvArray == null || drugSrvArray.length <= 0) {
			return null;
		}
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (MedSrvDO medSrvDO : drugSrvArray) {
			if (medSrvDO != null && StringUtils.isNotBlank(medSrvDO.getId_srv())
					&& StringUtils.isNotBlank(medSrvDO.getIncca_op())) {
				srvIdList.add(medSrvDO.getId_srv());
			}
		}
		return srvIdList.toArray(new String[0]);
	}

	/**
	 * 获取住院医疗服务主键集合
	 * 
	 * @param drugSrvArray
	 * @return
	 */
	private String[] getIpSrvIdArray(MedSrvDO[] drugSrvArray) {
		if (drugSrvArray == null || drugSrvArray.length <= 0) {
			return null;
		}
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (MedSrvDO medSrvDO : drugSrvArray) {
			if (medSrvDO != null && StringUtils.isNotBlank(medSrvDO.getId_srv())
					&& StringUtils.isNotBlank(medSrvDO.getIncca_ip())) {
				srvIdList.add(medSrvDO.getId_srv());
			}
		}
		return srvIdList.toArray(new String[0]);
	}

	/**
	 * 获取删除门诊条件语句
	 * 
	 * @param srvIdArray
	 * @return
	 */
	private String getDelOpWherePart(String[] srvIdArray) {
		StringBuilder wherePartBuilder = new StringBuilder("");

		String wherePart = String.format("id_incca = '%s'", IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
		wherePartBuilder.append(wherePart);

		wherePart = getDelWherePartBySrvIds(srvIdArray);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 获取删除住院条件语句
	 * 
	 * @param srvIdArray
	 * @return
	 */
	private String getDelIpWherePart(String[] srvIdArray) {
		StringBuilder wherePartBuilder = new StringBuilder("");

		String wherePart = String.format("id_incca = '%s'", IBdPpCodeTypeConst.ID_INHOS_INVOICE);
		wherePartBuilder.append(wherePart);

		wherePart = getDelWherePartBySrvIds(srvIdArray);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 获取过滤条件
	 * 
	 * @param srvIdArray
	 */
	private String getDelWherePartBySrvIds(String[] srvIdArray) {
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
	 * 根据条件语句删除账单对照
	 * 
	 * @param wherePart
	 * @throws BizException
	 */
	private void deleteIncCaItemRel(String wherePart) throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(IncCaItmRelDO.class, wherePart);
	}
}
