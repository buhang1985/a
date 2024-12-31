package iih.bl.cg.blcgipmend.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * *住院补/退费
 * @author weijia
 */
public class BlCgIpMendBp {
	
	/**
	 * review by yangyang 2017-10-21 住院补退费节点，针对退费的情形，只能采用差额红冲的情况，所以不能再显示汇总金额
	 * 该接口暂时停用，不考虑使用
	 * 获取就诊对应的记账信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public BlCgIpDO[] getBlCgIpInfoByIdEnt(String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT X.ID_OR, Y.name_OR as des_or, X.ID_SRV, X.ID_ORSRV, X.NAME_SRV, X.SRVU, M.CODE as srvu_code, M.NAME as srvu_name, X.PRICE, X.QUAN, X.ONLYCODE, X.ID_DEP_MP,P.Name as depmpname,X.Id_mm, D.Fg_Charge")
			.append(" FROM (SELECT A.ID_OR, A.ID_SRV, A.ID_ORSRV, A.NAME_SRV, A.ID_MM, A.PRICE, A.SRVU, SUM(A.QUAN * A.EU_DIRECT) AS QUAN, A.ONLYCODE, A.ID_DEP_MP")
			.append(" FROM BL_CG_IP A")
			.append(" WHERE A.ID_ENT = '").append(id_ent).append("' and fg_st='N'")
			.append(" GROUP BY A.ID_OR, A.ID_SRV, A.ID_ORSRV, A.NAME_SRV, A.ID_MM, A.PRICE, A.SRVU, A.ONLYCODE, A.ID_DEP_MP) X")
			.append(" LEFT JOIN CI_ORDER Y")
			.append(" ON X.ID_OR = Y.ID_OR")
			.append(" Left outer JOIN Bd_Dep P")
			.append(" ON X.ID_DEP_MP = P.ID_DEP")
			.append(" LEFT JOIN BD_MEASDOC M")
			.append(" ON  X.SRVU = M.ID_MEASDOC")
			.append(" LEFT JOIN BD_MM D")
			.append(" ON X.ID_MM = D.ID_MM");
		List<BlCgIpDO> blCgOrList  =(List<BlCgIpDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));
		BlCgIpDO[] blCgIpDOArr = null;
		if(blCgOrList != null && blCgOrList.size() > 0){
			blCgIpDOArr = blCgOrList.toArray(new BlCgIpDO[]{});
		}
		return blCgIpDOArr;
	}
	
	/**
	 * 根据就诊查询记账记录
	 * @param strIdEnt 就诊主键
	 * @return 患者记账数据
	 * @throws BizException
	 */
	public BlCgIpDO[] getBlCgIpDoByIdEnt(String strIdEnt) throws BizException
	{
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CGIP.*,CIOR.NAME_OR AS DES_OR,DEP.NAME AS DEPMPNAME,MM.FG_CHARGE,CGIPRE.QUAN AS QUAN_MEND");
		sql.append(" FROM BL_CG_IP CGIP ");
		sql.append(" LEFT JOIN BL_CG_IP CGIPRE ON CGIP.ID_CGIP=CGIPRE.ID_PAR");
		sql.append(" LEFT JOIN BD_MM MM ON CGIP.ID_MM=MM.ID_MM");
		sql.append(" LEFT JOIN CI_ORDER CIOR ON CGIP.ID_OR=CIOR.ID_OR");
		sql.append(" LEFT JOIN BD_DEP DEP ON CGIP.ID_DEP_MP=DEP.ID_DEP ");
		sql.append(" LEFT JOIN BD_MEASDOC MEASDOC ON MEASDOC.ID_MEASDOC=CGIP.SRVU");
		sql.append(" WHERE CGIP.FG_ST='N' AND CGIP.EU_DIRECT=1 AND CGIP.ID_ENT='").append(strIdEnt).append("'  order by cgip.sv desc ");
		List<BlCgIpDO> blCgOrList  =(List<BlCgIpDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));
		BlCgIpDO[] blCgIpDOArr = null;
		if(blCgOrList != null && blCgOrList.size() > 0){
			blCgIpDOArr = blCgOrList.toArray(new BlCgIpDO[]{});
		}
		List<BlCgIpDO> cgIpDoNewLst=new ArrayList<BlCgIpDO>();
		Map<String,BlCgIpDO> map=new HashMap<String,BlCgIpDO>();
		//这里对数据进行加工处理，退费必须要针对原退费记录进行退费
		for(BlCgIpDO cgIpDo:blCgOrList)
		{
			if(cgIpDo.getQuan_mend()!=null && cgIpDo.getQuan_mend().toDouble()>0)
			{
				if(map.containsKey(cgIpDo.getId_cgip()))
				{
					BlCgIpDO cgDo=map.get(cgIpDo.getId_cgip());
					cgDo.setQuan(cgDo.getQuan().sub(cgIpDo.getQuan_mend()));
				}
				else{
					cgIpDo.setQuan(cgIpDo.getQuan().sub(cgIpDo.getQuan_mend()));
					cgIpDo.setQuan_mend(new FDouble(0.00));
					map.put(cgIpDo.getId_cgip(), cgIpDo);
				}
				continue;
			}
			cgIpDoNewLst.add(cgIpDo);
		}
		
