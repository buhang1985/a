package iih.en.pv.s.bp.ip.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.common.CheckFlag;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.inpatient.d.OutDepChkInfo;
import iih.en.pv.inpatient.d.TransDepCheckStatus;
import iih.en.pv.s.bp.ip.LvHosCheckBP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取出院患者列表
 * 
 * @author liubin
 *
 */
public class GetLvHosDTOArrayBP {
	
	/**
	 * 获取出院申请列表
	 * @param depId
	 * @param nurId
	 * @return
	 * @throws BizException
	 */
	public LvHosAppDTO[] exec(String depId, String nurId) throws BizException{
		//1.获取出院申请列表
		LvHosAppDTO[] lvHosAppDTOs = this.getLvHosApps(depId, nurId,null);
		return processData(lvHosAppDTOs);
	}
	/**
	 * 根据就诊数组获取出院申请列表
	 * @param id_ents
	 * @return
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月27日 下午3:52:13
	 */
	public LvHosAppDTO[] exec(String[] idEnts) throws BizException{
		//1.获取出院申请列表
		if(EnValidator.isEmpty(idEnts))  return null;
		LvHosAppDTO[] lvHosAppDTOs = this.getLvHosApps(null,null,idEnts);	
		return processData(lvHosAppDTOs);
	}
	
