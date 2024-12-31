package iih.en.pv.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.GuidePsnInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 导医系统-获取科室人员信息
 * @author fanlq
 *
 */
public class GetGuidePsnBaseBP {
	/***
	 * 导医系统-获取科室人员信息
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public GuidePsnInfo[] exec(String id_dep) throws BizException{
		if(EnValidator.isEmpty(id_dep)){
			return null;
		}
		StringBuilder sqlSb = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSb.append(" select distinct psn.id_dep, ");
		sqlSb.append(" psn.id_psndoc, ");
		sqlSb.append(" psn.code as code_psndoc, ");
		sqlSb.append(" psn.name as name_psndoc, ");
		sqlSb.append(" psn.des as des_psndoc, ");
		sqlSb.append(" title.name as title_psndoc, ");
		sqlSb.append(" srv.id_srvtp, ");
		sqlSb.append(" srvtp.code as code_srvtp, ");
		sqlSb.append(" srvtp.name as name_srvtp, ");
		sqlSb.append(" res.des as speciality ");
		sqlSb.append(" from bd_psndoc psn ");
		sqlSb.append(" left join bd_udidoc title on title.id_udidoc = psn.id_emptitle ");
		sqlSb.append(" left join sc_pl pl on pl.id_dep = psn.id_dep ");
		sqlSb.append(" left join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sqlSb.append(" left join sc_res res on res.id_emp = psn.id_psndoc ");
		sqlSb.append(" left join bd_udidoc srvtp on srvtp.id_udidoc = srv.id_srvtp ");
		sqlSb.append(" where psn.id_dep = ? ");
		param.addParam(id_dep);
		sqlSb.append(" and psn.activestate = ? ");
		param.addParam(IBdResDictCodeConst.SD_PSN_ACTIVESTATE_ENABLE);
		@SuppressWarnings("unchecked")
		List<GuidePsnInfo> list =(List<GuidePsnInfo>)new DAFacade().execQuery(
				sqlSb.toString(), param,new BeanListHandler(GuidePsnInfo.class));
		//1.设置人员头像
		this.setPsnPhoto(list);
		return list == null || list.size() <= 0 ? null : list.toArray(new GuidePsnInfo[]{});
	}
	/***
	 * 设置人员头像
	 * @param list
	 * @throws BizException
	 */
	private void setPsnPhoto(List<GuidePsnInfo> list) throws BizException{
		if(list == null || list.size() <= 0 ){
			return;
		}
		List<String> id_psnlist = new ArrayList<String>();
		for(GuidePsnInfo psnInfo : list){
			if(!id_psnlist.contains(psnInfo.getId_psndoc())){
				id_psnlist.add(psnInfo.getId_psndoc());
			}
		}
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndos = service.find(SqlUtils.getInSqlByIds(PsnDocDO.ID_PSNDOC, id_psnlist), null, FBoolean.FALSE);
		Map<String,String> map = new HashMap<String,String>();
		if(psndos != null && psndos.length > 0){
			for(PsnDocDO psn : psndos){
				map.put(psn.getId_psndoc(), psn.getPhotoToString());
			}
			if(map != null && map.size() > 0){
				for(GuidePsnInfo psnInfo : list){
					psnInfo.setPhoto(map.get(psnInfo.getId_psndoc()));
				}
			}
		}
	}
}
