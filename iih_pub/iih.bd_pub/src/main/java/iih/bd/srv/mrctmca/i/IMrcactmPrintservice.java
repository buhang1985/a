package iih.bd.srv.mrctmca.i;

import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import xap.mw.core.data.BizException;

public interface IMrcactmPrintservice {
	/**
	*  打印查询自定义类型
	*/
    public abstract MrCtmCaDO[] getMrctmcaDO(String identp) throws BizException;

}
