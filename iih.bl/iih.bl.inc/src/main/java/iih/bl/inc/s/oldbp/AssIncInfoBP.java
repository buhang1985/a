package iih.bl.inc.s.oldbp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import iih.bd.pp.inccasplit.i.IInccasplitRService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceHeadTailDTO;
import iih.bl.inc.blincquerydto.d.BlInvoicePmDTO;
import iih.bl.inc.blincquerydto.d.BlinvoicecaitmDTO;
import iih.bl.inc.blincquerydto.d.PatHpInfoDTO;
import iih.bl.params.BlParams;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.mp.dg.dto.d.OpPresQueSiteDTO;
import iih.mp.dg.i.IMpDgConst;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.mapping.DORsReferMap;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 组装发票数据
 * 
 * @author wq.li
 *
 */
public class AssIncInfoBP {

	public BlIncItmVsTypeDTO[] exec(BlStOepDO stOepDo, BlincoepAggDO[] incOepAggdoLst) throws BizException {

		IBlpaypatoepRService paypatOepService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO paypatOepAggdo = paypatOepService.findById(stOepDo.getId_paypatoep());
		FBoolean Fg_redInvoice = FBoolean.FALSE;
		if (stOepDo.getEu_direct() == -1) {
			Fg_redInvoice = FBoolean.TRUE;
		}
		return handlerIncInfoDtos(FBoolean.TRUE, Fg_redInvoice, stOepDo, incOepAggdoLst, paypatOepAggdo);

	}

