package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.s.bp.qry.GetIpBillItmDtosUnEntQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 分页查询医保住院在院记账明细
 * @author hanjq 下午1:26:57 *
 */
public class GetHpIpInHosBillsByPageBP {

	public PagingRtnData<IpBillItmUploadHpDTO> exec(String wherePart, String orderBy, FBoolean isUpload,
			PaginationInfo pg,String uploadMode) throws BizException {
		
		GetIpBillItmDtosUnEntQry qrySql = new GetIpBillItmDtosUnEntQry(wherePart,orderBy,isUpload,uploadMode);
		StringBuilder sql = new StringBuilder(qrySql.getQrySQLStr());
		IpBillItmUploadHpDTO hpDto = new IpBillItmUploadHpDTO();		
		PagingServiceImpl<IpBillItmUploadHpDTO> pagingServiceImpl = new PagingServiceImpl<IpBillItmUploadHpDTO>();
		PagingRtnData<IpBillItmUploadHpDTO> prd = pagingServiceImpl.findByPageInfo(hpDto, pg, sql.toString(), "", null);
		GetIpBillItemDtosUnEntBP bp = new GetIpBillItemDtosUnEntBP();
		
		//begin--设置分页数据为对照过的数据
		FArrayList list = prd.getPageData();		
		if(list != null && list.size() > 0){
			ArrayList<IpBillItmUploadHpDTO> aList = new ArrayList<>();
			for(Object obj : list){
				if(obj instanceof IpBillItmUploadHpDTO){
					IpBillItmUploadHpDTO itm = (IpBillItmUploadHpDTO) obj;
					if(itm != null)
						aList.add(itm);
				}
				
			}
			IpBillItmUploadHpDTO [] billItmUploadHpDtoArr = aList.toArray(new IpBillItmUploadHpDTO [0]);
			if(billItmUploadHpDtoArr != null && billItmUploadHpDtoArr.length > 0){
				if(isUpload.booleanValue())
				{
					billItmUploadHpDtoArr=bp.processDataUploaded(billItmUploadHpDtoArr);
				}
				else{
					billItmUploadHpDtoArr=bp.processDataUploading(billItmUploadHpDtoArr);
					bp.saveHpCgItmIpDoBeforUpload(billItmUploadHpDtoArr);
				}
			}
			FArrayList newList = new FArrayList();
			newList.addAll(Arrays.asList(billItmUploadHpDtoArr));
			prd.setPageData(newList);
		}
		//end--设置分页数据为对照过的数据
		return prd;
	}

}
