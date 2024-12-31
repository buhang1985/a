package iih.bl.pay.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.params.BlParams;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊收取患者初次建档费
 * @author ly 2018/07/18
 *
 */
public class OpCollectPatRegisterBP {

	private PatDO pat = null;
	
	public OpCollectPatRegisterBP(){}
	
	public OpCollectPatRegisterBP(PatDO pat){
		this.pat = pat;
	}
	
	/**
	 * 门诊收取患者初次建档费
	 * @throws BizException
	 */
	public void exec(String patId) throws BizException{
		
		//暂不处理
	}
	
	/**
	 * 组装记账数据
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] assembleCgData()throws BizException{
		
		String srvIds = BlParams.BLCG0008();
		if(StringUtil.isEmpty(srvIds))
			return null;
		
		IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] srvDos = srvService.findByIds(srvIds.split(","), FBoolean.FALSE);
		
		List<BlOrderAppendBillParamDTO> paramList = new ArrayList<BlOrderAppendBillParamDTO>();
		for (MedSrvDO srvDO : srvDos) {
			BlOrderAppendBillParamDTO param = new BlOrderAppendBillParamDTO();
			param.setId_pat(this.pat.getId_pat());
			param.setId_pripat(this.pat.getId_patpritp());
			param.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			param.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			param.setId_srv(srvDO.getId_srv());
			param.setId_srvtp(srvDO.getId_srvtp());
			param.setSd_srvtp(srvDO.getSd_srvtp());
			param.setId_srvca(srvDO.getId_srvca());
			param.setCode_srv(srvDO.getCode());
			param.setName_srv(srvDO.getName());
			param.setSrvu(srvDO.getId_unit_med());
			param.setFg_mm(FBoolean.FALSE);
			param.setEu_srctp(FeeOriginEnum.PATREGISTER_FEE);
			param.setId_dep_or(Context.get().getDeptId());
			param.setId_org_or(Context.get().getOrgId());
			param.setId_emp_or(Context.get().getStuffId());
			//记账日期
			param.setDt_or(BlFlowContextUtil.getNowTime());
			param.setId_grp(Context.get().getGroupId());
			param.setId_org(Context.get().getOrgId());
			param.setId_org_cg(Context.get().getOrgId());
			param.setId_dep_cg(Context.get().getDeptId());
			param.setId_emp_cg(Context.get().getStuffId());
			param.setId_dep_mp(Context.get().getDeptId());
			param.setId_org_mp(Context.get().getOrgId());
			param.setDt_cg(AppUtils.getServerDateTime());
			param.setEu_direct(BookRtnDirectEnum.CHARGES);
			param.setQuan(FDouble.ONE_DBL);
			param.setSupportAppendBill(FBoolean.FALSE);
			
			BlOrderAppendOutpBillParamDTO outParam = new BlOrderAppendOutpBillParamDTO();
			outParam.setFg_acc(FBoolean.TRUE);
			
			param.setOutpBillDTO(outParam);
			paramList.add(param);
		}
		
		return paramList.toArray(new BlOrderAppendBillParamDTO[0]);
	}

	/**
	 * 组装记账数据新
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountDTO[] assembleCgDataNew() throws BizException{
		
		String srvIds = BlParams.BLCG0008();
		if(StringUtil.isEmpty(srvIds))
			return null;
		
		IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] srvDos = srvService.findByIds(srvIds.split(","), FBoolean.FALSE);
		
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		for (MedSrvDO srvDO : srvDos) {
			
			BlCgAccountDTO cardAccDto = new BlCgAccountDTO();
			cardAccDto.setId_pat(this.pat.getId_pat());
			cardAccDto.setId_srv(srvDO.getId_srv());
			cardAccDto.setQuan(FDouble.ONE_DBL);
			cardAccDto.setFg_mm(FBoolean.FALSE);
			cardAccDto.setId_unit_srv(srvDO.getId_unit_med());
			cardAccDto.setEu_direct(BookRtnDirectEnum.CHARGES);
			cardAccDto.setId_dep_or(Context.get().getDeptId());
			cardAccDto.setId_emp_or(Context.get().getStuffId());
			cardAccDto.setId_dep_mp(Context.get().getDeptId());
			cardAccDto.setFg_addfee(FBoolean.FALSE);
			
			cgAccList.add(cardAccDto);
		}
		
		return cgAccList.toArray(new BlCgAccountDTO[0]);
	}
}
