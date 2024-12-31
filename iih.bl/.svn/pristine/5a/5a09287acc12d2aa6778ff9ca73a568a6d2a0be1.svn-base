package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo;
import iih.bl.hp.hpblllitm.i.IHpblllitmCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存默认医保上传明细数据
 * @author ly 2018/11/24
 *
 */
public class BlHpSaveDefaultHpIpCgItemBP {
	
	/**
	 * 保存默认医保上传明细数据
	 * @param stId 结算id
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(String stId) throws BizException{
		
		if(StringUtil.isEmpty(stId))
			return;
		
		String sql = this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(stId);
		List<BlHpCgItmIpDo> hpCgList = (List<BlHpCgItmIpDo>)new DAFacade().execQuery(sql, param, new BeanListHandler(BlHpCgItmIpDo.class));
		if(ListUtil.isEmpty(hpCgList))
			return;
		
		List<BlHpCgItmIpDo> needSaveList = new ArrayList<BlHpCgItmIpDo>();
		for (BlHpCgItmIpDo hpCgIrmDO : hpCgList) {
			if(StringUtil.isEmpty(hpCgIrmDO.getId_hpblllitm())){
				hpCgIrmDO.setAmt_payzl(FDouble.ZERO_DBL);
				hpCgIrmDO.setAmt_payzf(FDouble.ZERO_DBL);
				hpCgIrmDO.setAmt_cxj_payzf(FDouble.ZERO_DBL);
				hpCgIrmDO.setAmt_czl_payzf(FDouble.ZERO_DBL);
				hpCgIrmDO.setStatus(DOStatus.NEW);
				needSaveList.add(hpCgIrmDO);
			}
		}
		
		if(needSaveList.size() == 0)
			return;
		
		IHpblllitmCudService cudService = ServiceFinder.find(IHpblllitmCudService.class);
		cudService.insert(needSaveList.toArray(new BlHpCgItmIpDo[0]));
	}
	
	/**
	 * 查询sql
	 * @return
	 */
	private String getSql(){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("hpcgip.id_hpblllitm,");
		sqlSb.append("cgip.id_ent,");
		sqlSb.append("cgip.id_cgip,");
		sqlSb.append("cgip.amt_ratio amt ");
		sqlSb.append("from bl_cg_ip cgip ");
		sqlSb.append("left join bl_hp_cgitm_ip hpcgip ");
		sqlSb.append("on cgip.id_cgip = hpcgip.id_cgip ");
		sqlSb.append("where cgip.id_stip = ? ");
		return sqlSb.toString();
	}
}
