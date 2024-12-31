package iih.en.pv.s.task.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.pv.enbeditem.d.Enbeditem;
import iih.en.pv.enbeditem.i.IEnbeditemCudService;
import iih.en.pv.enbeditem.i.IEnbeditemRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class IpBedUseStateBP {

	/***
	 * 床位使用明细
	 * 
	 * @param date
	 * @throws BizException 
	 */
	public void exec(FDate date) throws BizException{
		//1.校验查询日期
		if (date == null) {
			return;
		}
		//2.删除当天数据
		this.deleteItem(date);
		//3.查询数据
		Enbeditem[] enbeditems = this.getEnbeditemBySql(date);
		//4.保存数据
		cudService().insert(enbeditems);
	}
	
	/***
	 * 床位占用明细CUD服务
	 * @return
	 */
	private IEnbeditemCudService cudService(){
		return ServiceFinder.find(IEnbeditemCudService.class);
	}
	/***
	 * 床位占用明细查询服务
	 * @return
	 */
	private IEnbeditemRService rService(){
		return ServiceFinder.find(IEnbeditemRService.class);
	}
	/***
	 * 删除表中现有数据
	 * 
	 * @throws BizException
	 */
	private void deleteItem(FDate date) throws BizException{
		Enbeditem[] beditems = rService().find("createtime = '"+date+"' ",null, FBoolean.FALSE);
		cudService().delete(beditems);
	}
	/***
	 * 获取需要插入数据库的数据
	 * @return
	 * @throws BizException 
	 */
	private Enbeditem[] getEnbeditemBySql(FDate date) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append(" select ");
		sql.append(" ent.id_ent, ");
		sql.append(" pat.id_pat, ");
		sql.append("ip.code_amr_ip, ");
		sql.append("pat.name as name_pat, " );
		sql.append("dep.code as code_dep, " );
		sql.append("dep.name as name_dep, " );
		sql.append("ip.name_bed as name_bed, " );
		sql.append("ent.dt_acpt as dt_entry, " );
		sql.append("nb.weight as weight_nb, " );
		sql.append("nb.dt_birth as dt_birth_nb, " );
		sql.append("ent.code as code_ent, " );
		sql.append("nur.code as code_nur, " );
		sql.append("nur.name as name_nur, " );
		sql.append("acc.amt_prepay as Amt_prepay " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_ip ip on ip.id_ent = ent.id_ent " );
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat " );
		sql.append("inner join bd_dep dep on dep.id_dep = ent.id_dep_phy " );
		sql.append("inner join bd_dep nur on nur.id_dep = ent.id_dep_nur " );
		sql.append("left join en_ent_nb nb on nb.id_ent_bb = ent.id_ent " );
		sql.append("left join en_ent_acc acc on acc.id_ent = ent.id_ent " );
		sql.append("where ent.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' " );
		sql.append("and ent.fg_ip = 'Y' " );
		sql.append("and ent.fg_canc = 'N' ");
		List<Enbeditem> list = (List<Enbeditem>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(Enbeditem.class)); 
		if(list != null && list.size() > 0){
			for(Enbeditem item : list){
				item.setCreatetime(date.toString());
				item.setDs(DOStatus.NEW);
			}
			return list.toArray(new Enbeditem[]{});
		}
		return null;
	}
}
