package iih.mkr.ms.i;

import iih.mkr.ms.d.GrpAppTreeDTO;
import xap.mw.core.data.BizException;

public interface IMkrmsExtService {
	/**
	*  树的查询服务
	*/
    public abstract GrpAppTreeDTO[] find(String owtype,String id_ow) throws BizException;
}
