package iih.bl.cg.s.bp.op;

import iih.bd.base.utils.MapUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.bliptfin.i.IBliptfinCudService;
import iih.bl.cg.dto.oeptoip.d.BlCgOepToIpCondDTO;
import iih.bl.cg.s.ep.BlCgItmOepTfRcdEP;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊费用转住院费用
 * @author ly 2019/03/12
 *
 */
public class BlOepCgTransferToIpCgBP {

	/**
	 * 门诊费用转住院费用
	 * @param condDto 转移条件
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(BlCgOepToIpCondDTO condDto,FBoolean flag) throws BizException{
		
		this.validate(condDto);
		
		String[] cgIds = (String[])condDto.getOepcgids().toArray(new String[0]);
		//校验是否已经转入
		this.validateExist(cgIds);
		
		//检索原门诊记账数据
		DAFacade daf = new DAFacade();
		List<BlCgItmOepDO> itmOepDOList = (List<BlCgItmOepDO>)daf.findByPKs(BlCgItmOepDO.class, cgIds);
		
		if(ListUtil.isEmpty(itmOepDOList) || itmOepDOList.size() != cgIds.length){
			throw new  BizException("门诊费用转住院费用:未检索到记账明细或记账明细与传入id数量不一致");
		}
	
		//可转移性校验
		this.validateCanTransfer(itmOepDOList);
		
		//获取记账主表数据
		Set<String> cgHdIdSet = new HashSet<String>();
		for (BlCgItmOepDO itmOepDO : itmOepDOList) {
			cgHdIdSet.add(itmOepDO.getId_cgoep());
		}
		List<BlCgOepDO> oepDOlist = (List<BlCgOepDO>)daf.findByPKs(BlCgOepDO.class, cgHdIdSet.toArray(new String[0]));
		Map<String,BlCgOepDO> oepDOMap = (Map<String,BlCgOepDO>)MapUtils.convertListToMap(oepDOlist, BlCgOepDO.ID_CGOEP);
		
		//查询就诊数据
		//修复隐藏bug：banner查出来的id_ent不是最新的住院的id_ent
		//所以需要根据门诊明细中id_pat查询住院id_ent
		IPativisitRService patisRService = ServiceFinder.find(IPativisitRService.class);
		String sql = String.format(" id_pat='%s' and code_entp='10' and fg_st='N' ", itmOepDOList.get(0).getId_pat());
		PatiVisitDO[] enDOs = patisRService.find(sql, " sv desc ", FBoolean.FALSE);
//		PatiVisitDO enDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, condDto.getId_ent(), new String[] {
//				PatiVisitDO.ID_PAT, PatiVisitDO.ID_ENT });
		if (enDOs==null || enDOs.length==0) {
			throw new BizException("该患者已结算，不能进行操作！");
		}
		FBoolean BLCG0045 = BlParams.BLCG0045();
		if(FBoolean.FALSE.equals(enDOs[0].getFg_ip()) && FBoolean.FALSE.equals(BLCG0045)){
			throw new BizException("该患者已出科，不能进行操作！");
		}
		//生成转移记录及住院记账数据
		List<BlCgItmOepTfRcdDO> tfRcdDOList = new ArrayList<BlCgItmOepTfRcdDO>();
		List<BlCgIpTfInDO> tfInDOList = new ArrayList<BlCgIpTfInDO>();
		
		FBoolean opFeeRtnAble = BlParams.BLSTOEP0042();
		
		String[] tfKeys = new DBUtil().getOIDs(itmOepDOList.size());
		
		for (int i = 0; i < itmOepDOList.size(); i++) {
			BlCgItmOepDO itmOepDO = itmOepDOList.get(i);
	
			BlCgItmOepTfRcdDO tfRcdDO = this.createTfRcdData(itmOepDO, enDOs[0], tfKeys[i], opFeeRtnAble);
			tfRcdDOList.add(tfRcdDO);
			
			if(!FBoolean.TRUE.equals(opFeeRtnAble)){
				BlCgIpTfInDO tfInDO = this.createTfIn(oepDOMap.get(itmOepDO.getId_cgoep()), itmOepDO, enDOs[0], tfKeys[i]);
				tfInDOList.add(tfInDO);	
			}
			
		}
		
		//保存数据
		IBlcgoeptfCudService tfService = ServiceFinder.find(IBlcgoeptfCudService.class);
		tfService.insert(tfRcdDOList.toArray(new BlCgItmOepTfRcdDO[0]));
		
		if(tfInDOList.size() > 0){
			IBliptfinCudService ipTfInService = ServiceFinder.find(IBliptfinCudService.class);
			ipTfInService.insert(tfInDOList.toArray(new BlCgIpTfInDO[0]));
		}
		
		if (FBoolean.TRUE.equals(flag)) {//是否真实转入
			OepCgTransferToIpCgRealBP bp = new OepCgTransferToIpCgRealBP();
			bp.exec(enDOs[0].getId_ent());
		}
	}

	/**
	 * 校验
	 * @param condDto
	 * @throws BizException
	 */
	private void validate(BlCgOepToIpCondDTO condDto) throws BizException{
		
		if(condDto == null){
			throw new BizException("门诊费用转住院费用:入参为空");
		}
		
		if(StringUtil.isEmpty(condDto.getId_ent())){
			throw new BizException("门诊费用转住院费用:入参就诊id为空");
		}
		
		if(condDto.getOepcgids() == null || condDto.getOepcgids().size() == 0){
			throw new BizException("门诊费用转住院费用:入参费用明细id为空");
		}
	}

