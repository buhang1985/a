package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class PayForAptForWechatBP {
	
	/**
	 * 手机APP挂号付费（对微信接口）
	 * @param patCode 患者编码
	 * @param patType 患者类型
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param regDate 日期
	 * @param dayslotType 午别类型
	 * @param seqNo 顺序号
	 * @param orderNo 
	 * @param payType 支付方式
	 * @param accNo 
	 * @param money 金额
	 * @param oprCode 操作员编码
	 * @return
	 * @throws BizException
	 */
	public String exec(String patCode,String patType,String deptCode,String doctorCode,String regDate,String dayslotType,String seqNo,String orderNo,String payType,String accNo,String money,String oprCode) throws BizException{
		//1. 验证必输项
		this.validParam(patCode, regDate, dayslotType, deptCode, doctorCode, seqNo, payType, money, oprCode);
		
		OpAptDTO aptDTO = null;
		//1. 获取预约信息
		ScAptDO scAptDo = this.getAptInfo(patCode, regDate, dayslotType, deptCode, doctorCode, seqNo);
		if(scAptDo == null) 
			throw new BizException("没找到对应预约记录！");
		
		//是否可操作验证
		this.checkExec(scAptDo);
		
		aptDTO = this.scAptToOpApt(scAptDo);
		
		//加载资源及价格信息
		RegResDTO RegResDto = this.getRegRes(scAptDo);
		if(RegResDto == null) 
			throw new BizException("加载资源价格信息异常！");
		aptDTO.setRegresarray(ScAppUtils.doArray2List(RegResDto));
		
		//设置支付信息
		AptPayDTO payDTO = this.setPayInfo(RegResDto, payType, money, accNo, orderNo);
		
		//2. 划价
		PricingOpAptBP pricingBP = new PricingOpAptBP();
		aptDTO = pricingBP.exec(aptDTO, FBoolean.FALSE, FBoolean.FALSE);
		
		//3. 结算付费
		SettleOpAptBP settleOpAptBp = new SettleOpAptBP();
		settleOpAptBp.exec(aptDTO, payDTO, FBoolean.FALSE);
		
//		TakeApptNoBP takeApptNoBp = new TakeApptNoBP();
//		aptDTO = takeApptNoBp.takeApptNo(aptDTO.getId_pat(), aptDTO, payDTO);
//		if(aptDTO == null) return "预约信息结算失败！";
		return null;		
	}
	/**
	 * 获取挂号资源
	 * 
	 * @param scAptDo
	 * @return
	 * @throws BizException 
	 */
	private RegResDTO getRegRes(ScAptDO scAptDo) throws BizException{
		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		ResQrySchemeDTO scheme = new ResQrySchemeDTO();
		scheme.setIds_sch(ScAppUtils.objArray2List(scAptDo.getId_sch()));
		scheme.setId_scchl(scAptDo.getId_scchl());
		RegResDTO[] regRess = scSchOutQryService.getResByScheme(scheme);
		if(!ScValidator.isNullOrEmpty(regRess))
			return regRess[0];
		return null;
		
	}
	
	/*
	 * 验证必输项参数
	 * @param beginDate
	 * @param endDate
	 * @param srvType
	 * @param chlType
	 * @return
	 */
	private void validParam(String patCode, String dSch, String dayslotType, String deptCode, String doctorCode, String seqNo, String payType, String money, String oprCode) throws BizException{
		if(StringUtil.isEmpty(patCode)){
			throw new BizException("患者编码不能为空！");
		}
		if(StringUtil.isEmpty(dSch)){
			throw new BizException("挂号日期不能为空！");
		}
		if(StringUtil.isEmpty(dayslotType)){
			throw new BizException("午别类型不能为空！");
		}
		if(StringUtil.isEmpty(deptCode)){
			throw new BizException("科室编码不能为空！");
		}
		if(StringUtil.isEmpty(seqNo)){
			throw new BizException("顺序号不能为空！");
		}
		if(StringUtil.isEmpty(payType)){
			throw new BizException("支付方式不能为空！");
		}
		if(StringUtil.isEmpty(money)){
			throw new BizException("金额不能为空！");
		}
		if(StringUtil.isEmpty(oprCode)){
			throw new BizException("操作员编码不能为空！");
		}
	}
	
	/**
	 * 获取预约信息
	 * @param patCode 患者编码
	 * @param dSch 日期
	 * @param dayslotType 午别类型
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param seqNo 顺序号
	 * @return
	 * @throws DAException
	 */
	private ScAptDO getAptInfo(String patCode, String dSch, String dayslotType, String deptCode, String doctorCode, String seqNo) throws DAException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT APT.* ");
		sqlBuilder.append("FROM SC_APT_EXCHL EXCHL ");
		sqlBuilder.append("INNER JOIN SC_APT APT ");
		sqlBuilder.append("ON EXCHL.ID_APT = APT.ID_APT ");
		sqlBuilder.append("WHERE 1=1 ");
		
		sqlBuilder.append("AND EXCHL.CODE_PAT = ? ");
		param.addParam(patCode);
		
		sqlBuilder.append("AND EXCHL.D_SC = ? ");
		param.addParam(dSch);
		
		sqlBuilder.append("AND EXCHL.AMPM = ? ");
		param.addParam(dayslotType);
		
		sqlBuilder.append("AND EXCHL.CODE_DEP = ? ");
		param.addParam(deptCode);
		
		if(!StringUtil.isEmpty(doctorCode)){
			sqlBuilder.append("AND EXCHL.CODE_EMP_PHY = ? ");
			param.addParam(doctorCode);
		}
		
		sqlBuilder.append("AND APT.QUENO = ? ");
		param.addParam(seqNo);
		
		sqlBuilder.append("AND APT.FG_CANC= 'N' ");
		
		List<ScAptDO> aptInfos = (List<ScAptDO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(ScAptDO.class));
		if (ListUtil.isEmpty(aptInfos)) return null;
		return aptInfos.get(0);
	}
	
	/**
	 * DTO转换
	 * @param scAptDo
	 * @return
	 */
	private OpAptDTO scAptToOpApt(ScAptDO scAptDo){
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(scAptDo.getId_apt());
		aptDTO.setId_dayslot(scAptDo.getId_dateslot());//日期分组
		//aptDTO.setId_ent(scAptDo.getid_e); //就诊ID
		aptDTO.setId_pat(scAptDo.getId_pat());//患者id
		aptDTO.setDt_b(scAptDo.getDt_b());//预约日期

		aptDTO.getRegresarray();//挂号资源
		aptDTO.setId_sch(scAptDo.getId_sch());//排班
		aptDTO.setId_ticks(scAptDo.getId_ticks());//号段
		aptDTO.setId_tick(scAptDo.getId_tick());//号位
		aptDTO.setQueno(scAptDo.getQueno());;//票号
		
		aptDTO.setFg_payment(FBoolean.FALSE);
		return aptDTO;
	}
	
	/**
	 * 加载挂号资源信息
	 * @param regInfos 挂号信息DTO
	 * @throws BizException
	 */
	private RegResDTO[] loadRes(String schId) throws BizException{	
		List<String> schIdList = new ArrayList<String>();
//		for(OpAptDTO aptDTO : opAptDTOs){
			schIdList.add(schId);
//		}
		IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] regResArray = schService.getRegResBySch(schIdList.toArray(new String[0]), FBoolean.TRUE);
