package iih.bd.mm.medidirecdto.s.bp;

import java.util.ArrayList;
import iih.bd.mm.medicinedirectory.d.MedicineDirectoryDO;
import iih.bd.mm.medidirecdto.d.MedicDirecDTO;
import iih.bd.mm.medidirecdto.s.bp.sql.MediDirecDtoSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

public class MedidirecValiddtoBP {
	
	public void exec(MedicineDirectoryDO... dos) throws BizException {
		String[] slist = null;
		ArrayList<String> arraylist = new ArrayList<String>();
		for(MedicineDirectoryDO mdd :dos){
			arraylist.add(mdd.getId_mm().toString());
		}
		if(arraylist.size() > 0){
            slist = new String[arraylist.size()];
            for (int i = 0; i < arraylist.size(); i++) {
                slist[i] = arraylist.get(i).toString();
            }
    		PaginationInfo pg = new PaginationInfo();
    		pg.setPageSize(10);
    		pg.setPageIndex(0);
    		PagingRtnData<MedicDirecDTO> mdList = FindPagingByWherePart(slist, pg);
    		@SuppressWarnings("unchecked")
    		MedicDirecDTO[] mdArray = (MedicDirecDTO[]) mdList.getPageData().toArray(new MedicDirecDTO[] {});
    		if(mdArray.length > 0) {
    			throw new BizException("已经加进包药机药品目录的药不允许再次加入。"); 
    		}
		}
		return;
	}
	
	private PagingRtnData<MedicDirecDTO> FindPagingByWherePart(String[] mmIds, PaginationInfo pg) throws BizException {
		String wherePart="";
		StringBuilder wherePartBuilder = new StringBuilder();
		if(mmIds.toString().length() > 0){
			for(String mmId : mmIds){
				if(wherePartBuilder.length() == 0){
					wherePartBuilder.append("ID_MM='"+mmId+"'");
				}
				else{
					wherePartBuilder.append(" or ID_MM='"+mmId+"'");
				}
			}
			wherePart = "("+wherePartBuilder.toString()+")";
		}
		
		MediDirecDtoSql sql = new MediDirecDtoSql(wherePart);
		PagingServiceImpl<MedicDirecDTO> pagingServiceImpl = new PagingServiceImpl<MedicDirecDTO>();
		PagingRtnData<MedicDirecDTO> result = pagingServiceImpl.findByPageInfo(new MedicDirecDTO(), pg,
					sql.getQrySQLStr(), "", sql.getQryParameter(null));
		return result;
	}
}
