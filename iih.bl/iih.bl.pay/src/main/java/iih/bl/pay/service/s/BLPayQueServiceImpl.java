package iih.bl.pay.service.s;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.pay.blpaypat.bp.BlPayPmBp;
import iih.bl.pay.blpaypat.bp.BlprepayDetailBp;
import iih.bl.pay.blpaypat.bp.BlprepayStDetailBp;
import iih.bl.pay.blpaypat.bp.BlprepayUnStDetailBp;
import iih.bl.pay.blpaypat.bp.GetPrepayPatItemDTOByQur;
import iih.bl.pay.blpaypat.bp.ip.GetIpBannerInfoBp;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blprepayunstdetaildto.d.BlPrepayUnStDetailDTO;
import iih.bl.pay.bp.qry.GetBlPrePayPatDOInfoBp;
import iih.bl.pay.bp.qry.GetBlPrePayPatDOsBp;
import iih.bl.pay.bp.qry.GetEnAccountDOBp;
import iih.bl.pay.bp.qry.GetPatInfoByCondBp;
import iih.bl.pay.bp.qry.GetPiPatAccDOByIdpatBp;
import iih.bl.pay.debtcallup.DebtcallupBp;
import iih.bl.pay.designedfundspkgcollect.bp.DesignedFundsPkgCollectBp;
import iih.bl.pay.designedfundspkgcollect.bp.execQryAllPipatSrvPkgDTOs;
import iih.bl.pay.designedfundspkgcollect.bp.execQryPiPatSrvPkgDTOById;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pay.dto.d.BlLowerlimitOfArrearsDTO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.pay.dto.d.DebtinfoDTO;
import iih.bl.pay.dto.d.ETPatInfoDTO;
import iih.bl.pay.dto.d.PatInfoQryDTO;
import iih.bl.pay.dto.d.PipatSrvPkgDTO;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.bl.pay.prepayacctrans.bp.PrepayacctransBp;
import iih.bl.pay.s.bp.ip.GetBlLowerlimitOfArrearsBp;
import iih.bl.pay.service.i.IBLPayQueService;
import iih.bl.pay.service.s.bp.FindPatInfoByPageInfoBP;
import iih.bl.st.blstdetaildto.d.BlStDetailDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.pi.acc.account.d.PiPatAccDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

@Service(serviceInterfaces={IBLPayQueService.class}, binding=Binding.JSONRPC)
public  class BLPayQueServiceImpl implements IBLPayQueService {

	@Override
	public BlPayPatItemDTO getBlPayPatItemByQuery(String queryStr,String id_user,String payType)
			throws BizException {
		
		GetPrepayPatItemDTOByQur  qrybp=new GetPrepayPatItemDTOByQur();  
		return  qrybp.getBlPayPatItemDTOByQur(queryStr, id_user, payType);
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//return blpaypatCrudBp.getBlPayPatItemDTOByQur(queryStr, id_user, payType);
	}
	
	@Override 
	public BlPayPatItemDTO getBlPayPatItemByQur(String queryStr, String payType) throws BizException{
		GetPrepayPatItemDTOByQur qrybp = new GetPrepayPatItemDTOByQur();
		return qrybp.getBlPayPatItemByQur(queryStr, payType);
	}
	@Override
	public PrepayAccTransDTO[] getBalanceByIds(String id_pat)
			throws BizException {
		// TODO Auto-generated method stub
		PrepayacctransBp bp=new PrepayacctransBp();
		return bp.getBalanceByIds(id_pat);
	}

	@Override
	public BlPrePayPatDO[] getBlPrePayPatDOsByIds(String id_pat,
			String sd_paytp) throws BizException {
		// TODO Auto-generated method stub
		//PrepayacctransBp bp=new PrepayacctransBp();
		//return bp.getBlPrePayPatDOsByIds(id_pat,sd_paytp);
		GetBlPrePayPatDOsBp  qrybp=new GetBlPrePayPatDOsBp();
		return qrybp.execQryBlPrePayPatDOsByIds(id_pat, sd_paytp);
	}
	
