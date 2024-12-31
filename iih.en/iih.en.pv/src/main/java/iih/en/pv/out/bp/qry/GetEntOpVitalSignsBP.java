package iih.en.pv.out.bp.qry;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.d.EntOpVitalSignsDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊预检生命体征信息
 * 
 * @author ltf
 *
 */
public class GetEntOpVitalSignsBP {
	/**
	 * 数据元-生命体征-体重-KG
	 */
	private static String DECODE_WEIGHT_KG = "DE20.00.005.00";
	/**
	 * 数据元-生命体征-体重-G
	 */
	private static String DECODE_WEIGHT_G = "DE20.00.020.00";
	/**
	 * 数据元-生命体征-身高-CM
	 */
	private static String DECODE_HEIGHT_CM = "DE20.00.007.00";
	/**
	 * 获取门诊预检生命体征信息
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	public EntOpVitalSignsDTO[] exec(String[] idEnts)
			throws BizException {
		if (EnValidator.isEmpty(idEnts)) {
			return null;
		}
		//获取身高cm
		EntOpVitalSignsDTO[] entOpVitalHeights = this.getEntOpVitalHeights(idEnts);
		//获取体重kg
		EntOpVitalSignsDTO[] entOpVitalWeights = this.getEntOpVitalWeights(idEnts);
		//集成生命体征信息
		EntOpVitalSignsDTO[] entOpVitalSigns = this.getEntOpVitalSigns(entOpVitalWeights, entOpVitalHeights, idEnts);
		return entOpVitalSigns;
	}
	/**
	 * 集成生命体征信息
	 * @param entOpVitalWeights
	 * @param entOpVitalHeights
	 * @return
	 */
	private EntOpVitalSignsDTO[] getEntOpVitalSigns(EntOpVitalSignsDTO[] entOpVitalWeights,
			EntOpVitalSignsDTO[] entOpVitalHeights, String[] idEnts) {
		List<EntOpVitalSignsDTO> entOpVitalSignsDTO = new ArrayList();
		if (EnValidator.isEmpty(entOpVitalWeights)) {
			if (EnValidator.isEmpty(entOpVitalHeights)) {
				return null;
			}
			return entOpVitalHeights;
		}
		if (EnValidator.isEmpty(entOpVitalHeights)) {
			if (EnValidator.isEmpty(entOpVitalWeights)) {
				return null;
			}
			return entOpVitalWeights;
		}
		for (String idEnt : idEnts) {
			EntOpVitalSignsDTO data = new EntOpVitalSignsDTO();
			data.setId_ent(idEnt);
			entOpVitalSignsDTO.add(data);
		}
		//进行体征集成
		for (EntOpVitalSignsDTO data : entOpVitalSignsDTO) {
			//重量
			for (EntOpVitalSignsDTO entOpVitalWeight : entOpVitalWeights) {
				if(data.getId_ent().equals(entOpVitalWeight.getId_ent())){
					data.setWeight(entOpVitalWeight.getWeight()); 
					data.setId_srv_weight(entOpVitalWeight.getId_srv_weight()); 
					data.setId_unit_weight(entOpVitalWeight.getId_unit_weight()); 
					data.setName_unit_weight(entOpVitalWeight.getName_unit_weight()); 
				}
			}
			//高度
			for (EntOpVitalSignsDTO entOpVitalHeight : entOpVitalHeights) {
				if(data.getId_ent().equals(entOpVitalHeight.getId_ent())){
					data.setHeight(entOpVitalHeight.getHeight()); //高度值
					data.setId_srv_height(entOpVitalHeight.getId_srv_height()); //服务id
					data.setId_unit_height(entOpVitalHeight.getId_unit_height()); //高度值
					data.setName_unit_height(entOpVitalHeight.getName_unit_height()); //高度值
				}
			}
		}
		return entOpVitalSignsDTO.toArray(new EntOpVitalSignsDTO[0]);
	}
	/**
	 * 获取身高信息cm
	 * @param idEnts
	 * @return
	 * @throws DAException 
	 */
	private EntOpVitalSignsDTO[] getEntOpVitalHeights(String[] idEnts) throws DAException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT Id_ent, PRESRV.VAL0 Height,"); //值
		sqlBuilder.append(" VT.ID_SRV Id_srv_height,"); //服务id
		sqlBuilder.append(" VT.ID_UNIT Id_unit_height,"); //单位id
		sqlBuilder.append(" UNIT.NAME Name_unit_height"); //单位名称
		sqlBuilder.append(" FROM CI_OBS_PRE_SRV PRESRV");
		sqlBuilder.append(" INNER JOIN BD_SRV_VT VT ON PRESRV.ID_SRV = VT.ID_SRV");
		sqlBuilder.append(" INNER JOIN BD_MEASDOC UNIT ON VT.ID_UNIT = UNIT.ID_MEASDOC");
		sqlBuilder.append(" INNER JOIN BD_DE DE ON VT.ID_DE = DE.ID_DE");
		sqlBuilder.append(" WHERE DE.CODE = ?");
		sqlBuilder.append(" AND " + EnSqlUtils.getInSqlByIds("PRESRV.ID_ENT", idEnts));
		param.addParam(DECODE_HEIGHT_CM);
		@SuppressWarnings("unchecked")
		List<EntOpVitalSignsDTO> list = (List<EntOpVitalSignsDTO>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(
						EntOpVitalSignsDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EntOpVitalSignsDTO[0]);
	}
	/**
	 * 获取体重信息kg
	 * @param idEnts
	 * @return
	 * @throws DAException 
	 */
	private EntOpVitalSignsDTO[] getEntOpVitalWeights(String[] idEnts) throws DAException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT Id_ent, PRESRV.VAL0 Weight,"); //值
		sqlBuilder.append(" VT.ID_SRV Id_srv_weight,"); //服务id
		sqlBuilder.append(" VT.ID_UNIT Id_unit_weight,"); //单位id
		sqlBuilder.append(" UNIT.NAME Name_unit_weight"); //单位名称
		sqlBuilder.append(" FROM CI_OBS_PRE_SRV PRESRV");
		sqlBuilder.append(" INNER JOIN BD_SRV_VT VT ON PRESRV.ID_SRV = VT.ID_SRV");
		sqlBuilder.append(" INNER JOIN BD_MEASDOC UNIT ON VT.ID_UNIT = UNIT.ID_MEASDOC");
		sqlBuilder.append(" INNER JOIN BD_DE DE ON VT.ID_DE = DE.ID_DE");
		sqlBuilder.append(" WHERE (DE.CODE = ? or DE.CODE = ?)");
		sqlBuilder.append(" AND " + EnSqlUtils.getInSqlByIds("PRESRV.ID_ENT", idEnts));
		param.addParam(DECODE_WEIGHT_KG);
		param.addParam(DECODE_WEIGHT_G);
		@SuppressWarnings("unchecked")
		List<EntOpVitalSignsDTO> list = (List<EntOpVitalSignsDTO>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(EntOpVitalSignsDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EntOpVitalSignsDTO[0]);
	}
}
