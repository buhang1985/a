package iih.bl.cc.service.s;

import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import iih.bl.cc.blcc.bp.BlccBp;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blccdto.d.BlPayPatIpDTO;
import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import iih.bl.cc.blccoepinfodto.d.BlccOepInfoDTO;
import iih.bl.cc.s.bp.GatherIpPayFeeBp;
import iih.bl.cc.s.bp.GetBlPaypatIpDTOAfterBP;
import iih.bl.cc.s.bp.GetBlPaypatIpDTOBeforeBP;
import iih.bl.cc.s.bp.GetBlPaypatOepDtosPageAfterInfoBP;
import iih.bl.cc.s.bp.GetBlPaypatOepDtosPageBeforeInfoBP;
import iih.bl.cc.s.bp.GetCheckDataValidityPrintBP;
import iih.bl.cc.s.bp.GetPreviewChechOutBP;
import iih.bl.cc.service.i.IBLCcQueService;
import iih.bl.cc.service.s.bp.GetBlccOepInfosBP;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = {IBLCcQueService.class }, binding = Binding.JSONRPC)
public class IBLCcQueServiceImpl implements IBLCcQueService {

	//结账已废弃
	@Override
	public BlpayOepPatDTO[] findBlPaypatOepDtosByIdcc(String id_cc,String id_emp_pay)
			throws BizException {
		// TODO Auto-generated method stub
		BlccBp bp=new BlccBp();
		return bp.findBlPaypatOepDtosByIdcc(id_cc,id_emp_pay) ;
	}

	//结账已废弃
	@Override
	public BlPayPatIpDTO[] getBlPaypatIpDtosByIdcc(String id_cc,String id_emp_pay)
			throws BizException {
		// TODO Auto-generated method stub
		BlccBp bp=new BlccBp();
		return bp.getBlPaypatIpDtosByIdcc(id_cc,id_emp_pay) ;
	}