    /**
     * 处理出院数据 add by renying 19.5.10
     * @param lvHosAppDTOs
     * @return
     * @throws DAException
     */
	private LvHosAppDTO[] processData(LvHosAppDTO[] lvHosAppDTOs) throws DAException {
		// 2.过滤重复患者
		Map<String, LvHosAppDTO> map = this.FilterRepetPat(lvHosAppDTOs);
		// 3.查询新生儿信息
		return this.addBabys(map);
	}
	/**
	 * 获取出院申请列表
	 * @param nurId 病区列表
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private LvHosAppDTO[] getLvHosApps(String depId, String nurId,String[] idEnts) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT ");
		builder.append(" EN.ID_ENT, ");
		builder.append(" EN.CODE           AS CODE_ENT, ");
		builder.append(" EN.CODE_ENTP, ");
		builder.append(" ap.sd_outtp, ");
		builder.append(" doc.name          as name_outtp, ");
		builder.append(" pat.id_code, ");
		builder.append(" udi.name          AS name_sdtp, ");
		builder.append(" EN.ID_PAT, ");
		builder.append(" EN.NAME_PAT       AS NAME, ");
		builder.append(" EN.SD_SEX_PAT     AS SEX, ");
		builder.append(" EN.DT_BIRTH_PAT   AS DT_BIRTH, ");
		builder.append(" ip.fg_newborn     as fg_nb, ");
		builder.append(" EN.ID_DEP_PHY, ");
		builder.append(" EN.ID_DEP_NUR, ");
		builder.append(" DEP.NAME          AS NAME_DEP, ");
		builder.append(" NUR.NAME          AS NAME_NUR, ");
		builder.append(" EN.DT_ACPT, ");
		builder.append(" EN.DT_ENTRY, ");
		builder.append(" IP.ID_BED, ");
		builder.append(" IP.NAME_BED, ");
		builder.append(" IP.CODE_AMR_IP, ");
		builder.append(" enhp.id_hp        as id_hp_ent, ");
		builder.append(" CASE WHEN IP.FG_BLRECALL = 'Y' THEN IP.DT_DISC WHEN IP.DT_END_LAST < ACC.DT_BACKCG THEN NULL ELSE IP.DT_DISC END DT_DISC,");
		builder.append(" CIOR.ID_OR, ");
		builder.append(" CIOR.CONTENT_OR   AS NAME_OR, ");
		builder.append(" CIOR.DT_EFFE      AS DT_OUTOR, ");
		builder.append(" CIOR.CODE_OR      AS CI_CODE, ");
		builder.append(" CASE WHEN AP.SD_OUTTP = ? THEN 'Y' ELSE 'N' END FG_DIEOR, ");
		builder.append(" CIOR.DT_SIGN      AS DT_OUT_SIGN, ");
		builder.append(" PATCA.NAME        AS NAME_PATICATE, ");
		builder.append(" EN.DT_ENTRY       AS DT_ENTRY, ");
		builder.append(" IP.FG_BLRECALL, ");
		builder.append(" IP.DT_DISC        AS DT_DISC_IP");
		builder.append(" FROM CI_AP_OUT AP ");
		builder.append(" INNER JOIN CI_ORDER CIOR ON AP.ID_OR=CIOR.ID_OR AND CIOR.SD_SU_OR in(?,?,?)");
		builder.append(" INNER JOIN EN_ENT EN ON CIOR.ID_EN= EN.ID_ENT AND EN.FG_IP='Y' ");
		builder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		builder.append(" INNER JOIN PI_PAT PAT  ON PAT.ID_PAT = EN.ID_PAT ");
		builder.append(" left join en_ent_hp enhp on enhp.id_ent = en.id_ent ");
		builder.append(" LEFT JOIN BD_UDIDOC UDI  ON PAT.ID_IDTP = UDI.ID_UDIDOC");
		builder.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = EN.ID_DEP_PHY ");
		builder.append(" LEFT JOIN BD_DEP NUR ON NUR.ID_DEP = EN.ID_DEP_NUR ");
		builder.append(" LEFT JOIN BD_UDIDOC DOC ON DOC.ID_UDIDOC = AP.iD_OUTTP ");
		builder.append(" LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		builder.append(" LEFT JOIN EN_ENT_ACC ACC ON ACC.ID_ENT = IP.ID_ENT ");
		builder.append(" WHERE 1 = 1 AND EN.CODE_ENTP <> ?");//过滤预住院
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_OUTTP_5);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		param.addParam(IEnDictCodeConst.SD_ENTP_IPPRE);
		//1.科室
		if(!EnValidator.isEmpty(depId)){
			builder.append("AND EN.ID_DEP_PHY = ? ");
			param.addParam(depId);
		}
		//2.病区
		if(!EnValidator.isEmpty(nurId)){
			builder.append("AND EN.ID_DEP_NUR = ? ");
			param.addParam(nurId);
		}
		//2.id_ent
		if(!EnValidator.isEmpty(idEnts)){
			builder.append(" AND ");
			String ids = SqlUtils.getInSqlByIds("EN.ID_ENT", idEnts);
			builder.append(ids);

		}		
						
		List<LvHosAppDTO> dtoList = (List<LvHosAppDTO>) new DAFacade()
				.execQuery(builder.toString(), param, new BeanListHandler(
						LvHosAppDTO.class));
		return EnValidator.isEmpty(dtoList)? null : dtoList.toArray(new LvHosAppDTO[0]);
	}
 


	/**
	 * 过滤出最后一条签署的医嘱
	 * 
	 * @param dtoList
	 * @return
	 */
	private Map<String, LvHosAppDTO> FilterRepetPat(LvHosAppDTO[] hosAppDTOs) {
		if(EnValidator.isEmpty(hosAppDTOs))
			return null;
		Map<String, LvHosAppDTO> map = new HashMap<String, LvHosAppDTO>();
		for (LvHosAppDTO lvHosAppDTO : hosAppDTOs) {
			if (map.containsKey(lvHosAppDTO.getId_ent())) {
				if (map.get(lvHosAppDTO.getId_ent()).getDt_out_sign().compareTo(lvHosAppDTO.getDt_out_sign()) > 0) {
					continue;
				}else {
					map.put(lvHosAppDTO.getId_ent(), lvHosAppDTO);
				}
			}else {
				map.put(lvHosAppDTO.getId_ent(), lvHosAppDTO);
			}
		}
		return map;
	}
	
