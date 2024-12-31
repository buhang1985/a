package iih.ci.ord.ordprintsignpsn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordprintsignpsn.d.desc.OrdPrintSignPsnDODesc;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.bd.utils.UdidocUtils;
import iih.ci.ord.ordprintsignpsn.d.OrdPrintSignPsnDO;
import iih.ci.ord.ordprintsignpsn.i.IOrdprintsignpsnCudService;
import iih.ci.ord.ordprintsignpsn.i.IOrdprintsignpsnRService;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.i.IOrdprintRService;


/**
 * 医嘱打印签字人员AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdprintsignpsnCudService.class,IOrdprintsignpsnRService.class}, binding=Binding.JSONRPC)
public class OrdprintsignpsnCrudServiceImpl extends BaseDOService<OrdPrintSignPsnDO> implements IOrdprintsignpsnCudService,IOrdprintsignpsnRService {
    public OrdprintsignpsnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdPrintSignPsnDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }

	@Override
	public String delSignPsn(String id_en, String page_num, FBoolean fg_long, FBoolean fg_herb) throws BizException {
		OrdPrintSignPsnDO[] psns = this.find("id_ent='"+id_en+"' and page_num >= "+page_num + getQuerySql(fg_long,fg_herb), "", FBoolean.FALSE);
		if(psns == null || psns.length == 0){
			return "";
		}
		IOrdprintRService printRService = ServiceFinder.find(IOrdprintRService.class);
		OrdPrintDO[] prints = printRService.find("id_en = '"+id_en+"' and page_num = " + page_num + getPrintQuerySql(fg_long,fg_herb), "", FBoolean.FALSE);
		List<String> idpsns = new ArrayList<String>();
		if(prints != null && prints.length > 0){
			for(OrdPrintDO print : prints){
				if(StringUtils.isNotEmpty(print.getId_emp_sign()) && !idpsns.contains(print.getId_emp_sign())){
					idpsns.add(print.getId_emp_sign());
				}
				if(StringUtils.isNotEmpty(print.getId_emp_chk()) && !idpsns.contains(print.getId_emp_chk())){
					idpsns.add(print.getId_emp_chk());
				}
				if(StringUtils.isNotEmpty(print.getId_emp_stop()) && !idpsns.contains(print.getId_emp_stop())){
					idpsns.add(print.getId_emp_stop());
				}
				if(StringUtils.isNotEmpty(print.getId_emp_chk_stop()) && !idpsns.contains(print.getId_emp_chk_stop())){
					idpsns.add(print.getId_emp_chk_stop());
				}
				if(StringUtils.isNotEmpty(print.getId_emp_exe()) && !idpsns.contains(print.getId_emp_exe())){
					idpsns.add(print.getId_emp_exe());
				}
			}
			List<OrdPrintSignPsnDO> delPsnDos = new ArrayList<OrdPrintSignPsnDO>();
			for(OrdPrintSignPsnDO psn : psns){
				if(Integer.parseInt(psn.getPage_num()) > Integer.parseInt(page_num)){
					delPsnDos.add(psn);
				}else{
					if(!idpsns.contains(psn.getId_psn())){
						delPsnDos.add(psn);
					}
				}
			}
			this.delete(delPsnDos.toArray(new OrdPrintSignPsnDO[]{}));
		}else{
			this.delete(psns);
		}
		return "";
	}
	private String getPrintQuerySql(FBoolean fgLong,FBoolean fg_herb) throws BizException{
		//查看草药医嘱单是否启用了，启用，草药都打在草药医嘱单上面
		UdidocDO udidoc = UdidocUtils.getUdidocByCode(ICiDictCodeTypeConst.SD_POSTMPLMODE,"3");
		StringBuilder sql = new StringBuilder();
        if (FBoolean.TRUE.equals(fg_herb))
        {
            sql.append(" and sd_srvtp like '0103%' ");
        }
        else if (FBoolean.TRUE.equals(fgLong) && FBoolean.FALSE.equals(fg_herb))
        {
        	//草药医嘱单启用
			if(new Integer(2).equals(udidoc.getActivestate())){
				sql.append(" and Fg_long='Y' and sd_srvtp not like '0103%' ");
			}else{
				sql.append("  and Fg_long='Y' ");
			}
        }
        else if (FBoolean.FALSE.equals(fgLong)  && FBoolean.FALSE.equals(fg_herb))
        {
        	//草药医嘱单启用
			if(new Integer(2).equals(udidoc.getActivestate())){
				sql.append(" and Fg_long='N' and sd_srvtp not like '0103%' ");
			}else{
				sql.append("  and fg_long='N' ");
			}
        }
        return sql.toString();
	}
	private String getQuerySql(FBoolean fgLong,FBoolean fg_herb)
    {
        StringBuilder sql = new StringBuilder();
        if (FBoolean.TRUE.equals(fg_herb))
        {
            sql.append(" and fg_herb = 'Y' ");
        }
        else if (FBoolean.TRUE.equals(fgLong) && FBoolean.FALSE.equals(fg_herb))
        {
            sql.append(" and Fg_long='Y'  and fg_herb = 'N' ");
        }
        else if (FBoolean.FALSE.equals(fgLong)  && FBoolean.FALSE.equals(fg_herb))
        {
            sql.append(" and Fg_long='N'  and fg_herb = 'N'  ");
        }
        return sql.toString();
    }
}
