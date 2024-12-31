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
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 组装核算体系数据
 * 
 * @param medSrvDOs
 * @return
 * @throws BizException
 */
public class SetAccSrvByMedsrvDOBp {

	public void exec(MedSrvDO[] medSrvDOs) throws BizException {
		List<String> datalist = new ArrayList();
		for(MedSrvDO medDo : medSrvDOs){
			datalist.add(medDo.getId_srv());
		}	
		SetAccSrvByIdSrvs(medSrvDOs,datalist);	
	}

	private void SetAccSrvByIdSrvs(MedSrvDO[] medSrvDOs, List<String> datalist) throws BizException {
		String wherePart = GetWherePart(datalist);		
		IAccountsrvRService service = ServiceFinder.find(IAccountsrvRService.class);
		AccountSrvDO[] srvDOs = service.find(wherePart, "", FBoolean.FALSE);
		
		if(srvDOs == null|| srvDOs.length<=0) return;
		for(AccountSrvDO srvDO : srvDOs){
			for(MedSrvDO medDo : medSrvDOs){
				if(IBdPpDictCodeConst.ID_ACCOUNT_ZY.equals(srvDO.getId_account()) && medDo.getId_srv().equals(srvDO.getId_srv())){
					medDo.setId_account_zy(srvDO.getId_accountca());
					medDo.setId_acc_zy(srvDO.getId_account());
					medDo.setName_zy_accsub(srvDO.getCa_name());
					medDo.setCode_zy_accsub(srvDO.getCa_code());						
				} else if(IBdPpDictCodeConst.ID_ACCOUNT_GY.equals(srvDO.getId_account()) && medDo.getId_srv().equals(srvDO.getId_srv())){
					medDo.setId_account_gy(srvDO.getId_accountca());
					medDo.setName_gy_accsub(srvDO.getCa_name());
					medDo.setId_acc_gy(srvDO.getId_account());
					medDo.setCode_gy_accsub(srvDO.getCa_code());						
				} else if(IBdPpDictCodeConst.ID_ACCOUNT_MZ.equals(srvDO.getId_account()) && medDo.getId_srv().equals(srvDO.getId_srv())){
					medDo.setId_account_mz(srvDO.getId_accountca());
					medDo.setName_mz_accsub(srvDO.getCa_name());
					medDo.setId_acc_mz(srvDO.getId_account());
					medDo.setCode_mz_accsub(srvDO.getCa_code());
				}										
			}							
		}		
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
