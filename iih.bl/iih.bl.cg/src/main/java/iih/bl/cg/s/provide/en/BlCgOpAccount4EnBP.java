package iih.bl.cg.s.provide.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccount4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccountItm4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccountRlt4EnDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.i.IBlStQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 挂号记账

 * @author ly 2019/10/31
 *
 */
public class BlCgOpAccount4EnBP {

	private PatiVisitDO enEntDO = null;
	
	/**
	 * 挂号记账
	 * （含欠款及预交金记账）
	 * @param accDto
	 * @return
	 * @throws BizException
	 */
	public BlCgOpAccountRlt4EnDTO exec(BlCgOpAccount4EnDTO accDto) throws BizException {
		
		this.validate(accDto);
		
		this.loadEntData(accDto.getId_ent());
		
		this.resetCgMode(accDto);
		
		BlCgOpAccountRlt4EnDTO rlt = new BlCgOpAccountRlt4EnDTO();
		
		String stId = null;
		if(OepCgModeEnum.SUSP_CG == accDto.getEu_oepcgmode()){
			stId = new DBUtil().getOIDs(1)[0];
		}
		
		BlcgoepAggDO cgAggDO = this.keepAccount(accDto, stId);
		rlt.setId_cgoep(cgAggDO.getParentDO().getId_cgoep());
		
		if(OepCgModeEnum.SUSP_CG == accDto.getEu_oepcgmode()){
			
			this.saveSuspStData(accDto, cgAggDO);
			rlt.setId_stoep(stId);
		}
		
		return rlt;
	}
	
	/**
	 * 加载就诊数据
	 * @param entId
	 */
	private void loadEntData(String entId) throws BizException {
		
		DAFacade daf = new DAFacade();
		this.enEntDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
		
		if(this.enEntDO == null){
			throw new BizException("挂号记账为查询到就诊信息，就诊id：" + entId);
		}
	}

	/**
	 * 入参校验
	 * @param accDto
	 * @throws BizException
	 */
	private void validate(BlCgOpAccount4EnDTO accDto) throws BizException {
		
		if(accDto == null){
			throw new BizException("挂号记账入参为空");
		}
		
		if(StringUtil.isEmpty(accDto.getId_pat())){
			throw new BizException("挂号记账入参患者id为空");
		}

		if(StringUtil.isEmpty(accDto.getId_ent())){
			throw new BizException("挂号记账入参就诊id为空");
		}
		
		if(StringUtil.isEmpty(accDto.getId_pat())){
			throw new BizException("挂号记账入参记账模式为空");
		}
		
		if(accDto.getDetail() == null){
			throw new BizException("挂号记账入参记账明细为空");
		}
		
		for (int i = 0; i < accDto.getDetail().size(); i++) {
			BlCgOpAccountItm4EnDTO detail = (BlCgOpAccountItm4EnDTO)accDto.getDetail().get(i);
			if(detail == null){
				throw new BizException("挂号记账入参记账明细数据为空");
			}
			
			if(StringUtil.isEmpty(detail.getId_srv())){
				throw new BizException("挂号记账入参记账明细数据中服务id为空");
			}
			
			if (detail.getQuan() == null || detail.getQuan().compareTo(FDouble.ZERO_DBL) <= 0) {
				throw new BizException("挂号记账入参记账明细数据中数量为空或小于等于0");
			}
		}
	}

	/**
	 * 重新设置记账模式
	 * @param accDto
	 * @throws BizException
	 */
	private void resetCgMode(BlCgOpAccount4EnDTO accDto) throws BizException {
		
		IBlStQryService stService = ServiceFinder.find(IBlStQryService.class);
		FBoolean fgHpCg = stService.checkBHpCgPat(this.enEntDO.getId_patca());
		if(FBoolean.TRUE.equals(fgHpCg)){
			accDto.setEu_oepcgmode(OepCgModeEnum.HIGHHP_CG);
		}
	}
	