	/**
	 * 住院结账预览时获取住院结算收付款明细信息(分页)（包括结账后查询）
	 * @param map   where条件集合(id_user,end_time,id_cc)	 
	 * @param pageInfo
	 * @author Liwq
	 * @throws BizException
	 * */
	@Override
	public PagingRtnData<BlPayPatIpDTO> findBlPaypatIpDTOPageInfo(FMap map, PaginationInfo pageInfo) throws BizException {
	//	BlccBp bp=new BlccBp();
	//	return bp.getBlPaypatIpDTOPageInfo(map, pageInfo);
		StringBuffer sb= new StringBuffer();
		SqlParam sqlParam= new SqlParam();
		PagingRtnData<BlPayPatIpDTO> pageDTO = new PagingRtnData<BlPayPatIpDTO>();
			
		if("".equals(map.get("id_cc").toString()) || map.get("id_cc") == null){
			//预览状态下的住院收付款列表显示
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
		setBlPayPatIpDTOIncno(pageDTO);
		return pageDTO;
	}

	/**
	 * 设置住院收付款明细发票号
	 * @param pageDTO
	 * @throws BizException
	 */
	private void setBlPayPatIpDTOIncno(PagingRtnData<BlPayPatIpDTO> pageDTO) throws BizException{
		if(pageDTO != null && pageDTO.getPageData() != null && pageDTO.getPageData().size() > 0){
			HashSet<String> id_stipset = new HashSet<>();
			FArrayList blpayIpPatDTOs = pageDTO.getPageData();
			for(int i = 0,size = blpayIpPatDTOs.size(); i<size ; i++){
				BlPayPatIpDTO dto = (BlPayPatIpDTO)blpayIpPatDTOs.get(i);
				if(dto != null)
					id_stipset.add(dto.getId_stip());
			}
			if(id_stipset.size() > 0){
				//IBlincoepMDORService blincoepRService = ServiceFinder.find(BlincoepMDORService.class);
				IBlincipMDORService blincipRService = ServiceFinder.find(IBlincipMDORService.class);
				String[] id_stip_arr = id_stipset.toArray(new String [id_stipset.size()]);
				
				BlIncIpDO[] blincips = blincipRService.findByAttrValStrings(BlIncIpDO.ID_STIP, id_stip_arr);
				HashMap<String, String> stincmap = new HashMap<>();
				for(BlIncIpDO ipDo : blincips){
					String incnos = stincmap.get(ipDo.getId_stip());
					if(StringUtils.isBlank(incnos)){
						stincmap.put(ipDo.getId_stip(), ipDo.getIncno());
					}else{
						stincmap.put(ipDo.getId_stip(),incnos + ","+ ipDo.getIncno());
					}
				}
				for(int i = 0,size = blpayIpPatDTOs.size(); i<size ; i++){
					BlPayPatIpDTO dto = (BlPayPatIpDTO)blpayIpPatDTOs.get(i);
					dto.setIncno(stincmap.get(dto.getId_stip()));
				}
			}
		}
	}
	
	/**
	 * 门诊结账预览时获取门诊结算收付款明细信息（分页）（包括结账后查询）
	 * @param map where条件集合（id_cc,end_time,id_cc）
	 * @param pageInfo
	 * @author Liwq
	 * @throws BizException
	 * */
	@Override
	public PagingRtnData<BlpayOepPatDTO> findBlPaypatOepDtosPageInfo(FMap map, PaginationInfo pageInfo) throws BizException {
//		BlccBp bp=new BlccBp();
//		return bp.getBlPaypatOepDtosPageInfo(map, pageInfo);
		StringBuffer sb= new StringBuffer();
		SqlParam sqlParam= new SqlParam();
		PagingRtnData<BlpayOepPatDTO> pageDTO = new PagingRtnData<BlpayOepPatDTO>();
		PagingServiceImpl<BlpayOepPatDTO> service = new PagingServiceImpl();
		if(map.isEmpty()){
			return pageDTO;
		}
		if("~".equals(map.get("id_cc").toString()) || map.get("id_cc") == null) {
			GetBlPaypatOepDtosPageBeforeInfoBP before= new GetBlPaypatOepDtosPageBeforeInfoBP(map,pageInfo);
			sb.append(before.getQrySQLStr());
			sqlParam=before.getQryParameter(sb);
		}else{
			GetBlPaypatOepDtosPageAfterInfoBP  after= new GetBlPaypatOepDtosPageAfterInfoBP(map,pageInfo);
			sb.append(after.getQrySQLStr());
			sqlParam=after.getQryParameter(sb);
		}
		pageDTO = service.findByPageInfo(new BlpayOepPatDTO(), pageInfo,sb.toString(), "", sqlParam);
		
		setBlpayOepPatDTOIncno(pageDTO);
		
		return pageDTO;				
	}
	//设置门诊收付款明细发票号
	private void setBlpayOepPatDTOIncno(PagingRtnData<BlpayOepPatDTO> pageDTO) throws BizException{
		if(pageDTO != null && pageDTO.getPageData() != null && pageDTO.getPageData().size() > 0){
			HashSet<String> id_stoepset = new HashSet<>();
			FArrayList blpayOepPatDTOs = pageDTO.getPageData();
			for(int i = 0,size = blpayOepPatDTOs.size(); i<size ; i++){
				BlpayOepPatDTO dto = (BlpayOepPatDTO)blpayOepPatDTOs.get(i);
				if(dto != null)
				id_stoepset.add(dto.getId_stoep());
			}
			if(id_stoepset.size() > 0){
				//IBlincoepMDORService blincoepRService = ServiceFinder.find(BlincoepMDORService.class);
				IBlincoepMDORService blincoepRService = ServiceFinder.find(IBlincoepMDORService.class);
				String[] id_stoep_arr = id_stoepset.toArray(new String [id_stoepset.size()]);
				BlIncOepDO[] blincoeps = blincoepRService.findByAttrValStrings(BlIncOepDO.ID_STOEP, id_stoep_arr);
				HashMap<String, String> stincmap = new HashMap<>();
				if(!ArrayUtils.isEmpty(blincoeps))
				{
					for(BlIncOepDO oepdo : blincoeps){
						String incnos = stincmap.get(oepdo.getId_stoep());
						if(StringUtils.isBlank(incnos)){
							stincmap.put(oepdo.getId_stoep(), oepdo.getIncno());
						}else{
							stincmap.put(oepdo.getId_stoep(),incnos + ","+ oepdo.getIncno());
						}
					}
				}
				for(int i = 0,size = blpayOepPatDTOs.size(); i<size ; i++){
					BlpayOepPatDTO dto = (BlpayOepPatDTO)blpayOepPatDTOs.get(i);
					dto.setIncno(stincmap.get(dto.getId_stoep()));
				}
			}
		}
	}
	/**
	 * 查询结账 门诊收付款明细合计
	 * @param map where条件集合（id_cc,end_time,id_cc）
	 * @param pageInfo
	 * @author LIM
	 * @throws BizException
	 * @author LIM
	 * */
	@Override
	public FDouble getBlPaypatOepDtosTotalAmt(FMap map) throws BizException {
		BlpayOepPatDTO[] pageDTO = null;
		if(map.isEmpty()){
			return new FDouble();
		}
		if("~".equals(map.get("id_cc").toString()) || map.get("id_cc") == null) {
			GetBlPaypatOepDtosPageBeforeInfoBP before= new GetBlPaypatOepDtosPageBeforeInfoBP(map,null);
			pageDTO = (BlpayOepPatDTO[])AppFwUtil.getDORstWithDao(before, BlpayOepPatDTO.class) ;
		}else{
			GetBlPaypatOepDtosPageAfterInfoBP  after= new GetBlPaypatOepDtosPageAfterInfoBP(map,null);
			pageDTO = (BlpayOepPatDTO[])AppFwUtil.getDORstWithDao(after, BlpayOepPatDTO.class) ;
		}
		FDouble amt=FDouble.ZERO_DBL;
		for(BlpayOepPatDTO dto:pageDTO){
			if(!StringUtil.isEmpty(dto.getAmt().toString()) && !StringUtil.isEmpty(dto.getPayitem_eudirect().toString()) )
			{
				amt=amt.add(dto.getAmt().multiply(dto.getPayitem_eudirect()));
			}
		}		
		return amt;				
	}
	
	/**
	 * 查询结账 住院收付款明细合计
	 * @param map where条件集合（id_cc,end_time,id_cc）
	 * @param pageInfo
	 * @author yangyang
	 * @throws BizException
	 * @author yangyang
	 * */
	@Override
	public FDouble getBlPaypatIpDtosTotalAmt(FMap map) throws BizException {
		GatherIpPayFeeBp handlerBp=new GatherIpPayFeeBp();
		return handlerBp.exec(map);
	}

	@Override
	public BlccAggDO[] previewChechOut(String id_user, String id_org,
			String sd_cctp, FDateTime end_time) throws BizException {
//		BlccOperactionBp blccBp = new BlccOperactionBp();
//		return blccBp.previewChechOut(id_user, id_org, sd_cctp, end_time);
		GetPreviewChechOutBP blccBp = new GetPreviewChechOutBP();
		return blccBp.exec(id_user, id_org, sd_cctp, end_time);
	}
	
	/**
	 * 结账后打印时，检验数据有效性（防止取消结账后，打印已取消的结账数据）
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	@Override
	public FBoolean checkDataValidity_Print(String id_cc) throws BizException {
/*		BlccOperactionBp blccBp = new BlccOperactionBp();
		return blccBp.checkDataValidity_Print(id_cc);*/
		GetCheckDataValidityPrintBP bCheck= new GetCheckDataValidityPrintBP();
		return bCheck.exec(id_cc);
	}

	/**
	 * 通过收付款信息查询对应的费用明细
	 * @author zhang.hw
	 * @date 2019年9月23日
	 * @param blpayOepPatDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlccOepInfoDTO[] getBlccOepInfos(BlpayOepPatDTO blpayOepPatDTO) throws BizException {
		GetBlccOepInfosBP bp = new GetBlccOepInfosBP();
		return bp.exec(blpayOepPatDTO);
	}
}
