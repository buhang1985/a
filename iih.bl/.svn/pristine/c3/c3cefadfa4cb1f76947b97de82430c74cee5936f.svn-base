package iih.bl.cg.s.task;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除后台任务多任务同时执行时产生的重复数据
 * @author ly
 *
 */
public class IpBackCgDeleteMultiDataTast implements IBackgroundWorkPlugin {

	/**
	 * 执行任务
	 * 
	 * @param context 上下文
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PreAlertObject executeTask(BgWorkingContext context) throws BizException {
		 
		// 默认返回结果
		PreAlertObject obj = new PreAlertObject();
		Map<String, Object> map = context.getKeyMap();
		String chargeDateStr = (String) map.get("charge_date");
		
		if(StringUtil.isEmpty(chargeDateStr))
			return obj;
		
		DAFacade daf = new DAFacade();
		String entSql = "select id_ent from en_ent where fg_ip = 'Y' and code_entp = '10' ";
		
		List<String> entIdList = (List<String>)daf.execQuery(entSql, new ColumnListHandler());
		
		final String fChargeDate = chargeDateStr + " 23:59:59";
		for (String entId : entIdList) {
			
			final String fEntId = entId;
			try {
				TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus status){
					try {
						
						//处理
						deal(fEntId,fChargeDate);
						
					} catch (BizException e) {
						BLTaskLogger.error(e.getMessage(),e);
						throw new RuntimeException(e.getMessage());
					}
					return null;
				}
			});
			} catch (Exception e) {
			}
		}
		return obj;
	 }
	
	private void deal(String entId,String date) throws BizException{
		
		DAFacade daf = new DAFacade();
		//String sql = "select * from bl_cg_ip where id_ent = ? and dt_cg = ? and srcfunc_des ='ipbackkeepaccount' and id_entbed <> '~' and fg_refund = 'N' and eu_direct = 1 and fg_st = 'N' and ds = 0 order by id_entbed ";
		String sql = "select * from bl_cg_ip where id_ent = ? and dt_cg = ? and srcfunc_des ='ipbackkeepaccount' and fg_refund = 'N' and eu_direct = 1 and fg_st = 'N' and ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(date);
		
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> cgList =  (List<BlCgIpDO> )daf.execQuery(sql, param,new BeanListHandler(BlCgIpDO.class));
		
		if(ListUtil.isEmpty(cgList) || cgList.size() == 1)
			return;
		
		Set<String> orsrvSet = new HashSet<String>();
		Set<String> bedSet = new HashSet<String>();
		Set<String> dcgSet = new HashSet<String>();

		//删除数据
		FDouble amt = FDouble.ZERO_DBL;
		for (BlCgIpDO cgIpDO : cgList) {
			if(!StringUtil.isEmpty(cgIpDO.getId_orsrv())){
				
				if(orsrvSet.contains(cgIpDO.getId_orsrv())){
					amt = amt.add(cgIpDO.getAmt_ratio());
					String updateSql = "update bl_cg_ip set ds = 1 where id_cgip = '" +cgIpDO.getId_cgip()+"' ";
					daf.execUpdate(updateSql);
				}else{
					orsrvSet.add(cgIpDO.getId_orsrv());
				}
			}else if(!StringUtil.isEmpty(cgIpDO.getId_entbed())){
				
				String key = cgIpDO.getId_entbed() + cgIpDO.getId_srv();
				if(bedSet.contains(key)){
					amt = amt.add(cgIpDO.getAmt_ratio());
					String updateSql = "update bl_cg_ip set ds = 1 where id_cgip = '" +cgIpDO.getId_cgip()+"' ";
					daf.execUpdate(updateSql);
				}else{
					bedSet.add(key);
				}
			}else if(!StringUtil.isEmpty(cgIpDO.getId_entdcg())){
				
				String key = cgIpDO.getId_entdcg() + cgIpDO.getId_srv();
				if(dcgSet.contains(key)){
					amt = amt.add(cgIpDO.getAmt_ratio());
					String updateSql = "update bl_cg_ip set ds = 1 where id_cgip = '" +cgIpDO.getId_cgip()+"' ";
					daf.execUpdate(updateSql);
				}else{
					dcgSet.add(key);
				}
			}
		}
		
		if(amt.compareTo(FDouble.ZERO_DBL) == 0)
			return;
		
		String updateaccSql = "update en_ent_acc set amt_uncg = amt_uncg - ? where id_ent = ? ";
		SqlParam updateParam = new SqlParam();
		updateParam.addParam(amt);
		updateParam.addParam(entId);
		
		daf.execUpdate(updateaccSql, updateParam);
	}
}