	/**
	 * 已经转入校验
	 * @param cgIds
	 * @throws BizException
	 */
	private void validateExist(String[] cgIds) throws BizException{
		
		BlCgItmOepTfRcdEP ep = new BlCgItmOepTfRcdEP();
		BlCgItmOepTfRcdDO[] rcdDos = ep.getOepTfRcdByCgItmIds(cgIds);
	
		if(!ArrayUtil.isEmpty(rcdDos)){
			throw new  BizException("门诊费用转住院费用:当前选择费用已经转移");
		}
	}

	/**
	 * 可转入校验
	 * @param itmOepDOList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validateCanTransfer(List<BlCgItmOepDO> itmOepDOList) throws BizException{
		
		Set<String> stIdSet = new HashSet<String>();
		for (BlCgItmOepDO itmOepDO : itmOepDOList) {
			
			if(StringUtil.isEmpty(itmOepDO.getId_stoep())){
				throw new BizException("门诊费用转住院费用:未结算记账数据无法转移");
			}
			
			stIdSet.add(itmOepDO.getId_stoep());
		}
		
		//校验结算数据
		DAFacade daf = new DAFacade();
		List<BlStOepDO> stDOList = (List<BlStOepDO>)daf.findByPKs(BlStOepDO.class, stIdSet.toArray(new String[0]),
				new String[] { BlStOepDO.ID_STOEP, BlStOepDO.CODE_ST, BlStOepDO.FG_CANC, BlStOepDO.ID_PAYPATOEP });
		
		for (BlStOepDO blStOepDO : stDOList) {
		
			if(StringUtil.isEmpty(blStOepDO.getId_paypatoep())){
				throw new BizException("门诊费用转住院费用:未进行收付款的记账无法转移");
			}
		
			if(FBoolean.TRUE.equals(blStOepDO.getFg_canc())){
				throw new BizException("门诊费用转住院费用:已经取消结算的记账数据无法转移");
			}
		}
	}

	/**
	 * 组装门诊记账转移记录数据 
	 * @param itmOepDO
	 * @param enDO
	 * @param cgIpId
	 * @param opFeeRtnAble
	 * @return
	 */
	private BlCgItmOepTfRcdDO createTfRcdData(BlCgItmOepDO itmOepDO, PatiVisitDO enDO, String cgIpId, FBoolean opFeeRtnAble) {
		
		BlCgItmOepTfRcdDO rcdDO = new BlCgItmOepTfRcdDO();
		rcdDO.setId_grp(Context.get().getGroupId());
		rcdDO.setId_org(Context.get().getOrgId());
		rcdDO.setId_pat(enDO.getId_pat());
		rcdDO.setId_ent_tf(enDO.getId_ent());
		rcdDO.setId_cgitmoep(itmOepDO.getId_cgitmoep());
		rcdDO.setId_cgtfin(cgIpId);
		rcdDO.setDt_tf(BlFlowContextUtil.getNowTime());
		rcdDO.setId_dep_tf(Context.get().getDeptId());
		rcdDO.setId_emp_tf(Context.get().getStuffId());
		rcdDO.setFg_active(FBoolean.TRUE);
		rcdDO.setFg_realtf(opFeeRtnAble);
		rcdDO.setFg_tl(FBoolean.FALSE);
		rcdDO.setStatus(DOStatus.NEW);
		
		return rcdDO;
	}
	