	/**
	 * 记账
	 * @param accDto
	 * @throws BizException
	 */
	private BlcgoepAggDO keepAccount(BlCgOpAccount4EnDTO accDto, String stId) throws BizException {
		
		List<BlCgAccountDTO> accList = new ArrayList<BlCgAccountDTO>();
		for (int i = 0; i < accDto.getDetail().size(); i++) {
			BlCgOpAccountItm4EnDTO detail = (BlCgOpAccountItm4EnDTO)accDto.getDetail().get(i);
			BlCgAccountDTO cgAccDto = new BlCgAccountDTO();
			cgAccDto.setId_pat(accDto.getId_pat());
			cgAccDto.setId_ent(accDto.getId_ent());
			cgAccDto.setId_srv(detail.getId_srv());
			cgAccDto.setQuan(detail.getQuan());
			cgAccDto.setEu_direct(BookRtnDirectEnum.CHARGES);
			cgAccDto.setId_dep_or(this.enEntDO.getId_dep_phy());
			cgAccDto.setId_emp_or(this.enEntDO.getId_emp_phy());
			cgAccDto.setId_dep_mp(this.enEntDO.getId_dep_phy());
			cgAccDto.setId_pripat(this.enEntDO.getId_pripat());
			
			accList.add(cgAccDto);
		}
		
		BlCgOpAccountSetDTO accSet = new BlCgOpAccountSetDTO();
		accSet.setSrcfunc_des(IBlCgFuncConst.FUNC_OPEN_OPREGISTER);
		accSet.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);
		accSet.setEu_oepcgmode(accDto.getEu_oepcgmode());
		accSet.setId_stoep(stId);
		
		IBlCgAccountService accService = ServiceFinder.find(IBlCgAccountService.class);
		BlCgAccountRltDTO accRlt = accService.keepAccountForOp(accList.toArray(new BlCgAccountDTO[0]), accSet);
		
		return ((BlcgoepAggDO)accRlt.getCglist().get(0));
	}
	
	/**
	 * 保存挂起结算数据
	 * @param cgAggDO
	 * @return
	 * @throws BizException
	 */
	private void saveSuspStData(BlCgOpAccount4EnDTO accDto, BlcgoepAggDO cgAggDO) throws BizException {
		
		BlCgItmOepDO[] cgItmDos = cgAggDO.getBlCgItmOepDO();
		BlCgItmOepDO firstCgItmDO = cgItmDos[0];
		
		FDouble amtStd = FDouble.ZERO_DBL;
		FDouble amtRatio = FDouble.ZERO_DBL;
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			amtStd = amtStd.add(cgItmDO.getAmt_std());
			amtRatio = amtRatio.add(cgItmDO.getAmt_ratio());
		}
		
		BlStOepDO stDO = new BlStOepDO();
		stDO.setId_stoep(firstCgItmDO.getId_stoep());
		stDO.setId_org(Context.get().getOrgId());
		stDO.setId_grp(Context.get().getGroupId());
		stDO.setId_pat(accDto.getId_pat());
		stDO.setId_ent(accDto.getId_ent());
		stDO.setId_enttp(firstCgItmDO.getId_enttp());
		stDO.setCode_enttp(firstCgItmDO.getCode_enttp());
		stDO.setCode_st(BlCodeUtils.generateOepStCode());
		stDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		stDO.setEu_sttp(StTypeEnum.ST_OEP_REG);
		stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stDO.setAmt(amtRatio);
		stDO.setAmt_pat(amtRatio);
		stDO.setAmt_std(amtStd);
		stDO.setAmt_hp(FDouble.ZERO_DBL);
		stDO.setAmt_ratio(amtRatio);
		stDO.setDt_st(BlFlowContextUtil.getNowTime());
		stDO.setId_dep_st(Context.get().getDeptId());
		stDO.setId_emp_st(Context.get().getStuffId());
		stDO.setFg_cc(FBoolean.FALSE);
		stDO.setFg_canc(FBoolean.FALSE);
		stDO.setFg_arclear(FBoolean.TRUE);
		stDO.setId_hp(null);
		stDO.setId_patca(this.enEntDO.getId_patca());
		stDO.setId_hpsttp(null);
		stDO.setSd_hpsttp(null);
		
		stDO.setStatus(DOStatus.NEW);
		
		IBlstoepCudService stService = ServiceFinder.find(IBlstoepCudService.class);
		stService.insert(new BlStOepDO[] { stDO });
	}
}
