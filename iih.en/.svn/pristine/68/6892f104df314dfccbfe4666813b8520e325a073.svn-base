package iih.en.pv.s.bp;

import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntInfoDTO;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 就在信息查询BP
 * TODO 进行拆分
 * 
 * @author
 *
 */
public class EntInfoQryBP {

	public EntInfoQryBP() {

	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EntInfoDTO getEntInfo(String entId) throws BizException {
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		EntInfoDTO entInfoDTO = null;
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EN.ID_ENT AS ID_ENT,EN.ID_PAT AS ID_PAT,EN.NAME_PAT AS NAME_PAT,EN.TELNO_PAT AS TEL,");
		builder.append("PI.ID_CODE AS CODE_ID,PI.CODE AS CODE_PAT,");
		builder.append("DOC.NAME AS SD_IDTP,");
		builder.append("DI.ID_DI AS ID_DI_MAIN,DI.NAME_DI AS NAME_DI_MAIN,DI.DES AS DES_DI_MAIN  ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN PI_PAT PI ON EN.ID_PAT=PI.ID_PAT  ");
		builder.append("LEFT JOIN BD_UDIDOC DOC ON PI.ID_IDTP=DOC.ID_UDIDOC ");
		builder.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT=DI.ID_ENT AND DI.FG_MAJ='Y' AND DI.SD_CDSYSTP='0' ");
		builder.append("WHERE EN.ID_ENT=? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<EntInfoDTO> list = (List<EntInfoDTO>) new DAFacade().execQuery(
				sql, param, new BeanListHandler(EntInfoDTO.class));
		if (!EnValidator.isEmpty(list)) {
			entInfoDTO = list.get(0);
			String addr = new PatQryBP().getPresentAddress(entInfoDTO.getId_pat());
			entInfoDTO.setAddress(addr);
		}
		return entInfoDTO;
	}

	/**
	 * 门诊就诊查询患者
	 * 
	 * @param qryModDTO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public OutpatientQryDTO[] getPvDOList(EntQryModDTO qryModDTO)throws BizException {
		if(qryModDTO==null){
			throw new BizException("EntQryModDTO为空");
		}
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT DISTINCT EN.ID_ENT,EN.ID_PAT,EN.NAME_PAT,EN.SD_SEX_PAT,EN.DT_BIRTH_PAT,EN.ID_EMP_PHY,PS.NAME AS NAME_EMP_PHY,EN.DT_ENTRY, ");
		builder.append("EN.CODE AS CODE_ENT,PI.CODE AS CODE_PAT,OP.ID_SCRES AS ID_SCRES,RES.NAME AS NAME_SCRES,OP.TICKETNO AS TICKNO,OP.SD_STATUS,DOC.NAME AS NAME_SEX_PAT ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT=OP.ID_ENT AND EN.FG_CANC='N' ");
		// 输入不为空
		if (!EnValidator.isEmpty(qryModDTO.getValue_pat()) && !"NAME".equals(qryModDTO.getKey_pat()) && !"CODE".equals(qryModDTO.getKey_pat())) {
			builder.append("INNER JOIN PI_PAT_CARD CARD ON EN.ID_PAT=CARD.ID_PAT AND CARD.ID_PATCARDTP=? AND CARD.CODE=? ");
			param.addParam(qryModDTO.getKey_pat());
			param.addParam(qryModDTO.getValue_pat());
		}
		// 选择全科
		if (qryModDTO.getFg_indep().booleanValue()) {
			builder.append("INNER JOIN EN_ENT_DEP DEP ON EN.ID_ENT=DEP.ID_ENT AND DEP.ID_DEP=? ");
			param.addParam(qryModDTO.getId_dep());
		} else {// 默认本医生
			builder.append("INNER JOIN EN_ENT_EMP EMP ON EN.ID_ENT=EMP.ID_ENT AND EMP.ID_EMP=? ");
			param.addParam(qryModDTO.getId_emp());
		}
		builder.append("INNER JOIN PI_PAT PI ON EN.ID_PAT=PI.ID_PAT ");
		builder.append("LEFT JOIN SC_RES RES ON OP.ID_SCRES=RES.ID_SCRES ");
		builder.append("LEFT JOIN BD_PSNDOC PS ON EN.ID_EMP_PHY=PS.ID_PSNDOC ");
		builder.append("LEFT JOIN BD_UDIDOC DOC ON EN.ID_SEX_PAT = DOC.ID_UDIDOC ");
		builder.append(" WHERE EN.DT_ENTRY>=? AND EN.DT_ENTRY<=? ");
		builder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		param.addParam(qryModDTO.getDt_b());
		param.addParam(qryModDTO.getDt_e().getDateAfter(1));
		// 输入不为空
		if (!EnValidator.isEmpty(qryModDTO.getValue_pat())) {
		// 选择患者姓名
			if (qryModDTO.getKey_pat().equals("NAME")) {
				builder.append("AND EN.NAME_PAT=? ");
				param.addParam(qryModDTO.getValue_pat());
			// 选择患者编号
			} else if (qryModDTO.getKey_pat().equals("CODE")) {
				builder.append("AND PI.CODE=? ");
				param.addParam(qryModDTO.getValue_pat());
			} 
		}		
		builder.append("ORDER BY EN.DT_ENTRY  DESC ");
		String sql = builder.toString();
		List<OutpatientQryDTO> list = (List<OutpatientQryDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OutpatientQryDTO.class));
		if (!EnValidator.isEmpty(list)) {
			return list.toArray(new OutpatientQryDTO[0]);
		}
		return null;
	}
	/**
	 * 门诊查询接诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public OutpatientQryDTO getOpInfo(String entId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT EN.ID_ENT,EN.ID_PAT,EN.NAME_PAT, ");
		builder.append("EN.CODE AS CODE_ENT,PI.CODE AS CODE_PAT,OP.ID_SCRES AS ID_SCRES,nvl(RES.NAME,doc.name) AS NAME_SCRES,OP.TICKETNO AS TICKNO,OP.SD_STATUS ");
		builder.append("FROM EN_ENT EN ");
		builder.append("LEFT JOIN EN_ENT_OP OP ON EN.ID_ENT=OP.ID_ENT AND EN.FG_CANC='N' ");
		builder.append("LEFT JOIN SC_RES RES ON OP.ID_SCRES=RES.ID_SCRES ");
		builder.append("LEFT JOIN PI_PAT PI ON EN.ID_PAT=PI.ID_PAT ");
		builder.append("left join bd_psndoc doc on doc.id_psndoc = op.id_emp_reg ");//资源为空时取挂号医生，fanlq-2018-05-21
		builder.append("WHERE EN.ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		String sql = builder.toString();
		List<OutpatientQryDTO> list = (List<OutpatientQryDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OutpatientQryDTO.class));
		if (!EnValidator.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 加载价格信息，包括医保计划、价格分类
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public OutpatientQryDTO loadPriInfo(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		OutpatientQryDTO outpatientQryDTO = new OutpatientQryDTO();
		PvEP pvEp = new PvEP();
		PatiVisitDO pv = pvEp.getPvById(entId);
		outpatientQryDTO.setId_ent(pv.getId_ent());
		outpatientQryDTO.setId_pripat(pv.getId_pripat());
		outpatientQryDTO.setName_pripat(pv.getName_pripat());
		EntHpEP hpEp = new EntHpEP();
		EntHpDO[] hps = hpEp.getEntHpList(entId);
		if(!EnValidator.isEmpty(hps)){
			for(EntHpDO hp : hps){
				if(FBoolean.TRUE.equals(hp.getFg_maj())){
					outpatientQryDTO.setId_hp(hp.getId_hp());
					outpatientQryDTO.setName_hp(hp.getName_hp());
				}else{
					outpatientQryDTO.setId_hp_sup(hp.getId_hp());
					outpatientQryDTO.setName_hp_sup(hp.getName_hp());
				}
			}
		}
		return outpatientQryDTO;
	}
}