	/**
	 * 组装门诊转住院费用数据
	 * @param condDto
	 * @param blCgOepDO
	 * @param itmOepDO
	 * @return
	 */
	private BlCgIpTfInDO createTfIn(BlCgOepDO blCgOepDO, BlCgItmOepDO itmOepDO, PatiVisitDO enDO, String cgIpId) {
		
		BlCgIpTfInDO tfInDO = new BlCgIpTfInDO();
		tfInDO.setId_cgip_tfin(cgIpId);
		tfInDO.setId_grp(Context.get().getGroupId());
		tfInDO.setId_org(Context.get().getOrgId());
		tfInDO.setId_ent_tf(enDO.getId_ent());
		tfInDO.setId_pat(enDO.getId_pat());
		tfInDO.setId_pres(itmOepDO.getId_pres());
		tfInDO.setId_or(itmOepDO.getId_or());
		tfInDO.setId_orsrv(itmOepDO.getId_orsrv());
		tfInDO.setId_srvtp(itmOepDO.getId_srvtp());
		tfInDO.setSd_srvtp(itmOepDO.getSd_srvtp());
		tfInDO.setId_srvca(itmOepDO.getId_srvca());
		tfInDO.setId_srv(itmOepDO.getId_srv());
		tfInDO.setCode_srv(itmOepDO.getCode_srv());
		tfInDO.setName_srv(itmOepDO.getName_srv());
		tfInDO.setSrvu(itmOepDO.getSrvu());
		tfInDO.setPrice(itmOepDO.getPrice());
		tfInDO.setPrice_ratio(itmOepDO.getPrice_ratio());
		tfInDO.setRatio_pripat(itmOepDO.getRatio_pripat());
		tfInDO.setQuan(itmOepDO.getQuan());
		tfInDO.setAmt(itmOepDO.getAmt());
		tfInDO.setAmt_std(itmOepDO.getAmt_std());
		tfInDO.setAmt_pat(itmOepDO.getAmt_pat());
		tfInDO.setAmt_hp(itmOepDO.getAmt_hp());
		tfInDO.setAmt_ratio(itmOepDO.getAmt_ratio());
		tfInDO.setDt_or(itmOepDO.getDt_or());
		tfInDO.setId_dep_or(itmOepDO.getId_dep_or());
		tfInDO.setId_emp_or(itmOepDO.getId_emp_or());
		tfInDO.setId_dep_mp(itmOepDO.getId_dep_mp());
		tfInDO.setFg_mm(itmOepDO.getFg_mm());
		tfInDO.setId_mm(itmOepDO.getId_mm());
		tfInDO.setId_mmtp(itmOepDO.getId_mmtp());
		tfInDO.setSd_mmtp(itmOepDO.getSd_mmtp());
		tfInDO.setCode_mm(itmOepDO.getCode_mm());
		tfInDO.setName_mm(itmOepDO.getName_mm());
		tfInDO.setOnlycode(itmOepDO.getOnlycode());
		tfInDO.setSpec(itmOepDO.getSpec());
		tfInDO.setCd_batch(itmOepDO.getCd_batch());
		tfInDO.setId_pkgu_cur(itmOepDO.getPgku_cur());
		tfInDO.setId_pkgu_base(itmOepDO.getPgku_base());
		tfInDO.setFactor(itmOepDO.getFactor());
		tfInDO.setId_emp_cg(blCgOepDO.getId_emp_cg());
		tfInDO.setId_dep_cg(blCgOepDO.getId_dep_cg());
		tfInDO.setDt_cg(blCgOepDO.getDt_cg());
		tfInDO.setFg_st_tf(FBoolean.FALSE);
		tfInDO.setFg_hp_tf(FBoolean.FALSE);
		tfInDO.setStatus(DOStatus.NEW);
		
		return tfInDO;
	}
}
