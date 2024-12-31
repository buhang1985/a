package iih.en.er.bp.qry;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErPreInfoDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 获取患者本次所有有效就诊记录
 * 
 * @author liubin
 *
 */
public class GetEnErPreInfosByEntIdBP {
	
	/**
	 * 获取患者本次所有有效就诊记录
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public EnErPreInfoDTO[] exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		List<String> entIds = EnErUtils.getEntIdsByEntId(entId);
		if(ListUtil.isEmpty(entIds))
			return null;
		EnErPreInfoDTO[] enErPreInfos = (EnErPreInfoDTO[]) AppFwUtil.getDORstWithDao(new EnErPreInfosQry(entIds.toArray(new String[entIds.size()])), EnErPreInfoDTO.class);
		// 设置分级
		ErPreEP erPreEp = new ErPreEP();
		erPreEp.setErScoleName(enErPreInfos, "Sd_scale", "Name_scale");
		// 设置绿色通道
		erPreEp.setGreenNames(enErPreInfos, "Ids_green_channel", "Names_green_channel");
		// 设置其他自定义档案
		this.setUdidocInfo(enErPreInfos);
		
		return enErPreInfos;
	}
	
	/**
	 * 设置自定义档案
	 * 
	 * @param erPreInfos
	 * @throws BizException
	 */
	private void setUdidocInfo(EnErPreInfoDTO[] erPreInfos) throws BizException{
		if(ArrayUtil.isEmpty(erPreInfos))
			return;
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		//获取性别
		UdidocDO[] sexs = serv.findByUdidoclistCode(IPiDictCodeTypeConst.SD_SEX_CODE);
		Map<String, UdidocDO> sexMap = EnFMapUtils.getMap(UdidocDO.ID_UDIDOC, sexs);
		//获取分诊去向
		UdidocDO[] triageTos = serv.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ERPRE_TRIAGETO);
		Map<String, UdidocDO> triageToMap = EnFMapUtils.getMap(UdidocDO.CODE, triageTos);
		
		for(EnErPreInfoDTO erPreInfo : erPreInfos){
			if(sexMap != null && sexMap.containsKey(erPreInfo.getId_sex())){
				UdidocDO sex = sexMap.get(erPreInfo.getId_sex());
				erPreInfo.setName_sex(sex.getName());
			}
			if(triageToMap != null && triageToMap.containsKey(erPreInfo.getSd_triage_to())){
				UdidocDO triageTo = triageToMap.get(erPreInfo.getSd_triage_to());
				erPreInfo.setName_triage_to(triageTo.getName());
			}
		}
	}
	
	/**
	 * 查询患者预检信息
	 * 
	 * @author liubin
	 *
	 */
	private class EnErPreInfosQry implements ITransQry{

		public String[] entIds;
		
		public EnErPreInfosQry(String[] entIds){
			this.entIds = entIds;
		}
		
		
		@Override
		public SqlParam getQryParameter(StringBuffer arg0) {
			SqlParam param = new SqlParam();
			return param;
		}

		@Override
		public String getQrySQLStr() {
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" SELECT ERPRE.ID_ERPRE AS ID_ERPRE, ");
			sqlBuilder.append(" ERPRE.CODE AS CODE_ERPRE, ");
			sqlBuilder.append(" EN.ID_ENT AS ID_ENT, ");
			sqlBuilder.append(" EN.CODE AS CODE_ENT, ");
			sqlBuilder.append(" PAT.ID_PAT AS ID_PAT, ");
			sqlBuilder.append(" PAT.NAME AS NAME_PAT, ");
			sqlBuilder.append(" PAT.CODE AS CODE_PAT, ");
			sqlBuilder.append(" ERPRE.FG_NONPERSON AS FG_NONPERSON, ");
			sqlBuilder.append(" PAT.ID_SEX AS ID_SEX, ");
			sqlBuilder.append(" PAT.DT_BIRTH AS DT_BIRTH, ");
			sqlBuilder.append(" PAT.ID_CODE AS NO_ID, ");
			sqlBuilder.append(" PAT.TEL AS TEL, ");
			sqlBuilder.append(" ERPRE.DT_ENTRY AS DT_ENTRY, ");
			sqlBuilder.append(" ERPRE.SD_SCALE_HM AS SD_SCALE, ");
			sqlBuilder.append(" ERPRE.IDS_GREEN_CHANNEL_SYM AS IDS_GREEN_CHANNEL, ");
			sqlBuilder.append(" ERPRE.ID_DEP_TO AS ID_TRIAGE_DEP, ");
			sqlBuilder.append(" DEP.NAME AS NAME_TRIAGE_DEP, ");
			sqlBuilder.append(" ERPRE.SD_TRIAGE_TO AS SD_TRIAGE_TO,");
			sqlBuilder.append(" EN.ID_DEP_NUR AS ID_DEP_NUR,");
			sqlBuilder.append(" NUR.NAME AS NAME_DEP_NUR, ");
			sqlBuilder.append(" OP.DT_VALID_B AS DT_VALID_B, ");
			sqlBuilder.append(" OP.DT_VALID_E AS DT_VALID_E, ");
			sqlBuilder.append(" EN.DT_INSERT AS DT_INSERT ");
			sqlBuilder.append(" FROM EN_ENT EN ");
			sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
			sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON EN.ID_ENT = OPER.ID_ENT ");
			sqlBuilder.append(" INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
			sqlBuilder.append(" INNER JOIN EN_ERPRE ERPRE ON OPER.ID_ERPRE = ERPRE.ID_ERPRE ");
			sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON ERPRE.ID_DEP_TO = DEP.ID_DEP ");
			sqlBuilder.append(" LEFT JOIN BD_DEP NUR ON EN.ID_DEP_NUR = NUR.ID_DEP ");
			sqlBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", this.entIds));
			sqlBuilder.append(" ORDER BY OP.DT_VALID_B, EN.DT_INSERT ");
			return sqlBuilder.toString();
		}
		
	}
}
