package iih.en.pv.s.bp;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHisQryCondDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者的历史就诊诊断记录
 * @author liubin
 * @author yank
 *
 */
public class GetHisEntDiListBP {
	/**
	 * 获取患者的历史就诊诊断记录
	 * @param patCode 患者编码
	 * @param onlyDiagEnd 只包含诊毕状态
	 * @param withDetail 是否包含明细
	 * @param exclEntIds 排除的就诊ID，可为空
	 * @return
	 * @throws BizException
	 */
	public EntHisDiDTO[] exec(String patCode,FBoolean onlyDiagEnd,FBoolean withDetail,String[] exclEntIds) throws BizException{
		EnHisQryCondDTO cond = new EnHisQryCondDTO();
		cond.setCode_pat(patCode);
		cond.setFg_onlydiagend(onlyDiagEnd);
		cond.setFg_withdideail(withDetail);
		return this.exec(cond, exclEntIds);
	}
	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param cond
	 * @param exclEntIds
	 * @return
	 * @throws BizException
	 */
	public EntHisDiDTO[] exec(EnHisQryCondDTO cond, String[] exclEntIds) throws BizException {
		if(cond == null)
			return null;
		EntHisDiDTO[] hisEnts = this.getEntHisList(cond, exclEntIds);
		if(EnValidator.isEmpty(hisEnts))
			return null;
		EnAgeCalcUtil.setDoAges(hisEnts, "Id_ent", "Age");
		Map<String, EntHisDiDTO> map = new LinkedHashMap<>();
		for(EntHisDiDTO hisEnt : hisEnts){
			if(map.containsKey(hisEnt.getId_ent()))
				continue;
			else{
				//hisEnt.setAge(AgeCalcUtil.getAge(hisEnt.getDt_birth()));
				map.put(hisEnt.getId_ent(), hisEnt);
			}
		}
		if(FBoolean.TRUE.equals(cond.getFg_withdideail()))
			this.loadDiDetail(map);
		return map.values().toArray(new EntHisDiDTO[0]);
	}
	/**
	 * 获取就诊id集合
	 * 
	 * @param cond
	 * @param exclEntIds
	 * @return
	 * @throws BizException
	 */
	private EntHisDiDTO[] getEntHisList(EnHisQryCondDTO cond, String[] exclEntIds) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT EN.ID_ENT,");
		sqlBuilder.append("EN.ID_PAT AS ID_PAT, ");
		sqlBuilder.append("PAT.NAME AS NAME_PAT, ");
		sqlBuilder.append("EN.ID_ENTP AS ID_ENTP,");
		sqlBuilder.append("EN.CODE_ENTP AS CODE_ENTP,");
		sqlBuilder.append("EN.DT_ACPT AS DT_ACPT,");
		sqlBuilder.append("EN.ID_DEP_PHY AS ID_DEP,");
		sqlBuilder.append("DEP.NAME AS NAME_DEP,");
		sqlBuilder.append("EN.ID_EMP_PHY AS ID_EMP,");
		sqlBuilder.append("EMP.NAME AS NAME_EMP,");
		sqlBuilder.append("PAT.SD_SEX,");
		sqlBuilder.append("SEX.NAME AS NAME_SEX,");
		sqlBuilder.append("PAT.DT_BIRTH ");
		sqlBuilder.append("FROM EN_ENT EN ");
		sqlBuilder.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append("LEFT JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append("LEFT JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sqlBuilder.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC SEX ON PAT.ID_SEX = SEX.ID_UDIDOC ");
		sqlBuilder.append("LEFT JOIN PI_PAT_CARD CARD ON PAT.ID_PAT = CARD.ID_PAT ");
		sqlBuilder.append("WHERE ISNULL(EN.DT_ACPT,'~') <> '~' ");
		sqlBuilder.append("AND EN.FG_CANC = ? ");
		sqlBuilder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		param.addParam(FBoolean.FALSE);
		//患者卡查询
		if(EnValidator.isNotEmptyIgnoreBlank(cond.getSd_patcardtp()) 
				&& EnValidator.isNotEmptyIgnoreBlank(cond.getCode_patcard())){
			sqlBuilder.append("AND CARD.SD_PATCARDTP = ? AND CARD.CODE = ? ");
			param.addParam(cond.getSd_patcardtp());
			param.addParam(cond.getCode_patcard());
		}
		if(!EnValidator.isEmpty(cond.getName_pat())){//患者姓名
			sqlBuilder.append("AND PAT.NAME like ? ");
			param.addParam(cond.getName_pat() + "%");
		}
		if(!EnValidator.isEmpty(cond.getCode_pat())){//患者编码
			sqlBuilder.append("AND PAT.CODE like ? ");
			param.addParam(cond.getCode_pat() + "%");
		}
		if(!EnValidator.isEmpty(cond.getBarcode_chis())){//条码号
			sqlBuilder.append("AND PAT.BARCODE_CHIS like ? ");
			param.addParam(cond.getBarcode_chis() + "%");
		}
		if(!EnValidator.isEmpty(cond.getCode_id())){//患者证件号
			sqlBuilder.append("AND PAT.ID_CODE = ? ");
			param.addParam(cond.getCode_id());
		}
		if(!EnValidator.isEmpty(cond.getId_dep())){//科室
			sqlBuilder.append("AND EN.ID_DEP_PHY = ? ");
			param.addParam(cond.getId_dep());
		}
		if(!EnValidator.isEmpty(cond.getId_emp())){//医生
			sqlBuilder.append("AND EN.ID_EMP_PHY = ? ");
			param.addParam(cond.getId_emp());
		}
		if(cond.getDt_b() != null){
			sqlBuilder.append("AND EN.DT_ENTRY >= ? ");
			param.addParam(cond.getDt_b());
		}
		if(cond.getDt_e() != null){
			sqlBuilder.append("AND EN.DT_ENTRY < ? ");
			param.addParam(cond.getDt_e().getDateAfter(1));
		}
		if(FBoolean.TRUE.equals(cond.getFg_onlydiagend())){
			sqlBuilder.append(" AND (((EN.CODE_ENTP='00' OR EN.CODE_ENTP='01') AND OP.SD_STATUS='08') OR (EN.CODE_ENTP='10' AND IP.SD_STATUS='28')) ");
		}
		if(!EnValidator.isEmpty(exclEntIds)){
			String exclFilter = EnSqlUtils.getNotInSqlByIds("EN.ID_ENT", exclEntIds);
			if(!EnValidator.isEmpty(exclFilter)){
				sqlBuilder.append(" AND ").append(exclFilter);
			}			
		}
		sqlBuilder.append("ORDER BY EN.DT_ACPT ");
		List<EntHisDiDTO> list = (List<EntHisDiDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(EntHisDiDTO.class));
		if(!EnValidator.isEmpty(list))
			return list.toArray(new EntHisDiDTO[0]);
		return null;
	}
	/**
	 * 
	 * 加载就诊诊断明细
	 * 
	 * @param map
	 * @throws BizException
	 */
	private void loadDiDetail(Map<String, EntHisDiDTO> map) throws BizException{
		IEntdiRService serv = ServiceFinder.find(IEntdiRService.class);
		EntDiDO[] entDiDOs = serv.findByAttrValStrings(EntDiDO.ID_ENT, map.keySet().toArray(new String[0]));
		if(!EnValidator.isEmpty(entDiDOs)){
			for(EntDiDO entDiDO : entDiDOs){
				if(map.containsKey(entDiDO.getId_ent())){
					EntHisDiDTO hisEnt = map.get(entDiDO.getId_ent());
					if(hisEnt.getDi_array() == null)
						hisEnt.setDi_array(new FArrayList());
					hisEnt.getDi_array().add(entDiDO);
				}
			}
		}
	}
}
