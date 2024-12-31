package iih.mi.bd.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.s.bp.sql.FindDrugDirCompByHisDrugIdsSql;
import iih.mi.bd.s.bp.sql.FindSrvDirCompByHisSevIdsSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据诊疗项目主键和药品主键查询三大目录对照
 * 
 * @author hao_wu 2018-7-29
 *
 */
public class FindThreeDirCompByHisSrvIdsAndDrugIdsBp {

	/**
	 * 执行查询逻辑
	 * 
	 * @param hpId
	 * @param hisMedSrvIds
	 * @param hisDrugIds
	 * @return ThreeDirCompInfoDTO[]
	 * @throws BizException
	 */
	public ThreeDirCompInfoDTO[] exec(String hpId, String[] hisMedSrvIds, String[] hisDrugIds) throws BizException {

		String idRef = getIdRef(hpId);

		if (StringUtils.isNotEmpty(idRef)) {
			ThreeDirCompInfoDTO[] result = exec(idRef, hisMedSrvIds, hisDrugIds);
			return result;
		} else {
			String srvWherePart = getSrvWherePart(hisMedSrvIds);
			String drugWherePart = getDrugWherePart(hisDrugIds);
			List<ThreeDirCompInfoDTO> threeDirCompInfoDTOs = new ArrayList<ThreeDirCompInfoDTO>();
			
			List<ThreeDirCompInfoDTO> srvResult = new ArrayList<ThreeDirCompInfoDTO>();
			List<ThreeDirCompInfoDTO> drugResult = new ArrayList<ThreeDirCompInfoDTO>();
			
			if(!ArrayUtil.isEmpty(hisMedSrvIds)){
				srvResult = getSrvResult(hpId, srvWherePart);
			}
			
			if(!ArrayUtil.isEmpty(hisDrugIds)){
				drugResult = getDrugResult(hpId, drugWherePart);
			}
			
			threeDirCompInfoDTOs.addAll(srvResult);
			threeDirCompInfoDTOs.addAll(drugResult);
			return threeDirCompInfoDTOs.toArray(new ThreeDirCompInfoDTO[0]);
		}
	}

	/**
	 * 获取复用医保主键
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);

		return hpdo!=null?hpdo.getId_refhp():"";
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
		
		if(StringUtil.isEmpty(drugWherePart))
			return new ArrayList<ThreeDirCompInfoDTO>();
		
		FindDrugDirCompByHisDrugIdsSql durgSql = new FindDrugDirCompByHisDrugIdsSql(hpId, drugWherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<ThreeDirCompInfoDTO> drugResult = (ArrayList<ThreeDirCompInfoDTO>) daFacade.execQuery(
				durgSql.getQrySQLStr(), durgSql.getQryParameter(null), new BeanListHandler(ThreeDirCompInfoDTO.class));
		return drugResult;
	}

	/**
	 * 获得诊疗项目对照结果集
	 * 
	 * @param hpId
	 * @param srvWherePart
	 * @return List<ThreeDirCompInfoDTO>
	 * @throws DAException
	 */
	private List<ThreeDirCompInfoDTO> getSrvResult(String hpId, String srvWherePart) throws DAException {
		
		if(StringUtil.isEmpty(srvWherePart))
			return new ArrayList<ThreeDirCompInfoDTO>();
		
		FindSrvDirCompByHisSevIdsSql srvSql = new FindSrvDirCompByHisSevIdsSql(hpId, srvWherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<ThreeDirCompInfoDTO> srvResult = (ArrayList<ThreeDirCompInfoDTO>) daFacade.execQuery(
				srvSql.getQrySQLStr(), srvSql.getQryParameter(null), new BeanListHandler(ThreeDirCompInfoDTO.class));
		return srvResult;
	}

	/**
	 * 生成药品wherePart条件
	 * 
	 * @param hisDrugIds
	 * @return String
	 * @throws BizException
	 */
	private String getDrugWherePart(String[] hisDrugIds) throws BizException {
		
		if(ArrayUtil.isEmpty(hisDrugIds)){
			return null;
		}
		
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (hisDrugIds != null && hisDrugIds.length > 0) {
			String wherePart = SqlUtils.getInSqlByBigIds("BD_HP_SRVORCA.ID_MM", hisDrugIds);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 生成服务wherePart条件
	 * 
	 * @param hisMedSrvIds
	 * @return String
	 * @throws BizException
	 */
	private String getSrvWherePart(String[] hisMedSrvIds) throws BizException {
		
		if(ArrayUtil.isEmpty(hisMedSrvIds)){
			return null;
		}
		
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (hisMedSrvIds != null && hisMedSrvIds.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds("BD_HP_SRVORCA.ID_SRV", hisMedSrvIds);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}

}