	@Override
	public PiPatAccDO getPiPatAccDOByIdpat(String id_pat) throws BizException {
		// TODO Auto-generated method stub
		//PrepayacctransBp bp=new PrepayacctransBp();
		//return bp.getPiPatAccDOByIdpat(id_pat);
		GetPiPatAccDOByIdpatBp gppabp = new GetPiPatAccDOByIdpatBp();
		return gppabp.execQryPiPatAccDOByIdpat(id_pat);
	}
	
	@Override
	public BlPrePayPatDO[] getBlPrePayPatDOsByIdpatident(String id_pat,
			String id_ent) throws BizException {
		// TODO Auto-generated method stub
		//PrepayacctransBp bp=new PrepayacctransBp();
		//return bp.getBlPrePayPatDOsByIdpatident(id_pat,id_ent);
		GetBlPrePayPatDOInfoBp gbp =new GetBlPrePayPatDOInfoBp();
		return  gbp.execQryBlPrePayPatDOsByIdpatident(id_pat, id_ent);
	}
	
	@Override
	public EnAccountDO  getEnAccountDOByIdentidpat(String id_ent, String id_pat)
			throws BizException {
		// TODO Auto-generated method stub
		//PrepayacctransBp bp=new PrepayacctransBp();
		//return bp.getEnAccountDOByIdentidpat(id_ent,id_pat);
		GetEnAccountDOBp newbp = new GetEnAccountDOBp ();
		return newbp.execQryEnAccountDOByIdentidpat(id_ent, id_pat) ;
	}
	
	@Override
	public DebtinfoDTO[] findDebtinfoDTOsByQCond(String whereSql,
			String orderStr, FBoolean isLazy) throws BizException {
		// TODO Auto-generated method stub
		DebtcallupBp bp=new  DebtcallupBp(); 
		return bp.findDebtinfoDTOsByQCond(whereSql, orderStr, isLazy);
	}
	
	/**
	 * 获得门诊记账主键为ID_CGOEP下到付款信息：就诊领域使用
	 * @author tcy
	 */
	@Override
	public BlPayPmDTO[] getBlPayPmDTOByIdCgOep(String Id_cgoep)
			throws BizException {
		// TODO Auto-generated method stub
		BlPayPmBp bp=new BlPayPmBp();
		return bp.GetBlPayPmByIdCgOepDTO(Id_cgoep);
	}
	/**
	 * 通过患者主键id_pat查询获取该患者名下的服务包，目前在用
	 */
	@Override
	public PipatSrvPkgDTO[] findPiPatSrvPkgDTOByIdpat(String id_pat)
			throws BizException {
		// TODO Auto-generated method stub
		//DesignedFundsPkgCollectBp bp=new DesignedFundsPkgCollectBp();
		
		//return bp.findPiPatSrvPkgDTOByIdpat(id_pat);
		execQryPiPatSrvPkgDTOById  bp= new execQryPiPatSrvPkgDTOById();
		return bp.execfindPiPatSrvPkgDTOByIdpat(id_pat);
	}
	
	/**
	 * 查询得到所有可用的服务包，目前在用
	 */
	@Override
	public PipatSrvPkgDTO[] getAllPipatSrvPkgDTOs() throws BizException {
		// TODO Auto-generated method stub
	//	DesignedFundsPkgCollectBp bp=new DesignedFundsPkgCollectBp();
		execQryAllPipatSrvPkgDTOs bp= new execQryAllPipatSrvPkgDTOs();
		return bp.execQryAllPipatSrvPkgDTOs();
	}
	
	@Override
	public String getNextInvoiceNo(String Id_emp_inc, String code_incca)
			throws BizException {
		// TODO Auto-generated method stub
		DesignedFundsPkgCollectBp bp=new DesignedFundsPkgCollectBp();
		return bp.getNextInvoiceNo(Id_emp_inc,code_incca);
	}
    
