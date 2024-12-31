package iih.en.er.bp.register;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.custom.EnOpCustomServiceUtils;
import iih.en.comm.ep.EntOpErEP;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 急诊挂号处理
 * 
 * @author liubin
 *
 */
public class HandleErRegistBP {
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	public void exec(RegInfoDTO regInfo) throws BizException {
		boolean isCustom = EnOpCustomServiceUtils.handleErRegist(regInfo);
		if(isCustom)
			return;
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(regInfo.getCode_entp()))
			return;
		if(EnValidator.isEmpty(regInfo.getId_erpre())){
			//TODO 
			//return;
			throw new BizException("没有预检记录不允许直接挂急诊号!");
		}
		//1.查询该预检记录上次挂号消息
		PatiVisitDO lastEnt = getLastEntInfo(regInfo.getId_erpre(), regInfo.getId_ent());
		//2.设置预检信息
		EnErPreDO erPreDo = setErPre(regInfo);
		//3.设置EN_ENT表信息
		this.setEnt(regInfo, erPreDo, lastEnt);
		//4。设置EN_ENT_OP_ER表信息
		this.setEntOpEr(regInfo, erPreDo, lastEnt);
		//5.设置EN_ENT_OP表信息
		this.setEntOp(regInfo, erPreDo, lastEnt);
	}
	/**
	 * 设置预检信息
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	private EnErPreDO setErPre(RegInfoDTO regInfo) throws BizException{
		PiPatEP patEP = new PiPatEP();
		PatDO pat = patEP.getPatByPK(regInfo.getId_pat());
		ErPreEP ep = new ErPreEP();
		EnErPreDO erPreDo = ep.findById(regInfo.getId_erpre());
		erPreDo.setStatus(DOStatus.UPDATED);
		erPreDo.setFg_nonperson(regInfo.getFg_nonperson());
		erPreDo.setId_pat(regInfo.getId_pat());
		erPreDo.setName_pat(pat.getName());
		erPreDo.setId_ent_last(regInfo.getId_ent());
		erPreDo.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		if(EnValidator.isEmpty(erPreDo.getId_ent_fst()))
			erPreDo.setId_ent_fst(regInfo.getId_ent());
		EnErPreDO[] results = ep.save(new EnErPreDO[]{erPreDo});
		return results[0];
	}
	/**
	 * 设置就诊信息
	 * 
	 * @param regInfo
	 * @param lastEnt
	 * @throws BizException
	 */
	private void setEnt(RegInfoDTO regInfo, EnErPreDO erPreDo, PatiVisitDO lastEnt) throws BizException{
		if(lastEnt != null && IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(lastEnt.getCode_entp())){
			PvEP pvEP = new PvEP();
			PatiVisitDO pv = pvEP.getPvByPK(regInfo.getId_ent());
			pv.setStatus(DOStatus.UPDATED);
			lastEnt.setStatus(DOStatus.UPDATED);
			lastEnt.setDt_end(EnAppUtils.getServerDateTime());
			pv.setFg_acptvalid(lastEnt.getFg_acptvalid());
			pv.setDt_acpt(lastEnt.getDt_acpt());
			pv.setId_emp_phy(lastEnt.getId_emp_phy());
			pv.setId_dep_nur(lastEnt.getId_dep_nur());
			pvEP.save(new PatiVisitDO[] {lastEnt, pv});
		}
	}
	
	/**
	 * 设置EN_ENT_OP_ER表信息
	 * 
	 * @param regInfo
	 * @param erPreDo
	 * @return
	 * @throws BizException
	 */
	private EnEntOpErDO setEntOpEr(RegInfoDTO regInfo, EnErPreDO erPreDo, PatiVisitDO lastEnt)throws BizException{
		EnEntOpErDO entOpEr = new EnEntOpErDO();
		entOpEr.setStatus(DOStatus.NEW);
		entOpEr.setId_ent(regInfo.getId_ent());
		entOpEr.setId_ent_fst(erPreDo.getId_ent_fst());
		entOpEr.setId_erpre(erPreDo.getId_erpre());
		entOpEr.setFg_nonperson(regInfo.getFg_nonperson());
		UdidocDO sco = new UdiDocEP().getUdidocByCodeAndValue(IEnDictCodeTypeConst.SD_ERPRE_SCOLE, erPreDo.getSd_scale_hm());
		if(sco == null){
			throw new BizException("未找到患者预检分检级别!");
		}
		entOpEr.setId_scale_triage(sco.getId_udidoc());
		entOpEr.setSd_scale_triage(sco.getCode());
		if(lastEnt != null && IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(lastEnt.getCode_entp())){
			EntOpErEP opErEP = new EntOpErEP();
			EnEntOpErDO lastOpEr = opErEP.getByEntIdWithOutRef(lastEnt.getId_ent());
			entOpEr.setId_bed(lastOpEr.getId_bed());
			entOpEr.setId_level_nur(lastOpEr.getId_level_nur());
			entOpEr.setSd_level_nur(lastOpEr.getSd_level_nur());
		}
		EnEntOpErDO[] entOpErs = new EntOpErEP().save(new EnEntOpErDO[]{entOpEr});
		return entOpErs[0];
	}
	/**
	 * 设置EN_ENT_OP表信息
	 * 
	 * @param regInfo
	 * @param erPreDo
	 * @return
	 * @throws BizException
	 */
	private void setEntOp(RegInfoDTO regInfo, EnErPreDO erPreDo, PatiVisitDO lastEnt) throws BizException{
		if(lastEnt == null || !IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(lastEnt.getCode_entp()))
			return;
		DAFacade daf = new DAFacade();
		List<OutpatientDO> list = (List<OutpatientDO>) daf.findByAttrValStrings(OutpatientDO.class, OutpatientDO.ID_ENT, new String[]{regInfo.getId_ent(), lastEnt.getId_ent()}, null);
		OutpatientDO curOp = null;
		OutpatientDO lastOp = null;
		for(OutpatientDO op : list){
			if(regInfo.getId_ent().equals(op.getId_ent()))
				curOp = op;
			if(lastEnt.getId_ent().equals(op.getId_ent()))
				lastOp = op;
		}
		curOp.setStatus(DOStatus.UPDATED);
		curOp.setFg_rescue(FBoolean.TRUE);
		curOp.setSd_status(lastOp.getSd_status());
		lastOp.setStatus(DOStatus.UPDATED);
		lastOp.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		OpEP opEP = new OpEP();
		opEP.save(new OutpatientDO[]{lastOp, curOp});
	}
	/**
	 * 获取该预检最后一次就诊记录
	 * 
	 * @param erPreId
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getLastEntInfo(String erPreId, String entId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT TOP 1 EN.* ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON EN.ID_ENT = OPER.ID_ENT ");
		sqlBuilder.append(" WHERE OPER.ID_ERPRE = ?  ");
		sqlBuilder.append(" AND EN.ID_ENT <> ? ");
		sqlBuilder.append(" AND EN.FG_CANC = 'N' ");
		sqlBuilder.append(" ORDER BY OP.DT_VALID_B DESC, EN.DT_INSERT DESC ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(erPreId);
		param.addParam(entId); 
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(PatiVisitDO.class));
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
}