        //遍历HashMap的另一个方法  
        Set<Entry<String, BlCgIpDO>> sets = map.entrySet();  
        for(Entry<String, BlCgIpDO> entry : sets) {  
        	cgIpDoNewLst.add(entry.getValue());
        }  
		return cgIpDoNewLst.toArray(new BlCgIpDO[cgIpDoNewLst.size()]);
	}
	/**
	 * 住院退/补费
	 * */
	public BlCgIpDO[] setBlCgIpInfoMend(String id_ent,BlCgIpDO[] blcgOrArr) throws BizException{
		
		if(blcgOrArr == null || blcgOrArr.length == 0){
			return null;
		}
		//获取就诊对应的价格系数
		FDouble picPate = this.getPatRateByIdEnt(id_ent);
		String id_psndoc = this.getPsnDocIdByUser(Context.get().getUserId());
		
		//筛选、组装记账信息
		List<BlOrderAppendBillParamDTO> billDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		
		List<BlOrderAppendBillParamDTO> fundDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		for(BlCgIpDO blCgIpDO : blcgOrArr){
			BlOrderAppendBillParamDTO billDTO = null;
			if(blCgIpDO.getMark() == null || blCgIpDO.getMark() == 0){//原始数据
				continue;
			}else if(blCgIpDO.getMark() == 1){//变更数据（增加）
				billDTO = this.getBlCgDTO(blCgIpDO,id_psndoc,id_ent);
				billDTOList.add(billDTO);
			}else if(blCgIpDO.getMark() == 2){//变更数据（减少）
				billDTO = this.getBlCgDTO(blCgIpDO,id_psndoc,id_ent);
				fundDTOList.add(billDTO);
			}else if(blCgIpDO.getMark() == 3){//新增数据
				billDTO = this.getBlCgDTO(blCgIpDO,picPate);
				billDTOList.add(billDTO);
			}
		}
		//调用补费接口
		IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
		if(billDTOList != null && billDTOList.size() > 0){
			//billService.SetOrderAppendBill(billDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), false);
			//IBdFcDictCodeConst.SD_CODE_ENTP_IP
			//新接口，按明细补费
			billService.SetOrderAppendBill_ByItms(billDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		}
		if(fundDTOList != null && fundDTOList.size() > 0){
//			billService.RefundOrderAppendBill(fundDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), false);
			//tcy:调用新退费接口
			billService.SetOrderRefundBill(fundDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), false,IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		}
		//review by yangyang 2017-10-21 后端不再返回，返回后前端也没有使用，降低效率
//		return this.getBlCgIpInfoByIdEnt(id_ent);
		return null;
	}
	
	/**
	 * 组装补费/退费记账数据
	 * @param blCgIpDO 
	 * @return BlOrderAppendBillParamDTO
	 * @author weijia
	 * */
	public BlOrderAppendBillParamDTO getBlCgDTO(BlCgIpDO blCgIpInfo, String id_psndoc,String id_ent) throws BizException{
		TimeService timeService = new TimeServiceImpl();
		
//		BlCgIpDO blCgIpDO = this.getBlCgIpDOInfoByParam(blCgIpInfo,id_ent);
		BlCgIpDO blCgIpDO=blCgIpInfo;
		BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();
		blCgDTO.setId_org(blCgIpDO.getId_org());
		blCgDTO.setId_grp(blCgIpDO.getId_grp());
		blCgDTO.setId_pat(blCgIpDO.getId_pat());
		blCgDTO.setId_ent(blCgIpDO.getId_ent());
		blCgDTO.setId_srvtp(blCgIpDO.getId_srvtp());
		blCgDTO.setSd_srvtp(blCgIpDO.getSd_srvtp());
		blCgDTO.setId_srvca(blCgIpDO.getId_srvca());
		blCgDTO.setId_srv(blCgIpDO.getId_srv());
		blCgDTO.setCode_srv(blCgIpDO.getCode_srv());
		blCgDTO.setName_srv(blCgIpDO.getName_srv());
		blCgDTO.setSrvu(blCgIpDO.getSrvu());
		blCgDTO.setPrice(blCgIpDO.getPrice());
		
		blCgDTO.setId_enttp(blCgIpDO.getId_enttp());
		blCgDTO.setCode_enttp(blCgIpDO.getCode_enttp());
		blCgDTO.setDt_srv(blCgIpDO.getDt_srv());
		blCgDTO.setEu_srctp(blCgIpDO.getEu_srctp());
		if(blCgIpInfo.getMark() == 1){//变更数据（增加）
			blCgDTO.setQuan(blCgIpInfo.getQuan_mend());
			blCgDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
			blCgDTO.setRatio_pripat(blCgIpDO.getRatio_pripat());
			blCgDTO.setNote("补费（调整）");
		}else if(blCgIpInfo.getMark() == 2){//变更数据（减少）
			blCgDTO.setQuan(blCgIpInfo.getQuan_mend().abs());
			blCgDTO.setEu_direct(BookRtnDirectEnum.RETURNS);
			blCgDTO.setRatio_pripat(blCgIpDO.getRatio_pripat());
			//退费需要全额红冲
			blCgDTO.setId_par(blCgIpDO.getId_cgip());
			blCgDTO.setNote("退费（调整）");
		}

		blCgDTO.setAmt_std(blCgDTO.getQuan().multiply(blCgIpDO.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
		blCgDTO.setId_org_or(blCgIpDO.getId_org_or());
		blCgDTO.setId_dep_or(blCgIpDO.getId_dep_or());
		blCgDTO.setId_emp_or(blCgIpDO.getId_emp_or());
		blCgDTO.setDt_or(blCgIpDO.getDt_or());
		blCgDTO.setId_org_mp(blCgIpDO.getId_org_mp());
		blCgDTO.setId_dep_mp(blCgIpDO.getId_dep_mp());
		blCgDTO.setId_pripat(blCgIpDO.getId_pripat());
		blCgDTO.setId_hp(blCgIpDO.getId_hp());
		blCgDTO.setRatio_hp(blCgIpDO.getRatio_hp());
		blCgDTO.setAmt_hp(new FDouble(0));
		blCgDTO.setAmt_pat(blCgDTO.getQuan().multiply(blCgIpDO.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
		blCgDTO.setAmt(blCgDTO.getAmt_pat().multiply(blCgDTO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));///???是否判空
		blCgDTO.setFg_mm(blCgIpDO.getFg_mm());
		blCgDTO.setId_mm(blCgIpDO.getId_mm());
		blCgDTO.setId_mmtp(blCgIpDO.getId_mmtp());
		blCgDTO.setSd_mmtp(blCgIpDO.getSd_mmtp());
		blCgDTO.setCode_mm(blCgIpDO.getCode_mm());
		blCgDTO.setSpec(blCgIpDO.getSpec());
		blCgDTO.setOnlycode(blCgIpDO.getOnlycode());
		blCgDTO.setName_mm(blCgIpDO.getName_mm());
		blCgDTO.setCd_batch(blCgIpDO.getCd_batch());
		blCgDTO.setPgku_base(blCgIpDO.getPgku_base());
		blCgDTO.setPgku_cur(blCgIpDO.getPgku_cur());
		blCgDTO.setFactor(blCgIpDO.getFactor());
		blCgDTO.setQuan_base(blCgIpDO.getQuan_base());
		blCgDTO.setId_or(blCgIpDO.getId_or());
		blCgDTO.setId_orsrv(blCgIpDO.getId_orsrv());
		blCgDTO.setId_pres(blCgIpDO.getId_pres());
		blCgDTO.setFg_hp(FBoolean.FALSE);
		blCgDTO.setFg_susp(FBoolean.FALSE);
		blCgDTO.setFg_refund(FBoolean.FALSE);
		blCgDTO.setPrice_ratio(blCgIpDO.getPrice_ratio());
		//TODO 这里有争议 review by yangyang 2017-10-21 医保的策略会影响到住院费用的红冲情况，是全额红冲还是差额红冲
//		blCgDTO.setId_par(null);
////		if(blCgDTO.getEu_direct()==-1)
////		{
////			blCgDTO.setId_par(blCgIpDO.getId_cgip());
////		}
////		else{
////			blCgDTO.setId_par(null);
////		}
//		blCgDTO.setCode_cg(null);
		blCgDTO.setId_org_cg(Context.get().getOrgId());
		blCgDTO.setId_dep_cg(Context.get().getDeptId());//记账科室
		blCgDTO.setDt_cg(timeService.getUFDateTime());
		blCgDTO.setSupportAppendBill(FBoolean.FALSE);//是否支持后付费？？？
		blCgDTO.setId_emp_cg(id_psndoc);
		
		BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
		inpBillDTO.setFg_pddisc(blCgIpDO.getFg_pddisc());//出院带药标志
		inpBillDTO.setId_wg_or(blCgIpDO.getId_wg_or());//医疗组
		inpBillDTO.setId_dep_nur(blCgIpDO.getId_dep_nur());//病区
		inpBillDTO.setFg_bb(blCgIpDO.getFg_bb());//婴儿标志
		inpBillDTO.setNo_bb(blCgIpDO.getNo_bb());//婴儿序号
		inpBillDTO.setId_ent_mom(blCgIpDO.getId_ent_mom());
		
		blCgDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
		
		blCgDTO.setInpBillDTO(inpBillDTO);
		return blCgDTO;
	}
	
	/**
	 * 组装新增记账数据
	 * @param blCgIpDO 
	 * @param picPate 
	 * @return BlOrderAppendBillParamDTO
	 * @author weijia
	 * */
	public BlOrderAppendBillParamDTO getBlCgDTO(BlCgIpDO blCgIpDO,FDouble picPate){
		TimeService timeService = new TimeServiceImpl();
		
		BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();
		blCgDTO.setId_org(blCgIpDO.getId_org());
		blCgDTO.setId_grp(blCgIpDO.getId_grp());
		blCgDTO.setId_pat(blCgIpDO.getId_pat());
		blCgDTO.setId_ent(blCgIpDO.getId_ent());
		blCgDTO.setId_srvtp(blCgIpDO.getId_srvtp());
		blCgDTO.setSd_srvtp(blCgIpDO.getSd_srvtp());
		blCgDTO.setId_srvca(blCgIpDO.getId_srvca());
		blCgDTO.setId_srv(blCgIpDO.getId_srv());
		blCgDTO.setCode_srv(blCgIpDO.getCode_srv());
		blCgDTO.setName_srv(blCgIpDO.getName_srv());
		blCgDTO.setSrvu(blCgIpDO.getSrvu());
		blCgDTO.setPrice(blCgIpDO.getPrice());
		
		blCgDTO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		blCgDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		blCgDTO.setDt_srv(timeService.getUFDateTime());
		blCgDTO.setQuan(blCgIpDO.getQuan_mend());
		blCgDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blCgDTO.setRatio_pripat(picPate);//当前患者价格比例
		blCgDTO.setEu_srctp(0);
		blCgDTO.setNote("补费（新增）");
		blCgDTO.setFg_additm(FBoolean.TRUE);

	
		blCgDTO.setId_org_or(blCgIpDO.getId_org_or());
		blCgDTO.setId_dep_or(blCgIpDO.getId_dep_or());
		blCgDTO.setId_emp_or(blCgIpDO.getId_emp_or());
		blCgDTO.setDt_or(blCgIpDO.getDt_or());
		blCgDTO.setId_org_mp(blCgIpDO.getId_org_mp());
		blCgDTO.setId_dep_mp(blCgIpDO.getId_dep_mp());
		blCgDTO.setId_pripat(blCgIpDO.getId_pripat());
		blCgDTO.setId_hp(blCgIpDO.getId_hp());
		blCgDTO.setRatio_hp(blCgIpDO.getRatio_hp());
		blCgDTO.setAmt_hp(new FDouble(0));
		if(blCgDTO.getQuan()!=null)
		{
			blCgDTO.setAmt_std(blCgDTO.getQuan().multiply(blCgIpDO.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			blCgDTO.setAmt_pat(blCgDTO.getQuan().multiply(blCgIpDO.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			blCgDTO.setAmt(blCgDTO.getAmt_pat().multiply(blCgDTO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));///???是否判空	
		}
		blCgDTO.setFg_mm(blCgIpDO.getFg_mm());
		blCgDTO.setId_mm(blCgIpDO.getId_mm());
		blCgDTO.setId_mmtp(blCgIpDO.getId_mmtp());
		blCgDTO.setSd_mmtp(blCgIpDO.getSd_mmtp());
		blCgDTO.setCode_mm(blCgIpDO.getCode_mm());
		blCgDTO.setSpec(blCgIpDO.getSpec());
		blCgDTO.setOnlycode(blCgIpDO.getOnlycode());
		blCgDTO.setName_mm(blCgIpDO.getName_mm());
		blCgDTO.setCd_batch(blCgIpDO.getCd_batch());
		blCgDTO.setPgku_base(blCgIpDO.getPgku_base());
		blCgDTO.setPgku_cur(blCgIpDO.getPgku_cur());
		blCgDTO.setFactor(blCgIpDO.getFactor());
		blCgDTO.setQuan_base(blCgIpDO.getQuan_base());
		blCgDTO.setId_or(blCgIpDO.getId_or());
		blCgDTO.setId_orsrv(blCgIpDO.getId_orsrv());
		blCgDTO.setId_pres(blCgIpDO.getId_pres());
		blCgDTO.setFg_hp(FBoolean.FALSE);
		blCgDTO.setFg_susp(FBoolean.FALSE);
		blCgDTO.setFg_refund(FBoolean.FALSE);
		blCgDTO.setId_par(blCgIpDO.getId_cgip());
		blCgDTO.setCode_cg(null);
		blCgDTO.setId_org_cg(Context.get().getOrgId());
		blCgDTO.setId_dep_cg(Context.get().getDeptId());//记账科室
		blCgDTO.setDt_cg(timeService.getUFDateTime());
		blCgDTO.setSupportAppendBill(FBoolean.TRUE);//是否支持后付费？？？
		blCgDTO.setId_emp_cg(blCgIpDO.getId_emp_cg());
		
		BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
		inpBillDTO.setFg_pddisc(blCgIpDO.getFg_pddisc());//出院带药标志
		inpBillDTO.setId_wg_or(blCgIpDO.getId_wg_or());//医疗组
		inpBillDTO.setId_dep_nur(blCgIpDO.getId_dep_nur());//病区
    	blCgDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
		blCgDTO.setInpBillDTO(inpBillDTO);
		return blCgDTO;
	}
	
	/**
	 * 从住院记账数据组装成BlOrderAppendBillParamDTO类型的数据
	 * @param blCgIpDO 	 *
	 * @param operatorInfoDTO 执行重计价的操作员信息
	 * @param SupportAppendBill 是否支持后付费 
	 * @param Eu_direct 收退费方向
	 * @return BlOrderAppendBillParamDTO
	 * @author tcy
	 * */
	public BlOrderAppendBillParamDTO getRePricingBlOrderAppendBillParamDTO(BlCgIpDO blCgIpDO,OperatorInfoDTO operatorInfoDTO,FBoolean SupportAppendBill,int Eu_direct){
		TimeService timeService = new TimeServiceImpl();
		
		BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();
		blCgDTO.setId_org(blCgIpDO.getId_org());
		blCgDTO.setId_grp(blCgIpDO.getId_grp());
		blCgDTO.setId_pat(blCgIpDO.getId_pat());
		blCgDTO.setId_ent(blCgIpDO.getId_ent());
		blCgDTO.setId_srvtp(blCgIpDO.getId_srvtp());
		blCgDTO.setSd_srvtp(blCgIpDO.getSd_srvtp());
		blCgDTO.setId_srvca(blCgIpDO.getId_srvca());
		blCgDTO.setId_srv(blCgIpDO.getId_srv());
		blCgDTO.setCode_srv(blCgIpDO.getCode_srv());
		blCgDTO.setName_srv(blCgIpDO.getName_srv());
		blCgDTO.setSrvu(blCgIpDO.getSrvu());
		blCgDTO.setPrice(blCgIpDO.getPrice());
		
		blCgDTO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		blCgDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		blCgDTO.setDt_srv(timeService.getUFDateTime());
		blCgDTO.setQuan(blCgIpDO.getQuan_mend());
		//blCgDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blCgDTO.setEu_direct(Eu_direct);
		blCgDTO.setRatio_pripat(blCgIpDO.getRatio_pripat());//当前患者价格比例
		blCgDTO.setEu_srctp(0);
		if(Eu_direct==BookRtnDirectEnum.CHARGE)
		{
			blCgDTO.setNote("");
		}
		else
		{
			blCgDTO.setNote("红冲："+blCgIpDO.getId_cgip());
		}
		blCgDTO.setAmt_std(blCgDTO.getQuan().multiply(blCgIpDO.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
		blCgDTO.setId_org_or(blCgIpDO.getId_org_or());
		blCgDTO.setId_dep_or(blCgIpDO.getId_dep_or());
		blCgDTO.setId_emp_or(blCgIpDO.getId_emp_or());
		blCgDTO.setDt_or(blCgIpDO.getDt_or());
		blCgDTO.setId_org_mp(blCgIpDO.getId_org_mp());
		blCgDTO.setId_dep_mp(blCgIpDO.getId_dep_mp());
		blCgDTO.setId_pripat(blCgIpDO.getId_pripat());
		blCgDTO.setId_hp(blCgIpDO.getId_hp());
		blCgDTO.setRatio_hp(blCgIpDO.getRatio_hp());
		blCgDTO.setAmt_hp(new FDouble(0));
		blCgDTO.setAmt_pat(blCgDTO.getQuan().multiply(blCgIpDO.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
		blCgDTO.setAmt(blCgDTO.getAmt_pat().multiply(blCgDTO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));///???是否判空
		blCgDTO.setFg_mm(blCgIpDO.getFg_mm());
		blCgDTO.setId_mm(blCgIpDO.getId_mm());
		blCgDTO.setId_mmtp(blCgIpDO.getId_mmtp());
		blCgDTO.setSd_mmtp(blCgIpDO.getSd_mmtp());
		blCgDTO.setCode_mm(blCgIpDO.getCode_mm());
		blCgDTO.setSpec(blCgIpDO.getSpec());
		blCgDTO.setOnlycode(blCgIpDO.getOnlycode());
		blCgDTO.setName_mm(blCgIpDO.getName_mm());
		blCgDTO.setCd_batch(blCgIpDO.getCd_batch());
		blCgDTO.setPgku_base(blCgIpDO.getPgku_base());
		blCgDTO.setPgku_cur(blCgIpDO.getPgku_cur());
		blCgDTO.setFactor(blCgIpDO.getFactor());
		blCgDTO.setQuan_base(blCgIpDO.getQuan_base());
		blCgDTO.setId_or(blCgIpDO.getId_or());
		blCgDTO.setId_orsrv(blCgIpDO.getId_orsrv());
		blCgDTO.setId_pres(blCgIpDO.getId_pres());
		blCgDTO.setFg_hp(FBoolean.FALSE);
		blCgDTO.setFg_susp(FBoolean.FALSE);
		blCgDTO.setFg_refund(FBoolean.FALSE);
		if(Eu_direct==BookRtnDirectEnum.CHARGE)
		{
			blCgDTO.setId_par(null);
		}
		else
		{
			blCgDTO.setId_par(blCgIpDO.getId_cgip());
		}
		blCgDTO.setCode_cg(null);
		blCgDTO.setId_org_cg(Context.get().getOrgId());
		blCgDTO.setId_dep_cg(Context.get().getDeptId());//记账科室
		blCgDTO.setDt_cg(timeService.getUFDateTime());
		blCgDTO.setSupportAppendBill(SupportAppendBill);//是否支持后付费？？？
		blCgDTO.setId_emp_cg(blCgIpDO.getId_emp_cg());
		
		BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
		inpBillDTO.setFg_pddisc(blCgIpDO.getFg_pddisc());//出院带药标志
		inpBillDTO.setId_wg_or(blCgIpDO.getId_wg_or());//医疗组
		inpBillDTO.setId_dep_nur(blCgIpDO.getId_dep_nur());//病区
//		inpBillDTO.setFg_bb(blCgIpDO.getFg_bb());//婴儿标志
//		inpBillDTO.setNo_bb(blCgIpDO.getNo_bb());//婴儿序号
		blCgDTO.setInpBillDTO(inpBillDTO);
		
		//重计价的操作员信息
		BlOrderRefundBillParamDTO refundBillDTO=new BlOrderRefundBillParamDTO();
		refundBillDTO.setId_cg_pk(blCgIpDO.getId_cgip());
		refundBillDTO.setId_org_cg(operatorInfoDTO.getId_org_emp());
		refundBillDTO.setId_dep_cg(operatorInfoDTO.getId_dep());
		refundBillDTO.setId_emp_cg(operatorInfoDTO.getId_emp());
		blCgDTO.setRefundBillParamDTO(refundBillDTO);
		
		//blCgDTO.setInpBillDTO(inpBillDTO);
		return blCgDTO;
	}
	
	/**
     * 获取就诊对应的价格系数
     * */
	public FDouble getPatRateByIdEnt(String id_ent) throws BizException {
    	StringBuffer sql = new StringBuffer();
		sql.append("select b.rate ")
		   .append("from en_ent e ")
		   .append("left join bd_pri_pat b on e.id_pripat = b.id_pripat ")
		   .append("where e.id_ent = '").append(id_ent).append("' ");
		BigDecimal discount = (BigDecimal)new DAFacade().execQuery(sql.toString(), new ColumnHandler() );
		if(discount == null)
		{
			throw new BizException("就诊对应的价格分类不存在！");
		}
		return new FDouble(discount);
    }
	
	/**
	 * 根据用户id获取对应人员id
	 * */
	public String getPsnDocIdByUser(String id_user) throws BizException{
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO userDO = userService.findById(id_user);
		if(userDO == null){
			throw new BizException("用户"+id_user+"不存在！");
		}
		return userDO.getId_psn();
	}
	
	/**
	 * 根据记账条件查询记账数据
	 * */
	public BlCgIpDO getBlCgIpDOInfoByParam(BlCgIpDO blCgIpInfo,String id_ent) throws BizException{
		StringBuffer sqlQue = new StringBuffer();
		sqlQue.append("a0.ID_ENT = '").append(id_ent).append("'");
		if(StringUtils.isBlank(blCgIpInfo.getId_or())){
			sqlQue.append(" and (a0.id_or is null or a0.id_or = '~')");
		}else{
			sqlQue.append(" and a0.id_or = '").append(blCgIpInfo.getId_or()).append("'");
		}
		if(StringUtils.isBlank(blCgIpInfo.getId_srv())){
			sqlQue.append(" and (a0.id_srv is null or a0.id_srv = '~')");
		}else{
			sqlQue.append(" and a0.id_srv = '").append(blCgIpInfo.getId_srv()).append("'");
		}
		if(StringUtils.isBlank(blCgIpInfo.getId_orsrv())){
			sqlQue.append(" and (a0.id_orsrv is null or a0.id_orsrv = '~')");
		}else{
			sqlQue.append(" and a0.id_orsrv = '").append(blCgIpInfo.getId_orsrv()).append("'");
		}
		sqlQue.append(" and a0.price = ").append(blCgIpInfo.getPrice());
//				  .append(" and a0.eu_direct = ").append(blCgIpInfo.getEu_direct());
		if(StringUtils.isBlank(blCgIpInfo.getId_dep_mp())){
			sqlQue.append(" and (a0.id_dep_mp is null or a0.id_dep_mp = '~')");
		}else{
			sqlQue.append(" and a0.id_dep_mp = '").append(blCgIpInfo.getId_dep_mp()).append("'");
		}
		if(StringUtils.isBlank(blCgIpInfo.getSrvu())){
			sqlQue.append(" and (a0.srvu is null or a0.srvu = '~')");
		}else{
			sqlQue.append(" and a0.srvu = '").append(blCgIpInfo.getSrvu()).append("'");
		}
		if(StringUtils.isBlank(blCgIpInfo.getOnlycode())){
			sqlQue.append(" and (a0.onlycode is null or a0.onlycode = '~')");
		}else{
			sqlQue.append(" and a0.onlycode = '").append(blCgIpInfo.getOnlycode()).append("'");
		}
		IBlcgqueryRService cgRService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[]  blCgIpDOArr = cgRService.find(sqlQue.toString(), null, FBoolean.FALSE);
		if(blCgIpDOArr == null || blCgIpDOArr.length == 0){
			throw new BizException("补费对应的记账数据不存在！");
		}
		return blCgIpDOArr[0];
	}
	
	/**
	 * 根据banner中输入值查询相关患者就诊信息(住院补/退费，已结算，已付款，欠款)
	 * */
	@SuppressWarnings("unchecked")
	public BlBannerDTO[] getStMendBannerEnEntInfo(String inputValue,String[] selectCondition) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct(t.id_ent),p.id_pat,p.name as name_pat,dep.name as name_dep_nur,e.name_bed,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip ")
		    .append("from en_ent t ")
		    .append("join pi_pat p on p.id_pat = t.id_pat ")
		    .append("join en_ent_ip e on e.id_ent = t.id_ent ")
		    .append("left join bd_dep dep on t.id_dep_nur = dep.id_dep ")
		    .append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
		    .append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
		    .append("left join bd_hp h on h.id_hp = n.id_hp ")
			 .append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
			.append("where t.code_entp = 10 ")
			.append("and t.fg_canc = 'N' ")
			.append("and t.fg_st = 'N' ")
			.append("and e.sd_status != '22' ");
//		en_ent_ip.sd_status 入院:22/入科:25/退院:2a/出院未结算:28/出院结算未付款:28b/出院结算已付款:28c
		if(selectCondition != null && selectCondition.length > 0){
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for(String cond : selectCondition){
				if("code_ent".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue).append("%'");
				}else if("id_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue).append("%'");
				}else if("code_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue).append("%'");
				}else if("id_code".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue).append("%'");
				}else if("barcode_chis".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%").append(inputValue).append("%'");
				}else if("code_amr_ip".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.code_amr_ip like '%").append(inputValue).append("%'");
				}else if("patcode".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue).append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");//增加组织隔离
		sql.append(sqlContext);
		sql.append("order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[]{});
	}
}
