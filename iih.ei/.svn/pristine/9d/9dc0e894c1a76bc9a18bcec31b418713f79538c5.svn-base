package iih.ei.std.s.v1.bp.en;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingItmDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingRltDTO;
import iih.ei.std.d.v1.en.regpricing.d.RegPricingParamDTO;
import iih.ei.std.d.v1.en.regpricing.d.RegPricingResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.HpEP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.ei.std.s.v1.bp.common.PsnDocEP;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 挂号划价
 * @author fanlq
 * @date: 2019年10月11日 下午4:03:14
 */
public class RegPricingBP  extends IIHServiceBaseBP<RegPricingParamDTO, RegPricingResultDTO> {

	@Override
	protected void checkParam(RegPricingParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getCode_pat()))
			throw new BizException("患者编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_scsrv()))
			throw new BizException("排班服务编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_opr()))
			throw new BizException("操作员编码不能为空！");
	}

	@Override
	protected RegPricingResultDTO process(RegPricingParamDTO param) throws BizException {
		//1.组装划价信息
		BlOpRegPricingDTO opRegPricingDTO = this.assemlyBlOpRegPricingDTO(param);
		//2.划价
		BlOpRegPricingRltDTO pricingRlt = this.pricing(opRegPricingDTO);
		return this.wrap(pricingRlt);
	}

	/**
	 * 组装划价入参
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private BlOpRegPricingDTO assemlyBlOpRegPricingDTO(RegPricingParamDTO param) throws BizException{
		BlOpRegPricingDTO opRegPricingDTO = new BlOpRegPricingDTO();
		//获取患者信息
		PatEP ep = new PatEP();
		PatDO pat = ep.getPatByCode(param.getCode_pat());
		if(pat == null)
			throw new BizException(String.format("获取患者信息[%s]失败！", param.getCode_pat()));
		PiPatCaDO patCa = null;
		
		if(StringUtils.isNullOrEmpty(param.getCode_hp())){
			//自费
			patCa = ep.getAptSelfPayPatca(pat);
			if(patCa == null)
				throw new BizException(String.format("获取患者分类失败！", param.getCode_hp()));
		}else{
			//医保
			HPDO hp = new HpEP().getHpByCode(param.getCode_hp());
			if(hp == null)
				throw new BizException(String.format("获取医保产品[%s]失败！", param.getCode_hp()));
			opRegPricingDTO.setId_hp(hp.getId_hp());
			patCa = ep.getOpPatCaByHpId(hp.getId_hp());
			if(patCa == null)
				throw new BizException(String.format("获取医保产品[%s]对应患者分类失败！", param.getCode_hp()));
		}
		PsnDocDO psn = new PsnDocEP().getPsnByCode(param.getCode_opr());
		if(psn == null)
			throw new BizException(String.format("获取操作员[%s]失败！", param.getCode_opr()));
		ScheduleSrvRelDO[] srvs = getSrvs(param);
		if(ArrayUtil.isEmpty(srvs))
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
	private ScheduleSrvRelDO[] getSrvs(RegPricingParamDTO param)throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT SC_SRV_REL.* ");
		sqlBuilder.append(" FROM SC_SRV_REL SC_SRV_REL ");
		sqlBuilder.append(" INNER JOIN SC_SRV SC_SRV ON SC_SRV_REL.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sqlBuilder.append(" WHERE SC_SRV.CODE = ? ");
		sqlBuilder.append(" AND SC_SRV.SD_SCTP = ?  ");
		String orgWhere = ScGroupControlUtils.getGroupControlFitler(new ScheduleSrvDO(), "SC_SRV");
		if(!StringUtils.isNullOrEmpty(orgWhere)){
			sqlBuilder.append(" AND ").append(orgWhere);
		}
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(param.getCode_scsrv());
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		@SuppressWarnings("unchecked")
		List<ScheduleSrvRelDO> list = (List<ScheduleSrvRelDO>) new DAFacade().execQuery(sqlBuilder.toString(), sqlParam, new BeanListHandler(ScheduleSrvRelDO.class));
		return ListUtil.isEmpty(list) ? null : list.toArray(new ScheduleSrvRelDO[0]);
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
	private RegPricingResultDTO wrap(BlOpRegPricingRltDTO pricingRlt) throws BizException{
		if(pricingRlt == null)
			throw new BizException("划价失败！");
		RegPricingResultDTO data = new RegPricingResultDTO();
		data.setId_stoep(pricingRlt.getId_stoep());
		data.setCode_st(pricingRlt.getCode_st());
		data.setAmt_ticket(pricingRlt.getAmt().toString());
		data.setHpregisterinfo(pricingRlt.getHpregisterinfo());
		data.setHpdetailuploadinfo(pricingRlt.getHpdetailuploadinfo());
		data.setHpprestinfo(pricingRlt.getHpprestinfo());
		return data;
	}
}
