package iih.ci.ord.s.ems.op.tmpl.opr;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.op.base.OpBaseEmsValidate;

/**
 * 手术医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class TmplBaseOprValidate extends OpBaseEmsValidate {
	public ErrorEmsList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException  {
		FArrayList errorlist=new FArrayList();
		FArrayList objEmsList = (FArrayList)objEms;
		for(Object obj: objEmsList){
			EmsOpitemDO opdo=(EmsOpitemDO)obj;
			if(opdo==null)return null;
			
			if(StringUtil.isEmpty(opdo.getId_mp_dep())){
				errorlist.add(String.format("%s执行科室为空！", opdo.getName_srv()));
			}
			if(opdo.getDt_plan()==null){
				errorlist.add(String.format("%s计划手术时间为空！", opdo.getName_srv()));
			}
			if(StringUtil.isEmpty(opdo.getId_di())){
				errorlist.add(String.format("%s临床诊断为空！", opdo.getName_srv()));
			}
			if(StringUtil.isEmpty(opdo.getId_anestp())){
				errorlist.add(String.format("%s麻醉方式为空！", opdo.getName_srv()));
			}
		}
		
		return null;
	}

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}
}
