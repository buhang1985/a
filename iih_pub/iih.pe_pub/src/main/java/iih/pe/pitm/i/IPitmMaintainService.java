package iih.pe.pitm.i;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import xap.mw.core.data.BizException;

public interface IPitmMaintainService {

    /*
     * 导入第三方数据
     */
	public abstract void importDataFromThirdpart() throws BizException;
    
	/*
	 * 导入HIS检查检验医嘱
	 */
    public abstract void importDataSrv() throws BizException;
    
	/*
	 * 导入HIS医嘱到体检
	 */
    public abstract boolean synchronously(MedSrvDO derDo, PeSrvbCatlogDO catlogDo) throws BizException;

    /*
     * 同步HIS医嘱价格
     */
    public abstract void synchrPrice() throws BizException;
}
