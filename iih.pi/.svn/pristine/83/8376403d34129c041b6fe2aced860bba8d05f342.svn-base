package iih.pi.reg.pat.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 创建患者账户业务逻辑
 * 
 * @author ly
 *
 */
public class PiPatCreateAccBP {

	/**
	 * 创建患者账户
	 * 
	 * @param patDo
	 *            患者do
	 * @throws BizException
	 */
	public void exec(PatDO[] pats) throws BizException {

		if (pats == null || pats.length <= 0) {
			return;
		}

		CreatePatAccs(pats);
	}

	private void CreatePatAccs(PatDO[] pats) throws BizException {

		ArrayList<PiPatAccDO> patAccList = new ArrayList<PiPatAccDO>();
		for (PatDO patDo : pats) {
			PiPatAccDO accDo = new PiPatAccDO();
			// 账户名称=“主账户”，账户编码=“PRIMARY”，预交金金额=0，预交金_授权=0，预交金状态=1，
			// 信用额度=0，信用额度_授权=0，信用额度状态=1，账户状态=1，有效标志=1
			accDo.setStatus(1);
			accDo.setId_pat(patDo.getId_pat());
			accDo.setName("主账户");
			accDo.setCode("PRIMARY");
			accDo.setPrepay(new FDouble(0));

			accDo.setCred(new FDouble(0));
			accDo.setAcc_lock(new FDouble(0));
			accDo.setPrepay_emgstay(new FDouble(0));
			accDo.setCred_emgstay(new FDouble(0));
			accDo.setAcc_lock_emgstay(new FDouble(0));
			accDo.setId_accsta(IPiDictCodeConst.ID_ACCSTA_NORMAL);
			accDo.setSd_accsta(IPiDictCodeConst.SD_ACCSTA_NORMAL);
			accDo.setFg_active(new FBoolean(true));
			accDo.setId_grp(patDo.getId_grp());
			accDo.setId_org(patDo.getId_org());
			patAccList.add(accDo);
		}

		IAccountMDOCudService accountMDOCudService = ServiceFinder.find(IAccountMDOCudService.class);
		accountMDOCudService.insert(patAccList.toArray(new PiPatAccDO[0]));
	}
}
