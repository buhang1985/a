package iih.bl.hp.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.fc.tagtp.i.ITagtpRService;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.i.IPattagCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 患者贫困标签处理
 * @author:hanjq
 * @date  :2020年7月17日
 */
public class BlHpDeletePoorBP {
	
    public void exec () throws DAException{
    	String sql =" delete from bl_hp_pat_poor ";
    	new DAFacade().execUpdate(sql);
    	return ;
    }

    /**
     * 删除导入后非贫困患者的标签，增加导入后是贫困患者的标签
     * @description:
     * @author:hanjq  2020年7月17日
     * @param delNotExist:删除导入后非贫困患者的标签
     * @param saveNewImport:增加导入后是贫困患者的标签
     * @throws BizException 
     */
	public void exec(FBoolean delNotExist, FBoolean saveNewImport) throws BizException {
		if(FBoolean.TRUE.equals(delNotExist)){
			this.deleteNotExist();
		}
		
		if(FBoolean.TRUE.equals(saveNewImport)){
			this.saveNewPatTag();
		}
	}
	
	/**
	 * 删除不在贫困患者表的标签
	 * @description:
	 * @author:hanjq  2020年7月17日
	 * @throws DAException 
	 */
	private void deleteNotExist() throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append("delete from pi_pat_tag tag			");
		sql.append("where tag.sd_pattagtp = ?	and exists	");
		sql.append("	(select 1 from pi_pat pat	");
		sql.append("	left join bl_hp_pat_poor poor on poor.id_code = pat.id_code		");
		sql.append("	where   pat.id_pat = tag.id_pat and pat.sd_idtp = ? and poor.id_poor is null)	");
		
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_TAGTP_POOR);
		param.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
    	new DAFacade().execUpdate(sql.toString(),param);
	}
	
	/**
	 * 保存新的患者标签
	 * @description:
	 * @author:hanjq  2020年7月17日
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void saveNewPatTag() throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append("select id_pat,pat.id_org,pat.id_grp			");
		sql.append("from pi_pat pat	");
		sql.append("join bl_hp_pat_poor poor on poor.id_code = pat.id_code	");
		sql.append("where pat.sd_idtp = ?	and rownum < 1000	");
		sql.append("	and not exists(select 1 from pi_pat_tag tag where tag.sd_pattagtp = ? and pat.id_pat = tag.id_pat)	");
		SqlParam param = new SqlParam();
		param.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
		param.addParam(IBdFcDictCodeConst.SD_TAGTP_POOR);
		
		DAFacade daf = new DAFacade();
		
		List<PatTagDO> newTagList = (List<PatTagDO>) daf.execQuery(sql.toString(), param, new BeanListHandler(PatTagDO.class));
		if(newTagList != null && newTagList.size() > 0){
			IPattagCudService patTagService = ServiceFinder.find(IPattagCudService.class);
			ITagtpRService tpService = ServiceFinder.find(ITagtpRService.class);
			BdTagTpDO[] tagTps = tpService.findByAttrValString("Sd_tp", IBdFcDictCodeConst.SD_TAGTP_POOR);
			String idEmpTag = Context.get().getStuffId();
			String Id_pattagtp = tagTps[0].getId_tagtp();
			String Sd_pattagtp = tagTps[0].getCode();
			FDateTime Dt_tag = new FDateTime();
			
			while(newTagList != null && newTagList.size() > 0){
				for(PatTagDO itm:newTagList){
					itm.setId_emp_tag(idEmpTag);
					itm.setStatus(DOStatus.NEW);
					itm.setId_pattagtp(Id_pattagtp);
					itm.setSd_pattagtp(Sd_pattagtp);
					itm.setDt_tag(Dt_tag);
				}
				patTagService.save(newTagList.toArray(new PatTagDO[0]));
				newTagList = (List<PatTagDO>) daf.execQuery(sql.toString(), param, new BeanListHandler(PatTagDO.class));
			}
			
			
		}
	}
}
