package iih.bl.cg.service.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.d.BlIpFeeInfo;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class BlIpFeeSubmitDataBp {

	public FBoolean exec(BlIpFeeInfo[] infos) throws BizException{
		if(infos == null || infos.length == 0){
			return FBoolean.FALSE;
		}
		
		String id_ent =  infos[0].getId_ent();
		//获取就诊对应的价格系数
		FDouble picPate = this.getPatRateByIdEnt(id_ent);
		String id_psndoc = this.getPsnDocIdByUser(Context.get().getUserId());
		
		List<String> list = new ArrayList<String>();
		for(BlIpFeeInfo dto : infos) {
			list.add(dto.getId_cgip());
		}
		
		List<BlCgIpDO> doList = (List<BlCgIpDO>)new DAFacade().findByPKs(BlCgIpDO.class, list.toArray(new String[]{}));
		//筛选、组装记账信息
		
		List<BlOrderAppendBillParamDTO> fundDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		for(BlCgIpDO blCgIpDO : doList){
			BlOrderAppendBillParamDTO billDTO = null;
			for(BlIpFeeInfo dto : infos) {
				if(blCgIpDO.getId_cgip().equals(dto.getId_cgip()))
					blCgIpDO.setQuan_mend(dto.getQuan_mend());
			}
			billDTO = this.getBlCgDTO(blCgIpDO,id_psndoc,id_ent);
			fundDTOList.add(billDTO);
		}
		//调用退费接口
		IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
	
		if(fundDTOList != null && fundDTOList.size() > 0){
			billService.SetOrderRefundBill(fundDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), false,IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		}

		return FBoolean.TRUE;
	}
	
	/**
	 * 组装补费/退费记账数据
	 * @param blCgIpDO 
	 * @return BlOrderAppendBillParamDTO
	 * @author weijia
	 * */
	public BlOrderAppendBillParamDTO getBlCgDTO(BlCgIpDO blCgIpInfo, String id_psndoc,String id_ent) throws BizException{
		TimeService timeService = new TimeServiceImpl();
		
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

		blCgDTO.setQuan(blCgIpInfo.getQuan_mend().abs());
		blCgDTO.setEu_direct(BookRtnDirectEnum.RETURNS);
		blCgDTO.setRatio_pripat(blCgIpDO.getRatio_pripat());
		//退费需要全额红冲
		blCgDTO.setId_par(blCgIpDO.getId_cgip());
		blCgDTO.setNote("退费（调整）");

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
     * 获取就诊对应的价格系数
     * */
	private FDouble getPatRateByIdEnt(String id_ent) throws BizException {
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
	private String getPsnDocIdByUser(String id_user) throws BizException{
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO userDO = userService.findById(id_user);
		if(userDO == null){
			throw new BizException("用户"+id_user+"不存在！");
		}
		return userDO.getId_psn();
	}
}
