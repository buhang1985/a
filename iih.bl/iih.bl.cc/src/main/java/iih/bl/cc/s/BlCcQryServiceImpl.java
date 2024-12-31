package iih.bl.cc.s;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blccdto.d.BlPayPatIpDTO;
import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import iih.bl.cc.i.IBlCcQryService;
import iih.bl.cc.s.bp.GetBlPaypatIpDTOAfterBP;
import iih.bl.cc.s.bp.GetBlPaypatIpDTOBeforeBP;
import iih.bl.cc.s.bp.GetBlPaypatOepDtosPageAfterInfoBP;
import iih.bl.cc.s.bp.GetBlPaypatOepDtosPageBeforeInfoBP;
import iih.bl.cc.s.bp.GetCheckBlccDOCancelBP;
import iih.bl.cc.s.bp.GetCheckDataValidityPrintBP;
import iih.bl.cc.s.bp.GetPreviewChechOutBP;
import xap.lui.core.dataset.PaginationInfo;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 结账查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces={IBlCcQryService.class}, binding=Binding.JSONRPC)
public class BlCcQryServiceImpl implements IBlCcQryService {

	/**
	 *判断是否可以结账
	 *@param blccAggDOArr 结账AGGDO
	 */
	@Override
	public FBoolean checkBlccCancel(BlCcDO blccDO) throws BizException {
		GetCheckBlccDOCancelBP blccCancel = new GetCheckBlccDOCancelBP();
		return blccCancel.exec(blccDO);
	}

	@Override
	public BlccAggDO[] previewChechOut(String id_user, String id_org,
			String sd_cctp, FDateTime end_time) throws BizException {
		GetPreviewChechOutBP blccBp = new GetPreviewChechOutBP();
		return blccBp.exec(id_user, id_org, sd_cctp, end_time);
	}

	@Override
	public PagingRtnData<BlPayPatIpDTO> findBlPaypatIpDTOPageInfo(FMap map,
			PaginationInfo pageInfo) throws BizException {
		StringBuffer sb= new StringBuffer();
		SqlParam sqlParam= new SqlParam();
		PagingRtnData<BlPayPatIpDTO> pageDTO = new PagingRtnData<BlPayPatIpDTO>();
			
		if("".equals(map.get("id_cc").toString()) || map.get("id_cc") == null){
			GetBlPaypatIpDTOBeforeBP  before= new GetBlPaypatIpDTOBeforeBP(map,pageInfo);
			sb.append(before.getQrySQLStr());
			sqlParam=before.getQryParameter(sb);
		}
		else{
			GetBlPaypatIpDTOAfterBP end= new GetBlPaypatIpDTOAfterBP(map,pageInfo);
			sb.append(end.getQrySQLStr());
			sqlParam=end.getQryParameter(sb);
		}
		PagingServiceImpl<BlPayPatIpDTO> service = new PagingServiceImpl();	
		pageDTO = service.findByPageInfo(new BlPayPatIpDTO(), pageInfo,sb.toString(), "",sqlParam);
		return pageDTO;
	}
/**
 *  结账 已废弃
 */
	@Override
	public BlPayPatIpDTO[] getBlPaypatIpDtosByIdcc(String id_cc,
			String id_emp_pay) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagingRtnData<BlpayOepPatDTO> findBlPaypatOepDtosPageInfo(FMap map,
			PaginationInfo pageInfo) throws BizException {
		String sb=null;
		PagingRtnData<BlpayOepPatDTO> pageDTO = new PagingRtnData<BlpayOepPatDTO>();
		PagingServiceImpl<BlpayOepPatDTO> service = new PagingServiceImpl();
		if(map.isEmpty()){
			return pageDTO;
		}
		if("".equals(map.get("id_cc").toString()) || map.get("id_cc") == null) {
			GetBlPaypatOepDtosPageBeforeInfoBP before= new GetBlPaypatOepDtosPageBeforeInfoBP(map,pageInfo);
			sb=before.toString();
		}else{
			GetBlPaypatOepDtosPageAfterInfoBP  after= new GetBlPaypatOepDtosPageAfterInfoBP(map,pageInfo);
			sb= after.toString();
		}
		pageDTO = service.findByPageInfo(new BlpayOepPatDTO(), pageInfo,sb.toString(), "", null);
		return pageDTO;		
		
	}
	/**
	 * 结账后打印时，检验数据有效性（防止取消结账后，打印已取消的结账数据）
	 * @param id_cc
	 * @author LIM
	 */
	@Override
	public FBoolean checkDataValidity_Print(String id_cc) throws BizException {
		GetCheckDataValidityPrintBP bCheck= new GetCheckDataValidityPrintBP();
		return bCheck.exec(id_cc);
	}

	@Override
	public FDouble getBlPaypatOepDtosTotalAmt(FMap map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