//		for(OpAptDTO opApt : opAptDTOs){
//			for(RegResDTO regRes : regResArray){
//				if(regRes==null)continue;
//				if(opApt.getId_sch().equals(regRes.getId_sch())){
//					FArrayList regresArray = new FArrayList();
//					regresArray.add(regRes);
//					opApt.setRegresarray(regresArray);
//					break;
//				}
//			}
//		}	
		if(regResArray == null || regResArray.length == 0) return null;
		return regResArray;
	}
	
	/**
	 * 设置支付信息
	 * @param regRes 资源信息
	 * @param payType 支付方式
	 * @param money 支付金额
	 * @return
	 * @throws BizException 
	 */
	private AptPayDTO setPayInfo(RegResDTO regRes, String payType, String money, String accNo, String orderNo) throws BizException{
		//设置支付信息
		AptPayDTO payDTO = new AptPayDTO();
		payDTO.setFg_newprice(FBoolean.FALSE);
		payDTO.setFg_print(FBoolean.FALSE);
		payDTO.setFg_acc(FBoolean.FALSE);
		payDTO.setAmt_st(regRes.getAmt_st());
		payDTO.setAmt_hp(regRes.getAmt_hp());
		payDTO.setAmt_pat(regRes.getAmt_pat());
		payDTO.setAmt(regRes.getAmt());
		payDTO.setNo_bank(accNo);
		payDTO.setRemark(orderNo);
		if("2".equals(payType)){
			//支付宝
			payDTO.setPaystyle(IBdPripmCodeConst.CODE_PRI_PM_ALIPAY);
		}else if("3".equals(payType)){
			//微信
			payDTO.setPaystyle(IBdPripmCodeConst.CODE_PRI_PM_WECHAT); //付款方式
		}else{
			throw new BizException("支付方式错误！");
		}
		payDTO.setRelpay(new FDouble(money));
		payDTO.setChange(payDTO.getRelpay().sub(payDTO.getAmt()));
		payDTO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		return payDTO;
	}
	/**
	 * 检查预约是否可以支付
	 * 
	 * @param scAptDo
	 * @throws BizException 
	 */
	private void checkExec(ScAptDO scAptDo) throws BizException{
		//是否已回收
		if(scAptDo.getFg_canc().booleanValue()){
			throw new BizException("该预约已经取消！");
		}
		//是否已支付
		if(IScDictCodeConst.SD_APTSTATUS_PAY.equals(scAptDo.getSd_status())){
			throw new BizException("预约已经支付, 不能重复收费");
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(scAptDo.getSd_status()))
			throw new BizException("预约已经支付, 不能重复收费");
	}
}
