package iih.bd.pp.pripat.s.rule.bp;

import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDOCudService;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者价格分类服务插入前规则bp
 * @author guoyang
 *
 */
public class PriPatSrvOrCaDOInsertBeforeRuleBp {

	public void exec(PriPatSrvOrCaDO[] priPatSrvOrCaDOs) throws BizException {
		if(priPatSrvOrCaDOs == null || priPatSrvOrCaDOs.length <= 0){
			return;
		}
		//查询出患者价格分类下服务的历史记录
		PriPatSrvOrCaDO[] oldpriPatSrvOrCas = getPriPatSrvOrCaByPripatAndSrv(priPatSrvOrCaDOs);
		//将旧的数据的结束时间设置为当前时间-1s
		updatePriPatSrvOrCaDO(oldpriPatSrvOrCas, priPatSrvOrCaDOs);
	}

	/**
	 * 对查询出PriPatSrvOrCaDOs做更新操作
	 * @param oldpriPatSrvOrCas
	 * @param priPatSrvOrCaDOs 
	 * @throws BizException 
	 */
	private void updatePriPatSrvOrCaDO(PriPatSrvOrCaDO[] oldpriPatSrvOrCas, PriPatSrvOrCaDO[] priPatSrvOrCaDOs) throws BizException {
		if(oldpriPatSrvOrCas == null || oldpriPatSrvOrCas.length <= 0){
			return;
		}
		
		for (PriPatSrvOrCaDO oldpriPatSrvOrCaDO : oldpriPatSrvOrCas) {
			updateDte(oldpriPatSrvOrCaDO, priPatSrvOrCaDOs);
		}
		
		IPriPatSrvOrCaDOCudService priPatSrvOrCaDOCudService = ServiceFinder.find(IPriPatSrvOrCaDOCudService.class);
		priPatSrvOrCaDOCudService.update(oldpriPatSrvOrCas);
	}

	/**
	 * 设置结束时间dt_e为当前定价开始时间-1s
	 * @param oldpriPatSrvOrCas
	 * @param priPatSrvOrCaDOs
	 * @return 
	 */
	private void updateDte(PriPatSrvOrCaDO oldpriPatSrvOrCa, PriPatSrvOrCaDO[] priPatSrvOrCaDOs) {
		for (PriPatSrvOrCaDO priPatSrvOrCaDO : priPatSrvOrCaDOs) {
			if(oldpriPatSrvOrCa.getId_pripat().equals(priPatSrvOrCaDO.getId_pripat())
					&& oldpriPatSrvOrCa.getId_srv().equals(priPatSrvOrCaDO.getId_srv())){
				oldpriPatSrvOrCa.setDt_e(priPatSrvOrCaDO.getDt_b().addSeconds(-1));
				oldpriPatSrvOrCa.setStatus(DOStatus.UPDATED);
			}
		}
	}

	/**
	 * 根据患者价格分类和服务查询bd_pri_pat_srvorca表
	 * 
	 * @param priPatSrvOrCaDOs
	 * @return
	 * @throws BizException
	 */
	private PriPatSrvOrCaDO[] getPriPatSrvOrCaByPripatAndSrv(PriPatSrvOrCaDO[] priPatSrvOrCaDOs) throws BizException {
		IPriPatSrvOrCaDORService priPatSrvOrCaDORService = ServiceFinder.find(IPriPatSrvOrCaDORService.class);
		String whereStr = getWherestr(priPatSrvOrCaDOs);
		PriPatSrvOrCaDO[] patSrvOrCaDOs = priPatSrvOrCaDORService.find(whereStr, "", FBoolean.FALSE);
		return patSrvOrCaDOs;
	}

	/**
	 * 获取where条件
	 * 
	 * @param priPatSrvOrCaDOs
	 * @return
	 */
	private String getWherestr(PriPatSrvOrCaDO[] priPatSrvOrCaDOs) {
		StringBuffer sb = new StringBuffer(" dt_e = '2099-12-31 23:59:59' ");
		sb.append(" and ( 1 <> 1 ");
		for (PriPatSrvOrCaDO priPatSrvOrCaDO : priPatSrvOrCaDOs) {
			sb.append(String.format("  or (id_pripat = '%s' and id_srv = '%s')", priPatSrvOrCaDO.getId_pripat(),
					priPatSrvOrCaDO.getId_srv()));
		}
		sb.append(" )");
		return sb.toString();
	}

}