	/**
	 * 根据banner中输入值查询相关患者就诊信息
	 * @author wei_jia
	 * @author li_pengying
	 */
	@Override
	public BlBannerDTO[] findBannerDtoInfo(String inputValue,
			String[] selectCondition) throws BizException {
//		BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
//		return blpaypatCrudBp.getBannerEnEntInfo(inputValue, selectCondition);
		
		GetIpBannerInfoBp newbp= new GetIpBannerInfoBp();
		return newbp.getBannerEnEntInfo(inputValue,selectCondition);
	}
	
	 /**
     * 铜陵住院预交金节点的患者信息弹窗窗用  查询患者信息接口，参数为从前台界面传过来的查询条件
     * @param strcond
     * @return
     * @throws BizException
     */
	@Override
	public   PatInfoQryDTO[] findByQueryCondsforPatInfoqry(String strcond) throws BizException{
		GetPatInfoByCondBp  bp = new GetPatInfoByCondBp();
		return bp.exec(strcond);
	}
	
	/**
	 * 住院预交金节点的患者信息弹窗窗用  查询患者信息接口(分组)
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
    public PagingRtnData<PatInfoQryDTO> findPatInfoByPageInfo(PaginationInfo pg, String wherePart,String orderByPart)throws BizException{
    	FindPatInfoByPageInfoBP bp=new FindPatInfoByPageInfoBP();
    	return bp.exec(pg, wherePart, orderByPart);
    }

	/**
	 * @author xy.zhou 
	 */
	@Override
	public BlLowerlimitOfArrearsDTO[] findETPatsLowerLimitOfArrears(ETPatInfoDTO etPatInfoDTO) throws BizException {
		GetBlLowerlimitOfArrearsBp	bp=new GetBlLowerlimitOfArrearsBp();	
		return bp.findETPatsLowerLimitOfArrears(etPatInfoDTO);
	}

	@Override
	public BlPrepayDTO[] findPrepayDetail(String id_pat, String code_enttp, String Dt_start, String Dt_end)
			throws BizException {
		BlprepayDetailBp bp = new BlprepayDetailBp();
		return bp.findPrepayDetail(id_pat, code_enttp, Dt_start, Dt_end);
	}

	@Override
	public BlStDetailDTO[] findPrepayStDetail(String id_paypat, String code_enttp) throws BizException {
		BlprepayStDetailBp bp = new BlprepayStDetailBp();
		return bp.findPrepayStDetail(id_paypat, code_enttp);
	}
	
	@Override
	public BlPrepayUnStDetailDTO[] findPrepayUnStDetail(String id_pat, String code_enttp, String Dt_start, String Dt_end)throws BizException {
		BlprepayUnStDetailBp bp = new BlprepayUnStDetailBp();
		return bp.findPrepayUnStDetail(id_pat, code_enttp, Dt_start, Dt_end);
	}

	@Override
	public PagingRtnData<BlPrepayDTO> findPrepayDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException {
		BlprepayDetailBp blStarIpBp = new BlprepayDetailBp();
		return blStarIpBp.findPrepayDetailPageInfoDos(map, pageInfo);
	}

	@Override
	public PagingRtnData<BlPrepayUnStDetailDTO> findPrepayUnStDetailPageInfoDos(FMap map, PaginationInfo pageInfo)
			throws BizException {
		
		BlprepayUnStDetailBp bp = new BlprepayUnStDetailBp();
		return bp.findPrepayUnStDetailPageInfoDos(map, pageInfo);
	}
	
	@Override
	public PagingRtnData<BlStDetailDTO> findPrepayStDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException {
		BlprepayStDetailBp bp = new BlprepayStDetailBp();
		return bp.findPrepayStDetailPageInfoDos(map, pageInfo);
	}
}
