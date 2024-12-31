package iih.bd.srv.medsrv.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.i.IAccountsrvRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public class MedSrvSetAccSrvBp {

	public void exec(PagingRtnData<MedSrvDO> admlist) throws BizException {
		FArrayList adms = admlist.getPageData();
		if (adms == null || adms.size() <= 0) {
			return;
		}
		List<String> datalist = new ArrayList();
		for (Object admDo : adms) {
			MedSrvDO medDo = (MedSrvDO) admDo;
			datalist.add(medDo.getId_srv());
		}
		SetAccSrvByIdSrvs(adms, datalist);
	}

	private void SetAccSrvByIdSrvs(FArrayList adms, List<String> datalist) throws BizException {
		String wherePart = GetWherePart(datalist);

		IAccountsrvRService service = ServiceFinder.find(IAccountsrvRService.class);
		AccountSrvDO[] srvDOs = service.find(wherePart, "", FBoolean.FALSE);

		if (srvDOs == null || srvDOs.length <= 0)
			return;
		for (AccountSrvDO srvDO : srvDOs) {
			for (Object admDo : adms) {
				MedSrvDO medDo = (MedSrvDO) admDo;
				if (IBdPpDictCodeConst.ID_ACCOUNT_ZY.equals(srvDO.getId_account())
						&& medDo.getId_srv().equals(srvDO.getId_srv())) {
					medDo.setId_account_zy(srvDO.getId_accountca());
					medDo.setId_acc_zy(srvDO.getId_account());
					medDo.setName_zy_accsub(srvDO.getCa_name());
					medDo.setCode_zy_accsub(srvDO.getCa_code());

				} else if (IBdPpDictCodeConst.ID_ACCOUNT_GY.equals(srvDO.getId_account())
						&& medDo.getId_srv().equals(srvDO.getId_srv())) {
					medDo.setId_account_gy(srvDO.getId_accountca());
					medDo.setName_gy_accsub(srvDO.getCa_name());
					medDo.setId_acc_gy(srvDO.getId_account());
					medDo.setCode_gy_accsub(srvDO.getCa_code());

				} else if (IBdPpDictCodeConst.ID_ACCOUNT_MZ.equals(srvDO.getId_account())
						&& medDo.getId_srv().equals(srvDO.getId_srv())) {
					medDo.setId_account_mz(srvDO.getId_accountca());
					medDo.setName_mz_accsub(srvDO.getCa_name());
					medDo.setId_acc_mz(srvDO.getId_account());
					medDo.setCode_mz_accsub(srvDO.getCa_code());
				}
			}
		}

//		DAFacade daFacade = new DAFacade();
//		List<AccountSrvDO> list = (List<AccountSrvDO>)daFacade.findByCond(AccountSrvDO.class, wherePart);

	}

	private String GetWherePart(List<String> datalist) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");

		String BDModeSql = BdEnvContextUtil.processEnvContext(new AccountSrvDO(), true);
		if (BDModeSql != null && !BDModeSql.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(BDModeSql);
		}
		String wherePart = SqlUtils.getInSqlByIds(AccountSrvDO.ID_SRV, datalist);
		if (wherePart != null && !wherePart.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

}
