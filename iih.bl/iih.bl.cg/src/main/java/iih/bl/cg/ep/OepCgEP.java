package iih.bl.cg.ep;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门急诊记账EP
 * 
 * @author yankan
 * @since 2017-06-19
 *
 */
public class OepCgEP {

	/**
	 * 红冲门诊记账表，且修改原记账表
	 * 
	 * @param orgin_blcgoepAggDO1
	 *            原记账数据
	 * @param strDateTime
	 *            记账时间
	 * @param operatorInfoDTO
	 *            操作人
	 * @param AllRefundAndAllCharge
	 *            是否重收
	 * @param AllRefund
	 *            是否全退
	 * @param red_idStOep
	 *            红冲支付数据
	 * @return
	 * @throws BizException
	 */
	public BlcgoepAggDO[] redBack_CgOep(BlcgoepAggDO[] orgin_blcgoepAggDO1, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO, FBoolean AllRefundAndAllCharge, FBoolean AllRefund, String red_idStOep) throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();

		List<String> id_orsrv = new ArrayList<String>();

		List<BlcgoepAggDO> blcgoepAggDOList = new ArrayList<BlcgoepAggDO>();
		//急诊留观重收记账数据 by lim 2019-03-13
		List<BlcgoepAggDO> reBlcgoepAggDOList = new ArrayList<BlcgoepAggDO>();
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		//是否急诊留观
		FBoolean bStEt=FBoolean.FALSE; FBoolean bIpPreSt = FBoolean.FALSE;
		//是否门诊真实转入住院
		FBoolean istf = FBoolean.FALSE;
		// 更改原bl_cg_itm_oep中的fg_refund为Y
		for (BlcgoepAggDO agg : orgin_blcgoepAggDO1) {
			agg.getParentDO().setStatus(DOStatus.UPDATED);
			BlCgItmOepDO[] blCgItmOepDOarr = agg.getBlCgItmOepDO();
			
			//退费考虑门诊费用插入住院费用的情况
			List<String> idList = new ArrayList<String>();
			for(int a=0;a<blCgItmOepDOarr.length;a++){
				if (iih.bd.base.utils.StringUtils.isNotEmpty(blCgItmOepDOarr[a].getId_cgitmoep())) {
					idList.add(blCgItmOepDOarr[a].getId_cgitmoep());
				}
			}
			BlCgItmOepTfRcdDO[] blCgItmOepTfRcdDOs = getOepTfItmInfo(idList);
			if (blCgItmOepTfRcdDOs!=null && blCgItmOepTfRcdDOs.length>0) {
				istf = FBoolean.TRUE;
			}

			for (BlCgItmOepDO blCgItmOepdo : blCgItmOepDOarr) {
				//判断是不是急诊留观
				if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(blCgItmOepdo.getCode_enttp())){
					bStEt=FBoolean.TRUE;
				}
				// 判断是不是预住院结算
				if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(blCgItmOepdo.getCode_enttp())){
					bIpPreSt = FBoolean.TRUE;
				}
				blCgItmOepdo.setFg_refund(FBoolean.TRUE);
				blCgItmOepdo.setStatus(DOStatus.UPDATED);
			}

		}

		BlcgoepAggDO[] r_blcgoepAggDO = iBlcgoepCudService.save(orgin_blcgoepAggDO1);
		if (null == r_blcgoepAggDO || r_blcgoepAggDO.length == 0) {
			throw new BizException("修改原门诊记账信息失败");
		}

		FBoolean repireCiSdSuBl = FBoolean.FALSE; // 原样红冲数据时，是否需要修改医嘱记账状态
		if (!AllRefundAndAllCharge.booleanValue() && AllRefund.booleanValue()) // (不是重划重收，但是全退)，那么只存在红冲的数据，因此需要修改医嘱医嘱状态
		{
			repireCiSdSuBl = FBoolean.TRUE;
		}
		
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] strings = iBillcodeManage.getBatchBillCodes_RequiresNew(BlCgOepDODesc.CLASS_FULLNAME,new BlCgOepDO(), r_blcgoepAggDO.length*2);
		int nIndex = 0;
		
		long start_all = System.currentTimeMillis(); // 获取开始时间
		// 红冲原纪录
		for (int i = 0; i < r_blcgoepAggDO.length; i++) {
			BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
			//重收记账数据
			BlcgoepAggDO reBlcgoepAggDO = new BlcgoepAggDO();
			BlCgOepDO reBlCgOepDO = (BlCgOepDO) r_blcgoepAggDO[i].getParentDO().clone();
			reBlCgOepDO.setId_cgoep(null);
			reBlCgOepDO.setCode_cg(strings[nIndex++]);
			reBlCgOepDO.setStatus(DOStatus.NEW);
			
			BlCgOepDO blCgOepDO = (BlCgOepDO) r_blcgoepAggDO[i].getParentDO().clone();
			blCgOepDO.setId_cgoep(null);
			blCgOepDO.setId_org(operatorInfoDTO.getId_org());
			blCgOepDO.setId_grp(operatorInfoDTO.getId_grp());
			blCgOepDO.setCode_cg(code_ins.GetCodeBlCgOep());
			blCgOepDO.setId_dep_cg(operatorInfoDTO.getId_dep());
			blCgOepDO.setId_org_cg(operatorInfoDTO.getId_org_emp());
			blCgOepDO.setId_emp_cg(operatorInfoDTO.getId_emp());
			blCgOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
			blCgOepDO.setDt_cg(strDateTime);
			blCgOepDO.setStatus(DOStatus.NEW);
			BlCgItmOepDO[] blCgItmOepDOs = (BlCgItmOepDO[]) r_blcgoepAggDO[i].getBlCgItmOepDO();
			BlCgItmOepDO[] new_blCgItmOepDOs = new BlCgItmOepDO[blCgItmOepDOs.length];
			List<BlCgItmOepDO> reBlCgItmOepDOs= new ArrayList<BlCgItmOepDO>();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				//急诊留观重收收费明细
				BlCgItmOepDO reBlCgItmOepDO = (BlCgItmOepDO) blCgItmOepDOs[j].clone();
				reBlCgItmOepDO.setId_cgitmoep(null);
				reBlCgItmOepDO.setId_cgoep(null);
				reBlCgItmOepDO.setFg_st(FBoolean.FALSE);
				reBlCgItmOepDO.setId_stoep(null);
				reBlCgItmOepDO.setDt_st(null);
				reBlCgItmOepDO.setFg_susp(FBoolean.FALSE);
				reBlCgItmOepDO.setFg_refund(FBoolean.FALSE);
				reBlCgItmOepDO.setStatus(DOStatus.NEW);
				reBlCgItmOepDOs.add(reBlCgItmOepDO);
				
				BlCgItmOepDO new_BlCgItmOepDO = (BlCgItmOepDO) blCgItmOepDOs[j].clone();
				if (repireCiSdSuBl.booleanValue()) // 需要修改医嘱记账状态
				{
					if (blCgItmOepDOs[j].getId_orsrv() != null) // CI产生的数据需要修改医嘱记账状态；但是就诊来的数据就不用修改医嘱状态
					{
						id_orsrv.add(blCgItmOepDOs[j].getId_orsrv());
					}
				}
				new_BlCgItmOepDO.setNote("退费：" + blCgItmOepDOs[j].getId_cgitmoep());
				new_BlCgItmOepDO.setId_par(blCgItmOepDOs[j].getId_cgitmoep());
				new_BlCgItmOepDO.setId_cgitmoep(null);
				new_BlCgItmOepDO.setId_cgoep(null);
				new_BlCgItmOepDO.setId_org(operatorInfoDTO.getId_org());
				new_BlCgItmOepDO.setId_grp(operatorInfoDTO.getId_grp());
				new_BlCgItmOepDO.setFg_st(FBoolean.TRUE);
				new_BlCgItmOepDO.setId_stoep(red_idStOep);
				new_BlCgItmOepDO.setDt_st(strDateTime);
				new_BlCgItmOepDO.setFg_hp(blCgItmOepDOs[j].getFg_hp());
				new_BlCgItmOepDO.setFg_susp(FBoolean.FALSE);
				new_BlCgItmOepDO.setFg_refund(FBoolean.FALSE);
				new_BlCgItmOepDO.setId_root(StringUtil.isEmpty(blCgItmOepDOs[j].getId_root()) ? blCgItmOepDOs[j].getId_cgitmoep() : blCgItmOepDOs[j].getId_root());
				new_BlCgItmOepDO.setStatus(DOStatus.NEW);
				new_blCgItmOepDOs[j] = new_BlCgItmOepDO;
			}
			blcgoepAggDO.setParentDO(blCgOepDO);
			blcgoepAggDO.setBlCgItmOepDO(new_blCgItmOepDOs);
			blcgoepAggDOList.add(blcgoepAggDO);
			
			//急诊留观重收记账数据
			reBlcgoepAggDO.setParentDO(reBlCgOepDO);
			reBlcgoepAggDO.setBlCgItmOepDO(reBlCgItmOepDOs.toArray(new BlCgItmOepDO[]{} ));
			reBlcgoepAggDOList.add(reBlcgoepAggDO);
		}
		long ent_all = System.currentTimeMillis(); // 获取结束时间
		long use_all = ent_all - start_all;
		System.out.println("程序运行时间_all： " + use_all + "ms");

		// 6. 保存红冲的记账信息
		BlcgoepAggDO[] red_blcgoepAggDO1 = iBlcgoepCudService.save(blcgoepAggDOList.toArray(new BlcgoepAggDO[] {}));
		if (null == red_blcgoepAggDO1 || red_blcgoepAggDO1.length == 0) {
			throw new BizException("保存红冲门诊记账信息失败");
		}

		//7.保存急诊留观重新记账数据
		if(FBoolean.TRUE.equals(bStEt) || FBoolean.TRUE.equals(bIpPreSt)){
			BlcgoepAggDO[] reBlcgoepAggDO = iBlcgoepCudService.save(reBlcgoepAggDOList.toArray(new BlcgoepAggDO[] {}));
			if (null == reBlcgoepAggDO || reBlcgoepAggDO.length == 0) {
				throw new BizException("保存急诊留观重收门诊记账信息失败");
			}	
		}
		
		//8.更新完留观重新记账记录之后，需要还原pi_pat_acc的锁定金额
		FDouble dAmt = new FDouble(0.00);String id_pat = "";  String id_ent = "";
		if(FBoolean.TRUE.equals(bStEt) || FBoolean.TRUE.equals(bIpPreSt))
		{
			for(int i= 0; i< reBlcgoepAggDOList.size(); i++)
			{
				BlcgoepAggDO temp = reBlcgoepAggDOList.get(i);
				if(id_pat.equals("")){
					id_pat = temp.getParentDO().getId_pat();
				}
				
				BlCgItmOepDO[] tempItm = temp.getBlCgItmOepDO();
				for(int j= 0; j<tempItm.length; j++)
				{
					if(id_ent.equals("")){
						id_ent = tempItm[j].getId_ent();
					}
					//if(tempItm[j].getFg_acc().equals(FBoolean.TRUE))
					dAmt = dAmt.add(tempItm[j].getAmt_ratio());
				}
			}
		}
		
		if(FBoolean.TRUE.equals(bStEt)){
			IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
			accDService.updatePatEtAccLock(id_pat, dAmt);
		}
		
		// 预住院退费之后，需要更新锁定金额
		if (FBoolean.TRUE.equals(bIpPreSt)) {
			updateEnAccountUnCg(id_ent, dAmt);
		}

		//如果是医嘱留观,不再更新医嘱状态
		if (FBoolean.FALSE.equals(istf)) {
			if (id_orsrv.size() > 0 && (FBoolean.FALSE.equals(bStEt)  || FBoolean.FALSE.equals(bIpPreSt)))// 更新医嘱记账信息
			{
				// 7.修改医嘱为退费状态
				Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
				((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(id_orsrv.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, strDateTime, FeeReverseType.BLSTREVERSE);
			}
		}
		
		return red_blcgoepAggDO1;
	}
	
	/**
	 * 更新住院账户的锁定金额
	 * @param id_ent
	 * @param dAmt
	 * @throws BizException
	 */
	private void updateEnAccountUnCg(String id_ent, FDouble dAmt) throws BizException {
		if(id_ent.isEmpty())
			return;
		
		IEnaccountMDORService accRService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] enAccArray = accRService.findByAttrValString(EnAccountDO.ID_ENT, id_ent);
		if (enAccArray != null && enAccArray.length == 1) {
			EnAccountDO enAccDo = enAccArray[0];
			enAccDo.setAmt_uncg(enAccDo.getAmt_uncg().add(dAmt));
			enAccDo.setStatus(DOStatus.UPDATED);

			IEnaccountMDOCudService accCudService = ServiceFinder.find(IEnaccountMDOCudService.class);
			accCudService.update(new EnAccountDO[] { enAccDo });
		}
	}

	/**
	 * 组装BlCgOepAggDTO，包括记账结果和记账对应的医保计划
	 * 
	 * @param blcgoepAggDOArr
	 * @param EntHpDOArr
	 * @return
	 */
	public BlCgOepAggDTO createBlCgOepAggDTO(BlcgoepAggDO[] blcgoepAggDOArr, EntHpDO[] EntHpDOArr) {
		BlCgOepAggDTO blCgOepAggDTO = new BlCgOepAggDTO();
		FArrayList blcgoepAggDOList = new FArrayList();
		FArrayList entHpDOList = new FArrayList();
		if (blcgoepAggDOArr != null) {
			for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDOArr) {
				blcgoepAggDOList.add(blcgoepAggDO1);
			}
		}
		if (EntHpDOArr != null) {
			for (EntHpDO entHpDO : EntHpDOArr) {
				entHpDOList.add(entHpDO);
			}
		}

		blCgOepAggDTO.setBlcgoepAggDO(blcgoepAggDOList);
		blCgOepAggDTO.setEntHpDO(entHpDOList);
		return blCgOepAggDTO;
	}
	
	/**
	 * 获取记账数据DTO
	 * 
	 * @param idEn就诊编号
	 * @param CgType获取数据类型
	 * @param idOrs医嘱信息
	 * @param idEmp当前用户
	 * @return
	 * @throws DAException
	 */
	public BlOrderAppendBillParamDTO[] getCgOrderDTO(String idEn, String cgType, String[] idOrs, String idEmp) throws DAException {

		StringBuilder sqlCg = new StringBuilder();
		sqlCg.append(" SELECT OEP.* ");
		sqlCg.append(" FROM BL_CG_ITM_OEP OEP ");
		sqlCg.append(" INNER JOIN CI_OR_SRV CISRV ON OEP.ID_ORSRV=CISRV.ID_ORSRV ");
		sqlCg.append(" INNER JOIN BL_CG_OEP CG on OEP.id_cgoep=CG.id_cgoep ");
		sqlCg.append(" where CISRV.FG_FEERTNABLE='Y' and CISRV.sd_su_bl='1' and OEP.fg_refund='N' and CG.eu_direct=1 and OEP.fg_st='N'");
		sqlCg.append(" and OEP.id_ent = ? ");
		//sqlCg.append(" and CG.id_emp_cg = ? ");
		sqlCg.append(" and OEP.fg_hpcg='N'"); // 需要排除高端商保
		SqlParam param = new SqlParam();
		param.addParam(idEn);
		//param.addParam(idEmp);

		if (!ArrayUtil.isEmpty(idOrs)) {
			sqlCg.append(" and " + SqlUtils.getInSqlByBigIds("OEP.ID_OR", idOrs));
		}
		switch (cgType) {
		case CgTypeEnum.CG_PREPAY:
			sqlCg.append(" and OEP.fg_acc='Y'");
			break;

		case CgTypeEnum.CG_HPCG:
			sqlCg.append(" and OEP.fg_hpcg='Y'");
			break;

		case CgTypeEnum.CG_RESEARCH:
			sqlCg.append(" and OEP.fg_research='Y'");
			break;

		default:
			break;
		}

		List<BlOrderAppendBillParamDTO> billDtoList = new ArrayList<BlOrderAppendBillParamDTO>();
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> itmOepDOsList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlCg.toString(), param, new BeanListHandler(BlCgItmOepDO.class));

		for (BlCgItmOepDO cgItmDo : itmOepDOsList) {
			BlOrderAppendBillParamDTO tmpFeeDo = new BlOrderAppendBillParamDTO();
			tmpFeeDo.setCode_enttp(cgItmDo.getCode_enttp());
			tmpFeeDo.setId_pat(cgItmDo.getId_pat());
			tmpFeeDo.setId_org(cgItmDo.getId_org());
			tmpFeeDo.setId_or(cgItmDo.getId_or());
			tmpFeeDo.setId_orsrv(cgItmDo.getId_orsrv());
			tmpFeeDo.setId_emp_cg(idEmp);
			billDtoList.add(tmpFeeDo);
		}

		return billDtoList.toArray(new BlOrderAppendBillParamDTO[billDtoList.size()]);
	}
	
	/**
	 * 处理门诊费用真实转住院费用退费校验逻辑
	 * @author zhang.hw
	 * @date 2020年3月25日
	 * @param idList
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepTfRcdDO[] getOepTfItmInfo(List<String> idList) throws BizException{
		//退费考虑门诊费用插入住院费用的情况
		IBlcgoeptfRService tfrService = ServiceFinder.find(IBlcgoeptfRService.class);
		String ids = "";
		for(int i=0;i<idList.size();i++){
			if (i==idList.size()-1) {
				ids = ids + "'"+idList.get(i)+"'";
			}else {
				ids = ids + "'"+idList.get(i)+"',";
			}
		}
		String sql = String.format(" id_cgitmoep in(%s) and fg_active='Y' and fg_realtf='Y' and fg_tl='Y' ", ids);
		return tfrService.find(sql, "", FBoolean.FALSE);
	}
}