	/**
	 * 返回打印发票需要的DTO信息
	 * 
	 * @param Fg_window
	 *            物品是否分窗口
	 * @param Fg_RedInvoice
	 *            是否是红冲票
	 * @param stOepDo
	 *            结算信息DO
	 * @param incOepAggdoLst
	 *            发票AGG
	 * @param payPatOepAggdo
	 *            收付款支付方式AGG
	 * @return 返回打印发票需要的DTO信息
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIncItmVsTypeDTO[] handlerIncInfoDtos(FBoolean Fg_window, FBoolean Fg_RedInvoice, BlStOepDO stOepDo,
			BlincoepAggDO[] incOepAggdoLst, BlpaypatoepAggDO payPatOepAggdo) throws BizException {
		if(ArrayUtil.isEmpty(incOepAggdoLst)){
			return new BlIncItmVsTypeDTO[]{};
		}
		// 1.组装数据
		// 该服务获取药品处方对应的发药窗口信息
		IMpDgOutService mpDgoutService = ServiceFinder.find(IMpDgOutService.class);
		List<BlIncItmVsTypeDTO> incInfoDtoLst = new ArrayList<BlIncItmVsTypeDTO>();
		// 获得价格分类
		String pripat_name = "";
		String sql = "select distinct b.name from bl_cg_itm_oep a inner join bd_pri_pat b on a.id_pripat=b.id_pripat where a.id_stoep='" + stOepDo.getId_stoep() + "'";
		DAFacade facade = new DAFacade();
		List<PriPatDO> priPatDOLst = (List<PriPatDO>) facade.execQuery(sql, new BeanListHandler(PriPatDO.class));
		if (priPatDOLst != null && priPatDOLst.size() > 0) {
			pripat_name = priPatDOLst.toArray(new PriPatDO[0])[0].getName();
		}
		// 获得开票人编号
		
		String emp_code = "";
		if (incOepAggdoLst[0].getParentDO().getId_emp_inc() != null) {
			PsnDocDO psnDO = this.getPsnData(incOepAggdoLst[0].getParentDO().getId_emp_inc());
			emp_code = psnDO.getCode();
		}

		// 获取一下医疗机构类型
		String hospitalType = BlParams.BLHP000001();
		for (BlincoepAggDO incOepAggdo : incOepAggdoLst) {
			BlIncOepDO incOepDo = incOepAggdo.getParentDO();
			// 储存处方和其对应的发药窗口
			FMap presVsWindowInfo = new FMap();
			// 创建发票DTO模型
			BlIncItmVsTypeDTO incInfoDto = new BlIncItmVsTypeDTO();
			PatHpInfoDTO patHpInfoDto = new PatHpInfoDTO();
			EntHpDO enthp = null;
			FArrayList incItmOepDoLst = new FArrayList();
			BlIncItmOepDO[] incItmDoLst = incOepAggdo.getBlIncItmOepDO();
			// 发票账单项
			for (BlIncItmOepDO incCaItmDo : incItmDoLst) {
				BlinvoicecaitmDTO incCaItmDto = new BlinvoicecaitmDTO();
				incCaItmDto.setAmt(incCaItmDo.getAmt().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
//				incCaItmDto.setAmt_pat(incCaItmDo.getAmt_pat().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_hp(incCaItmDo.getAmt_hp().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_ratio(incCaItmDo.getAmt_ratio().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_free(incCaItmDo.getAmt_free().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_std(incCaItmDo.getAmt_std().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setCode_inccam(incCaItmDo.getCode());
				incCaItmDto.setId_incitmoep(incCaItmDo.getId_incitmoep());
				incCaItmDto.setId_incoep(incCaItmDo.getId_incoep());
				incCaItmDto.setName_inccam(incCaItmDo.getName());
				incItmOepDoLst.add(incCaItmDto);
			}
			incInfoDto.setBlInvoicecaitmDTOLst(incItmOepDoLst);

			// 设置是否是医保结算
			FBoolean hasHpSettle = FBoolean.FALSE;

			// 根据获取当前结算的分摊信息 判断是否有分摊数据决定当前是否是医保结算 下方循环费用明细时判断如果是医保结算 并且是特病结算的话
			// 将医保结算给费false
			if (!StringUtil.isEmpty(stOepDo.getId_stoep())) {
				IBlproparoepRService propoepService = ServiceFinder.find(IBlproparoepRService.class);
				BlproparoepAggDO[] propOepDO = propoepService.find("ID_PROPOEP=(SELECT ID_PROPOEP FROM BL_PROP_OEP WHERE ROWNUM=1 AND ID_STOEP='" + stOepDo.getId_stoep() + "')", "", FBoolean.FALSE);
				if (propOepDO != null && propOepDO.length == 1 && !StringUtil.isEmpty(propOepDO[0].getParentDO().getId_hp())) {
					hasHpSettle = FBoolean.TRUE;
				}
			}

			// 发票收费明细项目的数据组装
			// 查找该发票对应的费用明细,这里需考虑分票的情况
			// 下面的sql是查询BL_CG_ITM_OEP的所有字段,并把NAME_MM换成bd_mm中的peint_name
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT A.ID_CGITMOEP,A.ID_GRP,A.ID_ORG,A.ID_PAT,A.ID_CGOEP,A.ID_ENT,A.ID_ENTTP,A.CODE_ENTTP,A.ID_PRES,A.ID_OR,A.ID_ORSRV,A.ID_SRVTP,A.SD_SRVTP,A.ID_SRVCA,A.ID_SRV,A.CODE_SRV,A.NAME_SRV,A.SRVU,A.PRICE,A.QUAN,A.AMT,A.RATIO_PRIPAT,A.AMT_STD,A.ID_PRIPAT,A.AMT_PAT,A.ID_HPSRVTP,A.SD_HPSRVTP,A.ID_HP,A.RATIO_HP,A.AMT_HP,A.FG_ACC,A.AMT_ACC,A.AMT_RATIO,A.DT_OR,A.ID_ORG_OR,A.ID_DEP_OR,A.ID_EMP_OR,A.ID_ORG_MP,A.ID_DEP_MP,A.ID_DEP_WH,A.FG_MM,A.ID_MM,A.ID_MMTP,A.SD_MMTP,A.CODE_MM,A.ONLYCODE,A.SPEC,A.CD_BATCH,A.PGKU_BASE,A.PGKU_CUR,A.FACTOR,A.QUAN_BASE,A.PRI_SS,A.FG_ST,A.ID_STOEP,A.DT_ST,A.FG_HP,A.FG_SUSP,A.ID_PAR,A.EU_SRCTP,A.NOTE,A.FG_REFUND,A.FG_ADDITM,A.APPRNO,A.ID_RECG_OEP,A.FG_RECG,A.DT_SRV,A.SRCFUNC_DES,A.DS,A.SV,A.CODE_INCCAITM,A.NAME_INCCAITM,A.FG_FREE,A.CODE_APPLY,A.PRICE_RATIO,A.SD_ABRD,A.FG_HPCG,A.FG_PRICINGINSERTCG,A.CODE_APPLYTP,A.ID_HPSRVMPAYRATIO,A.FG_ZEROREG,A.ROWID");
			sb.append(",mm.printname name_mm, ");
			sb.append("depor.name as Depor_name, ");
			sb.append("psn.name   as Empor_name,");
			sb.append("depmp.name as Depmp_name, ");
			sb.append("srvmeasdoc.name srvu_name, ");
			sb.append("mmmeasdoc.name pgku_cur_name ");
			sb.append("FROM BL_CG_ITM_OEP A");
			sb.append(" INNER JOIN BL_INC_CG_ITM_OEP B");
			sb.append(" ON A.ID_CGITMOEP=B.ID_CGITMOEP");
			sb.append(" left join bd_mm mm on mm.id_mm=A.id_mm ");
			sb.append(" left join bd_dep depor on a.id_dep_or=depor.id_dep ");
			sb.append(" left join bd_dep depmp on a.id_dep_mp=depmp.id_dep ");
			sb.append(" left join bd_psndoc psn on a.id_emp_or=psn.id_psndoc  ");
			sb.append(" left join bd_measdoc srvmeasdoc on A.srvu=srvmeasdoc.id_measdoc  ");
			sb.append(" left join bd_measdoc mmmeasdoc on A.pgku_cur=mmmeasdoc.id_measdoc  ");
			sb.append(" WHERE A.ID_STOEP=? AND B.ID_INCOEP=?");
			SqlParam param = new SqlParam();
			param.addParam(incOepAggdo.getParentDO().getId_stoep());
			param.addParam(incOepAggdo.getParentDO().getId_incoep());

			@SuppressWarnings("unchecked")
			List<BlCgItmOepDO> cgItmOepDoLst = (List<BlCgItmOepDO>) facade.execQuery(sb.toString(), param, new BeanListHandler(BlCgItmOepDO.class));
			
			//票据明细
			FArrayList invoiceDetailDtoLst = new FArrayList();

			//不需要合并的费用明细
			List<BlCgItmOepDO> noHandleCgItmList=new ArrayList<BlCgItmOepDO>();
			//需合并的费用明细
			Map<String,List<BlCgItmOepDO>> cgItmMap=new HashMap<String,List<BlCgItmOepDO>>();
			//需要合并的医嘱
			Map<String, CiOrderDO> asoneOrMap =new HashMap<String, CiOrderDO>();
			//需要单独显示的账单项
			Set<String> incCodeSet = new HashSet<String>();
			
			//1.查询分票逻辑
			BdInccaSplitDO splitDo=this.getSplitSet();
			
			//2.判断对费用明细是否需要特殊处理
			if(isOrderAsOneWhenDetailShow(splitDo)){
				//明细模式医嘱按照一条显示，需要特殊处理
				List<String> orList = new ArrayList<String>();
				for (BlCgItmOepDO cgItm : cgItmOepDoLst) {
					if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
						orList.add(cgItm.getId_or());
					}
				}
			
				asoneOrMap = judgeAsOneOrder(orList, splitDo.getSd_disp_ci_srvtp());
			
			
				for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
					if(asoneOrMap.containsKey(cgItmOepDo.getId_or())){//需要合并
						if(cgItmMap.containsKey(cgItmOepDo.getId_or())){
							List<BlCgItmOepDO> cgItmList=cgItmMap.get(cgItmOepDo.getId_or());
							cgItmList.add(cgItmOepDo);
						}else{
							List<BlCgItmOepDO> cgItmList=new ArrayList<BlCgItmOepDO>();
							cgItmList.add(cgItmOepDo);
							cgItmMap.put(cgItmOepDo.getId_or(), cgItmList);
						}
					}else{//不需要合并
						noHandleCgItmList.add(cgItmOepDo);
					}
				}
			
			}else if (this.isIncitmWhenDetailShow(splitDo)){
			
				List<String> inccaItmList = new ArrayList<String>();
				inccaItmList.addAll(Arrays.asList(splitDo.getSd_disp_incitm().split(",")));
				
				for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
				
					if(inccaItmList.contains(cgItmOepDo.getCode_inccaitm())){
						incCodeSet.add(cgItmOepDo.getCode_inccaitm());
					}else{
						noHandleCgItmList.add(cgItmOepDo);
					}
				}
				
			}else if(this.isIncitmAndOrdWhenDetailShow(splitDo)){
				
				List<String> orList = new ArrayList<String>();
				for (BlCgItmOepDO cgItm : cgItmOepDoLst) {
					if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
						orList.add(cgItm.getId_or());
					}
				}
			
				asoneOrMap = judgeAsOneOrder(orList, splitDo.getSd_disp_ci_srvtp());
				
				List<String> inccaItmList = new ArrayList<String>();
				if(!StringUtil.isEmpty(splitDo.getSd_disp_incitm())){
					inccaItmList.addAll(Arrays.asList(splitDo.getSd_disp_incitm().split(",")));
				}
			
				for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
					if(asoneOrMap.containsKey(cgItmOepDo.getId_or())){//需要合并
						if(cgItmMap.containsKey(cgItmOepDo.getId_or())){
							List<BlCgItmOepDO> cgItmList=cgItmMap.get(cgItmOepDo.getId_or());
							cgItmList.add(cgItmOepDo);
						}else{
							List<BlCgItmOepDO> cgItmList=new ArrayList<BlCgItmOepDO>();
							cgItmList.add(cgItmOepDo);
							cgItmMap.put(cgItmOepDo.getId_or(), cgItmList);
						}
					}else if(inccaItmList.contains(cgItmOepDo.getCode_inccaitm())){
						incCodeSet.add(cgItmOepDo.getCode_inccaitm());
					}else{//不需要合并
						noHandleCgItmList.add(cgItmOepDo);
					}
				}
			}else{
				noHandleCgItmList.addAll(cgItmOepDoLst);
			}
			//把不需要特殊处理记账明细组装成票据明细
			/*********************************组装开始**********************/
			List<String> noHps = new ArrayList<String>();
			for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
				if (FBoolean.TRUE.equals(hasHpSettle) && FBoolean.TRUE.equals(cgItmOepDo.getFg_specill())) {
					hasHpSettle = FBoolean.FALSE;
				}
				BlInvoiceDetailsDTO invoiceSrvDetail = new BlInvoiceDetailsDTO();
				invoiceSrvDetail.setAmt(cgItmOepDo.getAmt().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setAmt_pat(cgItmOepDo.getAmt_pat().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setAmt_ratio(cgItmOepDo.getAmt_ratio().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setAmt_std(cgItmOepDo.getAmt_std().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setCode_inccaitm(cgItmOepDo.getCode_inccaitm());
				invoiceSrvDetail.setFg_free(cgItmOepDo.getFg_free());
				invoiceSrvDetail.setFg_mm(cgItmOepDo.getFg_mm());
				invoiceSrvDetail.setId_hp(cgItmOepDo.getId_hp());
				invoiceSrvDetail.setHpsrvtp(cgItmOepDo.getSd_hpsrvtp());
				invoiceSrvDetail.setId_cgoep(cgItmOepDo.getId_cgoep());
				invoiceSrvDetail.setId_mm(cgItmOepDo.getId_mm());
				invoiceSrvDetail.setId_srv(cgItmOepDo.getId_srv());
				invoiceSrvDetail.setCode_srv(cgItmOepDo.getCode_srv());
				invoiceSrvDetail.setEu_srctp(cgItmOepDo.getEu_srctp());
				invoiceSrvDetail.setName_inccaitm(cgItmOepDo.getName_inccaitm());
				invoiceSrvDetail.setFg_window(FBoolean.FALSE);// 是否需要设置领药窗口
				//增加开单科室  执行科室  开立医生  打发票用  by lim 2018-04-24
				invoiceSrvDetail.setName_dep_or(cgItmOepDo.getDepor_name());
				invoiceSrvDetail.setName_dep_mp(cgItmOepDo.getDepmp_name());
				invoiceSrvDetail.setName_emp_or(cgItmOepDo.getEmpor_name());
				invoiceSrvDetail.setId_dep_or(cgItmOepDo.getId_dep_or());
				invoiceSrvDetail.setId_emp_or(cgItmOepDo.getId_emp_or());
				invoiceSrvDetail.setId_dep_mp(cgItmOepDo.getId_dep_mp());
				//单位
				if(FBoolean.TRUE.equals(cgItmOepDo.getFg_mm())){
					invoiceSrvDetail.setSrvu(cgItmOepDo.getPgku_cur_name());
				}
				else{
					// 单位名称
					invoiceSrvDetail.setSrvu(cgItmOepDo.getSrvu_name());
				}
					
				// 得到社保号
				//String no_hp = this.getPatHpDOByIds(cgItmOepDo.getId_pat(), cgItmOepDo.getId_hp());
				enthp = this.getEntHpDo(cgItmOepDo.getId_ent(), cgItmOepDo.getId_hp());
				String no_hp = enthp != null ?enthp.getNo_hp() : "";
				noHps.add(no_hp);
				patHpInfoDto.setHp_code(no_hp);
				
				String patCa = null;
				if(!ListUtil.isEmpty(cgItmOepDoLst)){
					String id_ent = null;
					for (BlCgItmOepDO itm : cgItmOepDoLst) {
						if(!StringUtil.isEmpty(itm.getId_ent())){
							id_ent = itm.getId_ent();
							break;
						}
					}
					if(!StringUtil.isEmpty(id_ent)){
						StringBuffer hpSql = new StringBuffer();
						hpSql.append(" select  c.name  as  Id_paticate_name ");
						hpSql.append("     from  en_ent  b ");
						hpSql.append("   left  join  pi_pat_ca  c ");
						hpSql.append("         on  c.id_patca  =  b.id_patca ");
						hpSql.append("   where  b.id_ent=? ");
						SqlParam hpParam = new SqlParam();
						hpParam.addParam(id_ent);
						
						patCa = (String) facade.execQuery(hpSql.toString(), hpParam,new ColumnHandler());
					}
				}
				patHpInfoDto.setId_paticate_name(patCa);
				
				// 为医保类型字段赋值
				// 获得医保类型
				String name_hptp = "";
				String strsql = "select udi.name as name_hptp,hp.id_hptp ,hp.id_hp  from  bd_hp  hp join  bd_udidoc  udi on  hp.id_hptp = udi.id_udidoc where  udi.id_udidoclist='@@@@ZZ200000000000A2' and hp.id_hp ='"
						+ cgItmOepDo.getId_hp() + "'";
				DAFacade dafacade = new DAFacade();
				@SuppressWarnings("unchecked")
				List<HPDO> hpDOLst = (List<HPDO>) dafacade.execQuery(strsql, new BeanListHandler(HPDO.class));
				if (hpDOLst != null && hpDOLst.size() > 0) {
					name_hptp = hpDOLst.toArray(new HPDO[0])[0].getName_hptp();
					
				}
				invoiceSrvDetail.setHp_name(name_hptp);
				patHpInfoDto.setHp_psntype(name_hptp);
				if (cgItmOepDo.getFg_mm().booleanValue()) {
					invoiceSrvDetail.setName_srv(cgItmOepDo.getName_mm());
					if (Fg_window.booleanValue() && !StringUtil.isEmpty(cgItmOepDo.getId_dep_wh())) {
						invoiceSrvDetail.setFg_window(Fg_window);
						// 获取医保上传药品名称类型
						//String drugName = BlParamUtils.getHpUploadDrugNameType();
						// 根据参数 药品显示商品名还是通用名
						// if(drugName.equals(EuHpDrugNameType.MMNAME)){//商品名
						// invoiceSrvDetail.setName_srv(cgItmOepDo.getName_mm());
						// }else
						// if(drugName.equals(EuHpDrugNameType.SRVNAME)){//通用名
						// invoiceSrvDetail.setName_srv(cgItmOepDo.getName_srv());
						// }
						//invoiceSrvDetail.setName_srv(cgItmOepDo.getName_mm());
						// 获取窗口信息
						// 获取窗口信息（如果是留观，则不需要获取窗口信息）by xuebei 20190509
						if (!IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(cgItmOepDo.getCode_enttp())) {
						if (presVsWindowInfo.containsKey(cgItmOepDo.getId_pres())) {
							if (presVsWindowInfo.get(cgItmOepDo.getId_pres()) != null) {
								invoiceSrvDetail.setWindowinfo(presVsWindowInfo.get(cgItmOepDo.getId_pres()).toString());
							}
						} else {
							String name_wh = "";// 药房名称
							String ssql = " select dep.name as def10  from  ci_pres  pres join  bd_dep  dep on  pres.id_dep_mp = id_dep   where pres.id_pres = '" + cgItmOepDo.getId_pres() + "'";
							DAFacade cade = new DAFacade();
							@SuppressWarnings("unchecked")
							List<CiPresDO> presDOLst = (List<CiPresDO>) cade.execQuery(ssql, new BeanListHandler(CiPresDO.class));
							if (presDOLst != null && presDOLst.size() > 0) {
								name_wh = presDOLst.toArray(new CiPresDO[0])[0].getDef10();
							}
							// 如果是商保记账 或预交金记账 则在医嘱记账时已经分发了窗口号，这里需调用取窗口号接口
							//if (cgItmOepDo.getFg_hpcg().booleanValue() || cgItmOepDo.getFg_acc().booleanValue()) {
								FMap mapWindow = mpDgoutService.getQueSiteNameOfPres(new String[] { cgItmOepDo.getId_pres() }); // 其返回结果为map，
																																// key:处方id
																																// value:窗口名称（多个时用逗号分隔）
								String strWinInfo = (String) mapWindow.get(cgItmOepDo.getId_pres());
								strWinInfo = name_wh + strWinInfo;// 将取药窗口信息拼成
																	// 执行科室名称+窗口号的形式
								if (!presVsWindowInfo.containsKey(cgItmOepDo.getId_pres()))
									presVsWindowInfo.put(cgItmOepDo.getId_pres(), strWinInfo);
								// 获取并设置窗口名称
								invoiceSrvDetail.setWindowinfo(presVsWindowInfo.get(cgItmOepDo.getId_pres()).toString());
							/*} else {
								// 调用分窗口号接口
								OpPresQueSiteDTO opPresQueSiteDTO = mpDgoutService.insertPresWindowData(cgItmOepDo.getId_pres(), IMpDgConst.ENTRY_AFTER_CHARGE);
								if (opPresQueSiteDTO != null) {
									if (!presVsWindowInfo.containsKey(cgItmOepDo.getId_pres()))
										// 有些药是不需要发药窗口的，例如在院执行的
										presVsWindowInfo.put(cgItmOepDo.getId_pres(), name_wh + opPresQueSiteDTO.getName_quesite());
									// 获取并设置窗口名称
									invoiceSrvDetail.setWindowinfo(presVsWindowInfo.get(cgItmOepDo.getId_pres()).toString());
									}
								}*/
							}
						}	
					} 
				}else {
					invoiceSrvDetail.setName_srv(cgItmOepDo.getName_srv());
				}

				invoiceSrvDetail.setPrice(cgItmOepDo.getPrice());
				invoiceSrvDetail.setPrice_ratio(cgItmOepDo.getPrice_ratio());
				invoiceSrvDetail.setQuan(cgItmOepDo.getQuan());
				// 规格
				invoiceSrvDetail.setSpec_srv(cgItmOepDo.getSpec());
				
				if(asoneOrMap.containsKey(cgItmOepDo.getId_or()) || incCodeSet.contains(cgItmOepDo.getCode_inccaitm()))
					continue;
				
				invoiceDetailDtoLst.add(invoiceSrvDetail);
			}// 明细项组装完成
			/****************************组装结束*********************************/
			

			//把医嘱相应的记账明细进行合并,组装成一条票据明细
			if(cgItmMap != null && cgItmMap.size() > 0){
				for (Entry entry : cgItmMap.entrySet()) {
					List<BlCgItmOepDO> itmList=(List<BlCgItmOepDO>)entry.getValue();
					FDouble amt_ratio=FDouble.ZERO_DBL;
					FDouble amt=FDouble.ZERO_DBL;
					FDouble amt_std=FDouble.ZERO_DBL;
					FDouble amt_pat=FDouble.ZERO_DBL;
					for (BlCgItmOepDO blCgItmOepDO : itmList) {
						amt_ratio=amt_ratio.add(blCgItmOepDO.getAmt_ratio().multiply(incOepDo.getEu_direct()));
						amt=amt.add(blCgItmOepDO.getAmt().multiply(incOepDo.getEu_direct()));
						amt_std=amt_std.add(blCgItmOepDO.getAmt_std().multiply(incOepDo.getEu_direct()));
						amt_pat=amt_pat.add(blCgItmOepDO.getAmt_std().multiply(incOepDo.getEu_direct()));
					}
					BlInvoiceDetailsDTO invoiceSrvDetail = new BlInvoiceDetailsDTO();
					invoiceSrvDetail.setAmt(amt.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setAmt_pat(amt_pat.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setAmt_ratio(amt_ratio.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setAmt_std(amt_std.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setEu_srctp(0);
					CiOrderDO orDo=asoneOrMap.get(entry.getKey());
					if(orDo!=null){
						invoiceSrvDetail.setName_srv(orDo.getName_or());
						if(itmList.size() > 1){
							invoiceSrvDetail.setQuan(FDouble.ONE_DBL);
							invoiceSrvDetail.setPrice_ratio(invoiceSrvDetail.getAmt_ratio());
						}else{
							invoiceSrvDetail.setQuan(itmList.get(0).getQuan());
							invoiceSrvDetail.setPrice_ratio(itmList.get(0).getPrice_ratio());
						}
					}
					invoiceDetailDtoLst.add(invoiceSrvDetail);
				}
			}
			
			if(incCodeSet.size() > 0){
				
				for (String code : incCodeSet) {
					
					BlinvoicecaitmDTO incCaItmDto = null;
					for (int i = 0; i < incInfoDto.getBlInvoicecaitmDTOLst().size(); i++) {
						
						BlinvoicecaitmDTO incCaItmDto2 = (BlinvoicecaitmDTO)incInfoDto.getBlInvoicecaitmDTOLst().get(i);
						if(code.equals(incCaItmDto2.getCode_inccam())){
							incCaItmDto = incCaItmDto2;
							break;
						}
					}
					
					if(incCaItmDto != null){
						
						BlInvoiceDetailsDTO invoiceSrvDetail = new BlInvoiceDetailsDTO();
						invoiceSrvDetail.setAmt(incCaItmDto.getAmt());
						invoiceSrvDetail.setAmt_pat(incCaItmDto.getAmt_pat());
						invoiceSrvDetail.setAmt_ratio(incCaItmDto.getAmt_ratio());
						invoiceSrvDetail.setAmt_std(incCaItmDto.getAmt_std());
						invoiceSrvDetail.setEu_srctp(0);
						invoiceSrvDetail.setName_srv(incCaItmDto.getName_inccam());
						invoiceSrvDetail.setQuan(FDouble.ONE_DBL);
						invoiceSrvDetail.setPrice_ratio(invoiceSrvDetail.getAmt_ratio());
						
						invoiceDetailDtoLst.add(invoiceSrvDetail);
					}
				}
			}
			
			incInfoDto.setBlInvoiceDetailsDTO(invoiceDetailDtoLst);

			String strPayWay = "";
			// 获取对应的参照字段
			if (payPatOepAggdo != null) {
				BlPayItmPatOepDO[] payItmPatOpeDoLst = payPatOepAggdo.getBlPayItmPatOepDO();
				BlPayItmPatOepDO[] itmPatoepDoArr = new DORsReferMap<>(BlPayItmPatOepDO.class).convert(payItmPatOpeDoLst);
				payPatOepAggdo.setBlPayItmPatOepDO(itmPatoepDoArr);
				strPayWay = this.getPayWayStr(payPatOepAggdo);
			}
			// 发票头尾数据源组装
			// 获取医保结算信息
			BlPropArOepDO propArOepDoArr = null;

			if (hasHpSettle.booleanValue()) {
				// 如果是医保结算，获取医保交易流水号
				//propArOepDoArr = (BlPropArOepDO[]) AppFwUtil.getDORstWithDao(new BlPropArQry(stOepDo.getId_stoep()), BlPropArOepDO.class);
				propArOepDoArr = this.getPropData(stOepDo.getId_stoep());
			}
			BlInvoiceHeadTailDTO invoiceHeadTaildto = new BlInvoiceHeadTailDTO();
			String depName = "";
			if (invoiceDetailDtoLst != null && invoiceDetailDtoLst.size() != 0 && ((BlInvoiceDetailsDTO) invoiceDetailDtoLst.get(0)).getEu_srctp() == 1) {
				sql = "SELECT name FROM bd_dep WHERE ID_DEP=(select ID_DEP_PHY from en_ent WHERE ID_ENT='" + stOepDo.getId_ent() + "')";
				priPatDOLst = (List<PriPatDO>) facade.execQuery(sql, new BeanListHandler(PriPatDO.class));
				if (priPatDOLst != null && priPatDOLst.size() == 1) {
					depName = ((PriPatDO) priPatDOLst.get(0)).getName();
				}
			}
			if (noHps != null && noHps.size() != 0) {
				// 得到社会保障号
				invoiceHeadTaildto.setEnthpdo(noHps.get(0));
			}
			invoiceHeadTaildto.setAmt_st(stOepDo.getAmt_std().multiply(stOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			invoiceHeadTaildto.setId_incoep(incOepDo.getId_incoep());
			invoiceHeadTaildto.setAmt(incOepDo.getAmt().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (incOepDo.getAmt_free() != null) {
				invoiceHeadTaildto.setAmt_free(incOepDo.getAmt_free().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			if (incOepDo.getAmt_hp() != null)
				invoiceHeadTaildto.setAmt_hp(incOepDo.getAmt_hp().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			
			
			// modified by czl  20180524
			//查应收表
			if (propArOepDoArr != null ) {
				invoiceHeadTaildto.setAmt_hp(propArOepDoArr.getAmt_hp());
				invoiceHeadTaildto.setAmt_otherhp(propArOepDoArr.getAmt_other());
				
				/*if(propArOepDoArr[0].getAmt_other() != null){//ly 目前存放了医保盈亏金额
					invoiceHeadTaildto.setAmt_hp(invoiceHeadTaildto.getAmt_hp().add(propArOepDoArr[0].getAmt_other()));
				}*/
				
				invoiceHeadTaildto.setAmt_pat(propArOepDoArr.getAmt_cash());
				
			}else
   			   invoiceHeadTaildto.setAmt_pat(incOepDo.getAmt_pat().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			
			invoiceHeadTaildto.setAmt_std(incOepDo.getAmt_std().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			// 判断是否包含高端商保支付项目 如果包含减去患者自付金额合并高端商保字符类型为 CODE=17 的 并赋给字段amt_hpcg
			// 高保支付：***.**
			if (payPatOepAggdo != null) {
				BlPayItmPatOepDO[] itemDos = payPatOepAggdo.getBlPayItmPatOepDO();
				FDouble amt_hpcg = FDouble.ZERO_DBL;
				FDouble amt_jjzf = FDouble.ZERO_DBL;// 医保基金支付金额
				FDouble amt_grzhzf = FDouble.ZERO_DBL;// 个人账户支付金额
				FDouble amt_free = FDouble.ZERO_DBL;// 费用减免
				FDouble amt_diff = FDouble.ZERO_DBL;// 医保差额
				FDouble amt_profitloss = FDouble.ZERO_DBL;// 医保盈亏
				for (BlPayItmPatOepDO blPayItmPatOepDO : itemDos) {
					// 判断是否包含商保支付项目
					if (IBdPripmCodeConst.ID_PRI_PM_BUSINESS.equals(blPayItmPatOepDO.getId_pm())) {
						amt_hpcg = amt_hpcg.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
					// 判断是否包含医保基金支付项目
					if (IBdPripmCodeConst.ID_PRI_PM_INSUR.equals(blPayItmPatOepDO.getId_pm())) {
						amt_jjzf = amt_jjzf.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
					// 判断是否包含个人账户支付项目
					if (IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT.equals(blPayItmPatOepDO.getId_pm())) {
						amt_grzhzf = amt_grzhzf.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}

					// 判断是否包金额减免与项目减免
					if (IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatOepDO.getId_pm()) || IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION.equals(blPayItmPatOepDO.getId_pm())) {
						amt_free = amt_free.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}

					// 判断是否包含医保差额
					if (IBdPripmCodeConst.ID_PRI_PM_INSUR_DIFF.equals(blPayItmPatOepDO.getId_pm())) {
						amt_diff = amt_diff.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
					
					//医保盈亏
					if(IBdPripmCodeConst.ID_PRI_PM_HPPROFITLOSS.equals(blPayItmPatOepDO.getId_pm())) {
						amt_profitloss = amt_profitloss.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
				}
				// 设置商保支付金额
				if (!FDouble.ZERO_DBL.equals(amt_hpcg)) {
					invoiceHeadTaildto.setAmt_hpcg(("商保金额：" + amt_hpcg.setScale(2, BigDecimal.ROUND_HALF_UP)));
				}

				if (!FDouble.ZERO_DBL.equals(amt_jjzf)) {
					invoiceHeadTaildto.setAmt_hp((amt_jjzf.setScale(2, BigDecimal.ROUND_HALF_UP)));
				}
				if (!FDouble.ZERO_DBL.equals(amt_free)) {
					invoiceHeadTaildto.setAmt_free(amt_free.setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				// 设置个人账户支付金额
				invoiceHeadTaildto.setAmt_grzhzf((amt_grzhzf.setScale(2, BigDecimal.ROUND_HALF_UP)));

				// 判断是否包含个人支付项目 ，暂且将除了医保基金支付、个人账户支付、商保支付的其他支付方式均算在个人支付中，金额减免、
				// 项目减免、 内部转账的也暂且归到个人支付中，
				invoiceHeadTaildto.setAmt_pat(stOepDo.getAmt_ratio().sub(amt_hpcg.setScale(-2, BigDecimal.ROUND_HALF_UP)).sub(amt_jjzf.setScale(-2, BigDecimal.ROUND_HALF_UP))
						.sub(amt_grzhzf.setScale(-2, BigDecimal.ROUND_HALF_UP)).sub(amt_free.setScale(-2, BigDecimal.ROUND_HALF_UP)).sub(amt_diff.setScale(-2, BigDecimal.ROUND_HALF_UP))
						.sub(amt_profitloss.setScale(-2, BigDecimal.ROUND_HALF_UP)));

				invoiceHeadTaildto.setAmt_ratio(incOepDo.getAmt_ratio().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP).sub(amt_diff.setScale(-2, BigDecimal.ROUND_HALF_UP)));

			}

			// 医保交易流水号
			if (propArOepDoArr != null) {
				invoiceHeadTaildto.setCode_hp(propArOepDoArr.getCode_hp());
				// 如果当前是医保结算 当前结算总金额为医保金额 为了避免差额问题2017年12月11日 yang.lu
				invoiceHeadTaildto.setAmt(propArOepDoArr.getAmt_all());
			}
			invoiceHeadTaildto.setPay_tp(strPayWay);
			invoiceHeadTaildto.setFg_hp(hasHpSettle);
			invoiceHeadTaildto.setCode_st(stOepDo.getCode_st());
			invoiceHeadTaildto.setDatetime_print(incOepDo.getDt_inc());
			invoiceHeadTaildto.setDatetime_st(stOepDo.getDt_st());
			invoiceHeadTaildto.setEu_direct(incOepDo.getEu_direct());
			invoiceHeadTaildto.setEu_freemd(incOepDo.getEu_freemd());
			invoiceHeadTaildto.setHospital_type(hospitalType);
			invoiceHeadTaildto.setId_pat(incOepDo.getId_pat());
			invoiceHeadTaildto.setPatcode(incOepDo.getPatcode());
			invoiceHeadTaildto.setId_stoep(incOepDo.getId_stoep());
			invoiceHeadTaildto.setFg_reg(new FBoolean(StTypeEnum.ST_OEP_REG.equals(stOepDo.getEu_sttp()))); 
			invoiceHeadTaildto.setIncno(incOepDo.getIncno());
			invoiceHeadTaildto.setPripat_name(pripat_name);
			invoiceHeadTaildto.setDep_name(depName);
			invoiceHeadTaildto.setPatname(incOepDo.getPatname());
			//获取患者信息 
			PatDO patDo=getPatDO(incOepDo.getId_pat());
			invoiceHeadTaildto.setSex(patDo.getSd_sex());
			
			String eu_sttp = stOepDo.getEu_sttp();
			if (eu_sttp.equals(StTypeEnum.ST_OEP_CHARGE)) {
				invoiceHeadTaildto.setEu_sttp("门诊收费结算");
			} else if (eu_sttp.equals(StTypeEnum.ST_OEP_MIDWAY)) {
				invoiceHeadTaildto.setEu_sttp("门诊收费冲账");
			} else if (eu_sttp.equals(StTypeEnum.ST_REGISTER_MIDWAY)) {
				invoiceHeadTaildto.setEu_sttp("门诊挂号冲账");
			} else if (eu_sttp.equals(StTypeEnum.ST_OEP_REG)) {
				invoiceHeadTaildto.setEu_sttp("门诊挂号结算");
			} else if (eu_sttp.equals(StTypeEnum.ST_OEP_RED)) {
				invoiceHeadTaildto.setEu_sttp("收费取消结算");
			} else if (eu_sttp.equals(StTypeEnum.ST_REGISTER_RED)) {
				invoiceHeadTaildto.setEu_sttp("挂号取消结算");
			}
			
			//收付款信息
			FArrayList payList = new FArrayList();
			if(payPatOepAggdo != null){
				for (BlPayItmPatOepDO payItmDO : payPatOepAggdo.getBlPayItmPatOepDO()) {
					BlInvoicePmDTO pmDto = new BlInvoicePmDTO();
					pmDto.setId_pm(payItmDO.getId_pm());
					pmDto.setSd_pm(payItmDO.getSd_pm());
					pmDto.setName_pm(payItmDO.getPm_name());
					pmDto.setEu_direct(payItmDO.getEu_direct());
					pmDto.setAmt(payItmDO.getAmt());
					pmDto.setFg_realpay(payItmDO.getFg_realpay());
					payList.add(pmDto);
				}
			}
			
			// 发票开立人姓名,改成发票开立人code
			invoiceHeadTaildto.setInc_emp_name(emp_code);
			invoiceHeadTaildto.setPayee_emp_name(stOepDo.getId_emp_st_code());
			incInfoDto.setBlInvoiceHeadTailDTO(invoiceHeadTaildto);
			incInfoDto.setFg_RedInvoice(Fg_RedInvoice);// 是否红冲票
			incInfoDto.setBlInvoicePmDTOList(payList);
			incInfoDto.setPatHpInfoDTO(patHpInfoDto);
			if(enthp != null){
				FArrayList entHpDos = new FArrayList();
				entHpDos.add(enthp);
				incInfoDto.setEntHpDO(entHpDos);
			}			
			incInfoDtoLst.add(incInfoDto);
		}// 组装数据完成
		
		//按照发票号排序
		Collections.sort(incInfoDtoLst, new OpIncComparator_copy());
		
		return incInfoDtoLst.toArray(new BlIncItmVsTypeDTO[0]);
	}

	/**
	 * 过滤明细模式下需要单独医嘱的医嘱
	 * 
	 * @param orList
	 * @param ciSrvTp
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, CiOrderDO> judgeAsOneOrder(List<String> orList, String ciSrvTp) throws BizException {

		Map<String, CiOrderDO> result = new HashMap<String, CiOrderDO>();
		if (ListUtil.isEmpty(orList)) {
			return result;
		}	

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_or,name_or,quan_medu ");
		sqlSb.append("from ci_order ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("id_or", orList.toArray(new String[0])) + " ");
		if(StringUtils.isNotBlank(ciSrvTp)){
			String[] srtTps = ciSrvTp.split(",");
			sqlSb.append("and " + SqlUtils.getInSqlByIds("sd_srvtp", srtTps));
		}	

		DAFacade daf = new DAFacade();
		List<CiOrderDO> filterOrList = (List<CiOrderDO>) daf.execQuery(sqlSb.toString(),
				new BeanListHandler(CiOrderDO.class));

		if (ListUtil.isEmpty(filterOrList))
			return result;

		for (CiOrderDO orDo : filterOrList) {

			if (!result.containsKey(orDo.getId_or())) {
				result.put(orDo.getId_or(), orDo);
			}
		}
		return result;
	}

	/**
	 * 明细模式下医嘱是否按照一条显示明细模式下医嘱是否按照一条显示
	 * 
	 * @param splitSet
	 * @return
	 * @throws BizException
	 */
	private static boolean isOrderAsOneWhenDetailShow(BdInccaSplitDO splitSet) throws BizException {

		if (splitSet == null || StringUtil.isEmpty(splitSet.getSd_disp_ci_srvtp())) {
			return false;
		}

		if (FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())) {
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER.equals(splitSet.getSd_ac_disptp());
		} else {
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER.equals(splitSet.getSd_disptp());
		}
	}

	/**
	 * 获取门诊分票配置
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdInccaSplitDO getSplitSet() throws BizException {

		IInccasplitRService rService = ServiceFinder.find(IInccasplitRService.class);
		String whereSql = String.format("id_incca = '%s' and fg_active = 'Y'",
				IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);

		BdInccaSplitDO[] splitDos = rService.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(splitDos))
			return null;

		return splitDos[0];
	}

	/**
	 * 通过id_pat,id_hp得到患者医保计划表
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String getPatHpDOByIds(String id_pat, String id_hp) throws BizException {
		String sql = "select no_hp from pi_pat_hp where id_pat = ? and id_hp= ? ";
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(id_pat);
		sqlparam.addParam(id_hp);

		DAFacade facade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PiPatHpDO> entHpDODOLst = (List<PiPatHpDO>) facade.execQuery(sql, sqlparam,new BeanListHandler(PiPatHpDO.class));
		if (entHpDODOLst != null && entHpDODOLst.size() == 1) {
			String noHp = ((PiPatHpDO) entHpDODOLst.get(0)).getNo_hp();
			return noHp;
		}
		return null;
	}

	/**
	 * 获取支付方式拼接的字符串
	 * 
	 * @param payPatOepAggdo
	 *            结算支付方式
	 * @return
	 * @throws BizException
	 */
	private String getPayWayStr(BlpaypatoepAggDO payPatOepAggdo) throws BizException {
		BlPayItmPatOepDO[] payItmPatOpeDoLst = payPatOepAggdo.getBlPayItmPatOepDO();
		String strPayWay = "";
		for (BlPayItmPatOepDO itmPatOepDo : payItmPatOpeDoLst) {
			// 如果当前支付项目为医保差额则屏蔽此名称 2017年12月11日 yang.lu 医保差额不显示在打印当中
			if (IBdPripmCodeConst.ID_PRI_PM_INSUR_DIFF.equals(itmPatOepDo.getId_pm()))
				continue;
			if (itmPatOepDo.getPm_name() == null) {
				throw new BizException("当前付款方式名称异常，请及时联系管理员！");
			}
			// 找零方式暂时不考虑
			if (itmPatOepDo.getEu_direct() == 1 && strPayWay.indexOf(itmPatOepDo.getPm_name()) == -1)
				strPayWay = strPayWay + "," + itmPatOepDo.getPm_name();
		}
		if (StringUtil.isEmpty(strPayWay))
			return strPayWay;
		return strPayWay.substring(1);
	}

	/**
	 * 查询患者信息
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatDO(String id_pat) throws BizException {
		IPatiMDORService patService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = patService.findById(id_pat);
		return patDo == null ? new PatDO() : patDo;
	}

	private String GetBlPsnDocNameSQL() {

		return "select name from bd_psndoc where id_psndoc=?";
	}

	private String GetBlPsnDocCodeSQL() {

		return "select code from bd_psndoc where id_psndoc=?";
	}

	/**
	 * 获取人员姓名
	 * 
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	private String GetBlPsnDocName(String id_psndoc) throws BizException {
		ColumnHandler handler = new ColumnHandler();

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_psndoc);
		DAFacade cade = new DAFacade();
		String name = cade.execQuery(GetBlPsnDocNameSQL(), sqlParam, handler).toString();
		if (name.isEmpty()) {
			throw new BizException("工作人员名称不存在");
		}
		if (name.equals("Y")) {
			throw new BizException("工作人员名称不存在");
		}
		return name;
	}

	/**
	 * 获取人员编码
	 * 
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	private String GetBlPsnDocCode(String id_psndoc) throws BizException {
		ColumnHandler handler = new ColumnHandler();

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_psndoc);
		DAFacade cade = new DAFacade();
		String code = cade.execQuery(GetBlPsnDocCodeSQL(), sqlParam, handler).toString();
		if (code.isEmpty()) {
			throw new BizException("工作人员编号不存在");
		}
		if (code.equals("Y")) {
			throw new BizException("工作人员编号不存在");
		}
		return code;
	}
	
	/**
	 * 明细模式下账单项是否单独显示
	 * @param splitSet
	 * @return
	 * @throws BizException
	 */
	private boolean isIncitmWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
		
		if(splitSet == null || StringUtil.isEmpty(splitSet.getSd_disp_incitm())){
			return false;
		}
		
		if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM.equals(splitSet.getSd_ac_disptp());
		}else{
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM.equals(splitSet.getSd_disptp());
		}
	}
	
	/**
	 * 明细模式下账单项和医嘱是否单独显示
	 * @param splitSet
	 * @return
	 * @throws BizException
	 */
	private boolean isIncitmAndOrdWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
		
		if(splitSet == null)
			return false;
		
		if(StringUtil.isEmpty(splitSet.getSd_disp_incitm()) && StringUtil.isEmpty(splitSet.getSd_disp_ci_srvtp())){
			return false;
		}
		
		if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER.equals(splitSet.getSd_ac_disptp());
		}else{
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER.equals(splitSet.getSd_disptp());
		}
	}
	
	private PsnDocDO getPsnData(String psnId) throws BizException{
		DAFacade daf = new DAFacade();
		PsnDocDO psndocDO = (PsnDocDO) daf.findByPK(PsnDocDO.class, psnId,
				new String[] { PsnDocDO.ID_PSNDOC, PsnDocDO.CODE, PsnDocDO.NAME });
		return psndocDO;
	} 
	
	/**
	 * 获取医保信息
	 * @param id_ent
	 * @param id_hp
	 * @return
	 * @throws BizException
	 * @author hanJQ 2019年2月27日
	 */
	private EntHpDO getEntHpDo(String id_ent, String id_hp) throws BizException {
//		String sql = "select no_hp from en_ent_hp where id_ent ='" + id_ent + "' and id_hp='" + id_hp + "'";
//		DAFacade facade = new DAFacade();
//		@SuppressWarnings("unchecked")
//		List<EntHpDO> entHpDODOLst = (List<EntHpDO>) facade.execQuery(sql, new BeanListHandler(EntHpDO.class));
//		if (entHpDODOLst != null && entHpDODOLst.size() == 1) {
//			String noHp = ((EntHpDO) entHpDODOLst.get(0)).getNo_hp();
//			return noHp;
//		}
		IEnthpRService EnthpRService = ServiceFinder.find(IEnthpRService.class);
		String whereStr = "id_ent ='" + id_ent + "' and id_hp='" + id_hp + "'";
		EntHpDO[] entHpDos = EnthpRService.find(whereStr, "", FBoolean.FALSE);
		if(entHpDos != null && entHpDos.length > 0){
			return entHpDos[0];
		}
		return null;
	}
	
	/**
	 * 查询分摊数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlPropArOepDO getPropData(String stId) throws BizException {
		
		StringBuilder sb=new StringBuilder();
        sb.append(" SELECT A.* FROM BL_PROP_AR_OEP A");
        sb.append(" INNER JOIN BL_PROP_OEP B ON A.ID_PROPOEP=B.ID_PROPOEP");
        sb.append(" WHERE B.ID_STOEP=?");
        
        SqlParam param = new SqlParam();
        param.addParam(stId);
        
        DAFacade daf = new DAFacade();
        List<BlPropArOepDO> rlt = (List<BlPropArOepDO>)daf.execQuery(sb.toString(), param, new BeanListHandler(BlPropArOepDO.class));
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.get(0);
	}
}
