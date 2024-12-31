package iih.ei.std.s.v1.bp.mp.bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.oep.api.i.ILisBlendSamplerExtCallService;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ei.std.d.v1.mp.updatestatus.d.BillsupplyDTO;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.nr.api.bill.d.Billsupply;
import iih.mp.nr.mpcharge.IMpChargeService;
import iih.mp.nr.mpcharge.d.MpChargeDTO;
import iih.mp.nr.mpcharge.d.MpChargeSetDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
/**
 * 通用医技补费逻辑
* @ClassName: SetSupplyBillBp
* @Description: TODO(这里用一句话描述这个类的作用)
* @author zhy
* @date 2019年9月29日
*
 */
public class SetSupplyBillBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public void exec(BillsupplyDTO[] params, String code_entp) throws BizException {

		// 1、基础校验
		validation(params);

		// 2.实例化记账人信息
		initPsnId(params);

		// 3、调用补费
		setSupplyBillBp(params, code_entp);

	}

	/**
	 * 基础校验
	 * 
	 * @param params
	 * @throws BizException
	 */
	private void validation(BillsupplyDTO[] params) throws BizException {
		if (params == null || params.length <= 0)
			throw new BizException("医技计费:参数空异常！");
		List<String> srvList = new ArrayList<String>();
		Integer index = 0;
		for (BillsupplyDTO param : params) {
			if (StringUtil.isEmptyWithTrim(param.getCode_ent()))
				throw new BizException("医技补费:第【" + (index + 1) + "】行就诊编码空异常！");
			if (StringUtil.isEmptyWithTrim(param.getCode_srv()))
				throw new BizException("医技补费:第【" + (index + 1) + "】行补费项目编码空异常！");
			if (StringUtil.isEmptyWithTrim(param.getCode_dep()))
				throw new BizException("医技补费:第【" + (index + 1) + "】行补费科室编码空异常！");
			if (StringUtil.isEmptyWithTrim(param.getCode_emp()))
				throw new BizException("医技补费:第【" + (index + 1) + "】行补费人编码空异常！");
			if (param.getAttrVal("Quan_medu") != null) {
				double quan;
				try {
					quan = Double.parseDouble(param.getAttrVal("Quan_medu").toString());
				} catch (NumberFormatException ex) {
					throw new BizException("医技补费:第【" + (index + 1) + "】补费数量不合法！");
				}
				param.setQuan_medu(new FDouble(quan));
			}
			String srvKey = param.getCode_ent() + "|" + param.getCode_srv();
			if (srvList.contains(srvKey))
				throw new BizException("医技补费：就诊编码【" + param.getCode_ent() + "】对应补费项目【" + param.getCode_srv() + "】重复异常！");
			srvList.add(srvKey);
			index++;
		}
		for (int i = 0; i < params.length; i++) {
			if (!params[i].getCode_dep().equals(params[0].getCode_dep()))
				throw new BizException("医技补费：单次补费操作时，补费科室编码必须一致！");
		}
	}
	
	/**
	 * 根据人员编码查部门ID
	 * @param params
	 * @throws BizException 
	 */
	private void initPsnId(BillsupplyDTO[] params) throws BizException {
		PsnDocDO[] psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, params[0].getCode_emp());
		if (psnDocDOs != null && psnDocDOs.length > 0) {
			//2017年11月7日16:05:24 设置上下文人员ID
			Context.get().setStuffId(psnDocDOs[0].getId_psndoc());
		}
		if (psnDocDOs == null || psnDocDOs.length < 0) {
			throw new BizException("医技计费：编码为" + params[0].getCode_emp() + "的执行人不存在！");
		}
	}

	/**
	 * 调用补费（费用提供）
	 * 
	 * @param params
	 * @param code_entp
	 * @throws BizException
	 */
	private void setSupplyBillBp(BillsupplyDTO[] params, String code_entp) throws BizException {
		// 门诊计费
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			Billsupply[] billsupplies = changeDTO(params);
			ServiceFinder.find(ILisBlendSamplerExtCallService.class).setBillForSampler(billsupplies);
			// 住院计费
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			PatiVisitDO visitDO = ServiceFinder.find(IPativisitRService.class).findById(params[0].getCode_ent());
			Map<String,MedSrvDO> map = getSrvDOs(params);
			MpChargeDTO[] chargeDTOs = handledata(params,map,visitDO.getId_pat());
			ServiceFinder.find(IMpChargeService.class).mpChargingByOrig(chargeDTOs,getParamset());
		}

	}
	

	/**
	 * 
	 * @param params
	 * @return
	 * @throws BizException 
	 */
	private Map<String,MedSrvDO> getSrvDOs(BillsupplyDTO[] params) throws BizException{
		Map<String,MedSrvDO> map = new HashMap<String,MedSrvDO>();
		List<String> code_srv = new ArrayList<String>();
		for (BillsupplyDTO billsupply : params) {
			if(code_srv.contains(billsupply.getCode_srv())){
				continue;
			}
			code_srv.add(billsupply.getCode_srv());
		}
		MedSrvDO[] srvdo = ServiceFinder.find(IMedsrvMDORService.class).findByAttrValStrings(MedSrvDO.CODE, code_srv.toArray(new String[0]));
		map = MpnrUtils.mapBaseDO(srvdo, MedSrvDO.CODE);
		return map;
	}
	
	/**
	 * 参数转换
	 * @param string 
	 * @throws BizException 
	 */
	private MpChargeDTO[] handledata(BillsupplyDTO[] params,Map<String,MedSrvDO> map, String id_pat) throws BizException{
		List<MpChargeDTO> bilipdList =new ArrayList<MpChargeDTO>();
		for (BillsupplyDTO billsupply : params) {
			MpChargeDTO chargeDTO = new MpChargeDTO();
			if(!map.containsKey(billsupply.getCode_srv())){
				throw new BizException("未找到编码为["+billsupply.getCode_srv()+"] 对应的诊疗项目");
			}
			chargeDTO.setId_srv(map.get(billsupply.getCode_srv()).getId_srv());
			chargeDTO.setId_pat(id_pat);
			chargeDTO.setId_ent(billsupply.getCode_ent());
			chargeDTO.setId_unit_srv(map.get(billsupply.getCode_srv()).getId_unit_med());
			chargeDTO.setPrice_std(map.get(billsupply.getCode_srv()).getPri());
			chargeDTO.setQuan(billsupply.getQuan_medu());
			chargeDTO.setId_dep_mp(Context.get().getDeptId());
			chargeDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
			bilipdList.add(chargeDTO);
		}
		return bilipdList.toArray(new MpChargeDTO[bilipdList.size()]);
	}
	
	/**
	 * 获取记账参数
	 * 
	 * @return
	 */
	private MpChargeSetDTO getParamset() {
		MpChargeSetDTO rtn = new MpChargeSetDTO();
		rtn.setId_emp_cg(Context.get().getStuffId());// 记账人
		rtn.setId_dep_cg(Context.get().getDeptId());// 记账科室
		rtn.setDt_cg(new FDateTime());// 记账时间
		rtn.setFg_price_cal(FBoolean.TRUE);// 计算服务价格
		rtn.setFg_singlepat(FBoolean.FALSE);// 单患者模式
		rtn.setFg_postpaid(FBoolean.TRUE);// 是否支持后付费
		rtn.setFg_exception(FBoolean.TRUE);// 是否抛异常
		rtn.setFg_addfee(FBoolean.TRUE);
		rtn.setSrcfunc_des("techcharge");// 记账来源
		return rtn;
	}
	
	private Billsupply[] changeDTO(BillsupplyDTO[] params) {
	    List<Billsupply> list = new ArrayList<>();
		if (null != params && params.length > 0) {
			for (BillsupplyDTO dto : params) {
				Billsupply billsupply = new Billsupply();
				billsupply.setCode_ent(dto.getCode_ent());
				billsupply.setCode_srv(dto.getCode_srv());
				billsupply.setCode_dep(dto.getCode_dep());
				billsupply.setQuan_medu(dto.getQuan_medu());
				billsupply.setCode_emp(dto.getCode_emp());
				list.add(billsupply);
			}
		}
		return (Billsupply[]) list.toArray(new Billsupply[0]);
	}
}
