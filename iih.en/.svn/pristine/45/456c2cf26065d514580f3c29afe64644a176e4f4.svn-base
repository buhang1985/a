package iih.en.itf.bp.opapt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingItmDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingRltDTO;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.ep.HpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.itf.bean.input.opapt.WsEnParamRegPricing;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultRegPricing;
import iih.en.pv.s.bp.op.ws.SetPsnDocContextBP;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
/**
 * 挂号划价
 * 
 * @author liubin
 *
 */
public class WsEnRegPricingBP {
	/**
	 * 挂号划价
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WsEnResult<WsEnResultRegPricing> exec(WsEnParamRegPricing param) throws BizException {
		//1.参数校验
		this.validate(param);
		//2.设置上下文
		this.setContext(param);
		//3.组装划价信息
		BlOpRegPricingDTO opRegPricingDTO = this.assemlyBlOpRegPricingDTO(param);
		//4.划价
		BlOpRegPricingRltDTO pricingRlt = this.pricing(opRegPricingDTO);
		return this.wrap(pricingRlt);
	}
	/**
	 * 参数校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validate(WsEnParamRegPricing param) throws BizException {
		if(param == null)
			throw new BizException("入参为空或者xml转换失败!");
		if(EnValidator.isEmpty(param.getPatCode()))
			throw new BizException("患者编码不能为空！");
		if(EnValidator.isEmpty(param.getCode_scsrv()))
			throw new BizException("排班服务编码不能为空！");
		if(EnValidator.isEmpty(param.getCode_emp_oper()))
			throw new BizException("操作员编码不能为空！");
	}
	/**
	 * 设置上下文
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void setContext(WsEnParamRegPricing param) throws BizException {
		new SetPsnDocContextBP().exec(param.getCode_emp_oper());
	}
	/**
	 * 组装划价入参
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private BlOpRegPricingDTO assemlyBlOpRegPricingDTO(WsEnParamRegPricing param) throws BizException{
		BlOpRegPricingDTO opRegPricingDTO = new BlOpRegPricingDTO();
		//获取患者信息
		PatDO pat = new PatEP().getPatByCode(param.getPatCode());
		if(pat == null)
			throw new BizException(String.format("获取患者信息[%s]失败！", param.getPatCode()));
		PiPatCaDO patCa = null;
		PiPatEP piPatEp = new PiPatEP();
		if(EnValidator.isEmpty(param.getCode_hp())){
			//自费
			patCa = piPatEp.getAptSelfPayPatca(pat);
			if(patCa == null)
				throw new BizException(String.format("获取患者分类失败！", param.getCode_hp()));
		}else{
			//医保
			HPDO hp = new HpEP().getHpByCode(param.getCode_hp());
			if(hp == null)
				throw new BizException(String.format("获取医保产品[%s]失败！", param.getCode_hp()));
			opRegPricingDTO.setId_hp(hp.getId_hp());
			patCa = new PiPatEP().getOpPatCaByHpId(hp.getId_hp());
			if(patCa == null)
				throw new BizException(String.format("获取医保产品[%s]对应患者分类失败！", param.getCode_hp()));
		}
		PsnDocDO psn = new PsnDocEP().getPsnByCode(param.getCode_emp_oper());
		if(psn == null)
			throw new BizException(String.format("获取操作员[%s]失败！", param.getCode_emp_oper()));
		DeptDO dept = new DeptEP().getDeptByCode(param.getCode_dep_oper());
		ScheduleSrvRelDO[] srvs = getSrvs(param);
		if(EnValidator.isEmpty(srvs))
			throw new BizException(String.format("获取排班服务信息[%s]失败！", param.getCode_scsrv()));
		opRegPricingDTO.setId_pat(pat.getId_pat());
		opRegPricingDTO.setId_patca(patCa.getId_patca());
		opRegPricingDTO.setId_pripat(patCa.getId_patpritp());
		opRegPricingDTO.setHpcardinfo(param.getHpcardinfo());
		FArrayList srvDetails = new FArrayList();
		for(ScheduleSrvRelDO srv : srvs){
			BlOpRegPricingItmDTO detail = new BlOpRegPricingItmDTO();
			detail.setId_srv(srv.getId_mdsrv());
			detail.setQuan(new FDouble(1));
			srvDetails.add(detail);
		}
		opRegPricingDTO.setDetail(srvDetails);
		return opRegPricingDTO;
	}
	/**
	 * 获取服务明细
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private ScheduleSrvRelDO[] getSrvs(WsEnParamRegPricing param)throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT SC_SRV_REL.* ");
		sqlBuilder.append(" FROM SC_SRV_REL SC_SRV_REL ");
		sqlBuilder.append(" INNER JOIN SC_SRV SC_SRV ON SC_SRV_REL.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sqlBuilder.append(" WHERE SC_SRV.CODE = ? ");
		sqlBuilder.append(" AND SC_SRV.SD_SCTP = ?  ");
		String orgWhere = ScGroupControlUtils.getGroupControlFitler(new ScheduleSrvDO(), "SC_SRV");
		if(!EnValidator.isEmpty(orgWhere)){
			sqlBuilder.append(" AND ").append(orgWhere);
		}
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(param.getCode_scsrv());
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		List<ScheduleSrvRelDO> list = (List<ScheduleSrvRelDO>) new DAFacade().execQuery(sqlBuilder.toString(), sqlParam, new BeanListHandler(ScheduleSrvRelDO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new ScheduleSrvRelDO[0]);
	}
	/**
	 * 划价
	 * 
	 * @param opRegPricingDTO
	 * @throws BizException
	 */
	private BlOpRegPricingRltDTO pricing(BlOpRegPricingDTO opRegPricingDTO) throws BizException{
		IBlOpChargeForEnInnerService serv = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
		return serv.regPricing(opRegPricingDTO);
	}
	/**
	 * 组装返回值
	 * 
	 * @param pricingRlt
	 * @return
	 * @throws BizException
	 */
	private WsEnResult<WsEnResultRegPricing> wrap(BlOpRegPricingRltDTO pricingRlt) throws BizException{
		if(pricingRlt == null)
			throw new BizException("划价失败！");
		WsEnResultRegPricing data = new WsEnResultRegPricing();
		data.setId_stoep(pricingRlt.getId_stoep());
		data.setCode_st(pricingRlt.getCode_st());
		data.setAmt(pricingRlt.getAmt().floatValue());
		data.setHpregisterinfo(pricingRlt.getHpregisterinfo());
		data.setHpdetailuploadinfo(pricingRlt.getHpdetailuploadinfo());
		data.setHpprestinfo(pricingRlt.getHpprestinfo());
		List<WsEnResultRegPricing> datas = new ArrayList<WsEnResultRegPricing>();
		datas.add(data);
		WsEnResult<WsEnResultRegPricing> result = new WsEnResult<WsEnResultRegPricing>();
		result.setDatas(datas);
		return result;
	}
}