	/**
	 * 通过idEnts获取LvHosAppDTO（查询所有，不区分是否待出院）
	 * @param nurId 病区列表
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public LvHosAppDTO[] getLvHosAppsAllEnt(String[] idEnts) throws BizException {
		LvHosAppDTO[] list = sqlQry(idEnts);
		//检查
		LvHosCheckBP checkBP = new LvHosCheckBP();		
		checkBP.exec(list);
		return list;
	}
	
	/**
	 * 获得页签所需图标编码
	 * @author lilei
	 * @throws BizException 
	 * @date 2019年12月26日
	 */
	private void setCion(LvHosAppDTO[] appDTOs) throws BizException{
		//加载配置信息
		OutDepChkInfo chkInfo = OutDepChkInfo.loadFromCfg(EnParamUtils.getLeaveHosCheckCfg(), OutDepChkInfo.FLAG_CFG_LENTH_LEAVE);
		for (LvHosAppDTO appDTO : appDTOs) {
			appDTO.setStatus_or(getStatus(chkInfo.getFg_or()));//医嘱
			appDTO.setStatus_mp(getStatus(chkInfo.getFg_mp()));//执行
			appDTO.setStatus_med(getStatus(chkInfo.getFg_mm()));//药品
			appDTO.setStatus_bl(getStatus(chkInfo.getFg_bl()));//费用
			appDTO.setStatus_tech(getStatus(chkInfo.getFg_mt()));//医技
			appDTO.setStatus_other(TransDepCheckStatus.Error);//其他
		}
	}
	private Integer getStatus(Integer fg){
		if (CheckFlag.NoCheck.equals(fg)) return TransDepCheckStatus.Success;
		if (CheckFlag.Warn.equals(fg)) return TransDepCheckStatus.Warning;
		if (CheckFlag.Forced.equals(fg)) return TransDepCheckStatus.Error;
		return TransDepCheckStatus.Success;
	}
	
