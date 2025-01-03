package iih.bl.st.blauditip.bp;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.params.BlParams;
import iih.bl.st.blauditip.bp.qry.GetEtOutHpPatUnStFeeQry;
import iih.bl.st.blauditip.bp.qry.GetOutHpPatUnStFeeQry;
import iih.bl.st.blauditip.bp.qry.OutPatListQry;
import iih.bl.st.blipauditouthospcheck.d.BlIpAuditOutHospCheckDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 出院出观患者审核信息查询
 * 
 * @author shaokx
 * @since 2018/7/25
 */
public class GetOutPatListByQryBP {

	private boolean Fg_ET;
	public GetOutPatListByQryBP()
	{
		Fg_ET = false;
	}
	public GetOutPatListByQryBP(boolean fg_et)
	{
		Fg_ET = fg_et;
	}
	
	/**
	 * 出院患者带有查询方案和分页的查询
	 * 
	 * @param qryRoot
	 * @param pgInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> exec(QryRootNodeDTO qryRoot,
			PaginationInfo pgInfo) throws BizException {
		// 获得查询方案的String查询条件
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRoot);
		
		// 得到带有分页的数据集合
		PagingRtnData<BlIpAuditOutHospCheckDTO> pageFeeDTO = new PagingRtnData<BlIpAuditOutHospCheckDTO>();
		pageFeeDTO = getPatsInfo(whereStr, pgInfo);
		
		if (pageFeeDTO==null)
			return null;
		
		List<String> entids=new ArrayList<>();
		for (int i = 0; i < pageFeeDTO.getPageData().size(); i++) {
			BlIpAuditOutHospCheckDTO outHospCheckDTO = (BlIpAuditOutHospCheckDTO)
					pageFeeDTO.getPageData().get(i);
			if (outHospCheckDTO.getBirth_date() != null) {
				String age = AgeCalcUtil.getAge(outHospCheckDTO.getBirth_date());
				outHospCheckDTO.setPat_age(age);
			}
			entids.add(outHospCheckDTO.getId_ent());
		}
		//获取医保患者的未结费用
		Map<String,FDouble> hpPatUnstDee = new HashMap<String,FDouble>();
		if(this.Fg_ET)
		{
			hpPatUnstDee= this.getEtHpPatUnSt(whereStr);
		}
		else
		{
			hpPatUnstDee= this.getHpPatUnSt(whereStr);
		}
		PagingRtnData<BlIpAuditOutHospCheckDTO> rtnData = this.getAmtUncg(pageFeeDTO, hpPatUnstDee);
		return rtnData;
	}
	
	private PagingRtnData<BlIpAuditOutHospCheckDTO> getPatsInfo(String whereStr, PaginationInfo pgInfo) throws BizException
	{
		PagingRtnData<BlIpAuditOutHospCheckDTO> pageFeeDTO = new PagingRtnData<BlIpAuditOutHospCheckDTO>();
		PagingServiceImpl<BlIpAuditOutHospCheckDTO> service = new PagingServiceImpl<BlIpAuditOutHospCheckDTO>();
		OutPatListQry qry = new OutPatListQry(whereStr);
		qry.setFg_emgstay(Fg_ET);
        // 普通住院
		pageFeeDTO = service.findByPageInfo(new BlIpAuditOutHospCheckDTO(), pgInfo, qry.getQrySQLStr(), "", qry.getQryParameter(null));

		return pageFeeDTO;
	}
	
	/**
	 * 
	 * @Description: 获取未结算费用    
	 * @author: xy.zhou     
	 * @throws
	 */
	private PagingRtnData<BlIpAuditOutHospCheckDTO>  getAmtUncg
	(PagingRtnData<BlIpAuditOutHospCheckDTO> pageFeeDTO,Map<String,FDouble> hpPatUnstDee)throws BizException{
		
		//不取预交金锁定金额，取记账表里未结算费用，没有则为0 by lim 2018-11-22
		for (int i = 0; i < pageFeeDTO.getPageData().size(); i++) {
			BlIpAuditOutHospCheckDTO outHospCheckDTO = (BlIpAuditOutHospCheckDTO)
					pageFeeDTO.getPageData().get(i);
			if(hpPatUnstDee.containsKey(outHospCheckDTO.getId_ent())){
				outHospCheckDTO.setAmt_uncg(hpPatUnstDee.get(outHospCheckDTO.getId_ent()));
			}else{
				outHospCheckDTO.setAmt_uncg(new FDouble());
			}
		}
		return pageFeeDTO;
	}
	
	/**
	 * 获取医保患者的未结费用
	 * @param sWhere
	 * @return
	 * @throws Exception 
	 */
	private Map<String, FDouble> getHpPatUnSt(String sWhere) throws BizException {

		Map<String, FDouble> patUnstMap = new HashMap<String, FDouble>();
		String idhps = BlParams.BLHP000026();
		String[] idHpArr = StringUtils.isNotEmpty(idhps) ? idhps.split(",") : new String[] {};

		GetOutHpPatUnStFeeQry qry = new GetOutHpPatUnStFeeQry(sWhere, idHpArr);
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> blcgDoList = (List<BlCgIpDO>) new DAFacade().execQuery(qry.getQrySQLStr(),
				new BeanListHandler(BlCgIpDO.class));

		if (!ListUtil.isEmpty(blcgDoList)) {
			for (BlCgIpDO blcgDo : blcgDoList) {
				patUnstMap.put(blcgDo.getId_ent(), blcgDo.getAmt_ratio());
			}
		}
		return patUnstMap;
	}
	
	/**
	 * 获取医保患者的未结费用
	 * @param sWhere
	 * @return
	 * @throws Exception 
	 */
	private Map<String, FDouble> getEtHpPatUnSt(String sWhere) throws BizException {

		Map<String, FDouble> patUnstMap = new HashMap<String, FDouble>();
		String[] idHpArr = new String[0];
		GetEtOutHpPatUnStFeeQry qry = new GetEtOutHpPatUnStFeeQry(sWhere, idHpArr);
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> blcgDoList = (List<BlCgIpDO>) new DAFacade().execQuery(qry.getQrySQLStr(),
				new BeanListHandler(BlCgIpDO.class));

		if (!ListUtil.isEmpty(blcgDoList)) {
			for (BlCgIpDO blcgDo : blcgDoList) {
				patUnstMap.put(blcgDo.getId_ent(), blcgDo.getAmt_ratio());
			}
		}
		return patUnstMap;
	}
}
