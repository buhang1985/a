package iih.bd.pp.hpsrvorca.s;

import iih.bd.pp.hpsrvorca.i.IHpSrvorcaExtService;
import iih.bd.pp.hpsrvorca.s.bp.DeleteAllHpSrvorcaBp;
import iih.bd.pp.hpsrvorca.s.bp.DeleteDrugHpSrvorcaBp;
import iih.bd.pp.hpsrvorca.s.bp.DeleteTreatHpSrvorcaBp;
import xap.mw.core.data.BizException;

/***
 * 医保目录对照扩展服务
 * 
 * @author hao_wu
 *
 */
public class HpSrvorcaExtServiceImpl implements IHpSrvorcaExtService {

	@Override
	public void DeleteAll() throws BizException {
		DeleteAllHpSrvorcaBp bp = new DeleteAllHpSrvorcaBp();
		bp.exec();
	}
	
	@Override
	public void DeleteTreat() throws BizException {
		DeleteTreatHpSrvorcaBp bp = new DeleteTreatHpSrvorcaBp();
		bp.exec();
		
	}

	@Override
	public void DeleteDrug() throws BizException {
		DeleteDrugHpSrvorcaBp bp = new DeleteDrugHpSrvorcaBp();
		bp.exec();
	}
}