	@SuppressWarnings("unchecked")
	private LvHosAppDTO[] sqlQry(String[] idEnts) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT EN.ID_ENT,");
		builder.append(" ip.fg_blrecall,");
		builder.append(" ip.fg_newborn as fg_nb,");
		builder.append(" EN.DT_ACPT,");
		builder.append(" EN.DT_ENTRY,");
		builder.append(" APO.DT_EFFE as DT_OUTOR,");
		builder.append(" IP.FG_BLRECALL, ");
		builder.append(" IP.DT_DISC AS DT_DISC_IP ");
		builder.append(" FROM EN_ENT EN ");
		builder.append(" INNER JOIN EN_ENT_IP IP ");
		builder.append(" ON EN.ID_ENT = IP.ID_ENT ");
		builder.append(" INNER JOIN PI_PAT PAT");
		builder.append(" ON PAT.ID_PAT = EN.ID_PAT");
		builder.append(" LEFT JOIN (SELECT DISTINCT CIOR.ID_EN AS ID_ENT,AP.ID_OR, CIOR.DT_EFFE FROM CI_AP_OUT AP INNER JOIN CI_ORDER CIOR  ON AP.ID_OR = CIOR.ID_OR WHERE CIOR.SD_SU_OR IN (?, ?,?)) APO  ");
		builder.append(" on apo.ID_ENT = en.id_ent ");
		builder.append(" WHERE 1 = 1 ");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);

		if(!EnValidator.isEmpty(idEnts)){
			builder.append(" AND ");
			String ids = SqlUtils.getInSqlByIds("EN.ID_ENT", idEnts);
			builder.append(ids);

		}		
						
		List<LvHosAppDTO> dtoList = (List<LvHosAppDTO>) new DAFacade()
				.execQuery(builder.toString(), param, new BeanListHandler(
						LvHosAppDTO.class));
		return EnValidator.isEmpty(dtoList)? null : dtoList.toArray(new LvHosAppDTO[0]);
	}
	
	/**
	 * 添加待出院的新生儿
	 * @param dtoList
	 * @throws DAException
	 */
	private LvHosAppDTO[] addBabys(Map<String, LvHosAppDTO> map) throws DAException{
		if(EnValidator.isEmpty(map))
			return null;
		List<LvHosAppDTO> dtoList = new ArrayList<LvHosAppDTO>();
		dtoList.addAll(map.values());
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT EN.ID_ENT,");
		builder.append(" ap.sd_outtp,");
		builder.append(" doc.name as name_outtp, ");
		builder.append(" EN.CODE  CODE_ENT,");
		builder.append(" EN.CODE_ENTP,");
		builder.append(" EN.ID_PAT,");
		builder.append(" EN.DT_ACPT,");
		builder.append(" EN.DT_ENTRY,");
		builder.append(" EN.NAME_PAT     NAME,");
		builder.append(" EN.SD_SEX_PAT   SEX,");
		builder.append(" EN.DT_BIRTH_PAT DT_BIRTH,");
		builder.append(" EN.ID_DEP_PHY,");
		builder.append(" EN.ID_DEP_NUR,");
		builder.append(" EN.DT_ENTRY AS DT_ENTRY, ");
		builder.append(" DEP.NAME AS Name_dep,NUR.NAME AS Name_nur,");
		builder.append(" IP.ID_BED       ID_BED,");
		builder.append(" IP.NAME_BED     NAME_BED,");
		builder.append(" IP.CODE_AMR_IP,");
		builder.append(" NB.ID_ENT_MOM,");
		builder.append(" enhp.id_hp as id_hp_ent, ");
		builder.append(" CIOR.ID_OR,");
		builder.append(" CIOR.CODE_OR CI_CODE,");
		builder.append(" CIOR.CONTENT_OR NAME_OR,");
		builder.append(" CIOR.DT_EFFE DT_OUTOR,");
		builder.append(" CASE WHEN AP.SD_OUTTP = ? THEN 'Y' ELSE 'N' END FG_DIEOR, ");
		builder.append(" CASE WHEN IP.FG_BLRECALL = 'Y' THEN IP.DT_DISC WHEN IP.DT_END_LAST < ACC.DT_BACKCG THEN NULL ELSE IP.DT_DISC END  DT_DISC,");
		builder.append(" PATCA.NAME AS NAME_PATICATE, ");
		builder.append(" IP.FG_BLRECALL, ");
		builder.append(" IP.DT_DISC AS DT_DISC_IP");
		builder.append(" FROM EN_ENT EN ");
		builder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT");
		builder.append(" INNER JOIN EN_ENT_NB NB ON NB.ID_ENT_BB = EN.ID_ENT");
		builder.append(" left join en_ent_hp enhp on enhp.id_ent = en.id_ent ");
		builder.append(" LEFT JOIN CI_ORDER CIOR ON CIOR.ID_EN = EN.ID_ENT AND CIOR.SD_SU_OR IN (?,?,?) and cior.sd_srvtp in ('1202','1203')");
		builder.append(" LEFT JOIN CI_AP_OUT AP ON AP.ID_OR = CIOR.ID_OR");
		builder.append(" LEFT JOIN BD_UDIDOC DOC ON DOC.ID_UDIDOC = AP.iD_OUTTP ");
		builder.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = EN.ID_DEP_PHY ");
		builder.append(" LEFT JOIN BD_DEP NUR ON NUR.ID_DEP = EN.ID_DEP_NUR ");
		builder.append(" LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		builder.append(" LEFT JOIN EN_ENT_ACC ACC ON ACC.ID_ENT = IP.ID_ENT ");
		builder.append(" WHERE EN.FG_IP ='Y' ");
		builder.append(" AND ").append(EnSqlUtils.getInSqlByIds("NB.ID_ENT_MOM", map.keySet().toArray(new String[0])));
		builder.append(" AND (NB.FG_SEPA <> 'Y' OR NB.FG_SEPA IS NULL) ");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_OUTTP_5);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		
		@SuppressWarnings("unchecked")
		List<LvHosAppDTO> bbList = (List<LvHosAppDTO>) new DAFacade().execQuery(builder.toString(), 
				param, new BeanListHandler(LvHosAppDTO.class));
		if(EnValidator.isEmpty(bbList)){
			return dtoList.toArray(new LvHosAppDTO[0]);
		}
		//新生儿是否必须有出院医嘱
		if (EnParamUtils.getNBChkLeaveOrd()) {
			for (LvHosAppDTO bbLvHos : bbList) {
				if (map.get(bbLvHos.getId_ent()) instanceof LvHosAppDTO) {
					map.get(bbLvHos.getId_ent()).setId_ent_mom(bbLvHos.getId_ent_mom());
				}else {
					map.get(bbLvHos.getId_ent_mom()).setNb_no_or(FBoolean.TRUE);
				}
			}
			return map.values().toArray(new LvHosAppDTO[0]);
		} else {
			Boolean flag = true;
			//去掉重复数据
			for (LvHosAppDTO lvDTO : bbList) {
				for (LvHosAppDTO dto : dtoList) {
					if (dto.getId_ent().equals(lvDTO.getId_ent())) {
						flag = false;
						dto.setId_ent_mom(lvDTO.getId_ent_mom());
					}
				}
				if (flag) {
					lvDTO.setFg_nb(FBoolean.TRUE);
					dtoList.add(lvDTO);
				}
				flag = true;
			}
			return EnValidator.isEmpty(dtoList)?null:dtoList.toArray(new LvHosAppDTO[0]);
		}
	}
}
