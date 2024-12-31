package iih.pe.pwf.i;

import iih.pe.pwf.dto.pereglistdto.d.PeRegListDTO;
import iih.pe.pwf.dto.pewfnextrmdto.d.PeWfNextrmDTO;
import iih.pe.pwf.peregquery.d.PeRegQueryDO;
import xap.mw.core.data.BizException;

public interface IPereglistQueryService {
    /// <summary>
    /// 通过时间与体检类型查询
    /// </summary>
    /// <param name="regDate"></param>
    /// <param name="groupId"></param>
    /// <returns></returns>
	public PeRegListDTO[] findPeApptListByRegDateAndGroupId(PeRegQueryDO qry) throws BizException;
	
	 public PeWfNextrmDTO[] findPeWfNextrmById(String groupId) throws BizException;

}
