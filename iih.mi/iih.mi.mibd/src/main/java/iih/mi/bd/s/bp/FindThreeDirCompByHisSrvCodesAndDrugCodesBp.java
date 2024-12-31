package iih.mi.bd.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.s.bp.sql.FindDrugDirCompByHisDrugIdsSql;
import iih.mi.bd.s.bp.sql.FindSrvDirCompByHisSevIdsSql;
import iih.mi.bd.s.bp.sql.FindTreatDirCompByHisSevIdsSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据HIS医疗服务编码集合和药品编码集合查询三大目录对照信息集合业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindThreeDirCompByHisSrvCodesAndDrugCodesBp {

	/**
	 * 执行查询逻辑
	 * 
	 * @param hpId
	 * @param hisMedSrvCodes
	 * @param hisDrugCodes
	 * @return ThreeDirCompInfoDTO[]
	 * @throws BizException
	 */
	public ThreeDirCompInfoDTO[] exec(String hpId, String[] hisMedSrvCodes, String[] hisDrugCodes) throws BizException {

		String idRef = getIdRef(hpId);

		if (StringUtils.isNotEmpty(idRef)) {
			ThreeDirCompInfoDTO[] result = exec(idRef, hisMedSrvCodes, hisDrugCodes);
			return result;
		} else {
			String srvWherePart = getSrvWherePart(hisMedSrvCodes);
			String drugWherePart = getDrugWherePart(hisDrugCodes);
			List<ThreeDirCompInfoDTO> threeDirCompInfoDTOs = new ArrayList<ThreeDirCompInfoDTO>();
			
			List<ThreeDirCompInfoDTO> srvResult = new ArrayList<ThreeDirCompInfoDTO>();
			List<ThreeDirCompInfoDTO> drugResult = new ArrayList<ThreeDirCompInfoDTO>();
			if(!ArrayUtil.isEmpty(hisMedSrvCodes)){
				srvResult = getSrvResult(hpId, srvWherePart);
			}
			
			if(!ArrayUtil.isEmpty(hisDrugCodes)){
				drugResult = getDrugResult(hpId, drugWherePart);
			}
			
			threeDirCompInfoDTOs.addAll(srvResult);
			threeDirCompInfoDTOs.addAll(drugResult);
			return threeDirCompInfoDTOs.toArray(new ThreeDirCompInfoDTO[0]);
		}

	}

	/**
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);

		return hpdo.getId_refhp();
	}

	/**
	 * 获得药品对照结果集
	 * 
	 * @param hpId
	 * @param drugWherePart
	 * @return List<ThreeDirCompInfoDTO>
	 * @throws DAException
	 */
	private List<ThreeDirCompInfoDTO> getDrugResult(String hpId, String drugWherePart) throws DAException {
		FindDrugDirCompByHisDrugIdsSql durgSql = new FindDrugDirCompByHisDrugIdsSql(hpId, drugWherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<ThreeDirCompInfoDTO> drugResult = (ArrayList<ThreeDirCompInfoDTO>) daFacade.execQuery(
				durgSql.getQrySQLStr(), durgSql.getQryParameter(null), new BeanListHandler(ThreeDirCompInfoDTO.class));
		return drugResult;
	}

	/**
	 * 获得服务设施对照结果集
	 * 
	 * @param hpId
	 * @param srvWherePart
	 * @return List<ThreeDirCompInfoDTO>
	 * @throws DAException
	 */
	private List<ThreeDirCompInfoDTO> getSrvResult(String hpId, String srvWherePart) throws DAException {
		FindSrvDirCompByHisSevIdsSql srvSql = new FindSrvDirCompByHisSevIdsSql(hpId, srvWherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<ThreeDirCompInfoDTO> srvResult = (ArrayList<ThreeDirCompInfoDTO>) daFacade.execQuery(
				srvSql.getQrySQLStr(), srvSql.getQryParameter(null), new BeanListHandler(ThreeDirCompInfoDTO.class));
		return srvResult;
	}

	/**
	 * 获得诊疗对照结果集
	 * 
	 * @param hpId
	 * @param srvWherePart
	 * @return List<ThreeDirCompInfoDTO>
	 * @throws BizException
	 */
	private List<ThreeDirCompInfoDTO> getTreatResult(String hpId, String srvWherePart) throws BizException {
		FindTreatDirCompByHisSevIdsSql treatSql = new FindTreatDirCompByHisSevIdsSql(hpId, srvWherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<ThreeDirCompInfoDTO> treatResult = (ArrayList<ThreeDirCompInfoDTO>) daFacade.execQuery(
				treatSql.getQrySQLStr(), treatSql.getQryParameter(null),
				new BeanListHandler(ThreeDirCompInfoDTO.class));
		return treatResult;
	}

	/**
	 * 生成药品wherePart条件
	 * 
	 * @param hisDrugCodes
	 * @return String
	 * @throws BizException
	 */
	private String getDrugWherePart(String[] hisDrugCodes) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (hisDrugCodes != null && hisDrugCodes.length > 0) {
			String wherePart = SqlUtils.getInSqlByBigIds(MeterialDODesc.TABLE_NAME + "." + MeterialDO.CODE,
					hisDrugCodes);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}
		else{
			wherePartBuilder.append(" AND 1=0 ");
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 生成服务wherePart条件
	 * 
	 * @param hisMedSrvCodes
	 * @return String
	 * @throws BizException
	 */
	private String getSrvWherePart(String[] hisMedSrvCodes) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (hisMedSrvCodes != null && hisMedSrvCodes.length > 0) {
			String wherePart = SqlUtils.getInSqlByBigIds(MedSrvDODesc.TABLE_NAME + "." + MedSrvDO.CODE, hisMedSrvCodes);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}
}
