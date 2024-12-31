package iih.bl.pay.blpaypat.s.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blprepaypatacc.d.BlPrepayPatAccDO;
import iih.bl.pay.blprepaypatacc.i.IBlprepaypataccCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预交金插入后置规则保存预交金流水账
 * @author ly 2020/03/10
 *
 */
public class SavePrepayAccAfterInsertRule implements IRule<BlPrePayPatDO>{
	
	private final String ACC_TYPE_PAT = "1";//患者数据
	private final String ACC_TYPE_ENT = "2";//就诊数据
	private IBlprepaypataccCudService prepayAccService = null;

	@Override
	public void process(BlPrePayPatDO... paramVarArgs) throws BizException {
		
		this.prepayAccService = ServiceFinder.find(IBlprepaypataccCudService.class);
		
		Map<String,List<BlPrePayPatDO>> groupMap = new HashMap<String,List<BlPrePayPatDO>>();
		
		for (BlPrePayPatDO prepayDO : paramVarArgs) {
			
			String key = "";
			if(!StringUtil.isEmpty(prepayDO.getId_ent())){
				key = ACC_TYPE_ENT + "," + prepayDO.getId_ent();
			}else{
				key = ACC_TYPE_PAT + "," + prepayDO.getId_pat();
			}
			
			List<BlPrePayPatDO> prepayList = null;
			if(groupMap.containsKey(key)){
				prepayList = groupMap.get(key);
			}else{
				prepayList = new ArrayList<BlPrePayPatDO>();
				groupMap.put(key, prepayList);
			}
			prepayList.add(prepayDO);
		}
		
		for (String key : groupMap.keySet()) {
			this.dealPrepayData(key, groupMap.get(key));
		}
	}
	
	/**
	 * 保存账目数据
	 * @param key
	 * @param prepayList
	 * @throws BizException
	 */
	private void dealPrepayData(String key, List<BlPrePayPatDO> prepayList) throws BizException {
		
		String[] keys = key.split(",");
		FDouble prepay = null;
		if(ACC_TYPE_PAT.equals(keys[0])){
			prepay = this.getPatTotalPrepay(keys[1]);
		}else{
			prepay = this.getEntTotalPrepay(keys[1]);
		}
		
		List<BlPrepayPatAccDO> prepayAccList = new ArrayList<BlPrepayPatAccDO>();
		for (int i = prepayList.size() - 1; i >=0 ; i--) {
			
			if(i != prepayList.size() - 1){
				prepay = prepay.sub(prepayList.get(i+1).getAmt().multiply(prepayList.get(i+1).getEu_direct()));
			}
			
			BlPrepayPatAccDO prepayAccDO = new BlPrepayPatAccDO();
			prepayAccDO.setId_paypat(prepayList.get(i).getId_paypat());
			prepayAccDO.setId_grp(Context.get().getGroupId());
			prepayAccDO.setId_org(Context.get().getOrgId());
			prepayAccDO.setAmt_acc(prepay);
			prepayAccDO.setStatus(DOStatus.NEW);
			
			prepayAccList.add(prepayAccDO);
		}
		
		this.prepayAccService.insert(prepayAccList.toArray(new BlPrepayPatAccDO[0]));
	}
	
	private FDouble getPatTotalPrepay(String patId) throws BizException {
		
		DAFacade daf = new DAFacade();
		String sql = "select sum(amt * eu_direct) from bl_prepay_pat where id_pat = ? ";
		SqlParam param = new SqlParam();
		param.addParam(patId);
		
		Object prepay = daf.execQuery(sql, param, new ColumnHandler());
		return (FDouble)FTypeManager.convert2FType(FType.FDouble, prepay);
		
	}
	
	private FDouble getEntTotalPrepay(String entId) throws BizException {

		DAFacade daf = new DAFacade();
		String sql = "select sum(amt * eu_direct) from bl_prepay_pat where id_ent = ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		Object prepay = daf.execQuery(sql, param, new ColumnHandler());
		return (FDouble)FTypeManager.convert2FType(FType.FDouble, prepay);
	}
}
