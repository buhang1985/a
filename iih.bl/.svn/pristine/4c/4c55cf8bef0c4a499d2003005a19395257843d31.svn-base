package iih.bl.hp.blhppatpoor.s;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bl.hp.blhppatpoor.d.BlHpPatPoorDO;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.i.IPattagCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 导入贫困患者后置规则
 * 
 * @author hanjq 上午9:58:16 *
 * @param <T>
 */
public class AfterInsertHpPatPoorRule<T> implements IRule<T> {

	@Override
	public void process(T... datas) throws BizException {
		if (datas == null || datas.length <= 0) {
			return;
		}
		if (datas instanceof BlHpPatPoorDO[])
			insertPatTag((BlHpPatPoorDO[])datas);
	}

	/**
	 * 已存在数据库的患者插入贫困患者标签
	 * @author : hanjq 2019年8月21日 上午10:47:31
	 * @param datas
	 * @throws BizException 
	 */
	private void insertPatTag(BlHpPatPoorDO[] datas) throws BizException {
		String UnInsertPatTagSql = getUnInsertPatTagSql(datas);
		DAFacade daf = new DAFacade();
		List<PatTagDO> tags = (List<PatTagDO>) daf.execQuery(UnInsertPatTagSql, new BeanListHandler(PatTagDO.class));
		if(tags != null && tags.size() > 0){
			IPattagCudService service = ServiceFinder.find(IPattagCudService.class);
			FDateTime Dt_tag = new FDateTime();
			BdTagTpDO bdTagTpDO = getBdTagTp(daf);
			String Id_emp_tag = Context.get().getUserId();
			for(PatTagDO tag : tags){
				tag.setDt_tag(Dt_tag);
				tag.setId_emp_tag(Id_emp_tag);
				tag.setId_pattagtp(bdTagTpDO.getId_tagtp());
				tag.setSd_pattagtp(bdTagTpDO.getCode());
				tag.setStatus(DOStatus.NEW);
			}			
			service.save(tags.toArray(new PatTagDO[0]));
		}
	}
	
	/**
	 * 待导入贫困患者SQL
	 * @author : hanjq 2019年8月21日 上午10:30:56
	 * @param datas
	 * @return
	 */
	private String getUnInsertPatTagSql(BlHpPatPoorDO[] datas){
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct pat.Id_pat,pat.Id_org ,pat.Id_grp	");
		sb.append("from pi_pat pat	");
		//sb.append("left join pi_pat_tag ptap	");
		//sb.append("on pat.id_pat = ptap.id_pat and sd_pattagtp = '");
		//sb.append(IBdFcDictCodeConst.SD_TAGTP_POOR).append("'   ");
		sb.append("where pat.sd_idtp = '01' 	");
		//sb.append("and ptap.id_pat is null	");
		sb.append("	and pat.id_code in (");
		boolean isDoHao = false;
		for(BlHpPatPoorDO itm : datas){
			if(isDoHao){
				sb.append(",");
			}
			sb.append("'").append( itm.getId_code()).append("'");
			isDoHao = true;
		}		
		sb.append(") and not exists (select * from pi_pat_tag where sd_pattagtp = '");
		sb.append(IBdFcDictCodeConst.SD_TAGTP_POOR);
		sb.append("' and id_pat = pat.id_pat)");
		return sb.toString();
	}
	
	/**
	 * 获取贫困患者标签
	 * @author : hanjq 2019年8月21日 上午10:35:03
	 * @param daf
	 * @return
	 * @throws DAException 
	 */
	private BdTagTpDO getBdTagTp(DAFacade daf) throws DAException{
		BdTagTpDO bdTagTpDO = null;
		String sql = "select * from bd_tag_tp where sd_tp ='"
		+IBdFcDictCodeConst.SD_TAGTP_POOR+"' and rownum = 1";
		bdTagTpDO =  (BdTagTpDO) daf.execQuery(sql, new BeanHandler(BdTagTpDO.class));
		return bdTagTpDO;
	}

}
